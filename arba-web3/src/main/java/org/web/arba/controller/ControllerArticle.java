package org.web.arba.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.web.arba.common.PagingHelper;
import org.web.arba.common.WebConstant;
import org.web.arba.model.ModelArticle;
import org.web.arba.model.ModelComment;
import org.web.arba.model.ModelFile;
import org.web.arba.model.ModelVote;
import org.web.arba.svr.ServiceArticle;
import org.web.arba.svr.ServiceBoard;
import org.web.arba.svr.ServiceComment;
import org.web.arba.svr.ServiceFile;

@RequestMapping("/page")
@Controller
public class ControllerArticle {

    @Autowired
    ServiceArticle svr_article;

    @Autowired
    ServiceBoard svr_board;

    @Autowired
    ServiceFile svr_file;
    
    @Autowired
    ServiceComment svr_comment;

    // 인덱스
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Transactional
    public ModelAndView Index(HttpSession session
            , @RequestParam(defaultValue="") String searchType
            , @RequestParam(defaultValue="") String searchValue) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        
        if(session.getAttribute(WebConstant.SESSION_NAME)!=null) {
            mav.addObject("login_check", true);
        } else {
            mav.addObject("login_check", false);
        }
        
        // 메인 화면 미니 게시판 내용
        // getArticleOfBoard(board_id, start, end)
        List<ModelArticle> article_result = null;
        try {
            Map<String, String> article_param = new HashMap<>();
            article_param.put("start", "1");
            article_param.put("end", "10");

            if (!searchType.equals("")) {
                article_param.put("searchType", searchType);
            }
            if (!searchValue.equals("")) {
                article_param.put("searchValue", searchValue);
            }

            // noti
            article_param.put("board_id", "noti");
            article_result = svr_article.getArticleOfBoard(article_param);
            mav.addObject("noti_list", article_result);

            // free
            article_param.put("board_id", "free");
            article_result = svr_article.getArticleOfBoard(article_param);
            mav.addObject("free_list", article_result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    // 게시판 글 목록
    @RequestMapping(value = "/{board_id}/page={page}", method = RequestMethod.GET)
    @Transactional
    public ModelAndView GetArticleList(@PathVariable(value = "board_id") String board_id,
            @PathVariable(value = "page") Integer page
            , HttpSession session
            , @RequestParam(defaultValue="") String searchType
            , @RequestParam(defaultValue="") String searchValue) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("board");
        
        mav.addObject("page", page);
        
        if(session.getAttribute(WebConstant.SESSION_NAME)!=null) {
            mav.addObject("login_check", true);
        } else {
            mav.addObject("login_check", false);
        }

        int totalRecord = -2;
        try {
            Map<String, String> article_param = new HashMap<>();
            article_param.put("board_id", board_id);
            if (!searchType.equals("")) {
                article_param.put("searchType", searchType);
            }
            if (!searchValue.equals("")) {
                article_param.put("searchValue", searchValue);
            }
            totalRecord = svr_article.getArticleTotalRecord(article_param);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        PagingHelper pagingHelper = new PagingHelper(totalRecord, page);
        int totalFirstPage = pagingHelper.getTotalFirstPage();
        int prevLink = pagingHelper.getPrevLink();
        int pageLinks[] = pagingHelper.getPageLinks();
        int curPage = page;
        int nextLink = pagingHelper.getNextLink();
        int totalLastPage = pagingHelper.getTotalLastPage();

        mav.addObject("totalFirstPage", totalFirstPage);
        mav.addObject("prevLink", prevLink);
        mav.addObject("pageLinks", pageLinks);
        mav.addObject("curPage", curPage);
        mav.addObject("nextLink", nextLink);
        mav.addObject("totalLastPage", totalLastPage);

        // 글목록 가져오기
        // getArticleOfBoard(board_id, start, end)
        int start = pagingHelper.getStartRecord();
        int end = pagingHelper.getEndRecord();
        Map<String, String> article_param = new HashMap<>();
        article_param.put("board_id", board_id);
        article_param.put("start", String.valueOf(start));
        article_param.put("end", String.valueOf(end));
        if (!searchType.equals("")) {
            article_param.put("searchType", searchType);
        }
        if (!searchValue.equals("")) {
            article_param.put("searchValue", searchValue);
        }
        List<ModelArticle> article_result = null;
        try {
            article_result = svr_article.getArticleOfBoard(article_param);
            mav.addObject("article_list", article_result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 게시판 이름
        String board_name = "";
        try {
            board_name = svr_board.getBoardName(board_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("board_name", board_name);

        return mav;
    }
    
    // 게시판 리디렉션
    @RequestMapping(value = "/{board_id}", method = RequestMethod.GET)
    @Transactional
    public RedirectView RedirectBoard(@PathVariable(value="board_id") String board_id) {
        RedirectView redirect = new RedirectView();
        redirect.setUrl("/" + board_id + "/" + "page=1");
        
        return redirect;
    }

    // 글
    @RequestMapping(value = "/{board_id}/page={page}/article={article_subno}", method = RequestMethod.GET)
    @Transactional
    public ModelAndView ViewArticle(@PathVariable(value = "board_id") String board_id,
            @PathVariable(value = "article_subno") Integer article_subno
            , HttpSession session
            , @RequestParam(defaultValue="") String searchType
            , @RequestParam(defaultValue="") String searchValue
            , @PathVariable(value = "page") Integer page) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("article");
        
        if(session.getAttribute(WebConstant.SESSION_NAME)!=null) {
            String session_user_id = (String) session.getAttribute(WebConstant.SESSION_NAME);
            mav.addObject("session_user_id", session_user_id);
            mav.addObject("login_check", true);
        } else {
            mav.addObject("login_check", false);
        }

        ModelArticle article_result = null;
        
        // 글 하나 가져오기
        // getArticleOne(board_id, article_subno)
        Map<String, String> article_param = new HashMap<>();
        article_param.put("board_id", board_id);
        article_param.put("article_subno", String.valueOf(article_subno));
        try {
            article_result = svr_article.getArticleOne(article_param);
            article_result.setArticle_hit(article_result.getArticle_hit() + 1);
            // 조회수 증가
            svr_article.increaseHit(article_result);
            mav.addObject("article", article_result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 파일 이름
        int article_no = article_result.getArticle_no();
        mav.addObject("article_no", article_no);
        List<ModelFile> file_list = null;
        try {
            file_list = svr_file.getFileName(article_no);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        mav.addObject("file_list", file_list);

        // 게시판 이름
        String board_name = "";
        try {
            board_name = svr_board.getBoardName(board_id);
            mav.addObject("board_name", board_name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(session.getAttribute(WebConstant.SESSION_NAME)!=null) {
            mav.addObject("login_check", true);
            String user_id = (String) session.getAttribute(WebConstant.SESSION_NAME);
            String article_user_id = article_result.getUser_id();
            if(user_id.equals(article_user_id)) {
                mav.addObject("my_article_check", true);
            }
            else {
                mav.addObject("my_article_check", false);
            }
        }
        
        // 추천, 비추천 수 가져오기
        // 추천 비추천 확인
        String user_id = (String) session.getAttribute(WebConstant.SESSION_NAME);
        ModelVote vote_param = new ModelVote();
        vote_param.setArticle_no(article_no);
        vote_param.setVote_goodbad(1);
        vote_param.setUser_id(user_id);
        int goodvote_count = -2;
        int vote_check = -2;
        boolean goodvote_check = false;
        try {
            goodvote_count = svr_article.getArticleVoteCount(vote_param);
            vote_check = svr_article.checkVote(vote_param);
            if(vote_check==1) {
                goodvote_check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        vote_param.setVote_goodbad(0);
        int badvote_count = -2;
        vote_check = -2;
        boolean badvote_check = false;
        try {
            badvote_count = svr_article.getArticleVoteCount(vote_param);
            vote_check = svr_article.checkVote(vote_param);
            if(vote_check==1) {
                badvote_check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        mav.addObject("goodvote_count", goodvote_count);
        mav.addObject("badvote_count", badvote_count);
        
        mav.addObject("goodvote_check", goodvote_check);
        mav.addObject("badvote_check", badvote_check);
        
        // 댓글
        List<ModelComment> comment_list = null;
        try {
            comment_list = svr_comment.getCommentList(article_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("comment_list", comment_list);
        mav.addObject("user_id", user_id);
        
        int comment_count = comment_list.size();
        mav.addObject("comment_count", comment_count);
        
        // 하단부 보드
        mav.addObject("page", page);
        int totalRecord = -2;
        try {
            Map<String, String> board_param_2 = new HashMap<>();
            board_param_2.put("board_id", board_id);
            if (!searchType.equals("")) {
                board_param_2.put("searchType", searchType);
            }
            if (!searchValue.equals("")) {
                board_param_2.put("searchValue", searchValue);
            }
            totalRecord = svr_article.getArticleTotalRecord(board_param_2);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        PagingHelper pagingHelper = new PagingHelper(totalRecord, page);
        int totalFirstPage = pagingHelper.getTotalFirstPage();
        int prevLink = pagingHelper.getPrevLink();
        int pageLinks[] = pagingHelper.getPageLinks();
        int curPage = page;
        int nextLink = pagingHelper.getNextLink();
        int totalLastPage = pagingHelper.getTotalLastPage();

        mav.addObject("totalFirstPage", totalFirstPage);
        mav.addObject("prevLink", prevLink);
        mav.addObject("pageLinks", pageLinks);
        mav.addObject("curPage", curPage);
        mav.addObject("nextLink", nextLink);
        mav.addObject("totalLastPage", totalLastPage);
        
        int start = pagingHelper.getStartRecord();
        int end = pagingHelper.getEndRecord();
        Map<String, String> article_param_2 = new HashMap<>();
        article_param_2.put("board_id", board_id);
        article_param_2.put("start", String.valueOf(start));
        article_param_2.put("end", String.valueOf(end));
        if (!searchType.equals("")) {
            article_param_2.put("searchType", searchType);
        }
        if (!searchValue.equals("")) {
            article_param_2.put("searchValue", searchValue);
        }
        List<ModelArticle> article_result_2 = null;
        try {
            article_result_2 = svr_article.getArticleOfBoard(article_param_2);
            mav.addObject("article_list", article_result_2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return mav;
    }

    // 글 쓰기 페이지
    @RequestMapping(value = "/{board_id}/write", method = RequestMethod.GET)
    @Transactional
    public ModelAndView WriteArticle(@PathVariable(value = "board_id") String board_id
            , HttpSession session) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("write");
        
        if(session.getAttribute(WebConstant.SESSION_NAME)!=null) {
            mav.addObject("login_check", true);
        } else {
            mav.addObject("login_check", false);
        }

        // 게시판 이름
        String board_name = "";
        try {
            board_name = svr_board.getBoardName(board_id);
            mav.addObject("board_name", board_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    // 글 쓰기 Rest
    @RequestMapping(value = "/{board_id}/write_rest", method = RequestMethod.POST)
    @Transactional
    public RedirectView WriteArticlePost(@PathVariable(value = "board_id") String board_id,
            @RequestParam("title") String article_title, @RequestParam("content") String article_content,
            @RequestParam("file") MultipartFile[] file,
            HttpSession session) {
        // 리디렉션
        RedirectView redirect = new RedirectView();
        redirect.setUrl("/" + board_id + "/" + "page=1");

        // 글 테이블에 입력
        int article_subno = -2;
        try {
            article_subno = svr_article.getArticleMAXSubno(board_id);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        ModelArticle article_param = new ModelArticle();
        String user_id = (String) session.getAttribute(WebConstant.SESSION_NAME);
        
        article_param.setArticle_subno(article_subno);
        article_param.setArticle_title(article_title);
        article_param.setArticle_content(article_content);
        article_param.setUser_id(user_id);
        article_param.setBoard_id(board_id);

        int article_result = -2;
        try {
            article_result = svr_article.insertArticle(article_param);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // insert된 글의 pk number
        int article_no = article_param.getArticle_no();

        // 파일
        WebConstant webconstant = new WebConstant();
        String uploadPath = webconstant.UPLOAD_PATH;
        int file_result = -2;

        // 폴더 생성
        File directory = new File(uploadPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        // 파일 업로드
        ModelFile fileParam = new ModelFile();
        fileParam.setArticle_no(article_no);
        fileParam.setUser_id(user_id);
        for (MultipartFile multipartFile : file) {
            if (!multipartFile.isEmpty()) {
                String file_name = multipartFile.getOriginalFilename();
                String file_nametemp = String.valueOf(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
                Integer file_size = (int) multipartFile.getSize();
                int lastDot = file_name.lastIndexOf(".");
                String file_type = file_name.substring(lastDot + 1);
                String file_path = uploadPath + "/" + file_nametemp + "." + file_type;
                File upfile = new File(file_path);
                fileParam.setFile_name(file_name);
                fileParam.setFile_nametemp(file_nametemp);
                fileParam.setFile_type(file_type);
                fileParam.setFile_size(file_size);
                for (;;) {
                    if (!upfile.exists()) {
                        try {
                            multipartFile.transferTo(upfile);
                            fileParam.setFile_path(file_path);
                            file_result = svr_file.insertFile(fileParam);
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    } else {
                        file_nametemp = String.valueOf(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
                        file_path = uploadPath + "/" + file_nametemp + "." + file_type;
                        upfile = new File(file_path);
                    }
                }
            }
        }
        return redirect;
    }

    // 파일 다운로드
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    @Transactional
    public void download(@RequestParam(value = "file_no") int file_no, HttpServletRequest request,
            HttpServletResponse response) {
        ModelFile file_result = null;
        String filetemp = "";
        String fileorig = "";
        String filetype = "";
        try {
            file_result = svr_file.getFileOne(file_no);
            filetemp = file_result.getFile_nametemp();
            fileorig = file_result.getFile_name();
            filetype = file_result.getFile_type();
            filetemp = filetemp + "." + filetype;
        } catch (Exception e) {
            e.printStackTrace();
        }

        WebConstant webconstant = new WebConstant();
        String uploadPath = webconstant.UPLOAD_PATH;
        File file = new File(uploadPath + "/" + filetemp);

        if (filetype.trim().equalsIgnoreCase("txt")) {
            response.setContentType("text/plain");
        } else {
            response.setContentType("application/octet-stream");
        }

        response.setContentLength((int) file.length());

        // 브라우저 당 인코딩 설정
        String header = request.getHeader("User-Agent");
        String browser = "";

        // 브라우저 판단
        if (header.indexOf("MSIE") > -1) {
            browser = "MSIE";
        } else if (header.indexOf("Chrome") > -1) {
            browser = "Chrome";
        } else if (header.indexOf("Opera") > -1) {
            browser = "Opera";
        } else if (header.indexOf("Firefox") > -1) {
            browser = "Firefox";
        } else if (header.indexOf("Trident") > -1) {
            browser = "Trident";
        }

        // UTF-8로 인코딩
        // MSIE
        if (browser.equals("MSIE") || browser.equals("Trident")) {
            try {
                fileorig = URLEncoder.encode(fileorig, "UTF-8").replaceAll("\\+", "%20");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        // 크롬
        else if (browser.equals("Chrome")) {
            try {
                fileorig = "\"" + new String(fileorig.getBytes("UTF-8"), "8859_1") + "\"";
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        
        // 오페라
        else if (browser.equals("Opera")) {
            try {
                fileorig = "\"" + new String(fileorig.getBytes("UTF-8"), "8859_1") + "\"";
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        
        // 파이어폭스
        else if (browser.equals("Firefox")) {
            try {
                fileorig = "\"" + new String(fileorig.getBytes("UTF-8"), "8859_1") + "\"";
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        response.setHeader("Content-Disposition", "attachment; filename=" + fileorig + ";");

        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        FileInputStream fis = null;

        try {
            try {
                fis = new FileInputStream(file);
                FileCopyUtils.copy(fis, outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                }
            }
        }
    }
    
    // 글 수정 페이지
    @RequestMapping(value="/{board_id}/update", method = RequestMethod.POST)
    @Transactional
    public ModelAndView UpdateArticle(@PathVariable(value="board_id") String board_id
    , @RequestParam(value="article_subno") int article_subno
    , @RequestParam(value="page") int page
    , HttpSession session) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("update");
        
        mav.addObject("page", page);
        
        if(session.getAttribute(WebConstant.SESSION_NAME)!=null) {
            mav.addObject("login_check", true);
        } else {
            mav.addObject("login_check", false);
        }
        
        String board_name = "";
        try {
            board_name = svr_board.getBoardName(board_id);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        mav.addObject("board_name", board_name);
        
        Map<String, String> article_param = new HashMap<>();
        ModelArticle article_result = null;
        article_param.put("board_id", board_id);
        article_param.put("article_subno", String.valueOf(article_subno));
        
        try {
            article_result = svr_article.getArticleOne(article_param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("article", article_result);
        
        int article_no = article_result.getArticle_no();
        mav.addObject("article_no", article_no);
        
        List<ModelFile> file_list = null;
        try {
            file_list = svr_file.getFileName(article_no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("file_list", file_list);
        
        return mav;
    }
    
    // 글 수정 Rest
    @RequestMapping(value="/{board_id}/update_rest", method = RequestMethod.POST)
    @Transactional
    public RedirectView UpdateArticleRest(@PathVariable(value="board_id") String board_id
            , @RequestParam("article_subno") int article_subno
            , @RequestParam("title") String article_title
            , @RequestParam("content") String article_content
            , @RequestParam("article_no") int article_no
            , HttpSession session
            , @RequestParam("page") int page
            , @RequestParam("file") MultipartFile[] file) {
        RedirectView redirect = new RedirectView();
        redirect.setUrl("/" + board_id + "/" + "page=" + page + "/" + "article=" + article_subno);
        
        ModelArticle article_param = new ModelArticle();
        int article_result = -2;
        article_param.setArticle_subno(article_subno);
        article_param.setBoard_id(board_id);
        article_param.setArticle_title(article_title);
        article_param.setArticle_content(article_content);
        try {
            article_result = svr_article.updateArticle(article_param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String user_id = (String) session.getAttribute(WebConstant.SESSION_NAME);
        
        // 파일
        WebConstant webconstant = new WebConstant();
        String uploadPath = webconstant.UPLOAD_PATH;
        int file_result = -2;

        // 폴더 생성
        File directory = new File(uploadPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        // 파일 업로드
        ModelFile fileParam = new ModelFile();
        fileParam.setArticle_no(article_no);
        fileParam.setUser_id(user_id);
        for (MultipartFile multipartFile : file) {
            if (!multipartFile.isEmpty()) {
                String file_name = multipartFile.getOriginalFilename();
                String file_nametemp = String.valueOf(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
                Integer file_size = (int) multipartFile.getSize();
                int lastDot = file_name.lastIndexOf(".");
                String file_type = file_name.substring(lastDot + 1);
                String file_path = uploadPath + "/" + file_nametemp + "." + file_type;
                File upfile = new File(file_path);
                fileParam.setFile_name(file_name);
                fileParam.setFile_nametemp(file_nametemp);
                fileParam.setFile_type(file_type);
                fileParam.setFile_size(file_size);
                for (;;) {
                    if (!upfile.exists()) {
                        try {
                            multipartFile.transferTo(upfile);
                            fileParam.setFile_path(file_path);
                            file_result = svr_file.insertFile(fileParam);
                        } catch (IllegalStateException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    } else {
                        file_nametemp = String.valueOf(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
                        file_path = uploadPath + "/" + file_nametemp + "." + file_type;
                        upfile = new File(file_path);
                    }
                }
            }
        }
        
        return redirect;
    }
    
    // 글 삭제
    @RequestMapping(value="/{board_id}/delete", method = RequestMethod.POST)
    @Transactional
    public ModelAndView DeleteArticle(@PathVariable(value="board_id") String board_id
            , @RequestParam("article_subno") int article_subno) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("delete");
        
        mav.addObject("article_subno", article_subno);
        mav.addObject("board_id", board_id);
        
        return mav;
    }
    
    @RequestMapping(value="/{board_id}/delete_rest", method = RequestMethod.POST)
    @Transactional
    public RedirectView DeleteArticleRest(@PathVariable(value="board_id") String board_id
            , HttpSession session
            , @RequestParam(value="article_subno") int article_subno) {
        RedirectView redirect = new RedirectView();
        redirect.setUrl("/" + board_id);
        
        String user_id = (String) session.getAttribute(WebConstant.SESSION_NAME);
        ModelArticle article_param = new ModelArticle();
        article_param.setArticle_subno(article_subno);
        article_param.setBoard_id(board_id);
        article_param.setUser_id(user_id);
        int article_result = -2;
        try {
            article_result = svr_article.deleteArticle(article_param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return redirect;
    }
    
}

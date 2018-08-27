package org.web.arba.model;

public class ModelMessage {

    private String senderName  = "";
    private String sendMessage = "";

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(String sendMessage) {
        this.sendMessage = sendMessage;
    }

    public ModelMessage() {
        super();
    }

    public ModelMessage(String senderName, String sendMessage) {
        super();
        this.senderName = senderName;
        this.sendMessage = sendMessage;
    }

    @Override
    public String toString() {
        return "ModelMessage [senderName=" + senderName + ", sendMessage=" + sendMessage + "]";
    }

}

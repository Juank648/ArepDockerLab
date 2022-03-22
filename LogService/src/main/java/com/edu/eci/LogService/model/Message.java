package com.edu.eci.LogService.model;

import java.util.Date;

public class Message {

    private String msgContent;
    private Date date;

    public Message(String message) {
        this.msgContent = message;
        this.date = new Date();
    }
    public Message(String message, Date date) {
        this.msgContent = message;
        this.date = date;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

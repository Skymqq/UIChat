package com.example.administrator.uichat;

public class Msg {

    public static final int TYPE_RECEIVED = 0;//静态常量，用于表示消息类型为接收状态

    public static final int TYPE_SEND = 1;//静态常量，用于表示消息类型为发送状态

    private String content;//消息内容

    private int type;//消息类型

    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}

package com.torres.gpt;

public class IMessage {
    private String role;
    private String content;

    public IMessage(String role, String content) {
        this.role = role;
        this.content = content;
    }

    public String getRole() {
        return role;
    }

    public String getContent() {
        return content;
    }
}

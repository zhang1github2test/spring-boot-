package com.example.demo.Entity;

/**
 * zhshl  2018/9/8
 */
public class WiselyResponse {
    private String responseMessage;

    public WiselyResponse() {
    }

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}

package com.example.wit.model;

public class ResultModel {
    private String result;

    public ResultModel(String json) {
        this.result = json;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String json) {
        this.result = json;
    }
}

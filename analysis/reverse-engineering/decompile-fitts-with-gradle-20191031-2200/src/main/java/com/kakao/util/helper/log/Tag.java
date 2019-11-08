package com.kakao.util.helper.log;

public enum Tag {
    DEFAULT("kakao.sdk");
    
    private final String tag;

    private Tag(String str) {
        this.tag = str;
    }

    public String tag() {
        return this.tag;
    }
}

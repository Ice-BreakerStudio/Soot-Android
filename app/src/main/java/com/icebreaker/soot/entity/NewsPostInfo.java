package com.icebreaker.soot.entity;

import java.lang.reflect.Array;
import java.util.List;

public class NewsPostInfo {
    private String title;
    private String content;
    private String shareImageUrl;
    private String summary;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setShareImageUrl(String shareImageUrl) {
        this.shareImageUrl = shareImageUrl;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getShareImageUrl() {
        return shareImageUrl;
    }

    public String getSummary() {
        return summary;
    }
}

package com.icebreaker.soot.entity;

import java.lang.reflect.Array;
import java.util.List;

public class NewsPostInfo {
    private Array title;
    private Array content;

    public void setTitle(Array title) {
        this.title = title;
    }

    public void setContent(Array content) {
        this.content = content;
    }

    public Array getTitle() {
        return title;
    }

    public Array getContent() {
        return content;
    }
}

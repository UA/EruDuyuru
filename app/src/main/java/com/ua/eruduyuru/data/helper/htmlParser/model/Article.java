package com.ua.eruduyuru.data.helper.htmlParser.model;

import com.github.florent37.retrojsoup.annotations.JsoupHref;
import com.github.florent37.retrojsoup.annotations.JsoupSrc;
import com.github.florent37.retrojsoup.annotations.JsoupText;

public class Article {
    @JsoupText(".post-right")
    String title;

    @JsoupHref(".entry-content .detay")
    String href;

    @JsoupText(".entry-content")
    String description;

    public Article() {
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return title + "\n" +
                href + "\n" +
                description + "\n";
    }
}

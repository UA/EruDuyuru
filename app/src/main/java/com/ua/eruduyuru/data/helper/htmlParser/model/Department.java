package com.ua.eruduyuru.data.helper.htmlParser.model;

import com.github.florent37.retrojsoup.annotations.JsoupHref;
import com.github.florent37.retrojsoup.annotations.JsoupText;

public class Department {

    @JsoupText("li")
    String title;

    @JsoupHref("li a")
    String url;

    String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Department() {
    }
}

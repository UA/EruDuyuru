package com.ua.eruduyuru.ui.announcement;

import com.ua.eruduyuru.ui.base.BasePresenter;

public interface AnnouncementPresenter<V extends AnnouncementView> extends BasePresenter<V> {
    void getArticles(String url);
}

package com.ua.eruduyuru.ui.announcement;

import com.ua.eruduyuru.data.helper.htmlParser.model.Article;
import com.ua.eruduyuru.ui.base.BaseView;

import java.util.List;

public interface AnnouncementView extends BaseView {
    void onRetrieveArticles(List<Article> result);
}

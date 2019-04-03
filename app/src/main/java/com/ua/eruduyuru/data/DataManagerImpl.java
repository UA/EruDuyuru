package com.ua.eruduyuru.data;

import com.ua.eruduyuru.data.helper.htmlParser.HtmlParseHelper;
import com.ua.eruduyuru.data.helper.htmlParser.model.Article;
import com.ua.eruduyuru.data.helper.htmlParser.model.Department;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class DataManagerImpl implements DataManager {
    private final HtmlParseHelper htmlParseHelper;
    @Inject
    public DataManagerImpl(HtmlParseHelper htmlParseHelper) {
        this.htmlParseHelper = htmlParseHelper;
    }

    @Override
    public Observable<Department> doServiceDepartmentsHtmlParse() {
        return htmlParseHelper.doServiceDepartmentsHtmlParse();
    }

    @Override
    public Observable<Article> doServiceArticlesHtmlParse(String url) {
        return  htmlParseHelper.doServiceArticlesHtmlParse(url);
    }
}

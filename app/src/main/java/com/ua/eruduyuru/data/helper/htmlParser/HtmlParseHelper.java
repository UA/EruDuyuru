package com.ua.eruduyuru.data.helper.htmlParser;

import com.ua.eruduyuru.data.helper.htmlParser.model.Article;
import com.ua.eruduyuru.data.helper.htmlParser.model.Department;

import io.reactivex.Observable;

public interface HtmlParseHelper {
    Observable<Department> doServiceDepartmentsHtmlParse();

    Observable<Article> doServiceArticlesHtmlParse(String url);
}

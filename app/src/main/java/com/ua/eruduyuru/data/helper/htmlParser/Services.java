package com.ua.eruduyuru.data.helper.htmlParser;

import com.github.florent37.retrojsoup.annotations.Select;
import com.ua.eruduyuru.data.helper.htmlParser.model.Article;
import com.ua.eruduyuru.data.helper.htmlParser.model.Department;

import io.reactivex.Observable;

public interface Services {

    @Select(".DetayText div ul li")
    Observable<Department> departments();

    @Select("article .post")
    Observable<Article> articles();
}

package com.ua.eruduyuru.data.helper.htmlParser;

import android.util.Log;

import com.ua.eruduyuru.BuildConfig;
import com.ua.eruduyuru.data.helper.htmlParser.model.Article;
import com.ua.eruduyuru.data.helper.htmlParser.model.Department;
import com.ua.eruduyuru.utils.ServiceGenerator;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

@Singleton
public class HtmlParseHelperImpl implements HtmlParseHelper {

    @Inject
    public HtmlParseHelperImpl() {
    }

    @Override
    public Observable<Department> doServiceDepartmentsHtmlParse() {
        Services services = ServiceGenerator.createService(Services.class,
                BuildConfig.BASE_URL + "kategori/AKADEMIK/Fakulteler/3/9");
        return services.departments();
    }

    @Override
    public Observable<Article> doServiceArticlesHtmlParse(String url) {
        Services services = ServiceGenerator.createService(Services.class, url + "/?Duyurular");
        return services.articles();
    }
}

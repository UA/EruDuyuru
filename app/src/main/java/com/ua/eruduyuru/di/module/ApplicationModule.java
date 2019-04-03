package com.ua.eruduyuru.di.module;

import android.app.Application;
import android.content.Context;

import com.ua.eruduyuru.data.DataManager;
import com.ua.eruduyuru.data.DataManagerImpl;
import com.ua.eruduyuru.data.helper.htmlParser.HtmlParseHelper;
import com.ua.eruduyuru.data.helper.htmlParser.HtmlParseHelperImpl;
import com.ua.eruduyuru.di.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }


    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(DataManagerImpl dataManager) {
        return dataManager;
    }

    @Provides
    @Singleton
    HtmlParseHelper provideHtmlParseHelper(HtmlParseHelperImpl htmlParseHelper) {
        return htmlParseHelper;
    }
}

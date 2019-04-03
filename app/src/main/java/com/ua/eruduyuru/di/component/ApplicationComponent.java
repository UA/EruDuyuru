package com.ua.eruduyuru.di.component;

import android.app.Application;
import android.content.Context;

import com.ua.eruduyuru.AnnouncementApplication;
import com.ua.eruduyuru.data.DataManager;
import com.ua.eruduyuru.di.ApplicationContext;
import com.ua.eruduyuru.di.module.ApplicationModule;
import com.ua.eruduyuru.ui.main.MainAdapter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context context();

    Application application();

    void inject(AnnouncementApplication announcementApplication);

    DataManager getDataManager();
}

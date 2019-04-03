package com.ua.eruduyuru.di.component;

import com.ua.eruduyuru.di.PerActivity;
import com.ua.eruduyuru.di.module.ActivityModule;
import com.ua.eruduyuru.ui.announcement.AnnouncementViewImpl;
import com.ua.eruduyuru.ui.main.MainViewImpl;
import com.ua.eruduyuru.ui.splash.SplashViewImpl;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashViewImpl splashView);

    void inject(MainViewImpl mainView);

    void inject(AnnouncementViewImpl announcementView);
}

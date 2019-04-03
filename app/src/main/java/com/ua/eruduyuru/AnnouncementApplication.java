package com.ua.eruduyuru;

import android.app.Application;

import com.ua.eruduyuru.di.component.ApplicationComponent;
import com.ua.eruduyuru.di.component.DaggerApplicationComponent;
import com.ua.eruduyuru.di.module.ApplicationModule;

public class AnnouncementApplication extends Application {
    private ApplicationComponent mApplicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public void setApplicationComponent(ApplicationComponent mApplicationComponent) {
        this.mApplicationComponent = mApplicationComponent;
    }
}

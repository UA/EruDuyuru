package com.ua.eruduyuru.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.ua.eruduyuru.data.helper.htmlParser.model.Article;
import com.ua.eruduyuru.data.helper.htmlParser.model.Department;
import com.ua.eruduyuru.di.ActivityContext;
import com.ua.eruduyuru.di.PerActivity;
import com.ua.eruduyuru.ui.announcement.AnnouncementAdapter;
import com.ua.eruduyuru.ui.announcement.AnnouncementPresenter;
import com.ua.eruduyuru.ui.announcement.AnnouncementPresenterImpl;
import com.ua.eruduyuru.ui.announcement.AnnouncementView;
import com.ua.eruduyuru.ui.main.MainAdapter;
import com.ua.eruduyuru.ui.main.MainPresenter;
import com.ua.eruduyuru.ui.main.MainPresenterImpl;
import com.ua.eruduyuru.ui.main.MainView;
import com.ua.eruduyuru.ui.splash.SplashPresenter;
import com.ua.eruduyuru.ui.splash.SplashPresenterImpl;
import com.ua.eruduyuru.ui.splash.SplashView;
import com.ua.eruduyuru.utils.rx.ISchedulerProvider;
import com.ua.eruduyuru.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    ISchedulerProvider provideSchedulerProvider() {
        return new SchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashPresenter<SplashView> provideSplashPresenter(
            SplashPresenterImpl<SplashView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainPresenter<MainView> provideMainPresenter(
            MainPresenterImpl<MainView> presenter) {
        return presenter;
    }


    @Provides
    @PerActivity
    AnnouncementPresenter<AnnouncementView> provideAnnouncementPresenter(
            AnnouncementPresenterImpl<AnnouncementView> presenter) {
        return presenter;
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    @Provides
    MainAdapter provideMainAdapter() {
        return new MainAdapter(new ArrayList<Department>());
    }

    @Provides
    AnnouncementAdapter provideAnnouncementAdapter() {
        return new AnnouncementAdapter(new ArrayList<Article>());
    }
}

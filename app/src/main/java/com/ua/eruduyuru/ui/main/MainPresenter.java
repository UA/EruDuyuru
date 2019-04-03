package com.ua.eruduyuru.ui.main;

import com.ua.eruduyuru.di.PerActivity;
import com.ua.eruduyuru.ui.base.BasePresenter;

@PerActivity
public interface MainPresenter<V extends MainView> extends BasePresenter<V> {
    void getDepartments();
}

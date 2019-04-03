package com.ua.eruduyuru.ui.splash;

import com.ua.eruduyuru.data.DataManager;
import com.ua.eruduyuru.ui.base.BasePresenterImpl;

import javax.inject.Inject;


public class SplashPresenterImpl<V extends SplashView> extends BasePresenterImpl<V> implements SplashPresenter<V> {

    @Inject
    SplashPresenterImpl(DataManager mDataManager) {
        super(mDataManager);
    }
}

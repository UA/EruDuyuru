package com.ua.eruduyuru.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import com.ua.eruduyuru.R;
import com.ua.eruduyuru.ui.main.MainViewImpl;
import com.ua.eruduyuru.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class SplashViewImpl extends BaseActivity implements SplashView {
    @Inject
    SplashPresenter<SplashView> mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(SplashViewImpl.this);
        openMainActivity();
    }

    @Override
    protected void setUp() {
    }

    @Override
    public void openMainActivity() {
        Intent intent = new Intent(SplashViewImpl.this, MainViewImpl.class);
        startActivity(intent);
        finish();
    }
}

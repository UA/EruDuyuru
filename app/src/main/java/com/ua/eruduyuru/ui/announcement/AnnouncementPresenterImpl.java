package com.ua.eruduyuru.ui.announcement;

import android.util.Log;

import com.ua.eruduyuru.data.DataManager;
import com.ua.eruduyuru.ui.base.BasePresenterImpl;
import com.ua.eruduyuru.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class AnnouncementPresenterImpl<V extends AnnouncementView> extends BasePresenterImpl<V> implements AnnouncementPresenter<V> {
    private final CompositeDisposable mCompositeDisposable;
    private final ISchedulerProvider mSchedulerProvider;
    @Inject
    public AnnouncementPresenterImpl(DataManager mDataManager,
                                     CompositeDisposable mCompositeDisposable,
                                     ISchedulerProvider mSchedulerProvider) {
        super(mDataManager);
        this.mCompositeDisposable = mCompositeDisposable;
        this.mSchedulerProvider = mSchedulerProvider;
    }

    @Override
    public void getArticles(String url) {
        mCompositeDisposable.add(getDataManager().doServiceArticlesHtmlParse(url)
                .toList()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe((result, errorCodes) -> {
                    if (errorCodes == null && result != null) {
                        Log.d("Article:",result.get(0).getTitle());
                        getBaseView().onRetrieveArticles(result);
                    }
                })
        );
    }
}

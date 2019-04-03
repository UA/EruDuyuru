package com.ua.eruduyuru.ui.main;

import com.ua.eruduyuru.data.DataManager;
import com.ua.eruduyuru.ui.base.BasePresenterImpl;
import com.ua.eruduyuru.utils.rx.ISchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainPresenterImpl<V extends MainView> extends BasePresenterImpl<V> implements MainPresenter<V> {

    private final CompositeDisposable mCompositeDisposable;
    private final ISchedulerProvider mSchedulerProvider;

    @Inject
    public MainPresenterImpl(DataManager mDataManager, CompositeDisposable compositeDisposable,
                             ISchedulerProvider schedulerProvider) {
        super(mDataManager);
        this.mCompositeDisposable = compositeDisposable;
        mSchedulerProvider = schedulerProvider;
    }

    @Override
    public void getDepartments() {
        mCompositeDisposable.add(getDataManager().doServiceDepartmentsHtmlParse()
                .toList()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe((result, errorCodes) -> {
                    if (errorCodes == null && result != null) {
                        getBaseView().onRetrieveDepartments(result);
                    }
                })
        );
    }

}

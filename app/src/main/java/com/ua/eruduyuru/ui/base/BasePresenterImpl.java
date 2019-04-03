package com.ua.eruduyuru.ui.base;

import com.ua.eruduyuru.data.DataManager;

public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {
    private static final String TAG = "BasePresenter";

    private final DataManager mDataManager;

    private V mBaseView;

    public BasePresenterImpl(DataManager mDataManager) {
        this.mDataManager = mDataManager;
    }

    @Override
    public void onAttach(V baseView) {
        mBaseView = baseView;
    }

    @Override
    public void onDetach() {
        mBaseView = null;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public V getBaseView() {
        return mBaseView;
    }
}

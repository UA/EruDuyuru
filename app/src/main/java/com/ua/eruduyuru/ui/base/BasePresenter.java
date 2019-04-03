package com.ua.eruduyuru.ui.base;

public interface BasePresenter<V extends BaseView> {
    void onAttach(V mvpView);

    void onDetach();
}

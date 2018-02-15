package com.sergeikostin.demoapp.ui.mvp_core;


public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V mMvpView;

    @Override public void onAttach( V mvpView ) {
        this.mMvpView = mvpView;
    }

    public V getMvpView() {
        return mMvpView;
    }
}

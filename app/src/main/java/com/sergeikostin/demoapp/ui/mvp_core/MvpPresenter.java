package com.sergeikostin.demoapp.ui.mvp_core;


public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);
}

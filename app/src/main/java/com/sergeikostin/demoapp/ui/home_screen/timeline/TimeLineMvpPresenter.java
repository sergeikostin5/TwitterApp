package com.sergeikostin.demoapp.ui.home_screen.timeline;


import com.sergeikostin.demoapp.ui.mvp_core.MvpPresenter;

public interface TimeLineMvpPresenter<V extends TimeLineMvpView> extends MvpPresenter<V> {

    void onViewPrepared();

}

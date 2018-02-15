package com.sergeikostin.demoapp.ui.home_screen;


import com.sergeikostin.demoapp.di.PerActivity;
import com.sergeikostin.demoapp.ui.mvp_core.MvpPresenter;

@PerActivity
public interface HomeMvpPresenter <V extends HomeMvpView> extends MvpPresenter<V> {

    void handleNewTweetPressed();
}

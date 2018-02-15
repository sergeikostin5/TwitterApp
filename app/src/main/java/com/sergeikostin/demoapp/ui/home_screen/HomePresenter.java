package com.sergeikostin.demoapp.ui.home_screen;


import com.sergeikostin.demoapp.ui.mvp_core.BasePresenter;

import javax.inject.Inject;

public class HomePresenter<V extends HomeMvpView> extends BasePresenter<V> {

    @Inject
    public HomePresenter(){

    }

    public void handleNewTweetPressed() {
        getMvpView().openNewTweetActivity();
    }
}

package com.sergeikostin.demoapp.ui.splash_screen;

import com.sergeikostin.demoapp.di.PerActivity;
import com.sergeikostin.demoapp.ui.mvp_core.MvpPresenter;

@PerActivity
public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {

    void decideNextActivity();

}

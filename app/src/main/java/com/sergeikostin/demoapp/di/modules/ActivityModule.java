package com.sergeikostin.demoapp.di.modules;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.sergeikostin.demoapp.di.ActivityContext;
import com.sergeikostin.demoapp.di.PerActivity;
import com.sergeikostin.demoapp.ui.splash_screen.SplashMvpPresenter;
import com.sergeikostin.demoapp.ui.splash_screen.SplashMvpView;
import com.sergeikostin.demoapp.ui.splash_screen.SplashPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

}

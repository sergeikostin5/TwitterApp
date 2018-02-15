package com.sergeikostin.demoapp.di.modules;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.sergeikostin.demoapp.di.ActivityContext;
import com.sergeikostin.demoapp.di.PerActivity;
import com.sergeikostin.demoapp.ui.home_screen.HomeMvpPresenter;
import com.sergeikostin.demoapp.ui.home_screen.HomeMvpView;
import com.sergeikostin.demoapp.ui.home_screen.HomePresenter;
import com.sergeikostin.demoapp.ui.home_screen.timeline.TimeLineMvpPresenter;
import com.sergeikostin.demoapp.ui.home_screen.timeline.TimeLineMvpView;
import com.sergeikostin.demoapp.ui.home_screen.timeline.TimeLinePresenter;
import com.sergeikostin.demoapp.ui.login_screen.LoginMvpPresenter;
import com.sergeikostin.demoapp.ui.login_screen.LoginMvpView;
import com.sergeikostin.demoapp.ui.login_screen.LoginPresenter;
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

    @Provides
    @PerActivity
    public HomeMvpPresenter<HomeMvpView> provideHomePresenter( HomePresenter<HomeMvpView> presenter ){
        return presenter;
    }

    @Provides
    @PerActivity
    public TimeLineMvpPresenter<TimeLineMvpView> provideTimelinePresenter( TimeLinePresenter<TimeLineMvpView> presenter ){
        return presenter;
    }

    @Provides
    @PerActivity
    public LoginMvpPresenter<LoginMvpView> provideLoginPresenter( LoginPresenter<LoginMvpView> presenter ){
        return presenter;
    }

}

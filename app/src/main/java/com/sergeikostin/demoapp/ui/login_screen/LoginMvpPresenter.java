package com.sergeikostin.demoapp.ui.login_screen;


import com.sergeikostin.demoapp.di.PerActivity;
import com.sergeikostin.demoapp.ui.mvp_core.MvpPresenter;

@PerActivity
public interface LoginMvpPresenter<V extends  LoginMvpView> extends MvpPresenter<V> {
}

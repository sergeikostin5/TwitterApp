package com.sergeikostin.demoapp.ui.login_screen;


import com.sergeikostin.demoapp.ui.mvp_core.BasePresenter;

import javax.inject.Inject;

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V> {

    @Inject
    public LoginPresenter(){

    }

}

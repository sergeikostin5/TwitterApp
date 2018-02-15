package com.sergeikostin.demoapp.ui.splash_screen;

import android.content.Intent;
import android.os.Bundle;

import com.sergeikostin.demoapp.R;
import com.sergeikostin.demoapp.ui.home_screen.HomeActivity;
import com.sergeikostin.demoapp.ui.login_screen.LoginActivity;
import com.sergeikostin.demoapp.ui.mvp_core.BaseActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashMvpView{

    @Inject
    SplashMvpPresenter<SplashMvpView> mSplashPresenter;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash );

        getActivityComponent().inject(this);

        mSplashPresenter.onAttach( this );
        mSplashPresenter.decideNextActivity();
    }

    @Override public void openHomeActivity() {
        Intent intent = HomeActivity.getStartIntent( this );
        startActivity(intent);
        finish();
    }

    @Override public void openLoginActivity() {
        Intent intent = LoginActivity.getStartIntent( this );
        startActivity(intent);
        finish();
    }
}

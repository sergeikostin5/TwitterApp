package com.sergeikostin.demoapp.ui.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sergeikostin.demoapp.R;
import com.sergeikostin.demoapp.ui.home_screen.HomeActivity;
import com.sergeikostin.demoapp.ui.login_screen.LoginActivity;

public class SplashActivity extends AppCompatActivity implements SplashMvpView{

    SplashPresenter<SplashMvpView> mSplashPresenter;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash );

        mSplashPresenter = new SplashPresenter<>();
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

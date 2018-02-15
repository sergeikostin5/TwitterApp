package com.sergeikostin.demoapp.ui.splash_screen;

import android.os.Handler;
import android.util.Log;

import com.sergeikostin.demoapp.ui.mvp_core.BasePresenter;
import com.twitter.sdk.android.core.TwitterCore;

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V> {

    private final int SPLASH_DISPLAY_LENGTH = 1000;

    public void decideNextActivity() {
        new Handler().postDelayed( new Runnable(){
            @Override
            public void run() {
                if( TwitterCore.getInstance().getSessionManager().getActiveSession() == null){
                    getMvpView().openLoginActivity();
                }else{
                    getMvpView().openHomeActivity();
                    Log.d("Bingo", TwitterCore.getInstance().getSessionManager().getActiveSession().getAuthToken().secret);
                    Log.d("Bingo", TwitterCore.getInstance().getSessionManager().getActiveSession().getAuthToken().token);
                }
            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}

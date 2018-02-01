package com.sergeikostin.demoapp;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.sergeikostin.demoapp.di.ApplicationComponent;
import com.sergeikostin.demoapp.di.DaggerApplicationComponent;
import com.sergeikostin.demoapp.di.modules.ApplicationModule;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;

public class MyApplication extends Application {

    private ApplicationComponent mAppComponent;
    private static MyApplication sApp;

    private static Context context;

    public MyApplication(){
        sApp = this;
    }

    @Override public void onCreate() {
        super.onCreate();

        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger( Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("VCds8oyjE1pBsVzkgs35QHeE5", "YoFf0FdGYpGuEovDyQcEYsh3exT4gs5wHQD1VvDlRQdwDjfilI"))
                .debug(true)
                .build();
        Twitter.initialize(config);

        mAppComponent = DaggerApplicationComponent.builder().applicationModule( new ApplicationModule( this ) ).build();
        context = this;
    }

    public ApplicationComponent getAppComponent() {
        return mAppComponent;
    }

    public static MyApplication getApplication(){
        return sApp;
    }

}

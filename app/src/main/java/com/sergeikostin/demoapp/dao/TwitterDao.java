package com.sergeikostin.demoapp.dao;


import android.net.Uri;

import com.sergeikostin.demoapp.MyApplication;
import com.sergeikostin.demoapp.network.TwitterClient;

import javax.inject.Inject;

import okhttp3.Callback;


public class TwitterDao {

    @Inject TwitterClient mClient;

    public static final String TWITTER_BASE_URL = "https://api.twitter.com/1.1";
    private static final String PATH_STATUSES = "statuses";
    private static final String PATH_HOME_TIMELINE_JSON = "home_timeline.json";
    private static final String KEY_COUNT = "count";
    private static final String KEY_SINCE_ID = "since_id";

    public TwitterDao(){
        MyApplication.getApplication().getAppComponent().inject( this );
    }

    public void getHomeTimeline( Callback callback) {
        mClient.get(getHomeTimelineUri(), callback);
    }

    private String getHomeTimelineUri() {
        return Uri.parse( TWITTER_BASE_URL ).buildUpon().appendPath( PATH_STATUSES ).appendPath( PATH_HOME_TIMELINE_JSON )
                .appendQueryParameter(
                KEY_COUNT, "20" ).appendQueryParameter( KEY_SINCE_ID, "1" ).build().toString();
    }

}

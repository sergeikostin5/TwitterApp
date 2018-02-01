package com.sergeikostin.demoapp.feature.home_timeline;


import android.util.Log;

import com.sergeikostin.demoapp.MyApplication;
import com.sergeikostin.demoapp.dao.TwitterDao;
import com.sergeikostin.demoapp.model.Tweet;
import com.sergeikostin.demoapp.utils.JSONUtil;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class TimeLineViewPresenter {

    @Inject TwitterDao mTwitterDao;
    @Inject JSONUtil mJSONUtil;

    private TimeLineView mPresentersView;

    public TimeLineViewPresenter(){
        MyApplication.getApplication().getAppComponent().inject( this );
    }

    void setView(TimeLineView view){
        mPresentersView = view;
    }

    void populateTimeline() {
        Log.d("TimeLineFragment Bingo ", "populating");
        mTwitterDao.getHomeTimeline( new Callback() {
            @Override public void onFailure( Call call, IOException e ) {
                Log.d("Bingo onFailure", call + "  " + e.getMessage());
            }

            @Override public void onResponse( Call call, final Response response ) throws IOException {

                String jsonStirng = response.body().string();
                Log.d("Bingo onResponse", response.code() + "  " + jsonStirng);
                List<Tweet> tweets = mJSONUtil.tweetsFromJson( jsonStirng);
                mPresentersView.updateTimeLineTweets( tweets );
            }
        });
    }
}

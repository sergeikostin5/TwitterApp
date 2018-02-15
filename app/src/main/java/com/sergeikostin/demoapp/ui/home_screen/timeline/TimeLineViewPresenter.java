package com.sergeikostin.demoapp.ui.home_screen.timeline;


import android.util.Log;

import com.sergeikostin.demoapp.MyApplication;
import com.sergeikostin.demoapp.model.Tweet;
import com.sergeikostin.demoapp.network.TwitterApiEndpointService;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TimeLineViewPresenter {

    @Inject TwitterApiEndpointService mTwitterService;

    private TimeLineView mPresentersView;

    private Subscription mSubscription;

    public TimeLineViewPresenter(){
        MyApplication.getApplication().getAppComponent().inject( this );
    }

    void setView(TimeLineView view){
        mPresentersView = view;
    }

    void populateTimeline() {
            mSubscription = mTwitterService.getHomeTimelineTweets().subscribeOn( Schedulers.io() ).observeOn( AndroidSchedulers.mainThread() ).
                    subscribe( new Subscriber<List<Tweet>>() {
                @Override public void onCompleted() {

                }

                @Override public void onError( Throwable e ) {
                    Log.e("Bingo ", "Error " + e.getCause() + e.getMessage());
                }

                @Override public void onNext( List<Tweet> tweets ) {
                    mPresentersView.updateTimeLineTweets( tweets );
                }
            } );
    }

    public void onDestroy() {
        if(mSubscription != null && !mSubscription.isUnsubscribed()){
            mSubscription.unsubscribe();
        }
    }
}

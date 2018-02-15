package com.sergeikostin.demoapp.ui.home_screen.timeline;


import android.util.Log;

import com.sergeikostin.demoapp.MyApplication;
import com.sergeikostin.demoapp.model.Tweet;
import com.sergeikostin.demoapp.network.TwitterApiEndpointService;
import com.sergeikostin.demoapp.ui.mvp_core.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class TimeLinePresenter<V extends TimeLineMvpView> extends BasePresenter<V> implements TimeLineMvpPresenter<V>{

    @Inject TwitterApiEndpointService mTwitterService;

    private Subscription mSubscription;

    @Inject
    public TimeLinePresenter(){
        MyApplication.getApplication().getAppComponent().inject( (TimeLinePresenter<TimeLineMvpView>) this );
    }

    @Override
    public void onViewPrepared() {

        mSubscription = mTwitterService.getHomeTimelineTweets().subscribeOn( Schedulers.io() ).observeOn( AndroidSchedulers.mainThread() ).
                    subscribe( new Subscriber<List<Tweet>>() {
                @Override public void onCompleted() {

                }

                @Override public void onError( Throwable e ) {
                    Log.e("Bingo ", "Error " + e.getCause() + e.getMessage());
                }

                @Override public void onNext( List<Tweet> tweets ) { getMvpView().updateTimeLineTweets( tweets );
                }
            } );
    }

    @Override public void onDetach() {
        if(mSubscription != null && !mSubscription.isUnsubscribed()){
            mSubscription.unsubscribe();
        }
        super.onDetach();
    }
}

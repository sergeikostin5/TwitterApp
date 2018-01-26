package com.sergeikostin.demoapp.network;


import com.sergeikostin.demoapp.MyApplication;
import com.sergeikostin.demoapp.R;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

public class TwitterClient {

    private OkHttpClient mClient;
    private OkHttpOAuthConsumer consumer;
    private MyApplication mMyApplication = MyApplication.getApplication();

    public TwitterClient(){
        consumer = new OkHttpOAuthConsumer(mMyApplication.getResources().getString( R.string.twitter_consumer_key ),
                mMyApplication.getResources().getString( R.string.twitter_consumer_secret ) );
        TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
        TwitterAuthToken authToken = session.getAuthToken();
        consumer.setTokenWithSecret(authToken.token, authToken.secret);
        mClient = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .build();
    }

    public void get( String url, Callback callback){
        Request request = new Request.Builder().url( url ).build();
        try {
            Request signedRequest = (Request) consumer.sign(request).unwrap();
            mClient.newCall(signedRequest).enqueue( callback );
        } catch ( OAuthMessageSignerException | OAuthCommunicationException | OAuthExpectationFailedException e ) {
            e.printStackTrace();
        }

    }

}

package com.sergeikostin.demoapp.di.modules;

import android.content.Context;

import com.sergeikostin.demoapp.MyApplication;
import com.sergeikostin.demoapp.R;
import com.sergeikostin.demoapp.network.ImageDao;
import com.sergeikostin.demoapp.network.TwitterApiEndpointService;
import com.sergeikostin.demoapp.utils.Constants;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

@Module
public class NetworkModule {

    private static MyApplication sMyApplication = MyApplication.getApplication();

    @Provides
    @Singleton
    public ImageDao provideImageDao( Context context){
        return new ImageDao( context );
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(){
        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(sMyApplication.getResources().getString( R.string.twitter_consumer_key ),
                sMyApplication.getResources().getString( R.string.twitter_consumer_secret ) );
        TwitterSession session = TwitterCore.getInstance().getSessionManager().getActiveSession();
        if(session != null) {
            TwitterAuthToken authToken = session.getAuthToken();
            consumer.setTokenWithSecret( authToken.token, authToken.secret );
            return new OkHttpClient.Builder()
                    .addInterceptor(new SigningInterceptor(consumer))
                    .build();
        } else {
            // // TODO: @sergei.kostin 2/14/18 reauthenticate
            TwitterAuthToken authToken = session.getAuthToken();
            consumer.setTokenWithSecret( authToken.token, authToken.secret );
            return new OkHttpClient.Builder()
                    .addInterceptor(new SigningInterceptor(consumer))
                    .build();
        }
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit( OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl( Constants.TWITTER_BASE_URL)
                .addConverterFactory( GsonConverterFactory.create())
                .addCallAdapterFactory( RxJavaCallAdapterFactory.create() )
                .client( okHttpClient )
                .build();
    }

    @Provides
    @Singleton
    public TwitterApiEndpointService provideTwitterApiEndpointService( Retrofit retrofit) {
        return retrofit.create(TwitterApiEndpointService.class);
    }
}

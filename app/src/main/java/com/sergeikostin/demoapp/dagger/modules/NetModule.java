package com.sergeikostin.demoapp.dagger.modules;

import com.sergeikostin.demoapp.network.TwitterClient;
import com.sergeikostin.demoapp.utils.JSONUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetModule {

    @Provides
    @Singleton
    public JSONUtil provideJSONUtil( ){
        return new JSONUtil();
    }

    @Provides
    @Singleton
    public TwitterClient provideTwitterClient( ){
        return new TwitterClient();
    }




}

package com.sergeikostin.demoapp.dagger.modules;

import android.content.Context;

import com.sergeikostin.demoapp.dao.ImageDao;
import com.sergeikostin.demoapp.dao.TwitterDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DaoModule {

    @Provides
    @Singleton
    public ImageDao provideImageDao( Context context){
        return new ImageDao( context );
    }

    @Provides
    @Singleton
    public TwitterDao provideTwitterDao( Context context){
        return new TwitterDao( );
    }

}

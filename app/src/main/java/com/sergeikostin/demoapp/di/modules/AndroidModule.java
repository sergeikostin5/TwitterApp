package com.sergeikostin.demoapp.di.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidModule {

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences( context );
    }

    @Provides
    @Singleton
    public Resources provideResources( Context context){
        return context.getResources();
    }

}

package com.sergeikostin.demoapp.di.modules;

import com.sergeikostin.demoapp.feature.home_timeline.TimeLineViewPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    public TimeLineViewPresenter provideTimeLineViewPresenter(){
        return new TimeLineViewPresenter();
    }


}

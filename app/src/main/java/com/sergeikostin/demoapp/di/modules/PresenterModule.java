package com.sergeikostin.demoapp.di.modules;

import com.sergeikostin.demoapp.ui.home_screen.timeline.TimeLinePresenter;
import com.sergeikostin.demoapp.ui.new_tweet_screen.NewTweetPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    public TimeLinePresenter provideTimeLineViewPresenter(){
        return new TimeLinePresenter();
    }

    @Provides
    public NewTweetPresenter provideNewTweetPresenter(){
        return new NewTweetPresenter();
    }


}

package com.sergeikostin.demoapp.di.modules;

import com.sergeikostin.demoapp.ui.home_screen.HomePresenter;
import com.sergeikostin.demoapp.ui.home_screen.timeline.TimeLineViewPresenter;
import com.sergeikostin.demoapp.ui.new_tweet_screen.NewTweetPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    public TimeLineViewPresenter provideTimeLineViewPresenter(){
        return new TimeLineViewPresenter();
    }

    @Provides
    public HomePresenter provideHomePresenter(){
        return new HomePresenter();
    }

    @Provides
    public NewTweetPresenter provideNewTweetPresenter(){
        return new NewTweetPresenter();
    }


}

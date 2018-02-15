package com.sergeikostin.demoapp.di;

import com.sergeikostin.demoapp.di.modules.AndroidModule;
import com.sergeikostin.demoapp.di.modules.ApplicationModule;
import com.sergeikostin.demoapp.di.modules.NetworkModule;
import com.sergeikostin.demoapp.di.modules.PresenterModule;
import com.sergeikostin.demoapp.ui.home_screen.HomeActivity;
import com.sergeikostin.demoapp.ui.home_screen.timeline.TimeLineFragment;
import com.sergeikostin.demoapp.ui.home_screen.timeline.TimeLineViewPresenter;
import com.sergeikostin.demoapp.ui.home_screen.timeline.TweetsAdapter;
import com.sergeikostin.demoapp.ui.new_tweet_screen.NewTweetMvpView;
import com.sergeikostin.demoapp.ui.new_tweet_screen.NewTweetPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, AndroidModule.class, NetworkModule.class, PresenterModule.class})
public interface ApplicationComponent {

    // defining injection targets here
    void inject( TimeLineFragment fragment );

    void inject( TimeLineViewPresenter presenter );

    void inject( TweetsAdapter adapter );

    void inject( NewTweetPresenter<NewTweetMvpView> presenter );

    void inject( HomeActivity homeActivity );

}

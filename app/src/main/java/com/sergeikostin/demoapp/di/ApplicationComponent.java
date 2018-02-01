package com.sergeikostin.demoapp.di;

import com.sergeikostin.demoapp.TweetsAdapter;
import com.sergeikostin.demoapp.dao.TwitterDao;
import com.sergeikostin.demoapp.di.modules.AndroidModule;
import com.sergeikostin.demoapp.di.modules.ApplicationModule;
import com.sergeikostin.demoapp.di.modules.DaoModule;
import com.sergeikostin.demoapp.di.modules.NetModule;
import com.sergeikostin.demoapp.di.modules.PresenterModule;
import com.sergeikostin.demoapp.feature.home_timeline.TimeLineFragment;
import com.sergeikostin.demoapp.feature.home_timeline.TimeLineViewPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, AndroidModule.class, DaoModule.class, NetModule.class, PresenterModule.class})
public interface ApplicationComponent {

    // defining injection targets here
    void inject( TimeLineFragment fragment );

    void inject( TimeLineViewPresenter presenter );

    void inject( TweetsAdapter adapter );

    void inject( TwitterDao twitterDao );

}

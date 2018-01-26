package com.sergeikostin.demoapp.dagger;

import com.sergeikostin.demoapp.TweetsAdapter;
import com.sergeikostin.demoapp.dagger.modules.AndroidModule;
import com.sergeikostin.demoapp.dagger.modules.ApplicationModule;
import com.sergeikostin.demoapp.dagger.modules.DaoModule;
import com.sergeikostin.demoapp.dagger.modules.NetModule;
import com.sergeikostin.demoapp.dao.TwitterDao;
import com.sergeikostin.demoapp.feature.home_timeline.TimeLineFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, AndroidModule.class, DaoModule.class, NetModule.class})
public interface ApplicationComponent {

    // defining injection targets here
    void inject( TimeLineFragment fragment );

    void inject( TweetsAdapter adapter );

    void inject( TwitterDao twitterDao );
}

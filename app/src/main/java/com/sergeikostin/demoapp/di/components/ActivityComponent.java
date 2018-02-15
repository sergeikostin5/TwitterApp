package com.sergeikostin.demoapp.di.components;

import com.sergeikostin.demoapp.di.PerActivity;
import com.sergeikostin.demoapp.di.modules.ActivityModule;
import com.sergeikostin.demoapp.ui.splash_screen.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject( SplashActivity splashActivity );
}

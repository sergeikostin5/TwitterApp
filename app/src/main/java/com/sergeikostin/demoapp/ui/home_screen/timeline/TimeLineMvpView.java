package com.sergeikostin.demoapp.ui.home_screen.timeline;


import com.sergeikostin.demoapp.model.Tweet;
import com.sergeikostin.demoapp.ui.mvp_core.MvpView;

import java.util.List;

public interface TimeLineMvpView extends MvpView{

    void updateTimeLineTweets( List<Tweet> tweets);

}

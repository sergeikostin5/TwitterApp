package com.sergeikostin.demoapp.ui.home_screen.timeline;


import com.sergeikostin.demoapp.model.Tweet;

import java.util.List;

public interface TimeLineView {

    void updateTimeLineTweets( List<Tweet> tweets);

}

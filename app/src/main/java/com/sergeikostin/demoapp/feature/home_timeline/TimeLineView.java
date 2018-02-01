package com.sergeikostin.demoapp.feature.home_timeline;


import com.sergeikostin.demoapp.model.Tweet;

import java.util.List;

public interface TimeLineView {

    void updateTimeLineTweets( List<Tweet> tweets);

}

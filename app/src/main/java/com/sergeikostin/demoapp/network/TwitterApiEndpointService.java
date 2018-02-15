package com.sergeikostin.demoapp.network;


import com.sergeikostin.demoapp.model.Tweet;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

public interface TwitterApiEndpointService {

    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @GET("statuses/home_timeline.json")
    Observable<List<Tweet>> getHomeTimelineTweets( );

}

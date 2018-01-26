package com.sergeikostin.demoapp.feature.home_timeline;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sergeikostin.demoapp.MyApplication;
import com.sergeikostin.demoapp.R;
import com.sergeikostin.demoapp.TweetsAdapter;
import com.sergeikostin.demoapp.dao.TwitterDao;
import com.sergeikostin.demoapp.model.Tweet;
import com.sergeikostin.demoapp.utils.JSONUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeLineFragment extends Fragment {

    @Inject TwitterDao mTwitterDao;
    @Inject JSONUtil mJSONUtil;

    private RecyclerView mTweetsRV;
    private TweetsAdapter mTweetsAdapter;
    private List<Tweet> mTweets;

    public TimeLineFragment() {
        MyApplication.getApplication().getAppComponent().inject(this);
    }


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_time_line, container, false );

        mTweetsRV = view.findViewById( R.id.rvTweet );
        mTweets = new ArrayList<>(  );
        mTweetsAdapter = new TweetsAdapter( mTweets );
        mTweetsRV.setAdapter( mTweetsAdapter );
        mTweetsRV.setLayoutManager( new LinearLayoutManager( getActivity().getApplicationContext() ) );
        populateTimeline();
        return view;
    }

    private void populateTimeline() {
        mTwitterDao.getHomeTimeline( new Callback() {
            @Override public void onFailure( Call call, IOException e ) {
                Log.d("Bingo onFailure", call + "  " + e.getMessage());
            }

            @Override public void onResponse( Call call, final Response response ) throws IOException {
                //
                String jsonStirng = response.body().string();
                Log.d("Bingo onResponse", response.code() + "  " + jsonStirng);
                final List<Tweet> tweets = mJSONUtil.tweetsFromJson( jsonStirng);
                getActivity().runOnUiThread( new Runnable() {
                    @Override public void run() {
                        mTweets.addAll( tweets);
                        mTweetsAdapter.notifyDataSetChanged();
                    }
                } );
            }
        });
    }

}

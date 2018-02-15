package com.sergeikostin.demoapp.ui.home_screen.timeline;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sergeikostin.demoapp.MyApplication;
import com.sergeikostin.demoapp.R;
import com.sergeikostin.demoapp.model.Tweet;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeLineFragment extends Fragment implements TimeLineView {

    @Inject TimeLineViewPresenter mTimeLinePresenter;

    private RecyclerView mTweetsRV;
    private TweetsAdapter mTweetsAdapter;
    private List<Tweet> mTweets;

    public TimeLineFragment() {
        MyApplication.getApplication().getAppComponent().inject(this);
    }

    @Override public void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setRetainInstance( true );
        mTweets = new ArrayList<>(  );
        mTimeLinePresenter.populateTimeline();
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_time_line, container, false );
        mTimeLinePresenter.setView( this );

        mTweetsRV = view.findViewById( R.id.rvTweet );
        mTweetsAdapter = new TweetsAdapter( mTweets );
        mTweetsRV.setAdapter( mTweetsAdapter );
        mTweetsRV.setLayoutManager( new LinearLayoutManager( getActivity().getApplicationContext() ) );
        return view;
    }

    @Override public void onDestroy() {
        mTimeLinePresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void updateTimeLineTweets( final List<Tweet> tweets ) {
                mTweets.addAll( tweets );
                mTweetsAdapter.notifyDataSetChanged();
    }
}

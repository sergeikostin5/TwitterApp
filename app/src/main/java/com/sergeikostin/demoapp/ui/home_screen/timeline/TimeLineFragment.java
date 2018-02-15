package com.sergeikostin.demoapp.ui.home_screen.timeline;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sergeikostin.demoapp.R;
import com.sergeikostin.demoapp.di.components.ActivityComponent;
import com.sergeikostin.demoapp.model.Tweet;
import com.sergeikostin.demoapp.ui.mvp_core.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class TimeLineFragment extends BaseFragment implements TimeLineMvpView {

    @Inject TimeLineMvpPresenter<TimeLineMvpView> mTimeLinePresenter;

    private RecyclerView mTweetsRV;
    private TweetsAdapter mTweetsAdapter;
    private List<Tweet> mTweets;

    @Override public void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setRetainInstance( true );
        mTweets = new ArrayList<>(  );
    }

    @Override protected void setUp( View view ) {
        mTweetsAdapter = new TweetsAdapter( mTweets );
        mTweetsRV.setAdapter( mTweetsAdapter );
        mTweetsRV.setLayoutManager( new LinearLayoutManager( getActivity().getApplicationContext() ) );
        mTimeLinePresenter.onViewPrepared();
    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_time_line, container, false );

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            mTimeLinePresenter.onAttach(this);
        }

        mTweetsRV = view.findViewById( R.id.rvTweet );
        return view;
    }

    @Override public void onDestroy() {
        mTimeLinePresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void updateTimeLineTweets( final List<Tweet> tweets ) {
                mTweets.addAll( tweets );
                mTweetsAdapter.notifyDataSetChanged();
    }
}

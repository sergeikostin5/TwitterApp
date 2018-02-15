package com.sergeikostin.demoapp.ui.home_screen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sergeikostin.demoapp.MyApplication;
import com.sergeikostin.demoapp.R;
import com.sergeikostin.demoapp.ui.home_screen.timeline.TimeLineFragment;
import com.sergeikostin.demoapp.ui.new_tweet_screen.NewTweetActivity;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity implements HomeMvpView{

    private TimeLineFragment mTimeLineFragment;
    private FloatingActionButton mNewTweetButton;
    @Inject HomePresenter<HomeMvpView> mHomePresenter;


    public static Intent getStartIntent(Context context){
        Intent intent = new Intent( context, HomeActivity.class );
        return intent;
    }

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        Log.d("Bingo", "HomeActivity " + Thread.currentThread());
        MyApplication.getApplication().getAppComponent().inject(this);
        mHomePresenter.onAttach( this );
        setContentView( R.layout.activity_main );
        mTimeLineFragment = (TimeLineFragment) getSupportFragmentManager().findFragmentById( R.id.home_timeline_fragment );
        mNewTweetButton = findViewById( R.id.new_tweet_button );
        mNewTweetButton.setOnClickListener( view -> mHomePresenter.handleNewTweetPressed() );
    }

    @Override public void openNewTweetActivity() {
        Intent intent = NewTweetActivity.getStartIntent( this );
        startActivity( intent );
    }
}

package com.sergeikostin.demoapp.ui.new_tweet_screen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sergeikostin.demoapp.R;

public class NewTweetActivity extends AppCompatActivity implements NewTweetMvpView{

    private NewTweetPresenter<NewTweetMvpView> mPresenter;

    public static Intent getStartIntent( Context context){
        Intent intent = new Intent( context, NewTweetActivity.class );
        return intent;
    }

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_new_tweet );
        mPresenter = new NewTweetPresenter<>();
        mPresenter.onAttach( this );

    }
}

package com.sergeikostin.demoapp.ui.new_tweet_screen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.sergeikostin.demoapp.R;
import com.sergeikostin.demoapp.ui.mvp_core.BaseActivity;

public class NewTweetActivity extends BaseActivity implements NewTweetMvpView{

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

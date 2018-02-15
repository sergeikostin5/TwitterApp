package com.sergeikostin.demoapp.ui.login_screen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.sergeikostin.demoapp.R;
import com.sergeikostin.demoapp.ui.home_screen.HomeActivity;
import com.sergeikostin.demoapp.ui.mvp_core.BaseActivity;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements  LoginMvpView{

	private TwitterLoginButton loginButton;

	@Inject
	LoginMvpPresenter<LoginMvpView> mPresenter;

	public static Intent getStartIntent(Context context){
		Intent intent = new Intent( context, LoginActivity.class );
		return intent;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView( R.layout.activity_login);
		getActivityComponent().inject( this );
		mPresenter.onAttach( this );
		loginButton = findViewById(R.id.login_button);
		loginButton.setCallback(new Callback<TwitterSession>() {
			@Override
			public void success(Result<TwitterSession> result) {
				// Do something with result, which provides a TwitterSession for making API calls

				Intent intent = new Intent( LoginActivity.this, HomeActivity.class );
				startActivity( intent );
			}

			@Override
			public void failure(TwitterException exception) {
				// Do something on failure
				Log.d("Bingo", "onFailure");
			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		// Pass the activity result to the login button.
		Log.d("Bingo", "onActivityResult");
		loginButton.onActivityResult(requestCode, resultCode, data);
	}
}

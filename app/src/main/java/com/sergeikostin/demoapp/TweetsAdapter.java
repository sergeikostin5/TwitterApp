package com.sergeikostin.demoapp;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sergeikostin.demoapp.TweetsAdapter.ViewHolder;
import com.sergeikostin.demoapp.dao.ImageDao;
import com.sergeikostin.demoapp.model.Tweet;

import java.util.List;

import javax.inject.Inject;

public class TweetsAdapter extends RecyclerView.Adapter<ViewHolder>{

    @Inject ImageDao mImageDao;

    private List<Tweet> mTweets;

    public TweetsAdapter(List<Tweet> tweets){
        mTweets = tweets;
        MyApplication.getApplication().getAppComponent().inject( this );
    }

    @Override public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType ) {
        LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
        View itemView = inflater.inflate( R.layout.tweet_item, parent, false );
        return new ViewHolder( itemView );
    }

    @Override public void onBindViewHolder( ViewHolder holder, int position ) {
        Tweet tweet = mTweets.get( position );
        holder.tvUserName.setText( tweet.getUser().getName() );
        holder.tvScreenName.setText( tweet.getUser().getScreen_name() );
        holder.tvTextBody.setText( tweet.getText() );
        mImageDao.loadImage( tweet.getUser().getProfile_image_url(), holder.ivProfileImage );
    }

    @Override public int getItemCount() {
        return mTweets.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivProfileImage;
        TextView tvUserName;
        TextView tvScreenName;
        TextView tvTextBody;

        public ViewHolder( View itemView ) {
            super( itemView );

            ivProfileImage = itemView.findViewById( R.id.ivProfileImage );
            tvUserName = itemView.findViewById( R.id.tvName );
            tvScreenName = itemView.findViewById( R.id.tvScreenName );
            tvTextBody = itemView.findViewById( R.id.tvText );
        }
    }


}

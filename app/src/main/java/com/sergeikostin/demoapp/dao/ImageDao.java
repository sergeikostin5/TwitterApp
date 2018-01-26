package com.sergeikostin.demoapp.dao;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageDao {

    private Context mContext;

    public ImageDao(Context context){
        mContext = context;
    }

    public void loadImage( String url, ImageView view){
        Glide.with(mContext)
                .load( url)
                .into(view);
    }
}

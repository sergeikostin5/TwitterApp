package com.sergeikostin.demoapp.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sergeikostin.demoapp.model.Tweet;

import java.lang.reflect.Type;
import java.util.List;

public class JSONUtil {

    /**
     *
     * @param jsonArrayString
     * @return
     * @throws JsonSyntaxException
     */
    public List<Tweet> tweetsFromJson( String jsonArrayString) throws JsonSyntaxException{
        Gson gson = new GsonBuilder().create();
        Type type = new TypeToken<List<Tweet>>() {}.getType();
        return gson.fromJson( jsonArrayString, type );
    }


}

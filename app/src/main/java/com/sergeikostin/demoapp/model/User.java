package com.sergeikostin.demoapp.model;


public class User {

    private String name;
    private long id;
    private String screen_name;
    private String profile_image_url;

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name( String screen_name ) {
        this.screen_name = screen_name;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }

    public void setProfile_image_url( String profile_image_url ) {
        this.profile_image_url = profile_image_url;
    }

    @Override public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", screen_name='" + screen_name + '\'' +
                ", profile_image_url='" + profile_image_url + '\'' +
                '}';
    }
}

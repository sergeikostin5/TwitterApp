package com.sergeikostin.demoapp.model;


public class Tweet {

    private String text;
    private long id;
    private String created_at;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser( User user ) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText( String text ) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at( String created_at ) {
        this.created_at = created_at;
    }

    @Override public String toString() {
        return "Tweet{" +
                "text='" + text + '\'' +
                ", id=" + id +
                ", created_at='" + created_at + '\'' +
                ", user=" + user +
                '}';
    }
}

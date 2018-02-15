package com.sergeikostin.demoapp.ui.mvp_core;

import javax.inject.Inject;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * onAttach() and onDetach(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    

    private V mMvpView;

    @Inject
    public BasePresenter(){

    }

    @Override public void onAttach( V mvpView ) {
        this.mMvpView = mvpView;
    }

    @Override public void onDetach() {
        mMvpView = null;
    }

    public boolean isViewAttached(){
        return mMvpView != null;
    }

    @Override public void handleApiError( Exception e ) {

    }

    @Override public void setUserAsLoggedOut() {

    }

    public V getMvpView() {
        return mMvpView;
    }
}

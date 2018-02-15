package com.sergeikostin.demoapp;


import org.junit.Test;

import rx.Observable;
import rx.Observer;
import rx.Subscription;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private String result;

    @Test
    public void testObs(){
        Observable<String> observable = Observable.just( "Sergei", "Andrei" );
        Subscription sub = observable.subscribe( new Observer<String>() {
            @Override public void onCompleted() {
                System.out.println("Bingo onComplited");
            }

            @Override public void onError( Throwable e ) {

            }

            @Override public void onNext( String s ) {
                System.out.println("Bingo onNext " + s );
                result += s;
            }
        } );
        System.out.println("Bingo " + result);
    }


}

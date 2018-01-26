package com.sergeikostin.demoapp;

import org.junit.Test;

import java.io.IOException;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void testOkHttp() throws OAuthCommunicationException, OAuthExpectationFailedException, OAuthMessageSignerException {
//        OkHttpClient client = new OkHttpClient();

        String auth = "OAuth oauth_consumer_key=\"VCds8oyjE1pBsVzkgs35QHeE5\"," +
                "oauth_token=\"940366899073908739-u0KK75dEBAYDuprDDDvGspkgw7EPA9B\"," +
                "oauth_signature_method=\"HMAC-SHA1\"," +
                "oauth_timestamp=\"1516900764\"," +
                "oauth_nonce=\"cBZMzmazQCe\"," +
                "oauth_version=\"1.0\"," +
                "oauth_signature=\"fR6Rng1S%2BWfeDVnyxQuKMHN0TXU%3D\"";

        String auth2 = "Bearer 940366899073908739-u0KK75dEBAYDuprDDDvGspkgw7EPA9B";

//        Builder builder = new Request.Builder();
        //        TwitterOAuthUtil util = new TwitterOAuthUtil();
        //        util.setOAuth1Header( builder );
        //        Request request = builder.addHeader( "Content-Type", "application/json" )
        //                .url("https://api.twitter.com/1.1/statuses/home_timeline.json?count=2&since_id=1")
        //                .build();
        //        System.out.println(request.header( "Authorization" ));

        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer("VCds8oyjE1pBsVzkgs35QHeE5", "YoFf0FdGYpGuEovDyQcEYsh3exT4gs5wHQD1VvDlRQdwDjfilI");
        consumer.setTokenWithSecret("940366899073908739-u0KK75dEBAYDuprDDDvGspkgw7EPA9B", "884Q5MWjLOafjh2Is03jQdkIHDgSDdydAPEBOlO3V7Gki");

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .build();

        Request request = new Request.Builder().url( "https://api.twitter.com/1.1/statuses/home_timeline.json?count=2&since_id=1" ).build();
        Request signedRequest = (Request) consumer.sign(request).unwrap();
        //                .url("https://api.twitter.com/1.1/statuses/home_timeline.json?count=2&since_id=1")
        //                .build();

        try {
            Response response = client.newCall(signedRequest).execute();
            System.out.println("Response " + response);
            System.out.println("Response body" + response.body().string());
        } catch ( IOException e ) {
            e.printStackTrace();
        }




    }
}
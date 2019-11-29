package com.hot.fruits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.applinks.AppLinkData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // on debag
        FacebookSdk.setIsDebugEnabled(true);
//        FacebookSdk.setAutoInitEnabled(true);
//        FacebookSdk.fullyInitialize();

        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData1 = appLinkIntent.getData();
        if (appLinkData1 != null) {
            Log.d("MyLog" +  this.getLocalClassName(), "App Link appLinkData: " + appLinkData1.toString());
        }

        AppLinkData.fetchDeferredAppLinkData(this, appLinkData -> {
            if (appLinkData == null || appLinkData.getTargetUri() == null) {
                Log.d("MyLog", "deeplink = null");


            } else {

                Log.d("MyLog", "deeplink = " + appLinkData.getTargetUri().toString());

            }
        });
        setContentView(R.layout.activity_main);

    }
}

package com.example.kadir.intagramcloneparse;

import android.app.Application;

import com.parse.Parse;

public class ParseStarterActivity extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);
        Parse.initialize(new Parse.Configuration.Builder(this)
        .applicationId("13CCu1XexxWGNs918F6B4PLH1cF18Wsi4gfctwM7")
        .clientKey("OjFkokLb0GNQ8xofOD1x0Y9ga5cVYVBEuWc8aJRM")
        .server("https://parseapi.back4app.com/")
        .build());
    }
}

package com.iagodkin.showpostapi;

import android.app.Application;

import com.iagodkin.showpostapi.di.DependenceFactory;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new DependenceFactory(this);
    }
}

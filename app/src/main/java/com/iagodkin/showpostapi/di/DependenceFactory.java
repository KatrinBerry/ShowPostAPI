package com.iagodkin.showpostapi.di;

import android.content.Context;

import com.iagodkin.showpostapi.data.web.Api;
import com.iagodkin.showpostapi.data.web.HttpProvider;

public class DependenceFactory {
    private static DependenceFactory instance;
    private HttpProvider httpProvider;

    public DependenceFactory(Context context) {
        httpProvider = new HttpProvider();
        instance = this;
    }

    public Api getHttpProvider() {
        return httpProvider;
    }

    public static DependenceFactory getInstance() {
        return instance;
    }
}

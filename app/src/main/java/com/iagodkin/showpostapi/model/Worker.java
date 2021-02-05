package com.iagodkin.showpostapi.model;

import android.os.Handler;

import com.iagodkin.showpostapi.data.web.Api;
import com.iagodkin.showpostapi.di.DependenceFactory;

import java.io.IOException;

public class Worker implements Runnable {
    public static final int VALIDATION_START = 0x01;
    public static final int VALIDATION_SUCCESS = 0x02;
    public static final int VALIDATION_FAILURE = 0x03;
    public static final String FAIL = "Can't load";
    Handler handler;
    Api provider;
    String json;

    public Worker(Handler handler) {
        this.handler = handler;
        this.provider = DependenceFactory.getInstance().getHttpProvider();
    }

    public String get() {
        if (json != null) {
            return json;
        }
        return FAIL;
    }

    @Override
    public void run() {
        handler.sendEmptyMessage(VALIDATION_START);
        try {
            json = provider.show();
            handler.sendEmptyMessage(VALIDATION_SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
            handler.sendEmptyMessage(VALIDATION_FAILURE);
        }
    }

}

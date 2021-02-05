package com.iagodkin.showpostapi.viewmodel;

import android.os.Handler;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.iagodkin.showpostapi.model.Worker;

public class MainActivityViewModel extends ViewModel {

    public MutableLiveData<Boolean> liveDataB = new MutableLiveData<>();
    public MutableLiveData<String> liveDataS = new MutableLiveData<>();
    public Worker worker;

    public void onBtnClick(){
        Handler handler = new Handler(msg -> {
            switch (msg.what) {
                case Worker.VALIDATION_START:
                    liveDataB.setValue(true);
                    return true;
                case Worker.VALIDATION_SUCCESS:
                    liveDataB.postValue(false);
                        liveDataS.postValue(worker.get());
                    return true;
            }
            return false;
        });
        worker = new Worker(handler);
     new Thread(worker).start();
    }

}

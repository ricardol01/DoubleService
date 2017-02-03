package com.doubleservice;

import android.content.Intent;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by Administrator on 2017/1/24.
 */

public class ProcessModule extends ReactContextBaseJavaModule {
    ReactApplicationContext mReactContext;
    public ProcessModule(ReactApplicationContext reactContext){
        super(reactContext); mReactContext = reactContext;
    }
    @Override
    public String getName() {
        return "ProcessModule";
    }
    @ReactMethod
    public void StartServ()
    {
        Intent intent= new Intent(mReactContext, DaemonService.class);
        mReactContext.startService(intent);
    }

}

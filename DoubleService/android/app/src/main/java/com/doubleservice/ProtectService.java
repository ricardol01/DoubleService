package com.doubleservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2017/1/25.
 */

public class ProtectService extends Service {
    private static boolean isRunning;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate(){
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        if (!isRunning) {
            isRunning=true;
            new Thread(new Runnable(){

                @Override
                public void run() {
                    SystemClock.sleep(1500);
                    System.out.println("ProtectService");
                    isRunning=false;
                    startService(new Intent(ProtectService.this, DaemonService.class));
                }
            }).start();
        }
        return START_STICKY;
    }
}

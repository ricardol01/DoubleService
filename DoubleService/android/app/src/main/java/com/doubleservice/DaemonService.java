package com.doubleservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2017/1/25.
 */

public class DaemonService extends Service {
    private  static  boolean isRunning;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        if (!isRunning){
            isRunning=true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SystemClock.sleep(3000);
                    isRunning=false;
                    startService(new Intent(DaemonService.this,ProtectService.class));
                    System.out.println("DaemonService");
                }
            }).start();
        }
        return super.onStartCommand(intent, flags, startId);
    }
}

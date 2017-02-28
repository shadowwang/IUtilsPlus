package com.iutilsplus.app;

import android.app.Application;

import com.iutilsplus.monitor.viewlag.UILagLogPrinter;
import com.iutilsplus.monitor.viewlag.UILagMonitiorManager;

/**
 * Created by Administrator on 2017/2/28.
 */
public class CoreApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UILagMonitiorManager.getInstance().init();
    }
}

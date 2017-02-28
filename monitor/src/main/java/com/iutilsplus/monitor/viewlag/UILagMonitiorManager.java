package com.iutilsplus.monitor.viewlag;

import android.os.Looper;
import android.util.Printer;

/**
 * UI卡顿监控的管理类
 * Created by parsonswang on 2017/2/28.
 */
public class UILagMonitiorManager {

    private static UILagMonitiorManager sInstance;


    private Printer mLogPrinter;

    private UILagMonitiorManager() {
        mLogPrinter = new UILagLogPrinter();
    }

    public static UILagMonitiorManager getInstance() {
        if (sInstance == null) {
            sInstance = new UILagMonitiorManager();
        }
        return sInstance;
    }

    public void init() {
        Looper.getMainLooper().setMessageLogging(mLogPrinter);
    }
}

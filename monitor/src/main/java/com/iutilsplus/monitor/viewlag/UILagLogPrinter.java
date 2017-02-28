package com.iutilsplus.monitor.viewlag;

import android.util.Log;
import android.util.Printer;

/**
 * Created by Administrator on 2017/2/28.
 */
public class UILagLogPrinter implements Printer {

    private static final String TAG = UILagLogPrinter.class.getSimpleName();
    private long mStarttime;

    @Override
    public void println(String x) {
        if (mStarttime <= 0 ) {
            mStarttime = System.currentTimeMillis();
        } else {
            long endTime = System.currentTimeMillis();
            Log.i(TAG, "主线程耗时: " + (endTime - mStarttime) + "ms");
            mStarttime = 0;
        }
    }
}

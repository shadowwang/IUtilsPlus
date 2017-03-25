package com.iutilsplus.common.view.weaknetwork;

import android.util.SparseArray;
import android.view.View;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 整个组件的入口类，单例
 * Created by parsonswang on 2017/3/25.
 */

public class ViewLoading {

    private HashMap<View, ViewStateManager> mViewSparseArray;

    private ViewLoading() {
        mViewSparseArray = new HashMap<>();
    }

    private static ViewLoading mViewLoading;

    public static ViewLoading getInstance() {
        if (mViewLoading == null) {
            mViewLoading = new ViewLoading();
        }

        return mViewLoading;
    }

    public ViewLoading of(View... views) {
        for (View view : views) {
            mViewSparseArray.put(view, new ViewStateManager(view));
        }
        return this;
    }

    public void showShadeBg() {
        for (View view : mViewSparseArray.keySet()) {
            final ViewStateManager viewStateManager = mViewSparseArray.get(view);
            viewStateManager.showWeakBg();
        }
    }

    public void hideShadeBg() {
        Iterator<View> iterator = mViewSparseArray.keySet().iterator();
        while (iterator.hasNext()) {
            final View view = iterator.next();
            final ViewStateManager viewStateManager = mViewSparseArray.get(view);
            viewStateManager.hideWeakBg();
            mViewSparseArray.remove(view);
        }
    }
}

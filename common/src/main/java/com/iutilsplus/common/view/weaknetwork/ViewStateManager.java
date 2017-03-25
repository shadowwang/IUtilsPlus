package com.iutilsplus.common.view.weaknetwork;

import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by parsonswang on 2017/3/25.
 */

public class ViewStateManager<V extends View> {

    protected V v;
    protected Drawable mDrawable;//默认的背景颜色

    public ViewStateManager(V v) {
        this.v = v;
        this.mDrawable = v.getBackground();
    }

    /**
     * 显示弱网络背景
     */
    public void showWeakBg() {
        GreyDrawable greyDrawable = new GreyDrawable(v);
        this.v.setBackgroundDrawable(greyDrawable);
    }


    /**
     * 隐藏弱网络背景
     */
    public void hideWeakBg() {
        Drawable drawable = this.v.getBackground();
        if (drawable instanceof GreyDrawable) {
            GreyDrawable greyDrawable = (GreyDrawable) drawable;
            greyDrawable.disappear(new GreyDrawable.Callback() {
                @Override
                public void onAfterDisappear() {
                    //隐藏后恢复View原来的背景
                    ViewStateManager.this.v.setBackgroundDrawable(mDrawable);
                }
            });
        }
    }
}

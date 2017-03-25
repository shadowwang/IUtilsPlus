package com.iutilsplus.common.view.weaknetwork;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import java.lang.ref.WeakReference;

/**
 * 自定义灰色背景Drawable
 * Created by parsonswang on 2017/3/9.
 */

public class GreyDrawable extends Drawable {

    private static final int DEFAULT_BG_COLOR = Color.parseColor("#f1f7f8");

    private int mBgColor = DEFAULT_BG_COLOR;
    private Paint mPaint;
    private WeakReference<View> mViewWeakReference;

    public GreyDrawable(View view) {
        mPaint = new Paint();
        mViewWeakReference = new WeakReference<View>(view);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        mPaint.setColor(mBgColor);
        canvas.drawRect(canvas.getClipBounds(), mPaint);
    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }


    public void disappear(final Callback callback) {
        final View view = mViewWeakReference.get();
        if (view == null) {
            return;
        }

        //属性动画alpha
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, 1F)
                .setDuration(400);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ObjectAnimator.ofFloat(view, View.ALPHA, 0F);
                if (callback == null) {
                    return;
                }

                callback.onAfterDisappear();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        objectAnimator.setInterpolator(new DecelerateInterpolator());
        objectAnimator.start();
    }

    interface Callback {
        void onAfterDisappear();
    }
}

package ru.sawim.comm;

import android.graphics.drawable.Drawable;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class DrawableCallback implements Drawable.Callback {
    private List<WeakReference<TextView>> views;

    public DrawableCallback() {
        views = new ArrayList<WeakReference<TextView>>();
    }

    public void addView(TextView view) {
        System.out.println("========= adding view: " + view);
        WeakReference<TextView> viewRef = new WeakReference<TextView>(view);
        views.add(viewRef);
    }

    @Override
    public void invalidateDrawable(Drawable who) {
        System.out.println("========= invalidateDrawable: " + who);
        for(WeakReference<TextView> mViewWeakReference: views) {
            if (mViewWeakReference.get() != null) {
                System.out.println("========= invalidateDrawable: " + mViewWeakReference.get());
                mViewWeakReference.get().invalidate();
            }
        }
    }

    @Override
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
        System.out.println("========= scheduleDrawable: " + who);
        for(WeakReference<TextView> mViewWeakReference: views) {
            if (mViewWeakReference.get() != null) {
                System.out.println("========= scheduleDrawable: " + mViewWeakReference.get());
                mViewWeakReference.get().postDelayed(what, when);
            }
        }
    }

    @Override
    public void unscheduleDrawable(Drawable who, Runnable what) {
        System.out.println("========= unscheduleDrawable: " + who);
        for(WeakReference<TextView> mViewWeakReference: views) {
            if (mViewWeakReference.get() != null) {
                System.out.println("========= unscheduleDrawables: " + mViewWeakReference.get());
                mViewWeakReference.get().removeCallbacks(what);
            }
        }
    }
}

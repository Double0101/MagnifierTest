package com.sjgsu.ai.magnifiertest;

/**
 * Created by Double on 29/06/2017.
 */

import android.content.Context;
import android.graphics.PixelFormat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

/**
 * Created by Double on 10/06/2017.
 */

public class DrawSurface extends SurfaceView {

    private static final String TAG = "Calibration";

    private SurfaceHolder holder;

    public DrawSurface(Context context, AttributeSet attrs) {
        super(context, attrs);

        setWillNotDraw(false);
        setZOrderOnTop(true);
        holder = getHolder();
        holder.setFormat(PixelFormat.TRANSPARENT);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, event.getX() + " " + event.getY());
                break;

            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, event.getX() + " " + event.getY());
                break;

            case MotionEvent.ACTION_UP:
                Log.i(TAG, event.getX() + " " + event.getY());
                break;
        }

        return true;
    }
}

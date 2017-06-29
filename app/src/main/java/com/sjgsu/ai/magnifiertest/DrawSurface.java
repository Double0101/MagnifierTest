package com.sjgsu.ai.magnifiertest;

/**
 * Created by Double on 29/06/2017.
 */

import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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

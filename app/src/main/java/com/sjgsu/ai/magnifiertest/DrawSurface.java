package com.sjgsu.ai.magnifiertest;

/**
 * Created by Double on 29/06/2017.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.widget.ImageView;

/**
 * Created by Double on 10/06/2017.
 */

public class DrawSurface extends SurfaceView {

    private static final String TAG = "Calibration";

    private SurfaceHolder holder;

    private Bitmap bitmap;

    private BitmapShader shader;

    private Matrix matrix;

    private Paint paint;

    private boolean isCached = false;

    private ImageView imageView;

    private float pX;

    private float pY;

    public DrawSurface(Context context, AttributeSet attrs) {
        super(context, attrs);

        setWillNotDraw(false);
        setZOrderOnTop(true);
        holder = getHolder();
        holder.setFormat(PixelFormat.TRANSPARENT);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        matrix = new Matrix();
        paint = new Paint();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, event.getX() + " " + event.getY());
                pX = event.getX();
                pY = event.getY();
                isCached = true;
                break;

            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, event.getX() + " " + event.getY());
                pX = event.getX();
                pY = event.getY();
                isCached = true;
                break;

            case MotionEvent.ACTION_UP:
                Log.i(TAG, event.getX() + " " + event.getY());
                isCached = false;
                break;
            case MotionEvent.ACTION_CANCEL:
                isCached = false;
                break;
        }

        invalidate();
        return true;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawMagnifier(pX, pY, canvas);
    }

    private void drawMagnifier(float x, float y, Canvas canvas) {
        if (!isCached) {
            imageView.buildDrawingCache();
        } else {
            bitmap = imageView.getDrawingCache();
            shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            paint.setShader(shader);
            Log.i("MMMMM", 1+ "");
            matrix.reset();
            matrix.postScale(2f, 2f, x, y);
            paint.getShader().setLocalMatrix(matrix);
            canvas.drawCircle(x, y - 200, 200, paint);
        }
    }
}

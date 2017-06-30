package com.sjgsu.ai.magnifiertest;

/**
 * Created by Double on 29/06/2017.
 */

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by Double on 2017/5/13.
 */

public class MyDrawView extends RelativeLayout {

    private DrawSurface drawSurface;

    private ImageView imageView;

    private Context mContext;

    public MyDrawView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.my_draw_view, this);

        mContext = context;
        imageView = (ImageView) findViewById(R.id.imageview);
        drawSurface = (DrawSurface) findViewById(R.id.myDrawImage);
        drawSurface.setImageView(imageView);
    }

}

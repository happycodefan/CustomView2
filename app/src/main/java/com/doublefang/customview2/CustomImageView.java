package com.doublefang.customview2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by DoubleFang on 2016/3/29.
 */
public class CustomImageView extends ImageView {
    private static final String TAG = CustomImageView.class.getName();

    public CustomImageView(Context context) {
        super(context);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * ListView item里面的image的屏幕适配
     * 什么时候重写：
     * 1. wrap wrap 的时候不用写
     * 2. 宽度固定，高度不固定的时候重写，(垂直滚动的控件中使用) 让高度更具宽度来计算
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Drawable drawable = getDrawable();

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heidhtMode = MeasureSpec.getMode(heightMeasureSpec);
        // 1. 有图片 2. 宽度固定 3. 高度不固定
        if (drawable != null && (widthMode == MeasureSpec.EXACTLY && heidhtMode != MeasureSpec.EXACTLY)) {
            int widthSize = MeasureSpec.getSize(widthMeasureSpec);
            int heightSize = MeasureSpec.getSize(heightMeasureSpec);
            int h = drawable.getIntrinsicHeight() * widthSize / drawable.getIntrinsicWidth(); // 先乘后除？
            switch (heidhtMode) {
                case MeasureSpec.AT_MOST:
                    Log.d(TAG, "onMeasure heidhtMode:AT_MOST");
                    heightSize = Math.min(h, heightSize);
                    break;
                case MeasureSpec.UNSPECIFIED:   // m
                    Log.d(TAG, "onMeasure heidhtMode:UNSPECIFIED");
                    heightSize = h;
                    break;
            }
            setMeasuredDimension(widthSize, heightSize);
            //生成一个MeasureSpec的数
//            MeasureSpec.makeMeasureSpec();
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }


    }
}

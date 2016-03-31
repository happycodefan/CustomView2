package com.doublefang.customview2;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by DoubleFang on 2016/3/29.
 */
public class CustomView extends View {
    private static final String TAG = CustomView.class.getName();

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // 模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec); //
        // 大小
        int widthSize = MeasureSpec.getSize(widthMeasureSpec); // 在不同模式下size有不同的意义
        switch (widthMode) {
            case MeasureSpec.UNSPECIFIED: // 真正的包裹内容，不是在一定区间内包裹内容，当父控件可以滑动的时候会出现
                Log.d(TAG, "onMeasure widthMode:UNSPECIFIED");
                // size 没有意义
                widthSize = 200;

                break;
            case MeasureSpec.AT_MOST: // wrap_content
                Log.d(TAG, "onMeasure widthMode:AT_MOST");
                // size表示不能超过的值
                widthSize = Math.min(200, widthSize);

                break;
            case MeasureSpec.EXACTLY: // *dp
                Log.d(TAG, "onMeasure widthMode:EXACTLY");
                // size 表示宽度

                break;
        }

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        switch (heightMode) {
            case MeasureSpec.UNSPECIFIED:
//                Log.d(TAG, "onMeasure heightMode:UNSPECIFIED");
                heightSize = 200;

                break;
            case MeasureSpec.AT_MOST:
//                Log.d(TAG, "onMeasure heightMode:AT_MOST");
                heightSize = Math.min(200, heightSize);

                break;
            case MeasureSpec.EXACTLY:
//                Log.d(TAG, "onMeasure heightMode:EXACTLY");

                break;
        }

        setMeasuredDimension(widthSize,heightSize);
    }


    /**
     * 1.
     * 父控件：wrap_content --> AT_MOST 计算子控件中的最大宽度
     * 子控件: match_patent --> EXACTLY 父控件计算完后，子控件计算自己的宽度
     *
     *
     *
     *
     * a. listView 固定高度问题：
     * 设置item的外布局为 200dp：得到的还是 UNSPECIFIED
     *
     *
     * 测试：
     * 1. 子控件指定宽高时：
     *      父：match   e e
     *      父：wrap   e e
     *      父：指定值  a a
     * 2. 子控件wrap
     *      父: match   a a
     *      父：wrap   a a
     *      父：指定值  a a
     *
     *3. 子控件match
     *      父: match ae ae
     *      父：wrap ae ae
     *      父：指定值 ee ee ee
     *
     *
     *
     * */
}

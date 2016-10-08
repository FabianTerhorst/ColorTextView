package io.fabianterhorst.colortextview.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by fabianterhorst on 05.10.16.
 */

public class BenchmarkTextView extends TextView {

    public BenchmarkTextView(Context context) {
        super(context);
    }

    public BenchmarkTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BenchmarkTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BenchmarkTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        long time = System.nanoTime();
        super.onDraw(canvas);
        Log.d("time2 onDraw()", String.valueOf(System.nanoTime() - time));
    }
}

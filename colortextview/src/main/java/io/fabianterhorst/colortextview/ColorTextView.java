package io.fabianterhorst.colortextview;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by fabianterhorst on 05.10.16.
 */

public class ColorTextView extends View {

    private ColoredTexts coloredTexts;

    public ColorTextView(Context context) {
        super(context);
    }

    public ColorTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ColorTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ColorTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setColoredTextList(ColoredTexts coloredTexts) {
        this.coloredTexts = coloredTexts;
        coloredTexts.measure();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("color_text_view", "onDraw()");
        long time = System.nanoTime();
        ColoredText coloredText;
        int offset = 0;
        for (int i = 0, length = coloredTexts.size(); i < length; i++) {
            coloredText = coloredTexts.get(i);
            canvas.drawText(coloredText.getText(), offset, coloredText.getMargin(), coloredText.getPaint());
            offset += coloredText.getWidth();
        }
        Log.d("time onDraw()", String.valueOf(System.nanoTime() - time));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(
                MeasureSpec.makeMeasureSpec(coloredTexts.getWidth(), MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(coloredTexts.getHeight(), MeasureSpec.EXACTLY)
        );
    }
}

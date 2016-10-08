package io.fabianterhorst.colortextview;

import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.ColorInt;

/**
 * Created by fabianterhorst on 05.10.16.
 */

public class ColoredText {

    private String text;

    private Paint paint;

    private float width;

    private int bottom;

    private int margin;

    public ColoredText(@ColorInt int color, String text, int textSize) {
        this(color, text, Typeface.DEFAULT, textSize);
    }

    public ColoredText(@ColorInt int color, String text, Typeface typeface, int textSize) {
        this.text = text;
        this.paint = new Paint();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        if (typeface != Typeface.DEFAULT) {
            paint.setTypeface(typeface);
        }
        paint.setTextSize(textSize);
        this.width = paint.measureText(text);
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        bottom = bounds.bottom;
        margin = Math.round(paint.getTextSize() + paint.getFontMetrics().leading);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Paint getPaint() {
        return paint;
    }

    public float getWidth() {
        return width;
    }

    public int getMargin() {
        return margin;
    }

    public int getBottom() {
        return bottom;
    }
}

package io.fabianterhorst.colortextview.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;

import io.fabianterhorst.colortextview.ColorTextView;
import io.fabianterhorst.colortextview.ColoredText;
import io.fabianterhorst.colortextview.ColoredTexts;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ColorTextView colorTextView = (ColorTextView) findViewById(R.id.color_text_view);
        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
        long time = System.nanoTime();
        SpannableStringBuilder string = new SpannableStringBuilder();
        for(int i = 0;i < 100;i++) {
            string.append("green yyy black");
            string.setSpan(new ForegroundColorSpan(Color.GREEN), 0, 5, 0);
            string.setSpan(new ForegroundColorSpan(Color.CYAN), 6, 10, 0);
            string.setSpan(new ForegroundColorSpan(Color.BLACK), 10, 15, 0);
        }
        textView.setText(string);
        Log.d("time span", String.valueOf(System.nanoTime() - time));
        time = System.nanoTime();
        ColoredTexts coloredTexts = new ColoredTexts();
        for(int i = 0;i < 100;i++) {
            coloredTexts.add(new ColoredText(Color.GREEN, "green ", 40));
            coloredTexts.add(new ColoredText(Color.CYAN, "yyy ", 40));
            coloredTexts.add(new ColoredText(Color.BLACK, "black", 40));
        }
        colorTextView.setColoredTextList(coloredTexts);
        Log.d("time colored", String.valueOf(System.nanoTime() - time));
    }
}

package io.fabianterhorst.colortextview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabianterhorst on 05.10.16.
 */

public class ColoredTexts {

    private List<ColoredText> coloredTexts = new ArrayList<>();

    private int height;

    private int width;

    private void invalidate() {
        height = -1;
        width = -1;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<ColoredText> getColoredTexts() {
        return coloredTexts;
    }

    public void add(ColoredText coloredText) {
        coloredTexts.add(coloredText);
    }

    public ColoredText get(int index) {
        return coloredTexts.get(index);
    }

    public int size() {
        return coloredTexts.size();
    }

    void measure() {
        ColoredText coloredText;
        width = 0;
        height = 0;
        int currentHeight;
        for (int i = 0, length = coloredTexts.size(); i < length; i++) {
            coloredText = coloredTexts.get(i);
            width += coloredText.getWidth();
            currentHeight = coloredText.getMargin() + coloredText.getBottom();
            if(height < currentHeight) {
                height = currentHeight;
            }
        }
    }
}

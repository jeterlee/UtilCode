package com.jeterlee.utilcode.converter;

import com.jeterlee.utilcode.Utils;

/**
 * UnitConverter helps to convert dp or sp size into pixel.
 *
 * @author Leonardo Taehwan Kim
 */
public class UnitConverter {

    public static float dpToPx(float dp) {
        return dp * Utils.getDisplayMetrics().density;
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Utils.getDisplayMetrics().density + 0.5f);
    }

    public static float pxToDp(float px) {
        return px / Utils.getDisplayMetrics().density;
    }

    public static int pxToDp(int px) {
        return (int) (px / Utils.getDisplayMetrics().density + 0.5f);
    }

    public static float spToPx(float sp) {
        return sp * Utils.getDisplayMetrics().scaledDensity;
    }

    public static int spToPx(int sp) {
        return (int) (sp * Utils.getDisplayMetrics().scaledDensity + 0.5f);
    }

    public static float pxToSp(float px) {
        return px / Utils.getDisplayMetrics().scaledDensity;
    }

    public static int pxToSp(int px) {
        return (int) (px / Utils.getDisplayMetrics().scaledDensity + 0.5f);
    }
}
package com.jeterlee.utilcode;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.AnyRes;
import android.support.annotation.ArrayRes;
import android.support.annotation.BoolRes;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntegerRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.PluralsRes;
import android.support.annotation.RawRes;
import android.support.annotation.StringRes;
import android.support.annotation.XmlRes;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.jeterlee.utilcode.common.APILevel;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;

/**
 * ResourcesUtils helps to manage conveniently.
 *
 * author Leonardo Taehwan Kim
 */
public class ResourcesUtils {

    private static void finishPreloading() {
        Utils.getResources().finishPreloading();
    }

    private static void flushLayoutCache() {
        Utils.getResources().flushLayoutCache();
    }

    public static XmlResourceParser getAnimation(@AnimRes int animRes) {
        return Utils.getResources().getAnimation(animRes);
    }

    public static AssetManager getAssets() {
        return Utils.getResources().getAssets();
    }

    public static boolean getBoolean(@BoolRes int boolRes) {
        return Utils.getResources().getBoolean(boolRes);
    }

    @ColorInt
    public static int getColor(@ColorRes int colorRes) {
        return ContextUtils.getColor(colorRes);
    }

    @ColorInt
    public static int getColor(@ColorRes int colorRes, Resources.Theme theme) {
        if (APILevel.require(23)) {
            return Utils.getResources().getColor(colorRes, theme);
        } else {
            return getColor(colorRes);
        }
    }

    public static ColorStateList getColorStateList(@ColorRes int colorRes) {
        return ContextUtils.getColorStateList(colorRes);
    }

    public static ColorStateList getColorStateList(@ColorRes int colorRes, Resources.Theme theme) {
        if (APILevel.require(23)) {
            return Utils.getResources().getColorStateList(colorRes, theme);
        } else {
            return getColorStateList(colorRes);
        }
    }

    public static Configuration getConfiguration() {
        return Utils.getConfiguration();
    }

    public static float getDimension(@DimenRes int dimenRes) {
        return Utils.getResources().getDimension(dimenRes);
    }

    public static int getDimensionPixelOffset(@DimenRes int dimenRes) {
        return Utils.getResources().getDimensionPixelOffset(dimenRes);
    }

    public static int getDimensionPixelSize(@DimenRes int dimenRes) {
        return Utils.getResources().getDimensionPixelSize(dimenRes);
    }

    public static DisplayMetrics getDisplayMetrics() {
        return Utils.getDisplayMetrics();
    }

    public static Drawable getDrawable(@DrawableRes int drawableRes) {
        return ContextUtils.getDrawable(drawableRes);
    }

    public static Drawable getDrawable(@DrawableRes int drawableRes, Resources.Theme theme) {
        if (APILevel.require(21)) {
            return Utils.getResources().getDrawable(drawableRes, theme);
        } else {
            return Utils.getResources().getDrawable(drawableRes);
        }
    }

    public static Drawable getDrawableForDensity(@DrawableRes int drawableRes, int density) {
        if (APILevel.require(21)) {
            return Utils.getResources().getDrawableForDensity(drawableRes, density, Utils.getContext().getTheme());
        } else if (APILevel.require(15)) {
            return Utils.getResources().getDrawableForDensity(drawableRes, density);
        } else {
            return Utils.getResources().getDrawable(drawableRes);
        }
    }

    public static int getIdentifier(String name, String defType, String defPackage) {
        return Utils.getResources().getIdentifier(name, defType, defPackage);
    }

    public static int[] getIntArray(@ArrayRes int arrayRes) {
        return Utils.getResources().getIntArray(arrayRes);
    }

    public static int getInteger(@IntegerRes int integerRes) {
        return Utils.getResources().getInteger(integerRes);
    }

    public static XmlResourceParser getLayout(@LayoutRes int layoutRes) {
        return Utils.getResources().getLayout(layoutRes);
    }

    public static Movie getMovie(@RawRes int rawRes) {
        return Utils.getResources().getMovie(rawRes);
    }

    public static String getQuantityString(int id, int quantity, Object... formatArgs) {
        return Utils.getResources().getQuantityString(id, quantity, formatArgs);
    }

    public static String getQuantityString(@PluralsRes int pluralsRes, int quantity) throws Resources.NotFoundException {
        return Utils.getResources().getQuantityString(pluralsRes, quantity);
    }

    public static CharSequence getQuantityText(int id, int quantity) {
        return Utils.getResources().getQuantityText(id, quantity);
    }

    public static String getResourceEntryName(@AnyRes int anyRes) {
        return Utils.getResources().getResourceEntryName(anyRes);
    }

    public static String getResourceName(@AnyRes int anyRes) {
        return Utils.getResources().getResourceName(anyRes);
    }

    public static String getResourcePackageName(@AnyRes int anyRes) {
        return Utils.getResources().getResourcePackageName(anyRes);
    }

    public static String getResourceTypeName(@AnyRes int anyRes) {
        return Utils.getResources().getResourceTypeName(anyRes);
    }

    public static String getString(@StringRes int stringRes) {
        return Utils.getResources().getString(stringRes);
    }

    public static String getString(@StringRes int stringRes, Object... formatArgs) {
        return Utils.getResources().getString(stringRes, formatArgs);
    }

    public static String[] getStringArray(@ArrayRes int arrayRes) {
        return Utils.getResources().getStringArray(arrayRes);
    }

    public static Resources getSystem() {
        return Utils.getResources();
    }

    public static CharSequence getText(@StringRes int stringRes, CharSequence def) {
        return Utils.getResources().getText(stringRes, def);
    }

    public static CharSequence getText(@StringRes int stringRes) {
        return Utils.getResources().getText(stringRes);
    }

    public static CharSequence[] getTextArray(@ArrayRes int arrayRes) {
        return Utils.getResources().getTextArray(arrayRes);
    }

    public static void getValue(String name, TypedValue outValue, boolean resolveRefs) {
        Utils.getResources().getValue(name, outValue, resolveRefs);
    }

    public static void getValue(@AnyRes int anyRes, TypedValue outValue, boolean resolveRefs) {
        Utils.getResources().getValue(anyRes, outValue, resolveRefs);
    }

    public static void getValueForDensity(@AnyRes int anyRes, int density, TypedValue outValue, boolean resolveRefs) {
        if (APILevel.require(15)) {
            Utils.getResources().getValueForDensity(anyRes, density, outValue, resolveRefs);
        } else {
            Utils.getResources().getValue(anyRes, outValue, resolveRefs);
        }
    }

    public static XmlResourceParser getXml(@XmlRes int xmlRes) {
        return Utils.getResources().getXml(xmlRes);
    }

    public static Resources.Theme newTheme() {
        return Utils.getResources().newTheme();
    }

    public static TypedArray obtainAttributes(AttributeSet set, int[] attrs) {
        return Utils.getResources().obtainAttributes(set, attrs);
    }

    public static TypedArray obtainTypedArray(@ArrayRes int anyRes) {
        return Utils.getResources().obtainTypedArray(anyRes);
    }

    public static InputStream openRawResource(@RawRes int rawRes) {
        return Utils.getResources().openRawResource(rawRes);
    }

    public static InputStream openRawResource(@RawRes int rawRes, TypedValue value) {
        return Utils.getResources().openRawResource(rawRes, value);
    }

    public static AssetFileDescriptor openRawResourceFd(@RawRes int rawRes) {
        return Utils.getResources().openRawResourceFd(rawRes);
    }

    public static void parseBundleExtra(String tagName, AttributeSet attrs, Bundle outBundle) throws XmlPullParserException {
        Utils.getResources().parseBundleExtra(tagName, attrs, outBundle);
    }

    public static void parseBundleExtras(XmlResourceParser parser, Bundle outBundle) throws XmlPullParserException, IOException {
        Utils.getResources().parseBundleExtras(parser, outBundle);
    }

    public static void updateConfiguration(Configuration config, DisplayMetrics metrics) {
        Utils.getResources().updateConfiguration(config, metrics);
    }

    // Added methods
    public static int[] getColorArray(@ArrayRes int array) {
        if (array == 0) {
            return null;
        }

        TypedArray typedArray = Utils.getResources().obtainTypedArray(array);
        int[] colors = new int[typedArray.length()];
        for (int i = 0; i < typedArray.length(); i++) {
            colors[i] = typedArray.getColor(i, 0);
        }
        typedArray.recycle();
        return colors;
    }
}
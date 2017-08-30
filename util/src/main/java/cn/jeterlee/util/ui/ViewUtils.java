package cn.jeterlee.util.ui;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;

import cn.jeterlee.util.Utils;
import cn.jeterlee.util.assist.EmptyUtils;
import cn.jeterlee.util.etc.APILevel;

/**
 * ViewUtil helps to set background drawable conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class ViewUtils {

    private ViewUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void setBackground(View view, Drawable drawable) {
        if (view == null) return;

        if (APILevel.require(16)) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void setBackground(View view, @DrawableRes int drawableRes) {
        if (view == null) return;

        if (APILevel.require(16)) {
            view.setBackground(Utils.getResources().getDrawable(drawableRes));
        } else {
            view.setBackgroundDrawable(Utils.getResources().getDrawable(drawableRes));
        }
    }

    public static String getText(@NonNull View view) {
        if (view instanceof EditText) {
            return ((EditText) view).getText().toString().trim();
        }
        return null;
    }

    public static boolean getTextIsEmpty(@NonNull View view) {
        return EmptyUtils.isEmpty(getText(view));
    }

    public static boolean getTextIsNotEmpty(@NonNull View view) {
        return EmptyUtils.isNotEmpty(getText(view));
    }
}
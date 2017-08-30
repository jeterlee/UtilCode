package cn.jeterlee.util.ui;

import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.jeterlee.util.R;
import cn.jeterlee.util.content.Ctx;
import cn.jeterlee.util.content.Res;
import cn.jeterlee.util.etc.APILevel;
import cn.jeterlee.util.service.WindowManagerUtils;

/**
 * DisplayUtil helps to calculate screen size conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class DisplayUtils {

    private DisplayUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    // 屏幕基准
    public static final Double BASE_SCREEN_WIDTH = 320.0D;
    public static final Double BASE_SCREEN_HEIGHT = 480.0D;

    private static final int[] APPCOMPAT_CHECK_ATTRS = {R.attr.colorPrimary};

    public static void checkAppCompatTheme() {
        TypedArray a = Ctx.obtainStyledAttributes(APPCOMPAT_CHECK_ATTRS);
        final boolean failed = !a.hasValue(0);
        a.recycle();
        if (failed) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme "
                    + "(or descendant) with the design library.");
        }
    }

    /**
     * 获取屏幕的宽
     *
     * @return 屏幕的宽
     */
    public static int getWidth() {
        Display display = WindowManagerUtils.getDefaultDisplay();
        if (APILevel.require(13)) {
            Point size = new Point();
            display.getSize(size);
            return size.x;
        } else {
            return display.getWidth();
        }
    }

    /**
     * 获取屏幕的高
     *
     * @return 屏幕的高
     */
    public static int getHeight() {
        Display display = WindowManagerUtils.getDefaultDisplay();
        if (APILevel.require(13)) {
            Point size = new Point();
            display.getSize(size);
            return size.y;
        } else {
            return display.getHeight();
        }
    }

    public static int getStatusBarHeight() {
        int resourceId = Res.getIdentifier("status_bar_height", "dimen", "android");
        return resourceId > 0 ? Res.getDimensionPixelSize(resourceId) : 0;
    }

    public static int getNavigationBarHeight() {
        int resourceId = Res.getIdentifier("navigation_bar_height", "dimen", "android");
        return resourceId > 0 ? Res.getDimensionPixelSize(resourceId) : 0;
    }

    /**
     * 缩放文字大小,这样设置的好处是文字的大小不和密度有关
     * 能够使文字大小在不同的屏幕上显示比例正确
     *
     * @param textView   button
     * @param sizePixels px值
     */
    public static void setTextSize(TextView textView, float sizePixels) {
        float scaledSize = scaleTextValue(sizePixels);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, scaledSize);
    }

    /**
     * 描述：根据屏幕大小缩放.
     *
     * @param value the px value
     * @return the int
     */
    public static int scaleValue(float value) {
        DisplayMetrics mDisplayMetrics = Res.getDisplayMetrics();
        // 为了兼容尺寸小密度大的情况
        if (mDisplayMetrics.scaledDensity > 2) {
            // 缩小到密度分之一
            value = value * (1.1f - 1.0f / mDisplayMetrics.scaledDensity);
        }
        return scale(mDisplayMetrics.widthPixels, mDisplayMetrics.heightPixels, value);
    }

    /**
     * 描述：根据屏幕大小缩放文本.
     *
     * @param value the px value
     * @return the int
     */
    public static int scaleTextValue(float value) {
        DisplayMetrics mDisplayMetrics = Res.getDisplayMetrics();
        // 为了兼容尺寸小密度大的情况
        if (mDisplayMetrics.scaledDensity > 2) {
            // 缩小到密度分之一
            //value = value*(1.1f - 1.0f/mDisplayMetrics.scaledDensity);
        }
        return scale(mDisplayMetrics.widthPixels, mDisplayMetrics.heightPixels, value);
    }

    /**
     * 描述：根据屏幕大小缩放.
     *
     * @param displayWidth  the display width
     * @param displayHeight the display height
     * @param pxValue       the px value
     * @return the int
     */
    public static int scale(int displayWidth, int displayHeight, float pxValue) {
        if (pxValue == 0) {
            return 0;
        }
        float scale = 1;
        try {
            float scaleWidth = (float) (displayWidth / BASE_SCREEN_WIDTH);
            float scaleHeight = (float) (displayHeight / BASE_SCREEN_HEIGHT);
            scale = Math.min(scaleWidth, scaleHeight);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Math.round(pxValue * scale + 0.5f);
    }

    /**
     * 设置PX padding.
     *
     * @param view   the view
     * @param left   the left padding in pixels
     * @param top    the top padding in pixels
     * @param right  the right padding in pixels
     * @param bottom the bottom padding in pixels
     */
    public static void setPadding(View view, int left, int top, int right, int bottom) {
        int scaledLeft = scaleValue(left);
        int scaledTop = scaleValue(top);
        int scaledRight = scaleValue(right);
        int scaledBottom = scaleValue(bottom);
        view.setPadding(scaledLeft, scaledTop, scaledRight, scaledBottom);
    }

    /**
     * 设置view margin
     *
     * @param view   the view
     * @param left   the left padding in pixels
     * @param top    the top padding in pixels
     * @param right  the right padding in pixels
     * @param bottom the bottom padding in pixels
     */
    public static void setMargins(View view, int left, int top, int right, int bottom) {
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            p.setMargins(left, top, right, bottom);
            view.requestLayout();
        }
    }
}

package cn.jeterlee.util.service;

import android.view.Display;
import android.view.View;
import android.view.WindowManager;

/**
 * WindowManagerUtil helps to manage {@link WindowManager} conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class WindowManagerUtils {

    private WindowManagerUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Display getDefaultDisplay() {
        return ServiceUtils.getWindowManager().getDefaultDisplay();
    }

    public static void removeViewImmediate(View view) {
        ServiceUtils.getWindowManager().removeViewImmediate(view);
    }
}
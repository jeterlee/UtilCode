package cn.jeterlee.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;

/**
 * Utils helps to get {@link Context}, {@link Resources},
 * {@link AssetManager}, {@link Configuration} and
 * {@link DisplayMetrics} in any class.
 *
 * @author Leonardo Taehwan Kim
 */
public class Utils {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    public static void initialize(@NonNull Context context) {
        Utils.context = context;
    }

    public static Context getContext() {
        synchronized (Utils.class) {
            if (Utils.context == null)
                throw new NullPointerException("Call Utils.initialize(context) " +
                        "within your Application onCreate() method.");

            return Utils.context.getApplicationContext();
        }
    }

    public static Resources getResources() {
        return Utils.getContext().getResources();
    }

    public static Resources.Theme getTheme() {
        return Utils.getContext().getTheme();
    }

    public static AssetManager getAssets() {
        return Utils.getContext().getAssets();
    }

    public static Configuration getConfiguration() {
        return Utils.getResources().getConfiguration();
    }

    public static DisplayMetrics getDisplayMetrics() {
        return Utils.getResources().getDisplayMetrics();
    }

}

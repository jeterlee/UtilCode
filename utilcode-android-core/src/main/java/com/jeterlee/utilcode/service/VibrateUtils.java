package com.jeterlee.utilcode.service;

import android.os.Vibrator;

/**
 * 震动
 * <p>All methods requires the caller to hold the permission
 * {@link android.Manifest.permission#VIBRATE}.
 */
@SuppressWarnings("deprecation")
public class VibrateUtils {

    private VibrateUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * Vibrate constantly for the specified period of time.
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#VIBRATE}.
     *
     * @param milliseconds The number of milliseconds to vibrate.
     */
    public static void vibrate(long milliseconds) {
        Vibrator vibrator = ServiceUtils.getVibrator();
        vibrator.vibrate(milliseconds);
    }

    /**
     * Vibrate with a given pattern.
     * <p/>
     * <p>
     * Pass in an array of ints that are the durations for which to turn on or off
     * the vibrator in milliseconds.  The first value indicates the number of milliseconds
     * to wait before turning the vibrator on.  The next value indicates the number of milliseconds
     * for which to keep the vibrator on before turning it off.  Subsequent values alternate
     * between durations in milliseconds to turn the vibrator off or to turn the vibrator on.
     * </p><p>
     * To cause the pattern to repeat, pass the index into the pattern array at which
     * to start the repeat, or -1 to disable repeating.
     * </p>
     * <p>This method requires the caller to hold the permission
     * {@link android.Manifest.permission#VIBRATE}.
     *
     * @param pattern an array of longs of times for which to turn the vibrator on or off.
     * @param repeat  the index into pattern at which to repeat, or -1 if
     *                you don't want to repeat.
     */
    public static void vibrate(long[] pattern, int repeat) {
        Vibrator vibrator = ServiceUtils.getVibrator();
        vibrator.vibrate(pattern, repeat);
    }
}

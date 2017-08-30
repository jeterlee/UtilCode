package cn.jeterlee.util.content;

import android.annotation.TargetApi;
import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.annotation.StyleableRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import cn.jeterlee.util.Utils;

/**
 * ContextUtils helps to manage {@link Context} conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class ContextUtils {

    public static boolean bindService(Intent service, ServiceConnection conn, int flags) {
        return Utils.getContext().bindService(service, conn, flags);
    }

    public static int checkCallingOrSelfPermission(String permission) {
        return Utils.getContext().checkCallingOrSelfPermission(permission);
    }

    public static int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        return Utils.getContext().checkCallingOrSelfUriPermission(uri, modeFlags);
    }

    public static int checkCallingPermission(String permission) {
        return Utils.getContext().checkCallingPermission(permission);
    }

    public static int checkCallingUriPermission(Uri uri, int modeFlags) {
        return Utils.getContext().checkCallingUriPermission(uri, modeFlags);
    }

    public static int checkPermission(String permission, int pid, int uid) {
        return Utils.getContext().checkPermission(permission, pid, uid);
    }

    public static int checkSelfPermission(@NonNull String permission) {
        return ContextCompat.checkSelfPermission(Utils.getContext(), permission);
    }

    public static int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        return Utils.getContext().checkUriPermission(uri, pid, uid, modeFlags);
    }

    public static int checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        return Utils.getContext().checkUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags);
    }

    public static Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        return Utils.getContext().createPackageContext(packageName, flags);
    }

    public static boolean deleteFile(String name) {
        return Utils.getContext().deleteFile(name);
    }

    public static boolean deleteDatabase(String name) {
        return Utils.getContext().deleteDatabase(name);
    }

    public static void enforceCallingOrSelfPermission(String permission, String message) {
        Utils.getContext().enforceCallingOrSelfPermission(permission, message);
    }

    public static void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
        Utils.getContext().enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }

    public static void enforceCallingPermission(String permission, String message) {
        Utils.getContext().enforceCallingPermission(permission, message);
    }

    public static void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
        Utils.getContext().enforceCallingUriPermission(uri, modeFlags, message);
    }

    public static void enforcePermission(String permission, int pid, int uid, String message) {
        Utils.getContext().enforcePermission(permission, pid, uid, message);
    }

    public static void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
        Utils.getContext().enforceUriPermission(uri, pid, uid, modeFlags, message);
    }

    public static void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
        Utils.getContext().enforceUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags, message);
    }

    public static String[] fileList() {
        return Utils.getContext().fileList();
    }

    public static Context getApplicationContext() {
        return Utils.getContext().getApplicationContext();
    }

    public static ApplicationInfo getApplicationInfo() {
        return Utils.getContext().getApplicationInfo();
    }

    public static AssetManager getAssets() {
        return Utils.getContext().getAssets();
    }

    public static File getCacheDir() {
        return Utils.getContext().getCacheDir();
    }

    public static ClassLoader getClassLoader() {
        return Utils.getContext().getClassLoader();
    }

    @ColorInt
    public static int getColor(@ColorRes int colorRes) {
        return ContextCompat.getColor(Utils.getContext(), colorRes);
    }

    public static ColorStateList getColorStateList(@ColorRes int colorRes) {
        return ContextCompat.getColorStateList(Utils.getContext(), colorRes);
    }

    public static ContentResolver getContentResolver() {
        return Utils.getContext().getContentResolver();
    }

    public static File getDir(String name, int mode) {
        return Utils.getContext().getDir(name, mode);
    }

    public static Drawable getDrawable(@DrawableRes int drawableRes) {
        return ContextCompat.getDrawable(Utils.getContext(), drawableRes);
    }

    @Nullable
    @TargetApi(8)
    public static File getExternalCacheDir() {
        return Utils.getContext().getExternalCacheDir();
    }

    public static File[] getExternalCacheDirs() {
        return ContextCompat.getExternalCacheDirs(Utils.getContext());
    }

    @Nullable
    @TargetApi(8)
    public static File getExternalFilesDir(String type) {
        return Utils.getContext().getExternalFilesDir(type);
    }

    public static File[] getExternalFilesDirs(String type) {
        return ContextCompat.getExternalFilesDirs(Utils.getContext(), type);
    }

    @TargetApi(21)
    public static File[] getExternalMediaDirs() {
        return Utils.getContext().getExternalMediaDirs();
    }

    public static File getFileStreamPath(String name) {
        return Utils.getContext().getFileStreamPath(name);
    }

    public static File getFilesDir() {
        return Utils.getContext().getFilesDir();
    }

    public static Looper getMainLooper() {
        return Utils.getContext().getMainLooper();
    }

    @TargetApi(11)
    public static File getObbDir() {
        return Utils.getContext().getObbDir();
    }

    public static File[] getObbDirs() {
        return ContextCompat.getObbDirs(Utils.getContext());
    }

    @TargetApi(8)
    public static String getPackageCodePath() {
        return Utils.getContext().getPackageCodePath();
    }

    public static PackageManager getPackageManager() {
        return Utils.getContext().getPackageManager();
    }

    public static String getPackageName() {
        return Utils.getContext().getPackageName();
    }

    @TargetApi(8)
    public static String getPackageResourcePath() {
        return Utils.getContext().getPackageResourcePath();
    }

    public static Resources getResources() {
        return Utils.getContext().getResources();
    }

    public static SharedPreferences getSharedPreferences(String name, int mode) {
        return Utils.getContext().getSharedPreferences(name, mode);
    }

    public static String getString(@StringRes int stringRes) {
        return Utils.getContext().getString(stringRes);
    }

    public static String getString(@StringRes int stringRes, Object... formatArgs) {
        return Utils.getContext().getString(stringRes, formatArgs);
    }

    @TargetApi(23)
    public static <T> T getSystemService(Class<T> serviceClass) {
        return Utils.getContext().getSystemService(serviceClass);
    }

    public static Object getSystemService(String name) {
        return Utils.getContext().getSystemService(name);
    }

    @TargetApi(23)
    public static String getSystemServiceName(Class<?> serviceClass) {
        return Utils.getContext().getSystemServiceName(serviceClass);
    }

    public static CharSequence getText(@StringRes int stringRes) {
        return Utils.getContext().getText(stringRes);
    }

    public static Resources.Theme getTheme() {
        return Utils.getContext().getTheme();
    }

    public static Drawable getWallpaper() {
        return WallpaperManager.getInstance(Utils.getContext()).getDrawable();
    }

    public static int getWallpaperDesiredMinimumHeight() {
        return WallpaperManager.getInstance(Utils.getContext()).getDesiredMinimumHeight();
    }

    public static int getWallpaperDesiredMinimumWidth() {
        return WallpaperManager.getInstance(Utils.getContext()).getDesiredMinimumWidth();
    }

    public static void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        Utils.getContext().grantUriPermission(toPackage, uri, modeFlags);
    }

    public static boolean isRestricted() {
        return Utils.getContext().isRestricted();
    }

    public static TypedArray obtainStyledAttributes(@StyleableRes int[] attrs) {
        return Utils.getContext().obtainStyledAttributes(attrs);
    }

    public static TypedArray obtainStyledAttributes(AttributeSet set, @StyleableRes int[] attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        return Utils.getContext().obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes);
    }

    public static TypedArray obtainStyledAttributes(AttributeSet set, @StyleableRes int[] attrs) {
        return Utils.getContext().obtainStyledAttributes(set, attrs);
    }

    public static TypedArray obtainStyledAttributes(@StyleRes int resid, @StyleableRes int[] attrs) {
        return Utils.getContext().obtainStyledAttributes(resid, attrs);
    }

    public static FileInputStream openFileInput(String name) throws FileNotFoundException {
        return Utils.getContext().openFileInput(name);
    }

    public static FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        return Utils.getContext().openFileOutput(name, mode);
    }

    public static Drawable peekWallpaper() {
        return WallpaperManager.getInstance(Utils.getContext()).peekDrawable();
    }

    @TargetApi(14)
    public static void registerComponentCallbacks(ComponentCallbacks callback) {
        Utils.getContext().registerComponentCallbacks(callback);
    }

    public static Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return Utils.getContext().registerReceiver(receiver, filter);
    }

    public static Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        return Utils.getContext().registerReceiver(receiver, filter, broadcastPermission, scheduler);
    }

//    public static void removeStickyBroadcast(Intent intent) {
//        Utils.getContext().removeStickyBroadcast(intent);
//    }
//
//    @TargetApi(17)
//    public static void removeStickyBroadcastAsUser(Intent intent, UserHandle user) {
//        Utils.getContext().removeStickyBroadcastAsUser(intent, user);
//    }

    public static void revokeUriPermission(Uri uri, int modeFlags) {
        Utils.getContext().revokeUriPermission(uri, modeFlags);
    }

    public static void sendBroadcast(Intent intent, String receiverPermission) {
        Utils.getContext().sendBroadcast(intent, receiverPermission);
    }

    public static void sendBroadcast(Intent intent) {
        Utils.getContext().sendBroadcast(intent);
    }

    @TargetApi(17)
    public static void sendBroadcastAsUser(Intent intent, UserHandle user) {
        Utils.getContext().sendBroadcastAsUser(intent, user);
    }

    @TargetApi(17)
    public static void sendBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission) {
        Utils.getContext().sendBroadcastAsUser(intent, user, receiverPermission);
    }

    public static void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        Utils.getContext().sendOrderedBroadcast(intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }

    public static void sendOrderedBroadcast(Intent intent, String receiverPermission) {
        Utils.getContext().sendOrderedBroadcast(intent, receiverPermission);
    }

    @TargetApi(17)
    public static void sendOrderedBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        Utils.getContext().sendOrderedBroadcastAsUser(intent, user, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }

//    public static void sendStickyBroadcast(Intent intent) {
//        Utils.getContext().sendStickyBroadcast(intent);
//    }
//
//    @TargetApi(17)
//    public static void sendStickyBroadcastAsUser(Intent intent, UserHandle user) {
//        Utils.getContext().sendStickyBroadcastAsUser(intent, user);
//    }
//
//    public static void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
//        Utils.getContext().sendStickyOrderedBroadcast(intent, resultReceiver, scheduler, initialCode, initialData, initialExtras);
//    }
//
//    @TargetApi(17)
//    public static void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle user, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
//        Utils.getContext().sendStickyOrderedBroadcastAsUser(intent, user, resultReceiver, scheduler, initialCode, initialData, initialExtras);
//    }

    public static void setTheme(@StyleRes int styleRes) {
        Utils.getContext().setTheme(styleRes);
    }

    public static void setWallpaper(InputStream data) throws IOException {
        WallpaperManager.getInstance(Utils.getContext()).setStream(data);
    }

    public static void setWallpaper(Bitmap bitmap) throws IOException {
        WallpaperManager.getInstance(Utils.getContext()).setBitmap(bitmap);
    }

    public static boolean startActivities(Intent[] intents, Bundle options) {
        for (Intent intent : intents)
            if (intent != null)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return ContextCompat.startActivities(Utils.getContext(), intents, options);
    }

    public static boolean startActivities(Intent[] intents) {
        for (Intent intent : intents)
            if (intent != null)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        return ContextCompat.startActivities(Utils.getContext(), intents);
    }

    public static void startActivity(@NonNull Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Utils.getContext().startActivity(intent);
    }

    @TargetApi(16)
    public static void startActivity(Intent intent, Bundle options) {
        Utils.getContext().startActivity(intent, options);
    }

    public static boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments) {
        return Utils.getContext().startInstrumentation(className, profileFile, arguments);
    }

    @TargetApi(16)
    public static void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        Utils.getContext().startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }

    public static void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        Utils.getContext().startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    public static ComponentName startService(Intent service) {
        return Utils.getContext().startService(service);
    }

    public static boolean stopService(Intent service) {
        return Utils.getContext().stopService(service);
    }

    public static void unbindService(ServiceConnection conn) {
        Utils.getContext().unbindService(conn);
    }

    @TargetApi(14)
    public static void unregisterComponentCallbacks(ComponentCallbacks callback) {
        Utils.getContext().unregisterComponentCallbacks(callback);
    }

    public static void unregisterReceiver(BroadcastReceiver receiver) {
        Utils.getContext().unregisterReceiver(receiver);
    }
}
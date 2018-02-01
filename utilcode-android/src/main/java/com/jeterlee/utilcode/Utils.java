/*Blankj/AndroidUtilCode is licensed under the

            Apache License 2.0

    A permissive license whose main conditions
 require preservation of copyright and license notices.
 Contributors provide an express grant of patent rights.
 Licensed works, modifications, and larger works may be
 distributed under different terms and without source code.*/

package com.jeterlee.utilcode;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.Log;

import com.jeterlee.utilcode.common.PermissionUtils;

import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 16/12/08
 *     desc  : Utils 初始化相关
 * </pre><pre>
 *     author: Leonardo Taehwan Kim
 *
 *     Utils helps to get in any class.
 * </pre><pre>
 *     desc: 更新完善 Utils 初始化相关
 *     email: xqlee120@yeah.net
 *     date: 2018/1/31 0031
 *     author jeterlee
 * </pre>
 */
public final class Utils {

    @SuppressLint("StaticFieldLeak")
    private static Context sContext;

    private static WeakReference<Activity> sTopActivityWeakRef;
    static List<Activity> sActivityList = new LinkedList<>();

    private static ActivityLifecycleCallbacks mCallbacks = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            sActivityList.add(activity);
            setTopActivityWeakRef(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
            setTopActivityWeakRef(activity);
        }

        @Override
        public void onActivityResumed(Activity activity) {
            setTopActivityWeakRef(activity);
        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            sActivityList.remove(activity);
        }
    };

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(@NonNull final Context context) {
        Utils.sContext = context;
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(mCallbacks);
        } else {
            Log.w("Utils", "Application don't register activity lifecycle! " +
                    "Please init within application! ");
        }
    }

    /**
     * 获取 Context
     *
     * @return Context
     */
    public static Context getContext() {
        synchronized (Utils.class) {
            if (Utils.sContext == null) {
                throw new NullPointerException("Call Utils.init(context) " +
                        "within your Application onCreate() method.");
            }

            return Utils.sContext.getApplicationContext();
        }
    }

    /**
     * 获取 Resources
     *
     * @return Resources
     */
    public static Resources getResources() {
        return getContext().getResources();
    }

    /**
     * 获取 Theme
     *
     * @return Theme
     */
    public static Resources.Theme getTheme() {
        return getContext().getTheme();
    }

    /**
     * 获取 Assets
     *
     * @return Assets
     */
    public static AssetManager getAssets() {
        return getContext().getAssets();
    }

    /**
     * 获取 Assets
     *
     * @return Assets
     */
    public static Configuration getConfiguration() {
        return getResources().getConfiguration();
    }

    /**
     * 获取 DisplayMetrics
     *
     * @return DisplayMetrics
     */
    public static DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    private static void setTopActivityWeakRef(final Activity activity) {
        if (activity.getClass() == PermissionUtils.PermissionActivity.class) {
            return;
        }
        if (sTopActivityWeakRef == null || !activity.equals(sTopActivityWeakRef.get())) {
            sTopActivityWeakRef = new WeakReference<>(activity);
        }
    }
}

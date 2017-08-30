package cn.jeterlee.util.etc;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.InvalidParameterException;

/**
 * ============================================================
 * <p>
 * 作者 : xqlee
 * <p>
 * 创建日期 : 2017/7/7 0007
 * <p>
 * 描述 : 项目中对于一些并不复杂的耗时操作，比如计算，不频繁操作数据库等，因为没必要使用线程池，
 * 所以之前项目会直接使用new Thread的方式，时间一长，回头再看，原来new Thread之处已经很多了，
 * 这样带来了一些问题：不断的new Thread，损耗性能。在有生命周期的类（Activity或者Fragment或者Service）
 * 中，有可能出现内存泄漏。缺乏统一管理，维护不方便。
 * <p>
 * 对于任务量小，操作不那么频繁的，我们只需要放在一个后台线程中即能满足要求，思路是只需要分门别类就可以了，
 * 对于操作数据库的，都使用data线程，对于计算相关的，都使用background线程，这样整个项目只需要维护几个固定后台线程。
 * <p>
 * 注意：
 * 1. data 和 background 都是线程的名字，可以自己添加或者定义。
 * 因为项目中已经维护了自己封装的线程池，所有涉及到下载，请求等大量I/O操作会使用线程池。
 * 2. 在绑定生命周期的api中使用，需要主动 removeCallBacks，防止内存泄漏。
 * <p>
 * 修订历史 :
 * <p>
 * 恩斯迈电子(深圳)有限公司-版权所有
 * Copyright (c) 2017. All Rights Reserved.
 * <p>
 * ============================================================
 **/
public class ThreadManager {

    private static final int THREAD_SIZE = 3;

    /**
     * 主线程
     */
    public static final int THREAD_UI = 0;
    /**
     * background线程，用于一般的耗时操作
     */
    public static final int THREAD_BACKGROUND = 1;
    /**
     * data线程，用于数据库操作
     */
    public static final int THREAD_DATA = 2;

    @IntDef({THREAD_UI, THREAD_BACKGROUND, THREAD_DATA})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    /**
     * 线程信息数组
     */
    private static final Handler[] HANDLER_LIST = new Handler[THREAD_SIZE];
    private static final String[] THREAD_NAME_LIST = {
            "thread_ui",
            "thread_background",
            "thread_data"
    };

    private ThreadManager() {
        HANDLER_LIST[THREAD_UI] = new Handler();
    }

    private static class ThreadManagerHolder {
        private static ThreadManager sManager = new ThreadManager();
    }

    public static ThreadManager getManager() {
        return ThreadManagerHolder.sManager;
    }

    /**
     * 派发任务
     *
     * @param index 线程类型
     * @param r     任务
     */
    public void post(@Type int index, Runnable r) {
        postDelayed(index, r, 0);
    }

    /**
     * 延迟派发任务
     *
     * @param index       线程类型
     * @param r           任务
     * @param delayMillis 延迟时间
     */
    public void postDelayed(@Type int index, Runnable r, long delayMillis) {
        Handler handler = getHandler(index);
        handler.postDelayed(r, delayMillis);
    }

    /**
     * 删除任务
     *
     * @param index 线程类型
     * @param r     任务
     */
    public void removeCallbacks(@Type int index, Runnable r) {
        Handler handler = getHandler(index);
        handler.removeCallbacks(r);
    }

    /**
     * 获取线程Handler
     *
     * @param index 线程类型
     * @return 线程信息
     */
    public Handler getHandler(@Type int index) {
        if (index < 0 || index >= THREAD_SIZE) {
            throw new InvalidParameterException();
        }
        if (HANDLER_LIST[index] == null) {
            synchronized (HANDLER_LIST) {
                if (HANDLER_LIST[index] == null) {
                    HandlerThread thread = new HandlerThread(THREAD_NAME_LIST[index]);
                    if (index != THREAD_UI) {
                        // 优先级要低于主线程
                        thread.setPriority(Thread.MIN_PRIORITY);
                    }
                    thread.start();
                    Handler handler = new Handler(thread.getLooper());
                    HANDLER_LIST[index] = handler;
                }
            }
        }
        return HANDLER_LIST[index];
    }

    /**
     * 判断是否运行在当前线程
     *
     * @param index 线程类型
     * @return {@code true}: 运行在当前线程<br>{@code false}: 反之
     */
    public boolean runningOnCurrent(@Type int index) {
        return getHandler(index).getLooper() == Looper.myLooper();
    }
}

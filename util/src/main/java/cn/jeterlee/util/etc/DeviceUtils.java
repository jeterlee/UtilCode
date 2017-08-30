package cn.jeterlee.util.etc;

import android.annotation.SuppressLint;
import android.provider.Settings;

import java.util.UUID;

import cn.jeterlee.util.service.ServiceUtils;

import static cn.jeterlee.util.content.ContextUtils.getContentResolver;

/**
 * ============================================================
 * <p>
 * 作者 : xqlee
 * <p>
 * 创建日期 : 2017/5/5 0005
 * <p>
 * 描述 : 读取设备的唯一标识,uuid标识.
 * -  注意添加权限 ：<uses-permission android:name="android.permission.READ_PHONE_STATE"/>
 * <p>
 * 修订历史 :
 * <p>
 * 恩斯迈电子(深圳)有限公司-版权所有
 * Copyright (c) 2017. All Rights Reserved.
 * <p>
 * ============================================================
 **/
public class DeviceUtils {

    private DeviceUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 获取AndroidId
     *
     * @return AndroidId
     */
    @SuppressLint("HardwareIds")
    public static String getAndroidId() {
        return Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    /**
     * 获取DeviceId
     *
     * @return DeviceId
     */
    @SuppressWarnings("deprecation")
    @SuppressLint("HardwareIds")
    public static String getDeviceId() {
        return ServiceUtils.getTelephonyManager().getDeviceId();
    }

    /**
     * 获取SimSerialNumber
     *
     * @return SimSerialNumber
     */
    @SuppressLint("HardwareIds")
    public static String getSimSerialNumber() {
        return ServiceUtils.getTelephonyManager().getSimSerialNumber();
    }

    /**
     * 设备的uuid
     *
     * @return uuid
     */
    public static String getDeviceUuid() {
        UUID uuid = new UUID(getAndroidId().hashCode(), ((long) getDeviceId().hashCode() << 32) |
                getSimSerialNumber().hashCode());
        return uuid.toString();
    }
}

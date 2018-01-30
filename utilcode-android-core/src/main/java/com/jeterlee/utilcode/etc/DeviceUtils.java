package com.jeterlee.utilcode.etc;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;

import com.jeterlee.utilcode.Ctx;
import com.jeterlee.utilcode.service.ServiceUtils;

import java.util.UUID;

import static com.jeterlee.utilcode.content.ContextUtils.getContentResolver;

/**
 * 读取设备的唯一标识,uuid标识.
 * -  注意添加权限 ：<uses-permission android:name="android.permission.READ_PHONE_STATE"/>
 *
 * @author jeterlee
 * @date 2018/1/30 0030
 * @email xqlee120@yeah.net
 */
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
        if (ActivityCompat.checkSelfPermission(Ctx.getApplicationContext(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }
        return ServiceUtils.getTelephonyManager().getDeviceId();
    }

    /**
     * 获取SimSerialNumber
     *
     * @return SimSerialNumber
     */
    @SuppressLint("HardwareIds")
    public static String getSimSerialNumber() {
        if (ActivityCompat.checkSelfPermission(Ctx.getApplicationContext(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }
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

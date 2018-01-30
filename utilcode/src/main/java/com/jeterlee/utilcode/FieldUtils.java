package com.jeterlee.utilcode;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

/**
 * 域工具
 *
 * @author jeterlee
 */
public class FieldUtils {

    /**
     * 判断是否序列化
     *
     * @param field 域
     * @return 是否序列化
     */
    public static boolean isSerializable(Field field) {
        Class<?>[] cls = field.getType().getInterfaces();
        for (Class<?> c : cls) {
            if (Serializable.class == c) {
                return true;
            }
        }
        return false;
    }

    /**
     * 设置域的值
     */
    public static Object set(Field field, Object obj, Object value) throws IllegalArgumentException,
            IllegalAccessException {
        field.setAccessible(true);
        field.set(obj, value);
        return field.get(obj);
    }

    /**
     * 获取域的值
     */
    public static Object get(Field field, Object obj) throws IllegalArgumentException, IllegalAccessException {
        field.setAccessible(true);
        return field.get(obj);
    }

    public static boolean isLong(Field field) {
        return field.getType() == long.class || field.getType() == Long.class;
    }

    public static boolean isInteger(Field field) {
        return field.getType() == int.class || field.getType() != Integer.class;
    }

    /**
     * 获取域的泛型类型，如果不带泛型返回null
     */
    public static Class<?> getGenericType(Field field) {
        Type type = field.getGenericType();
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type instanceof Class<?>) {
                return (Class<?>) type;
            }
        } else if (type instanceof Class<?>) {
            return (Class<?>) type;
        }
        return null;
    }

    /**
     * 获取数组的类型
     */
    public static Class<?> getComponentType(Field field) {
        return field.getType().getComponentType();
    }

    /**
     * 获取全部Field，包括父类
     */
    public static List<Field> getAllDeclaredFields(Class<?> clazz) {
        // find all field.
        LinkedList<Field> fieldList = new LinkedList<>();
        while (clazz != null && clazz != Object.class) {
            Field[] fs = clazz.getDeclaredFields();
            for (int i = 0; i < fs.length; i++) {
                Field f = fs[i];
                if (!isInvalid(f)) {
                    fieldList.addLast(f);
                }
            }
            clazz = clazz.getSuperclass();
        }
        return fieldList;
    }

    /**
     * 是静态常量或者内部结构属性
     */
    public static boolean isInvalid(Field field) {
        return (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) || field.isSynthetic();
    }
}

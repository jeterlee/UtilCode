package com.jeterlee.utilcode.data;

import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

/**
 * SparseArrayUtil helps to manage SparseArray conveniently.
 *
 * @author Leonardo Taehwan Kim
 */
public class SparseArrayUtils {

    public static <C> List<C> asArrayList(SparseArray<C> sparseArray) {
        if (sparseArray == null) {
            return new ArrayList<>();
        }

        ArrayList<C> arrayList = new ArrayList<>(sparseArray.size());
        for (int i = 0; i < sparseArray.size(); i++) {
            arrayList.add(sparseArray.valueAt(i));
        }
        return arrayList;
    }
}
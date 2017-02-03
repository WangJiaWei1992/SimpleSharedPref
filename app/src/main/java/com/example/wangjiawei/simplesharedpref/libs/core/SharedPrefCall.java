package com.example.wangjiawei.simplesharedpref.libs.core;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.wangjiawei.simplesharedpref.App;

/**
 * Created by WangJiaWei on 2017/2/3.
 */

public class SharedPrefCall<T> implements Call<T>  {

    private final ServiceMethod<T> serviceMethod;

    private String mStrSharedPreferenceName = null;
    private SharedPreferences mShardPreferences = null;

    public SharedPrefCall(ServiceMethod<T> serviceMethod) {
        this.serviceMethod = serviceMethod;

        mStrSharedPreferenceName = App.getContext().getPackageName() + "_preferences";
        mShardPreferences = App.getContext().getSharedPreferences(mStrSharedPreferenceName, Context.MODE_PRIVATE);
    }

    @Override
    public T get() {
        String key = serviceMethod.getKey();
        String defaultValue = serviceMethod.getDefault();
        Class<T> cls = serviceMethod.getTypeClass();

        try {
            if (cls == Integer.class) {
                return cls.cast(getIntValue(key, Integer.parseInt(defaultValue)));
            } else if (cls == Float.class) {
                return cls.cast(getFloatValue(key, Float.parseFloat(defaultValue)));
            } else if (cls == Boolean.class) {
                return cls.cast(getBooleanValue(key, Boolean.parseBoolean(defaultValue)));
            } else if (cls == Long.class) {
                return cls.cast(getLongValue(key, Long.parseLong(defaultValue)));
            } else if (cls == String.class) {
                return cls.cast(getStringValue(key, defaultValue));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void put(T t) {
        String key = serviceMethod.getKey();
        Class cls = serviceMethod.getTypeClass();

        try {
            if (cls == Integer.class) {
                setIntValue(key, (Integer) t);
            } else if (cls == Float.class) {
                setFloatValue(key, (Float) t);
            } else if (cls == Boolean.class) {
                setBooleanValue(key, (Boolean) t);
            } else if (cls == Long.class) {
                setLongValue(key, (Long) t);
            } else if (cls == String.class) {
                setStringValue(key, (String) t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getLongValue(String key, long defValue) {
        return getSharedPreference().getLong(key, defValue);
    }

    public boolean getBooleanValue(String key, boolean defValue) {
        return getSharedPreference().getBoolean(key, defValue);
    }

    public int getIntValue(String key, int defValue) {
        return getSharedPreference().getInt(key, defValue);
    }

    public float getFloatValue(String key, float defValue) {
        return getSharedPreference().getFloat(key, defValue);
    }

    public String getStringValue(String key, String defValue) {
        return getSharedPreference().getString(key, defValue);
    }

    public void setBooleanValue(String key, boolean value) {
        SharedPreferences.Editor editor = getSharedPreference().edit();
        editor.putBoolean(key, value);
        applyToEditor(editor);
    }

    public void setLongValue(String key, long value) {
        SharedPreferences.Editor editor = getSharedPreference().edit();
        editor.putLong(key, value);
        applyToEditor(editor);
    }

    public void setIntValue(String key, int value) {
        SharedPreferences.Editor editor = getSharedPreference().edit();
        editor.putInt(key, value);
        applyToEditor(editor);
    }

    public void setFloatValue(String key, float value) {
        SharedPreferences.Editor editor = getSharedPreference().edit();
        editor.putFloat(key, value);
        applyToEditor(editor);
    }

    public void setStringValue(String key, String value) {
        SharedPreferences.Editor editor = getSharedPreference().edit();
        editor.putString(key, value);
        applyToEditor(editor);
    }

    private SharedPreferences getSharedPreference() {
        return mShardPreferences;
    }

    private void applyToEditor(SharedPreferences.Editor editor) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) {
            editor.apply();
        } else {
            editor.commit();
        }
    }
}

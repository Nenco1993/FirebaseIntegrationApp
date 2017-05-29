package com.example.neven.firebaseintegrationapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Neven on 27.5.2017..
 */
public class SharedPrefsUtils {

    private Context context;

    public SharedPrefsUtils(Context context) {
        this.context = context;
    }

    public void storeRegIdInPref(String token) {
        SharedPreferences pref = context.getSharedPreferences("sharedpreferences", 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("regId", token);
        editor.apply();
    }
}

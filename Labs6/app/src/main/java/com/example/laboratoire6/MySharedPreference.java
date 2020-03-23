package com.example.laboratoire6;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreference {

    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    public MySharedPreference (Context context) {
        settings = context.getSharedPreferences("MyPref", 0);
        editor = settings.edit();
    }

    public void save(String text){
        editor.putString("textView", text);
        editor.commit(); // commit changes

    }

    public String getValue(){
        return settings.getString("textView", null);
    }

    public void clearSharedPreferences(){
        editor.clear();
        editor.commit(); // commit changes
    }
}

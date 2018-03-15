package com.example.fanny.projetfinal;

import android.content.Context;
import android.content.SharedPreferences;

public class Tools {
    public static void setSource(Context c, String source){
        SharedPreferences sharedPref = c.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("last_source", source);
        editor.apply();
    }
    public static String getSource(Context c){
        SharedPreferences sharedPref = c.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String defaultValue = "lequipe";
        return sharedPref.getString("last_source", defaultValue);
    }
}

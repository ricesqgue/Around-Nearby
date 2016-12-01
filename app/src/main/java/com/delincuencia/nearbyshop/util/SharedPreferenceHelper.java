package com.delincuencia.nearbyshop.util;

import android.content.Context;
import android.content.SharedPreferences;

/***
 * Created by Ricardo on 01/12/2016.
 */
public class SharedPreferenceHelper {

    private static String PREFERENCES_FILE_NAME = "MisPreferencias";
    private static final String ID = "ID";
    private static final String USERNAME = "USERNAME";
    private static final String FIRSTNAME = "FIRSTNAME";
    private static final String LASTNAME = "LASTNAME";
    private static final String SEX = "SEX";
    private static final String ADDRESS = "ADDRESS";
    private static final String REMEMBER = "REMEMBER";


    public static SharedPreferences getSharedPreferences(Context context) {

        SharedPreferences prefs = context.getSharedPreferences(PREFERENCES_FILE_NAME,
                Context.MODE_PRIVATE);

        return prefs;
    }

    public static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();

        return editor;
    }


    public static void putID(Context context, String value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(ID, value);
        editor.commit();
    }

    public static String getID(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        prefs.getString(ID, "");
        return prefs.getString(ID, "");
    }

    public static void putUsername(Context context, String value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(USERNAME, value);
        editor.commit();
    }

    public static String getUsername(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        prefs.getString(USERNAME, "");
        return prefs.getString(USERNAME, "");
    }

    public static void putFirstname(Context context, String value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(FIRSTNAME, value);
        editor.commit();
    }

    public static String getFirstname(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        prefs.getString(FIRSTNAME, "");
        return prefs.getString(FIRSTNAME, "");
    }

    public static void putLastname(Context context, String value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(LASTNAME, value);
        editor.commit();
    }

    public static String getLastname(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        prefs.getString(LASTNAME, "");
        return prefs.getString(LASTNAME, "");
    }

    public static void putSex(Context context, String value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(SEX, value);
        editor.commit();
    }

    public static String getSex(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        prefs.getString(SEX, "");
        return prefs.getString(SEX, "");
    }

    public static void putAddress(Context context, String value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(ADDRESS, value);
        editor.commit();
    }

    public static String getAddress(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        prefs.getString(ADDRESS, "");
        return prefs.getString(ADDRESS, "");
    }

    public static void putRemember(Context context, Boolean value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(REMEMBER, value);
        editor.commit();
    }

    public static Boolean getRemember(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        prefs.getBoolean(REMEMBER, false);
        return prefs.getBoolean(REMEMBER, false);
    }


}

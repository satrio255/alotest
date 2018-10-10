package com.tsj.alotest;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by tunggul.jati on 09/10/2018.
 */

public class App extends android.app.Application {

    private static App currentApplication;
    private SharedPreferences appSharedPreferences;
    private SharedPreferences ncAppSharedPreferences;

    public App()
    {
        currentApplication = this;
    }

    public static synchronized App getInstance(){return currentApplication;}

    @Override
    public void onCreate() {
        super.onCreate();
        setupAppSharedPreferences();
        currentApplication = this;
    }

    private void setupAppSharedPreferences(){
        this.appSharedPreferences = getSharedPreferences(App.class.getSimpleName(), Context.MODE_PRIVATE);
        this.ncAppSharedPreferences = getSharedPreferences("nc"+App.class.getSimpleName(), Context.MODE_PRIVATE);

    }
    public SharedPreferences getAppSharedPreferences(){
        return appSharedPreferences;
    }

    public SharedPreferences getncAppSharedPreferences(){
        return ncAppSharedPreferences;
    }

    public static App get(Context context)
    {
        return (App) context.getApplicationContext();
    }

}

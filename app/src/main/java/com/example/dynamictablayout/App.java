package com.example.dynamictablayout;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

public class App extends Application {

    Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context =this;
    }

    public static ArrayList<String> tabList = new ArrayList<>();
    public static ArrayList<String> tablist2 = new ArrayList<>();
    public static int tab_position ;
}

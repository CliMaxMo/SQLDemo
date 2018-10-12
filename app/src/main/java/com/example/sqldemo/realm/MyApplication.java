package com.example.sqldemo.realm;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * 项目名     SQLDemo
 * 包名       com.example.sqldemo
 * 文件名     MyApplication
 * 创建者     CMW
 * 创建时间   2018/10/9
 * 描述      TODO
 */

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
    }
}

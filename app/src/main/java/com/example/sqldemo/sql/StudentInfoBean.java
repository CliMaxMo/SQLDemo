package com.example.sqldemo.sql;

import io.realm.RealmObject;

/**
 * 项目名     SQLDemo
 * 包名       com.example.sqldemo
 * 文件名     StudentInfoBean
 * 创建者     CMW
 * 创建时间   2018/10/8
 * 描述      TODO
 */

public class StudentInfoBean extends RealmObject {
    public String name;
    public int age;
    public String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

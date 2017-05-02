package com.zw.entity;

/**
 * Created by Administrator on 2017/5/2.
 */
public class User {
    private static Integer id;
    private static String user_name;
    private static String password;
    private static Integer age;
    private static  Integer roleid;

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        User.id = id;
    }

    public static String getUser_name() {
        return user_name;
    }

    public static void setUser_name(String user_name) {
        User.user_name = user_name;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static Integer getAge() {
        return age;
    }

    public static void setAge(Integer age) {
        User.age = age;
    }

    public static Integer getRoleid() {
        return roleid;
    }

    public static void setRoleid(Integer roleid) {
        User.roleid = roleid;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + user_name + ", password=" + password  + ", age=" + age +"]";
    }
}

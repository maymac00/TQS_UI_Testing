package io.cucumber.skeleton.Pages;

public class User {
    private static String user="";
    private static String pass="";

    public User(String user, String pass){
        this.user=user;
        this.pass=pass;
    }
    public static String getUser(){
        return user;
    }
    public static String getPass(){
        return pass;
    }
    public static void setUser(String u){
        User.user=u;
    }
    public static void setPass(String p){
        User.pass=p;
    }
}

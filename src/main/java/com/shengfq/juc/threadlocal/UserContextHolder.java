package com.shengfq.juc.threadlocal;

public class UserContextHolder{
    private static ThreadLocal<User> userContextHolder = new ThreadLocal<>();
    public static void setUser(User user){
        userContextHolder.set(user);
    }
    public static User getUser(){
        return userContextHolder.get();
    }
    public static void remove(){
         userContextHolder.remove();
    }
}
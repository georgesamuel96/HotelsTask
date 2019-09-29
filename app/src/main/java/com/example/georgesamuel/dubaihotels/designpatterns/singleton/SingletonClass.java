package com.example.georgesamuel.dubaihotels.designpatterns.singleton;

import java.io.Serializable;

public class SingletonClass implements Serializable {

    private static volatile SingletonClass instance;
    private SingletonClass() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public  static SingletonClass getInstance() {
        if (instance == null) { //Check for the first time
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}

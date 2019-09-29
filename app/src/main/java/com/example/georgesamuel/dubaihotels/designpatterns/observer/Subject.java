package com.example.georgesamuel.dubaihotels.designpatterns.observer;

public interface Subject {

    void registerObserver(Observer observer);

    void unregisterObserver(Observer observer);

    void notifyObservers();
}

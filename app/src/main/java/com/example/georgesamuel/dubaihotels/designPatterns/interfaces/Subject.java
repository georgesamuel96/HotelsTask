package com.example.georgesamuel.dubaihotels.designPatterns.interfaces;

public interface Subject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();
}

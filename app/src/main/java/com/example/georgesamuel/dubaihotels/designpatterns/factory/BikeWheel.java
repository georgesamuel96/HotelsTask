package com.example.georgesamuel.dubaihotels.designpatterns.factory;

public  class BikeWheel extends Wheel{
    private float diameter;
    private float width;

    public BikeWheel(float diameter, float width) {
        this.diameter = diameter;
        this.width = width;
    }

    @Override
    public float getDiameter() {
        return diameter;
    }

    @Override
    public float getWidth() {
        return width;
    }
}

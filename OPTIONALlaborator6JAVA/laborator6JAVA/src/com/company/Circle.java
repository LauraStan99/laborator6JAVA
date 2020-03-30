package com.company;
import jdk.management.resource.SimpleMeter;

import java.awt.geom.*;

public class Circle extends Ellipse2D.Double implements Item{
    public int x;
    public int y;
    public int radius;
    public String name;

    public Circle(double x0, double y0, double radius) {

        super(x0 - radius / 2, y0 - radius / 2, radius, radius);
    }

    @Override
    public double getCoordX() {
        return x;
    }

    @Override
    public double getCoordY() {
        return y;
    }
    public double getRadius(){
        return radius;
     }
    public void setName(String name) {
        this.name = name;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String getName() {
        return name;
    }

   public int getSides() {
        return -1;
   }
}

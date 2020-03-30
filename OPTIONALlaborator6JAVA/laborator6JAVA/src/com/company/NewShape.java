package com.company;

import java.awt.*;
import java.awt.geom.Path2D;
import java.sql.Struct;

public class NewShape extends Polygon implements Item{
    public String name;
    public int x;
    public int y;


    public NewShape(int x, int y )
    {
        this.addPoint( x, y-50 );
        this.addPoint( x+10 , y-25);
        this.addPoint( x+35, y-35);
        this.addPoint( x+25, y-10);
        this.addPoint( x+50, y);
        this.addPoint( x+25, y+10);
        this.addPoint( x+35, y+35);
        this.addPoint( x+10, y+25);
        this.addPoint( x, y+50);
        this.addPoint( x-10, y+25);
        this.addPoint( x-35, y+35);
        this.addPoint( x-25, y+10);
        this.addPoint( x-50, y);
        this.addPoint( x-25, y-10);
        this.addPoint( x-35, y-35);
        this.addPoint( x-10, y-25);
        this.addPoint( x, y-50);
        this.addPoint( x, y+25);
        this.addPoint( x, y+50);


    }


    public void setName(String name) {
        this.name = name;
    }

    public double getCoordX() {
        return x;
    }

    public double getCoordY() {
        return y;
    }
    public double getRadius(){
        return -1;
    }
    public int getSides(){
        return -1;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String getName() {
        return name;
    }
}
package com.company;

import java.awt.*;

public class RegularPolygon extends Polygon implements Item {
    public int x;
    public int y;
    public int radius;
    public int sides;
    public String name;

    /*
     *RegularPolygon este o clasa ce mosteneste clasa Polygon
     * x0, y0 reprezinta coordonatele mouse-ului , locul unde va fi desenat pologonul
     * radius reprezinta raza poligonului, iar sides=este numarul de laturi ale poligonului
     *pentru fiecare latura se calculeaza coordonatele in functie de raza si unghiuri
     */
    public RegularPolygon(int x0, int y0, int radius, int sides) {
        double alpha = 2 * Math.PI / sides;
        for (int i = 0; i < sides; i++) {
            double x = x0 + radius * Math.cos(alpha * i);
            double y = y0 + radius * Math.sin(alpha * i);
            this.addPoint((int) x, (int) y);
        }
    }


    public double getCoordX() {
        return x;
    }

    public double getCoordY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public int getSides() {
        return sides;
    }

    @Override
    public String getName() {
        return name;
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

    public void setSides(int sides) {
        this.sides = sides;
    }
}

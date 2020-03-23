package com.company;

import java.awt.*;

public class RegularPolygon extends Polygon {
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

}

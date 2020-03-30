package com.company;

public interface Item {
    /*
    * cu ajutorul interfetei am reusit sa creez o lista care sa contina toate figurile indiferent de tipul lor
    * clasele Circle , RegularPolygon si NewShape implementeaza aceasta interfata */
    String getName();
     double getCoordX();
     double getCoordY();
     double getRadius();
     int getSides();

}

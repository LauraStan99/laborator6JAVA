package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Shapes extends JPanel{

    final MainFrame frame;

    JComboBox availableShapes;
    JLabel saveAs ;
    JLabel loadFrom ;
    JTextField text1;
    JTextField text2;
    JButton undo= new JButton("UNDO");




    public Shapes(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public void init(){
    setLayout(new GridLayout(10, 1));
    String shapes[]={"Polygon" ,"Circle","Star"};
    availableShapes=new JComboBox(shapes);

    text1=new JTextField();
    saveAs=new JLabel("You can save as: ");


        /**
         * Pentru cele 2 noi comenzi SAVE AS si LOAD FROM
         * am actualizat functiile save si load din clasa ConfigurationPanel
         * explicatiile se gasesc acolo
         */

    text2=new JTextField();
    loadFrom=new JLabel("Load file with name(from this directory) : ");
    add(availableShapes);
    add(saveAs);
    add(text1);
    add(loadFrom);
    add(text2);
    add(undo);

    undo.addActionListener(this::deleteLastShape);
    }

    /**
     * in momentul in care este apasat butonul de UNDO se apeleaza aceasta functie
     * acesta prelucreaza lista (o lista de Item-uri care contine toate tipurile de forme:cerc,poligon,stea ; avand Interfata Item pt acest lucru)
     * de figuri desenate deja pe ecran , se calculeaza ultima forma desenata ,se compara tipul de forma desenata
     * si se STERGE apeland functia corespunzatoare fiecarei forme
     * STERGERE= este de fapt apelarea unor functii din clasa DrawingPanel care imi deseneaza o figura (cu aceleasi coordonate si dimensiuni)
     * de culoare alba deasupra celei pe care dorim sa o stergem
     *
     */

    public void deleteLastShape(ActionEvent e) {

        int indexOfLastElement=this.frame.canvas.shapesItems.size()-1;
        Item item =this.frame.canvas.shapesItems.get(indexOfLastElement);

        this.frame.canvas.shapesItems.remove(indexOfLastElement);

        if(item.getName()=="star"){
            System.out.println("star");
            this.frame.canvas.drawWhiteStar(item.getCoordX(),item.getCoordY());
            this.frame.canvas.repaint();

        }
        else if(item.getName()=="circle"){
            System.out.println("circle");
            this.frame.canvas.drawWhiteCircle(item.getCoordX(),item.getCoordY(),item.getRadius());
            this.frame.canvas.repaint();
        }
        else if(item.getName()=="polygon"){
            System.out.println("polygon");
            this.frame.canvas.drawWhitePoligon(item.getCoordX(),item.getCoordY(),item.getRadius(),item.getSides());
            this.frame.canvas.repaint();
        }
    }
}

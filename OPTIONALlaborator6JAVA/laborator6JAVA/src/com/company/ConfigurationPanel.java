package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ConfigurationPanel extends JPanel{

   final MainFrame frame;
    JLabel sidesLabel;
    JSpinner sidesField;
    JComboBox colorCombo;


    public ConfigurationPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /*
     *Functia este utilizata pentru a initializa zona ferestrei rezervate Panoului de configuratii,
     * obiectul de tip JLabel este folosit pentru a plasa textul oferit intr-un container,
     * obiectul de tip JSpinner creeaza un camp de intrare care permite sa fie selectat un numar care reprezinta numarul de laturi ale poligonului
     * numarul ales trebuie din secventa 0-100 cu posibilitatea de a incrementa sau decrementa numarul cu 1 (stepSize=1),
     * obictul de tip JComboBox este folosit pentru a creea un meniu cu posibilitate de alegere ( optiunile sunt luate dintr-un vector de string-uri)
     *la final se adauga "butoanele" pe fereastra
     */
    private void init() {

        sidesLabel= new JLabel("Number of sides for polygon:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sidesField.setValue(6);

        String colors[]={"RANDOM-COLOR","BLACK"};

        colorCombo=new JComboBox(colors);

        add(sidesLabel);
        add(sidesField);
        add(colorCombo);
    }


}

package com.company;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import javafx.scene.layout.Background;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadButton = new JButton("Load");
    JButton saveButton = new JButton("Save");
    JButton resetButton = new JButton("Reset");
    JButton exitButton =new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /*
     * Functia este utilizata pentru a initializa zona ferestrei rezervate Panoului de control
     * Se foloseste GridLayout pentru a aranja componentele ferestrei in functie de parametrii oferiti (pe o singura linie , toate cele 4 butoane)
     * Se adauga butoanele pe fereastra si se adauga functionalitati pentru fiecare in parte, pentru a raspunde cand acestea sunt solicitate
     */
    private void init() {
        setLayout(new GridLayout(1, 4));
        add(loadButton);
        add(saveButton);
        add(resetButton);
        add(exitButton);
        saveButton.addActionListener(this::save);
        loadButton.addActionListener(this::load);
        resetButton.addActionListener(this::reset);
        exitButton.addActionListener(this::exit);


    }

    /*
     * Functia save utilizeaza ImageIO care este  externsibil si cu ajutorul functiei write salveaza imaginea realizata
     * in canvas in format PNG , utilizand si FileOutputStrem pentru a salva imaginea intr-o anumita locatie
     * FileOutputStream este folosit pentru a scrie date orientate pe octeti, cum ar fi cele de tip image
     * In acelasi timp tratandu-se erorile pe parcursul rularii functiei
     */
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new FileOutputStream("./test.png"));
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }


    /*
     *Functia load se foloseste de un obiect al subclasei BufferedImage (este sublasa a clasei Image)
     * pentru a prelucra datele imaginii preluate,citite (cu ajutorul functiei read) de la locatia oferita .
     * Noua imagine este pusa pe fereastra in zona rezervata pentru Drawing si se valideaza modificarile
     * De asemenea functia createGraphics() (linia 75) permite desenarea peste imaginea incarcata
     *In acelasi timp tratandu-se erorile pe parcursul rularii functiei
     */
    public void load(ActionEvent e){

        BufferedImage newPicture;
        try {
            newPicture = ImageIO.read(new File("./hello.png"));
            this.frame.canvas.image = newPicture;
            frame.canvas.validate();
            frame.canvas.graphics = frame.canvas.image.createGraphics();
            frame.canvas.repaint();
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }

    /*
     * Pentru aceasta functie am ales ca pentru fereastra principala MainFrame(frame)
     * zona centrala de tip DrawingPanel (canvas) sa se poate reseta apeland functia createOffscreenImage()
     * care reconstruieste fundalul initial
     */

    public void reset(ActionEvent e){

        frame.canvas.createOffscreenImage();
        frame.canvas.validate();
        frame.canvas.repaint();
    }

    /*
     * Pentru functia de iesire (exit) am ales sa inchid intregul proces
     * De asemenea o alta solutie ar fi fost sa inchid doar fereastra GUI prin apelarea functiei dispose()  (ex: frame.dispose() )
     */
    public void exit(ActionEvent e)
    {
       System.exit(0);

    }

}

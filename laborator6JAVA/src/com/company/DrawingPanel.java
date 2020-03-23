package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {

    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }
/*
 * creez partea de DrawinPanel in functie de parametrii oferiti
 * si pentru a prelucra pe imagine se utilizeaza obiectul de tip Graphics2D care permite a seta un fundal alb pe toata suprafata
 * ferestrei DrawinPanel
 */
    public void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }
    /*
     * Se initializeaza zona de DrawingPanel , setandu-se dimenziunea zonei
     * functia mousePressed() este utilizata pentru a inregistra coordonatele cursorului mouse-ului
     * si apeleaza functia drawShape care deseneaza poligonul in locul respectiv
     */
    private void init() {
        this.setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            }}
        );
    }

    /*
     *Aceasta functie are ca si parametrii coordonatele ultinei actiuni ale mouse-ului
     *  in acel loc se asteapta sa se deseneze un poligon
     * poligonului i se seteaza raza si numarul de laturi
     * raza este aleasa in mod random , iar pt numarul de laturi este preluata valoarea din sectiunea ConfigurationPanel din campul adresat
     * tot in mod random este aleasa si o culoare(transparenta) pentru desenarea poligonului
     * culoarea este realizata utilizand culorile de baza (rosu, verde ,albastru) fiecare avand valori alese random
     * dupa setarea culorii se apeleaza functia RegularPolygon pentru realizarea figurii
     */
    private void drawShape(int x, int y) {
        Random rand=new Random();
        int radius = rand.nextInt(100);
        int sides = (Integer)frame.configPanel.sidesField.getValue();

        Random rand1 = new Random();
        int r = rand1.nextInt(255);
        int g = rand1.nextInt(255);
        int b = rand1.nextInt(255);
        Color color = new Color(r, g, b, 128);
        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }

    @Override
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }


}

package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel {

    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D graphics;
    List<Item> shapesItems=new ArrayList<>();

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
     * in acel loc se asteapta sa se deseneze o figura in functie de ce s-a selectat in sectiunea Shape (panoul din dreapta ferestrei)
     * din campul adresat .
     * Doar poligonului i se poate setea numarul de laturi in sectiunea ConfigurationPanel
     * raza este aleasa in mod random ,tot in mod random este aleasa si o culoare(transparenta) pentru desenarea  figurilor
     * culoarea este realizata utilizand culorile de baza (rosu, verde ,albastru) fiecare avand valori alese random
     */
    public void drawShape(int x, int y) {


        Random rand=new Random();
        int radius = rand.nextInt(100);
        int sides = (Integer)frame.configPanel.sidesField.getValue();

        Random rand1 = new Random();
        int r = rand1.nextInt(255);
        int g = rand1.nextInt(255);
        int b = rand1.nextInt(255);
        Color color = new Color(r, g, b, 128);
        Color black=Color.BLACK;

        if(this.frame.configPanel.colorCombo.getSelectedItem().equals("BLACK")) { graphics.setColor(black);}
        else{graphics.setColor(color); }

        if(this.frame.shapes.availableShapes.getSelectedItem().equals("Polygon"))
          { RegularPolygon polygon=new RegularPolygon(x, y, radius, sides);
              polygon.setName("polygon");
              polygon.setRadius(radius);
              polygon.setX(x);
              polygon.setY(y);
              polygon.setSides(sides);
              graphics.fill(polygon);
              shapesItems.add(polygon);}
         else
              if(this.frame.shapes.availableShapes.getSelectedItem().equals("Circle"))
              { Circle circle=new Circle(x,y,radius);
                circle.setName("circle");
                circle.setRadius(radius);
                circle.setX(x);
                circle.setY(y);
                graphics.fill(circle);
                shapesItems.add(circle);
               }
               else
                    if(this.frame.shapes.availableShapes.getSelectedItem().equals("Star"))
                   {   NewShape star=new NewShape(x,y);
                       star.setName("star");
                       star.setX(x);
                       star.setY(y);
                       graphics.fill(star);
                       shapesItems.add(star);
                   }

        }


/**
 * aceasta functie ajuta la stergerea figurii in cazul in care se doreste sa se stearga un polygon
 * se seteaza culoarea de desen (alba) si se umble figura ,figura construita cu ajutorul constructorului parametrizat RegularPolygon(...)
 * convertind parametrii la int , deoarece constructorul accepta parametrii de acest tip
 */

    public void drawWhitePoligon(double x,double y, double radius , int sides){
        Double newData1 = new Double(x); Double newData2 = new Double(y); Double newData3 = new Double(radius);
        int intX=newData1.intValue();
        int intY=newData2.intValue();
        int intRad=newData3.intValue();

        Color white=Color.WHITE;
        graphics.setColor(white);
        graphics.fill(new  RegularPolygon(intX,intY,intRad,sides));

    }

    /**
     * aceasta functie ajuta la stergerea figurii in cazul in care se doreste sa se stearga un cerc
     * se seteaza culoarea de desen (alba) si se umble figura ,figura construita cu ajutorul constructorului parametrizat Circle(...)
     *
     */

    public void drawWhiteCircle(double x,double y, double radius){
        Double newData1 = new Double(x); Double newData2 = new Double(y); Double newData3 = new Double(radius);
        int intX=newData1.intValue();
        int intY=newData2.intValue();
        int intRad=newData3.intValue();

        Color white=Color.WHITE;
        graphics.setColor(white);
        graphics.fill(new Circle(intX,intY,intRad));

        /**
         * aceasta functie ajuta la stergerea figurii in cazul in care se doreste sa se stearga o stea
         * se seteaza culoarea de desen (alba) si se umble figura ,figura construita cu ajutorul constructorului parametrizat NewShape(...)
         * convertind parametrii la int , deoarece constructorul accepta parametrii de acest tip
         */
    }public void drawWhiteStar(double x,double y){
        Double newData1 = new Double(x); Double newData2 = new Double(y);
        int intX=newData1.intValue();
        int intY=newData2.intValue();


        Color white=Color.WHITE;
        graphics.setColor(white);
        graphics.fill(new  NewShape(intX,intY));

    }

    @Override
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }


}

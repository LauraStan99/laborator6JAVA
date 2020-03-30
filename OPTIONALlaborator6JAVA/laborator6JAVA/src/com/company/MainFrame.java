package com.company;
import javafx.scene.layout.Background;

import javax.swing.*;
import java.awt.*;
public class MainFrame extends JFrame {

    ConfigurationPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    Shapes shapes;
    public MainFrame()
    {
        super("Drawing Application" );
        init();
    }
     /*
     *Creez cate un obiect din fiecare tip, reprezentant zone ale ferestrei principale si le pozitionez pe fereastra
     * partea de configuratii in partea de sus(NORTH) a ferestrei , partea de Drawing in centrul(CENTER) ferestrei
     * iar partea de panou de control in josul(SOUTH) ferestrei
     */

    private void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = new DrawingPanel(this);
        configPanel=new ConfigurationPanel(this);
        controlPanel=new ControlPanel(this);
        shapes=new Shapes(this);
        add(configPanel,BorderLayout.NORTH);
        add(canvas,BorderLayout.CENTER);
        add(controlPanel,BorderLayout.SOUTH);
        add(shapes, BorderLayout.EAST);
        pack();
    }


}

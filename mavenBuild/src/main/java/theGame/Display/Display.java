package theGame.Display;
import javax.swing.Icon;
import  javax.swing.JFrame;
import javax.swing.JLabel;

import controls.Control;

import java.awt.*;

//For testing
import image.Image;

public class Display {
    private JFrame frame;
    private Canvas canvas;

    private String title;
    private int width,height;

    /**
     * construction
     * @param title
     * @param width
     * @param height
     */
    public Display (String title, int width, int height, JFrame gameFrame){

        this.title = title;
        this.width = width;
        this.height = height;
        frame=gameFrame;

        createDisplay();
    }

    /**
     * create window
     */
    private void createDisplay(){
    	//frame.getContentPane().removeAll();
        //frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        canvas =new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.addKeyListener(new Control());	
        canvas.setBackground(new Color(200,200,200));
       
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    public Canvas getCanvas() {
        return canvas;
    }
}

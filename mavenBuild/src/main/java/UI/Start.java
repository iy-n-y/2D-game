package UI;


import theGame.main.Game;

import javax.swing.JFrame;
import javax.swing.*;

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * start user interface
 */
public class Start extends JFrame {
	public static JFrame frame;
	public static LayoutManager layout;
	public static int width=530;
	public static int height=450;

    public Start(){
    	frame =new JFrame();
    	frame.setTitle("Group 7 Project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width,height);
        JLabel text = new JLabel("Group 7 Project");
        JLabel text2 = new JLabel("Press Start to Begin!");
        JButton button=new JButton("Start");    
        text.setFont(new Font("SansSerif", Font.BOLD, 37));
        text2.setFont(new Font("SansSerif", Font.BOLD, 20));   
		text.setBounds(width/2-(300/2), 65, 300, 100);
		text2.setBounds(width/2-(198/2)-6, 96, 198, 100);
		button.setBounds(width/2-(140/2)-6,180,140, 40); 
		
		frame.add(button);    
		frame.add(text);  
		frame.add(text2);
		
		layout = frame.getLayout();
        frame.setLayout(null); 
        frame.setResizable(false);
        frame.setVisible(true);
  
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.setLayout(layout);
            	frame.getContentPane().removeAll();
                Game game=new Game("title",500,400-39,frame);
                game.start();
            }
        });
    }
    public static void restart() {
    	frame.getContentPane().removeAll();
    	frame.setTitle("The game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width,height);
        JLabel text = new JLabel("Group 7 Project");
        JLabel text2 = new JLabel("Press Start to Begin!");
        JButton button=new JButton("Start");    
        text.setFont(new Font("SansSerif", Font.BOLD, 37));
        text2.setFont(new Font("SansSerif", Font.BOLD, 20));   
		text.setBounds(width/2-(300/2), 65, 300, 100);
		text2.setBounds(width/2-(198/2)-6, 96, 198, 100);
		button.setBounds(width/2-(140/2)-6,180,140, 40); 
		
		frame.add(button);    
		frame.add(text);  
		frame.add(text2);
		
		layout = frame.getLayout();
        frame.setLayout(null); 
        frame.setResizable(false);
        frame.setVisible(true);
    }

 public static void main(String[] agrs){
        new Start();
 }

}
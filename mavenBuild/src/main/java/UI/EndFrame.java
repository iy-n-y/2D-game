package UI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import theGame.main.Game;

public class EndFrame {
	//Win vs Lose in constructor
	public static int width=530;
	public static int height=450;
	public static void gameLost(int score, int time) {
		Start.frame.getContentPane().removeAll();

		Start.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Start.frame.setSize(width,height);
		Start.frame.setLayout(null); 
		JLabel text = new JLabel("You've Lost!");
        JLabel text2 = new JLabel("Your score fell bellow 0.");
        
        text.setFont(new Font("SansSerif", Font.BOLD, 37));
        text2.setFont(new Font("SansSerif", Font.BOLD, 20));   
		text.setBounds(132, 95+10, 300, 100);
		text2.setBounds(135, 130+10, 300, 100);
	 
		Start.frame.add(text);  
		Start.frame.add(text2);
		Game.stop();
		return;
	}
	public static void gameWon(int score, int time) {
		Start.frame.getContentPane().removeAll();

		Start.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Start.frame.setSize(width,height);
		Start.frame.setLayout(null); 
		JLabel text = new JLabel("You've Won!");
        JLabel text2 = new JLabel("Your final score was: "+ (score) );
        JLabel text3;
        JLabel text4 = new JLabel("Time Bonus: "+ (250/((time/60/60)+1)) );
        JLabel text5 = new JLabel("Your final score is: "+ (score+250/((time/60/60)+1)) );
        
        if((time/60)%60<10)
        	 text3 = new JLabel("Your final time was: "+time/60/60+":"+"0"+(time/60)%60);
    	else
    		text3 = new JLabel("Your final time was: "+time/60/60+":"+(time/60)%60);
        
        text.setFont(new Font("SansSerif", Font.BOLD, 37));
        text2.setFont(new Font("SansSerif", Font.BOLD, 20));   
        text3.setFont(new Font("SansSerif", Font.BOLD, 20)); 
        text4.setFont(new Font("SansSerif", Font.BOLD, 20)); 
        text5.setFont(new Font("SansSerif", Font.BOLD, 20)); 
		text.setBounds(132, 95+10, 300, 100);
		text2.setBounds(135, 130+20, 300, 100);
		text3.setBounds(135, 130-95+130+10, 300, 100);
		text4.setBounds(172, 130-95+130+10+25, 300, 100);
		text5.setBounds(143, 130-95+130+10+50, 300, 100);
	 
		Start.frame.add(text);  
		Start.frame.add(text2);
		Start.frame.add(text3);
		Start.frame.add(text4);
		Start.frame.add(text5);
		Game.stop();
		return;
	}
}

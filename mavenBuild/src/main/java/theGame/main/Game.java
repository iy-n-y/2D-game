package theGame.main;

import image.Assets;
import image.SpriteSheet;
import theGame.Display.Display;
import image.Image;
import theGame.state.GameState;
import theGame.state.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

/**
The below class used to determine all class type during game running
 */
public class Game implements Runnable {
    private Display display;
    public static int width;
	public static int height;
    public String title;

    private static boolean running = false;
    private static Thread thread;

    private BufferStrategy buffer;
    private Graphics graph;
    
    private JFrame gameFrame;

    private static State gameState;

    public Game(String title, int width, int height,JFrame gameFrame) {
        this.height = height;
        this.width = width;
        this.title = title;
        this.gameFrame = gameFrame;
    }
    private void init() {
        display = new Display(title, width, height, gameFrame);
        Assets.init();
        gameState = new GameState();
        State.setState(gameState);
    }
    
    public static void reset() {
    	gameState.restart();
    }

    private void update() {
        if(State.getState() != null)
            State.getState().upDate();
    }

    private void render() {
        buffer = display.getCanvas().getBufferStrategy();
        if (buffer == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        graph = buffer.getDrawGraphics();
        graph.clearRect(0,0,width,height);
        if(State.getState() != null)
            State.getState().render(graph);

        buffer.show();
        graph.dispose();
    }

    public void run() {
        init();
        int fps =60;
        double timePerUpDate = 1000000000 /fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer=0;
        int ticks =0;

        while (running) {
            now =System.nanoTime();
            delta += (now-lastTime) / timePerUpDate;
            timer +=now -lastTime;
            lastTime = now;

            if(delta >= 1) {
                update();
                render();
                ticks++;
                delta--;
            }
            if(timer >= 1000000000 ){
                //System.out.println("Ticks and Frames"+ticks);
                ticks =0 ;
                timer = 0;
            }
        }
        stop();
        ;
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();

    }

    public synchronized static void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static int getWidth() {
    	return width;
    }
    public static int getHeight() {
    	return height;
    }

}

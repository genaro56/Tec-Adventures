/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferStrategy;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jesus
 */
public class MiniGame implements Runnable {

    /*private BufferStrategy bs;         // to have several buffers when displaying
    private Graphics g;                // to paint objects
    private Display display;           // to display in the game*/
    private Game game;
    private int width;                 // width of the window
    private int height;                // height of the window
    private Thread thread;             // thread to create the game
    private boolean running;           // to set the game 
    private KeyManager keyManager;     // to manage the keyboard
    private MouseManager mouseManager; // to manage the mouse
    private int life;                  // to manage the lifes 
    

    /**
     * to create title, width and height and set the game is still not running
     *
     * @param title to set the title of the window
     * @param width to set the width of the window
     * @param height to set the height of the window
     */
    public MiniGame(Game game, int number) {
        width = 800;
        height = 500;
        running = true;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        life = 5;
    }

    /**
     * To get the width of the game window
     *
     * @return an <code>int</code> value with the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * To get the height of the game window
     *
     * @return an <code>int</code> value with the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * initializing the display window of the game
     */
    private void init() {        
        Assets.init();
        
        //Esta es una creación individual        
        game.display.getJframe().addKeyListener(keyManager);
        
        //display.getJframe().addMouseListener(mouseManager);
        //display.getJframe().addMouseMotionListener(mouseManager);
        //display.getCanvas().addMouseListener(mouseManager);
        //display.getCanvas().addMouseMotionListener(mouseManager);
    }

    @Override
    public void run() {
        init();
        // frames per second
        int fps = 30;
        // time for each tick in nano segs
        double timeTick = 1000000000 / fps;
        // initializing delta
        double delta = 0;
        // define now to use inside the loop
        long now;
        // initializing last time to the computer time in nanosecs
        long lastTime = System.nanoTime();
        while (life > 0) {
            // setting the time now to the actual time
            now = System.nanoTime();
            // acumulating to delta the difference between times in timeTick units
            delta += (now - lastTime) / timeTick;
            // updating the last time
            lastTime = now;

            // if delta is positive we tick the game
            //Tenemos que modificar la forma en que termina el juego y es aquí
            if (delta >= 1) {
                tick();
                render();
            }
        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    private void tick() {
        keyManager.tick();
        
        //Aquí se activa cada tick del juego cuando no está pausado
        if (!getKeyManager().pause) {            
        
            // Esto podría funcionar solo si usamos enemigos
            // y lo anterior se usaría para los enemigos
            if (life < 0) {
                stop();
            }
        }
    }

    

    private void render() {
        // get the buffer strategy from the display
        game.bs = game.display.getCanvas().getBufferStrategy();
        /* if it is null, we define one with 3 buffers to display images of
        the game, if not null, then we display every image of the game but
        after clearing the Rectanlge, getting the graphic object from the 
        buffer strategy element. 
        show the graphic and dispose it to the trash system
         */
        if (game.bs == null) {
            game.display.getCanvas().createBufferStrategy(3);
        } else {
            game.g = game.bs.getDrawGraphics();
            game.g.drawImage(Assets.background, 0, 0, width, height, null);
            if (life <= 0) {
                game.g.drawImage(Assets.end, (getWidth() / 2) - 450, (getHeight() / 2) - 150, 900, 300, null);
            }
            if (getKeyManager().pause) {
                game.g.drawImage(Assets.pause, 0, (getHeight() / 3), getWidth(), getHeight() / 3, null);
            }
            game.bs.show();
            game.g.dispose();
        }

    }

    /**
     * setting the thead for the game
     */
    public synchronized void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * stopping the thread
     */
    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

}

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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jesus
 */
public class Game implements Runnable {

    public BufferStrategy bs;         // to have several buffers when displaying
    public Graphics g;                // to paint objects
    public Display display;           // to display in the game
    String title;                      // title of the window
    private int width;                 // width of the window
    private int height;                // height of the window
    private Thread thread;             // thread to create the game
    private boolean running;           // to set the game
    private Player player;             // to use a player
    //private Enemy asteroid;          // to have an enemy   
    private Mapa map;                  // to move the map
    private KeyManager keyManager;     // to manage the keyboard
    private MouseManager mouseManager; // to manage the mouse
    private int life;                  // to manage the lifes 
    //Tenemos que hacer un areglo 
    //o lista encadenada de edificios 
    //para crear todos lo que vamosa usar
    //private likedList<Edificio> edificios;
    private Edificio rectoria;
    private Edificio A2;
    private Boton boton;
    private MiniGame minigame;
    private boolean MG;

    /**
     * to create title, width and height and set the game is still not running
     *
     * @param title to set the title of the window
     * @param width to set the width of the window
     * @param height to set the height of the window
     */
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        running = false;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        life = 5;
        MG = false;
        JPanel campo = new JPanel(new GridLayout(0, 2));
        JLabel jl_pwf = new JLabel("Escriba la contraseña: ");
        campo.add(jl_pwf);
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

    public void setMG(boolean MG) {
        this.MG = MG;
    }
    public void startMinigame(int number){
        
    }

    /**
     * initializing the display window of the game
     */
    private void init() {
        display = new Display(title, getWidth(), getHeight());
        Assets.init();
        // Se crea el jugador
        player = new Player(-10, 520, -20, 50, 50, this);
        // Se cra el mapa para que se pueda desplazar la vista
        map = new Mapa(-50, -500, getHeight() * 3, getWidth() * 3, this);
        //minigame = new MiniGame(this, 1);
        // Aquí se van a crear todos los edificios dentro de la lista
        /* Algo como esto (Podemos crear un achivo 
            con todas las ubicaciones y tamaños y de ahí sacar
            la información y guardarla en un arreglo
         int iNum = (int)(Math.random()* 8 + 5);
         for(int i = 0; i < iNum; i++){
             int iPosX = (int) (Math.random() * (getWidth() - 100));
             int iPosY = (int) (Math.random() * (getHeight() *0.5d - 100) - 1.5d * getHeight());
             edifiios.add(new Edificio(iPosX, iPosY, vel, 100, 100, this));                          
         }
         */
        //Esta es una creación individual
        //Esta es una creación individual        
        //rectoria = new Edificio(370, 350, 230, 140, this, 1);
        A2 = new Edificio(470, 625, 600, 120, this, 2);
        boton = new Boton(0, 700, 100, 100, this);
        display.getJframe().addKeyListener(keyManager);

        display.getJframe().addMouseListener(mouseManager);
        display.getJframe().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
    }

    @Override
    public void run() {
        init();
        // frames per second
        int fps = 60;
        // time for each tick in nano segs
        double timeTick = 1000000000 / fps;
        // initializing delta
        double delta = 0;
        // define now to use inside the loop
        long now;
        // initializing last time to the computer time in nanosecs
        long lastTime = System.nanoTime();
        while (running) {
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
                if (life <= 0) {
                    render();
                    running = false;
                }
                delta--;
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

        //Estos son las llamadas a los métodos para 
        //guardar cargar y reiniciar
        //Pero necesitamos arreglar los métodos
        /*if (getKeyManager().guardar) {
            try {
                //Graba los valores en el archivo.
                grabaArchivo("guardado.txt");
            } catch (IOException ex) {
                System.out.println("Error en " + ex.toString());
            }
        }
        if (getKeyManager().cargar) {
            try {
                leeArchivo("guardado.txt");
            } catch (IOException ex) {
                System.out.println("Error en " + ex.toString());
            }
        }
        if (getKeyManager().reiniciar) {
            for (int i = 0; i < cObject; i++) {
                Alien alien = aliens.get(i);
                alien.setDying(false);
            }
            try {
                leeArchivo("reinicio.txt");
            } catch (IOException ex) {
                System.out.println("Error en " + ex.toString());
            }
        }*/
        //Aquí se activa cada tick del juego cuando no está pausado
        if (!getKeyManager().pause) {
            if (!MG) {
                move(getKeyManager());
                //player.tick();
                //map.tick();
                //asteroid.tick();
                //Aquí tenemos que modificar para que sean la intersecciones 
                //con los edificios y que se active la opción de minijuego
                /*usar un for para revisar todos los edificios*/
                if (rectoria.intersecta(player)) {
                    boton.setIsVisible(true);
                    minigame = new MiniGame(this, 1, width, height);
                    //boton.setEdificioNo(1);//aquí se pondría el numero del for
                    boton.tick();
                    /*asteroid.setX(getWidth()-100);
            asteroid.setY(0);
            asteroid.setVelocity(asteroid.getVelocity() + 1);
            asteroid.setColision(30);
            player.setX(0);
            player.setY(getHeight()-100);
            player.setColision(30);
            Assets.bomb.play();
            life--;*/
                } else {
                    boton.setIsVisible(false);
                    boton.setClicked(false);
                }
                // Esto podría funcionar solo si usamos enemigos
                // y lo anterior se usaría para los enemigos
                if (life < 0) {
                    stop();
                }
            } else {
                minigame.tick();
            }
        }
    }

    //Esto sirve para sincronizar los movimientos del mapa y los edificios 
    //con el jugador
    private void move(KeyManager km) {
        if (km.down || km.left || km.up || km.right) {
            if (km.right && map.getX() <= getWidth() - map.getWidth()
                    || km.right && player.getX() <= getWidth() / 4 - 50
                    || km.left && map.getX() >= -50
                    || km.left && player.getX() >= getWidth() / 4 + 50
                    || km.up && map.getY() >= 0
                    || km.up && player.getY() >= getHeight() / 2 + 50
                    || km.down && map.getY() <= getHeight() - map.getHeight()
                    || km.down && player.getY() <= getHeight() / 2 - 50) {
                player.tick();

            } else {
                map.tick();
                rectoria.tick();
                A2.tick();
            }
        }
    }

    // Tenemos que definir todas la variables que vamos a guardar 
    // en el archivo para poder arreglar las funciones
/*    public void leeArchivo(String archivo) throws IOException {

        BufferedReader fileIn;
        try {
            fileIn = new BufferedReader(new FileReader(archivo));
        } catch (FileNotFoundException e) {
            File puntos = new File(archivo);
            PrintWriter fileOut = new PrintWriter(puntos);
            fileOut.println("100,demo");
            fileOut.close();
            fileIn = new BufferedReader(new FileReader(archivo));
        }
        String dato = fileIn.readLine();
        life = (Integer.parseInt(dato));
        dato = fileIn.readLine();
        score = (Integer.parseInt(dato));
        dato = fileIn.readLine();
        alienDirection = (Integer.parseInt(dato));
        dato = fileIn.readLine();
        alienY = (Integer.parseInt(dato));
        dato = fileIn.readLine();
        player.setX((Integer.parseInt(dato)));
        dato = fileIn.readLine();
        player.setVisible((Boolean.parseBoolean(dato)));
        dato = fileIn.readLine();
        obj.setX((Integer.parseInt(dato)));
        dato = fileIn.readLine();
        obj.setY((Integer.parseInt(dato)));
        dato = fileIn.readLine();
        obj.setVisible((Boolean.parseBoolean(dato)));
        dato = fileIn.readLine();
        cObject = (Integer.parseInt(dato));
        for (int j = 0; j < cObject; j++) {
            Alien alien = aliens.get(j);
            dato = fileIn.readLine();
            alien.setX(Integer.parseInt(dato));
            dato = fileIn.readLine();
            alien.setY((Integer.parseInt(dato)));
            dato = fileIn.readLine();
            alien.setDirection(Integer.parseInt(dato));
            dato = fileIn.readLine();
            alien.setVisible(Boolean.parseBoolean(dato));
            dato = fileIn.readLine();
            alien.getBomb().setX(Integer.parseInt(dato));
            dato = fileIn.readLine();
            alien.getBomb().setY(Integer.parseInt(dato));
            dato = fileIn.readLine();
            alien.getBomb().setDestroyed(Boolean.parseBoolean(dato));
        }

        fileIn.close();
    }

    public void grabaArchivo(String archivo) throws IOException {

        PrintWriter fileOut = new PrintWriter(new FileWriter(archivo));

        fileOut.println("" + life);
        fileOut.println("" + score);
        fileOut.println("" + alienDirection);
        fileOut.println("" + alienY);
        fileOut.println("" + player.getX());
        fileOut.println("" + player.isVisible());
        fileOut.println("" + obj.getX());
        fileOut.println("" + obj.getY());
        fileOut.println("" + obj.isVisible());
        fileOut.println("" + cObject);
        for (int i = 0; i < cObject; i++) {
            Alien alien = aliens.get(i);
            fileOut.println("" + alien.getX());
            fileOut.println("" + alien.getY());
            fileOut.println("" + alien.getDirection());
            fileOut.println("" + alien.isVisible());
            fileOut.println("" + alien.getBomb().getX());
            fileOut.println("" + alien.getBomb().getY());
            fileOut.println("" + alien.getBomb().isDestroyed());
        }
        fileOut.close();
    }
     */
    private void render() {
        // get the buffer strategy from the display
        bs = display.getCanvas().getBufferStrategy();
        /* if it is null, we define one with 3 buffers to display images of
        the game, if not null, then we display every image of the game but
        after clearing the Rectanlge, getting the graphic object from the 
        buffer strategy element. 
        show the graphic and dispose it to the trash system
         */
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
        } else {

            g = bs.getDrawGraphics();
            //g.drawImage(Assets.background, 0, 0, width, height, null);
            if (!MG) {
                map.render(g);
                player.render(g);
                rectoria.render(g);
                A2.render(g);
                boton.render(g);
                //asteroid.render(g);
                g.setColor(Color.yellow);
                g.drawString("Vidas: " + life, 5, 20);
                g.setColor(Color.red);
                g.drawString("Player X: " + player.getX(), 5, 30);
                g.drawString("Player y: " + player.getY(), 5, 40);
                g.drawString("map X: " + map.getX(), 5, 50);
                g.drawString("map y: " + map.getY(), 5, 60);
                g.drawString("rectoria X: " + rectoria.getX(), 5, 70);
                g.drawString("rectoria y: " + rectoria.getY(), 5, 80);
                if (life <= 0) {
                    g.drawImage(Assets.end, (getWidth() / 2) - 450, (getHeight() / 2) - 150, 900, 300, null);
                }
                if (getKeyManager().pause) {
                    g.drawImage(Assets.pause, 0, (getHeight() / 3), getWidth(), getHeight() / 3, null);
                }
            } else {
                minigame.render(g);
            }
            bs.show();
            g.dispose();
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

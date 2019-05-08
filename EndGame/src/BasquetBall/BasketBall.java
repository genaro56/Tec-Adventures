/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasquetBall;


import static java.awt.Color.black;
import static java.awt.Color.white;
import java.awt.Font;
import java.awt.Graphics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import videogame.Game;


/**
 *
 * @author jesus
 */
public class BasketBall {

    
    private Display display;              // to display in the game
    String title;                         // title of the window
    private int width;                    // width of the window
    private int height;                   // height of the window
    private Player player;                // to use a player
    private Obj obj;                      // to use objects  
    private LinkedList<Bloque> bloques;   // to use bricks  
    private KeyManager keyManager;        // to manage the keyboard
    private int life;                     // to manage lifes
    private int score;                    // to manage the score
    private int down;                     // to manage times object toch the botton
    private int vel;                      // to manage the objects velocity
    private int cObject;                  // to control bricks' quantity 
    private String[] arr;                 //Arreglo del archivo divido.
    private boolean end;
    private Game game;

    /**
     * to create title, width and height and set the game is still not running
     *
     * @param title to set the title of the window
     * @param width to set the width of the window
     * @param height to set the height of the window
     */
    public BasketBall(Game game) {
        
        this.game = game;
        
        bloques = new LinkedList<Bloque>();
        life = 5;
        score = 0;
        down = 0;
        vel = 3;
        end = false;
        init();
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
     * To get the score of the player
     *
     * @return an <code>int</code> value with the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Set score value
     *
     * @param score to modify
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * To get the player's lifes
     *
     * @return an <code>int</code> value with the lifes
     */
    public int getLife() {
        return life;
    }

    /**
     * Set life value
     *
     * @param life to modify
     */
    public void setLife(int life) {
        this.life = life;
    }

    /**
     * to get the number of objects in the bottom
     *
     * @return
     */
    public int getDown() {
        return down;
    }

    /**
     * Set number of objects in the bottom
     *
     * @param down to modify
     */
    public void setDown(int down) {
        this.down = down;
    }

    /**
     * initializing the display window of the game
     */
    private void init() {
        Assets.init();
        int longitud = 200;
        player = new Player((game.getWidth() / 2) - longitud/2, game.getHeight() + 50, longitud, 20, game);
        //adding element obj
        obj = new Obj(game.getWidth() / 2 - 10, game.getHeight() - 100, vel, 50, 50, game, this);
        //adding elements to bricks
        int iNum = 7;
        int jNum = 4;
        cObject = iNum*jNum;
        int he = (game.getHeight()/2 - jNum*2)/jNum;
        int wi = (game.getWidth() - iNum * 5)/iNum;
        for(int i = 0; i < iNum; i++){            
            int iPosX = wi * i + 5*(i+1);
            for(int j = 0; j < jNum; j++){                
                int iPosY = he * j + 2*(j+1);
                //int level = (int)(Math.random() * 4/*cantidad de niveles*/ - 1);
            bloques.add(new Bloque(iPosX, iPosY, wi, he,1));                          
            }
        }
    }

    

    public void tick() {
        if (game.getKeyManager().guardar) {
            try {
            //Graba los valores en el archivo.
                grabaArchivo();
            } catch (IOException ex) {
                System.out.println("Error en " + ex.toString());
            }
        }
        if (game.getKeyManager().cargar) {
            try {
                leeArchivo();
            } catch (IOException ex) {
                System.out.println("Error en " + ex.toString());
            }
        }

        if (!game.getKeyManager().pause) {
            // avancing player with colision       
            player.tick();
            

            // ticking the objs
            obj.setVelocity(vel);
            obj.tick();
            // checking collision between player and object
            if (player.intersecta(obj)) {
                // increase the player's score
                setScore(getScore() + 100);
                obj.setDirY(-1);
                // play the colission sound
                Assets.eat.play();
            }
            // Change the obj dir depending on the zone of the player
            if (player.intersectaI(obj)) {
                obj.setDirX(-1);
            }
            if (player.intersectaC(obj)) {
                obj.setDirX(obj.getDirX() * 2);
            }
            if (player.intersectaD(obj)) {
                obj.setDirX(1);
            }

            for (int i = 0; i < cObject; i++) {
                Bloque bloque = bloques.get(i);
                if (bloque.intersecta(obj)) {
                    // increase the player's score
                    setScore(getScore() + 100);
                    // play the colission sound
                    Assets.eat.play();

                    // Change the obj dir depending on the zone of the player
                    if (bloque.intersectaI(obj)) {
                        obj.setDirY(obj.getDirY() * -1);
                        obj.setDirX(-1);
                    }
                    if (bloque.intersectaC(obj)) {
                        obj.setDirY(obj.getDirY() * -1);
                        obj.setDirX(obj.getDirX() * 2);
                    }
                    if (bloque.intersectaD(obj)) {
                        obj.setDirY(obj.getDirY() * -1);
                        obj.setDirX(1);
                    }
                    // Change the obj dir depending on the zone of the player
                    if (bloque.intersectaIS(obj)) {
                        obj.setDirY(-1);
                        obj.setDirX(-1);
                    }
                    if (bloque.intersectaII(obj)) {
                        obj.setDirY(1);
                        obj.setDirX(-1);
                    }
                    if (bloque.intersectaDS(obj)) {
                        obj.setDirY(-1);
                        obj.setDirX(1);
                    }
                    if (bloque.intersectaDI(obj)) {
                        obj.setDirY(1);
                        obj.setDirX(1);
                    }
                    bloque.setX(getWidth() * -1);
                }
            }

            // verify if the objects in the botton are the maximum per life
            if (down >= 10) {
                down -= 10; // reset the colissions in the life
                life--; // upgrade the lifes
                vel += 1; // increase the velocity
            }
            if(game.getKeyManager().exit || life < 1) {
                game.setScore(game.getScore() + score);
                game.setMG(false);
            }
        }

    }
    public void leeArchivo() throws IOException {

        BufferedReader fileIn;
        try {
            fileIn = new BufferedReader(new FileReader("BasquetBall.txt"));
        } catch (FileNotFoundException e) {
            File puntos = new File("BasquetBall.txt");
            PrintWriter fileOut = new PrintWriter(puntos);
            fileOut.println("100,demo");
            fileOut.close();
            fileIn = new BufferedReader(new FileReader("guardado.txt"));
        }
        String dato = fileIn.readLine();                        
            life = (Integer.parseInt(dato));
            dato = fileIn.readLine();
            score = (Integer.parseInt(dato));
            dato = fileIn.readLine();
            player.setHeight((Integer.parseInt(dato)));
            dato = fileIn.readLine();
            player.setWidth((Integer.parseInt(dato)));
            dato = fileIn.readLine();
            player.setX((Integer.parseInt(dato)));
            dato = fileIn.readLine();
            player.setY((Integer.parseInt(dato)));
            dato = fileIn.readLine();
            obj.setHeight((Integer.parseInt(dato)));
            dato = fileIn.readLine();
            obj.setWidth((Integer.parseInt(dato)));
            dato = fileIn.readLine();
            obj.setX((Integer.parseInt(dato)));
            dato = fileIn.readLine();
            obj.setY((Integer.parseInt(dato)));
            dato = fileIn.readLine();
            obj.setDirX((Integer.parseInt(dato)));
            dato = fileIn.readLine();
            obj.setDirY((Integer.parseInt(dato)));
            dato = fileIn.readLine();
            cObject = (Integer.parseInt(dato));
        for (int j = 0; j < cObject; j++) {
            Bloque bloque = bloques.get(j);
            dato = fileIn.readLine();
            bloque.setX((Integer.parseInt(dato)));
            dato = fileIn.readLine();
            bloque.setY((Integer.parseInt(dato)));
        }
        
        fileIn.close();
    }

    public void grabaArchivo() throws IOException {

        PrintWriter fileOut = new PrintWriter(new FileWriter("guardado.txt"));

        fileOut.println("" + life);
        fileOut.println("" + score);
        fileOut.println("" + player.getHeight());
        fileOut.println("" + player.getWidth());
        fileOut.println("" + player.getX());
        fileOut.println("" + player.getY());
        fileOut.println("" + obj.getHeight());
        fileOut.println("" + obj.getWidth());
        fileOut.println("" + obj.getX());
        fileOut.println("" + obj.getY());
        fileOut.println("" + obj.getDirX());
        fileOut.println("" + obj.getDirY());
        fileOut.println("" + cObject);
        for (int i = 0; i < cObject; i++) {
            Bloque bloque = bloques.get(i);
            int x, y;
            x = bloque.getX();
            y = bloque.getY();
            fileOut.println("" + x);
            fileOut.println("" + y);
        }
        fileOut.close();
    }

    public void render(Graphics g) {
        
            g.drawImage(Assets.background, 0, 0, game.getWidth(), game.getHeight(), null);
            player.render(g);
            obj.render(g);
            for (int i = 0; i < cObject; i++) {
                Bloque bloque = bloques.get(i);
                bloque.render(g);
            }

            // display score & lifes
            g.setColor(black);
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString("Vidas: " + (int) life, 5, game.getHeight() - 15);
            g.setColor(black);
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString("Puntos: " + score, game.getWidth() - 150, game.getHeight() - 15);
            // if the lifes are 0, display GameOver image
            if (life <= 0 || game.getKeyManager().pause) {
                g.drawImage(Assets.end, (game.getWidth() / 2) - 450, (game.getHeight() / 2) - 150, 900, 300, null);
            }
    }

}

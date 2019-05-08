/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasquetBall;

import java.awt.Graphics;
import java.awt.Rectangle;
import videogame.Game;

/**
 *
 * @author jesus
 */
public class Player extends Item{

    private int direction;       // direction of the player
    private int width;           // to store the width of the game
    private int height;          // to store the height of the game
    private int AWidth;          // width of the basquetball
    private int AHeight;         // height of the basquetball
    private int asteroidX;       // x direction of the basquetball
    private int asteroidY;       // y direction of the basquetball
    private Game game;           // to store the Game variable
    
    /**
     * To create the x, y, width, height and game variables
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game 
     */
    public Player(int x, int y, int width, int height, Game game) {
        super(x, y);        
        this.width = width;
        this.height = height;
        this.game = game;        
    }
    /**
     * To get the direction
     * 
     * @return an <code>int</code> value with the Direction
     */
    public int getDirection() {
        return direction;
    }
    /**
     * To get the width
     * 
     * @return an <code>int</code> value with the width
     */
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    /**
     * To set the direction value
     * 
     * @param direction 
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }
    /**
     * To set the width value
     * 
     * @param width 
     */
    public void setWidth(int width) {
        this.width = width;
    }
    /**
     * To set the height value
     * 
     * @param height 
     */
    public void setHeight(int height) {
        this.height = height;
    }
    /**
     * To get the x position of the basquetball
     * 
     * @return an <code>int</code> value with the x position
     */
    public int getAsteroidX() {
        return asteroidX;
    }
    /**
     * To get the y position of the basquetball
     * 
     * @return an <code>int</code> value with the y position
     */
    public int getAsteroidY() {
        return asteroidY;
    }
    /**
     * To set the x position value of the basquetball
     * 
     * @param asteroidX 
     */
    public void setAsteroidX(int asteroidX) {
        this.asteroidX = asteroidX;
    }
    /**
     * To set the y position value of the basquetball
     * 
     * @param asteroidY 
     */
    public void setAsteroidY(int asteroidY) {
        this.asteroidY = asteroidY;
    }
    /**
     * To get the basquetball height
     * 
     * @return an <code>int</code> value with the basquetball height
     */
    public int getAHeight() {
        return AHeight;
    }
    /**
     * To get the basquetball width
     * 
     * @return an <code>int</code> value with the basquetball with
     */
    public int getAWidth() {
        return AWidth;
    }
    /**
     * To set the height of the basquetball
     * 
     * @param AHeight 
     */
    public void setAHeight(int AHeight) {
        this.AHeight = AHeight;
    }
    /**
     *  To set the width of the basquetball
     * 
     * @param AWidth 
     */
    public void setAWidth(int AWidth) {
        this.AWidth = AWidth;
    }

    @Override
    public void tick() {
        // moving player depending on flags        
        /*if (game.getKeyManager().up) {
           setY(getY() - 5);
        }
        if (game.getKeyManager().down) {
           setY(getY() + 5);
        }*/
        if (game.getKeyManager().left) {
           setX(getX() - 5);
        }
        if (game.getKeyManager().right) {
           setX(getX() + 5);
        }
        // reset x position and y position if colision
        if (getX() + getWidth() >= game.getWidth()) {
            setX(game.getWidth() - getWidth());
        }
        else if (getX() <= 0) {
            setX(0);
        }
        if (getY() + 20 >= game.getHeight()) {
            setY(game.getHeight() - 20);
        }
        else if (getY() <= 0) {
            setY(0);
        }
    }
    /**
     * Funciton for getting the rectangle
     * 
     * @return 
     */
    public Rectangle getPerimetro(){
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }    
    /**
     * Funcion para checar interseccion
     * 
     * @param obj
     * @return 
     */
    public boolean intersecta(Obj obj){        
        return getPerimetro().intersectsLine(obj.getX(),obj.getY()+obj.getHeight(),obj.getWidth()+obj.getX(),obj.getY()+obj.getWidth());
    }
    /**
     * Funcion que regresa el perimetroI
     * 
     * @return 
     */
    public Rectangle getPerimetroI(){
        return new Rectangle(getX(), getY(), getWidth()/3, getHeight());
    }
    /**
     * Funcion que regresa el perimetroC
     * 
     * @return 
     */
    public Rectangle getPerimetroC(){
        return new Rectangle(getX()+getWidth()/3, getY(), getWidth()/3, getHeight());
    }  
    /**
     * Funcion que regresa el perimetroD
     * 
     * @return 
     */
    public Rectangle getPerimetroD(){
        return new Rectangle(getX()+2*getWidth()/3, getY(), getWidth()/3, getHeight());
    }    
    /**
     * Funcion que checa la interseccionC
     * 
     * @param obj
     * @return 
     */
    public boolean intersectaC(Obj obj){        
        return getPerimetroC().intersectsLine(obj.getX(),obj.getY()+obj.getHeight(),obj.getWidth()+obj.getX(),obj.getY()+obj.getWidth());
    }
    /**
     * Funcion que checa la interseccionI
     * 
     * @param obj
     * @return 
     */
    public boolean intersectaI(Obj obj){        
        return getPerimetroI().intersectsLine(obj.getX(),obj.getY()+obj.getHeight(),obj.getWidth()+obj.getX(),obj.getY()+obj.getWidth());
    }
    /**
     * Funcion que checa la interseccionD
     * 
     * @param obj
     * @return 
     */
    public boolean intersectaD(Obj obj){        
        return getPerimetroD().intersectsLine(obj.getX(),obj.getY()+obj.getHeight(),obj.getWidth()+obj.getX(),obj.getY()+obj.getWidth());
    }
    /**
     * player render
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);
        
    }
}

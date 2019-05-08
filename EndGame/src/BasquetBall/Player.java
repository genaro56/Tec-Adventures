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

    private int direction;
    private int width;
    private int height;
    private int AWidth;
    private int AHeight;
    private int asteroidX;
    private int asteroidY;
    private Game game;    
    
    public Player(int x, int y, int width, int height, Game game) {
        super(x, y);        
        this.width = width;
        this.height = height;
        this.game = game;        
    }

    public int getDirection() {
        return direction;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAsteroidX() {
        return asteroidX;
    }

    public int getAsteroidY() {
        return asteroidY;
    }

    public void setAsteroidX(int asteroidX) {
        this.asteroidX = asteroidX;
    }

    public void setAsteroidY(int asteroidY) {
        this.asteroidY = asteroidY;
    }

    public int getAHeight() {
        return AHeight;
    }

    public int getAWidth() {
        return AWidth;
    }

    public void setAHeight(int AHeight) {
        this.AHeight = AHeight;
    }

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
    public Rectangle getPerimetro(){
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }    
    
    public boolean intersecta(Obj obj){        
        return getPerimetro().intersectsLine(obj.getX(),obj.getY()+obj.getHeight(),obj.getWidth()+obj.getX(),obj.getY()+obj.getWidth());
    }
    public Rectangle getPerimetroI(){
        return new Rectangle(getX(), getY(), getWidth()/3, getHeight());
    }
    
    public Rectangle getPerimetroC(){
        return new Rectangle(getX()+getWidth()/3, getY(), getWidth()/3, getHeight());
    }  
    
    public Rectangle getPerimetroD(){
        return new Rectangle(getX()+2*getWidth()/3, getY(), getWidth()/3, getHeight());
    }    
    
    public boolean intersectaC(Obj obj){        
        return getPerimetroC().intersectsLine(obj.getX(),obj.getY()+obj.getHeight(),obj.getWidth()+obj.getX(),obj.getY()+obj.getWidth());
    }
    public boolean intersectaI(Obj obj){        
        return getPerimetroI().intersectsLine(obj.getX(),obj.getY()+obj.getHeight(),obj.getWidth()+obj.getX(),obj.getY()+obj.getWidth());
    }
    public boolean intersectaD(Obj obj){        
        return getPerimetroD().intersectsLine(obj.getX(),obj.getY()+obj.getHeight(),obj.getWidth()+obj.getX(),obj.getY()+obj.getWidth());
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);
        
    }
}

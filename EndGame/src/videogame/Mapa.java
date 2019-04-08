/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author jesus
 */
public class Mapa  extends Item{

    private int direction;
    private int width;
    private int height;
    private Game game;
    private int colision;
    
    public Mapa(int x, int y, int direction, int width, int height, Game game) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        colision = 0;
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

    public void setColision(int colision) {
        this.colision = colision;
    }
    

    @Override
    public void tick() {
        // moving player depending on flags
        if (game.getMouseManager().isIzquierdo()) {
            int xm = game.getMouseManager().getX();
            int ym = game.getMouseManager().getY();
                    if(xm > getX() && xm < getX() + getWidth())
                        if(ym > getY() && ym < getY() + getHeight()){
                            setX(xm-50);
                            setY(ym-50);                           
                        }                                    
            //game.getMouseManager().setIzquierdo(false);
        }
        if (game.getKeyManager().up) {
           setY(getY() + 1);
        }
        if (game.getKeyManager().down) {
           setY(getY() - 1);
        }
        if (game.getKeyManager().left) {
           setX(getX() + 1);
        }
        if (game.getKeyManager().right) {
           setX(getX() - 1);
        }
        // reset x position and y position if colision
        if (getX() + getWidth() <= game.getWidth()) {
            setX(game.getWidth() - getWidth());
        }
        else if (getX() >= -39) {
            setX(-39);
        }
        if (getY() + getHeight() <= game.getHeight()) {
            setY(game.getHeight() - getHeight());
        }
        else if (getY() >= 0) {
            setY(0);
        }
        colision--;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.map, getX(), getY(), getWidth(), getHeight(), null);        
    }
}

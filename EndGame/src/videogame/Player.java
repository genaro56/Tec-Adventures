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
public class Player extends Item{

    private int direction;
    private int width;
    private int height;
    private Game game;
    private int colision;
    
    public Player(int x, int y, int direction, int width, int height, Game game) {
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
        if (game.getKeyManager().up) {
           setY(getY() - 2);
        }
        if (game.getKeyManager().down) {
           setY(getY() + 2);
        }
        if (game.getKeyManager().left) {
           setX(getX() - 2);
        }
        if (game.getKeyManager().right) {
           setX(getX() + 2);
        }
        // reset x position and y position if colision
        if (getX() + getWidth() >= game.getWidth()) {
            setX(game.getWidth() - 100);
        }
        else if (getX() <= -10) {
            setX(-10);
        }
        if (getY() + getHeight() >= game.getHeight()) {
            setY(game.getHeight() - 100);
        }
        else if (getY() <= 0) {
            setY(0);
        }
        colision--;
    }
    public Rectangle getPerimetro(){
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    

    @Override
    public void render(Graphics g) {     
        g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);        
    }
}


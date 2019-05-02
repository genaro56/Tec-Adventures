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
    private Animation playerAr;
    private Animation playerAb;
    private Animation playerDe;
    private Animation playerIz;
    
    public Player(int x, int y, int direction, int width, int height, Game game) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        colision = 0;
        this.playerAr = new Animation(Assets.playerAr, 10);
        this.playerAb = new Animation(Assets.playerAb, 100);
        this.playerDe = new Animation(Assets.playerDe, 100);
        this.playerIz = new Animation(Assets.playerIz, 100);
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
           setY(getY() - 1);
        }
        if (game.getKeyManager().down) {
           setY(getY() + 1);
        }
        if (game.getKeyManager().left) {
           setX(getX() - 1);
        }
        if (game.getKeyManager().right) {
           setX(getX() + 1);
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
        this.playerAr.tick();
        this.playerAb.tick();
        this.playerIz.tick();
        this.playerDe.tick();
    }
    public Rectangle getPerimetro(){
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    

    @Override
    public void render(Graphics g) {
        if(game.getKeyManager().up){
            g.drawImage(playerAr.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        }
        else
        if(game.getKeyManager().down){
            g.drawImage(playerAb.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        }
        else
        if(game.getKeyManager().left){
            g.drawImage(playerIz.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        }
        else
        if(game.getKeyManager().right){
            g.drawImage(playerDe.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        }
        else
        g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);        
    }
}


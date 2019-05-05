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
    private boolean colision;
    private boolean colisionU;
    private boolean colisionD;
    private boolean colisionL;
    private boolean colisionR;
    private boolean preColision;
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
        colision = false;
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

    public void setColision(boolean colision) {
        this.colision = colision;
    }

    public Animation getPlayerAb() {
        return playerAb;
    }

    public Animation getPlayerAr() {
        return playerAr;
    }

    public Animation getPlayerDe() {
        return playerDe;
    }

    public Animation getPlayerIz() {
        return playerIz;
    }
    
    

    @Override
    public void tick() {
        if (game.getKeyManager().up ) {
            if(colision){
                if(!preColision){
                    preColision = true;
                    colisionU = true;
                }
            }else colisionU = false;            
            if(!colisionU)
            setY(getY() - 3);
        }
        if (game.getKeyManager().down) {
            if(colision){
                if(!preColision){
                    preColision = true;
                    colisionD = true;
                }
            }else colisionD = false;
            if(!colisionD)
                setY(getY() + 3);
        }
        if (game.getKeyManager().left) {
            if(colision){
                if(!preColision){
                    preColision = true;
                    colisionL = true;
                }
            }else colisionL = false;
            if(!colisionL)
                setX(getX() - 3);
            
        }
        if (game.getKeyManager().right) {
             if(colision){
                if(!preColision){
                    preColision = true;
                    colisionR = true;
                }
             }else colisionR = false;
            if(!colisionR)                
                setX(getX() + 3);
            
        }
        // reset x position and y position if colision
        if (getX() + 40 >= game.getWidth()) {
            setX(game.getWidth() - 40);
        }
        else if (getX() <= -10) {
            setX(-10);
        }
        if (getY() + getHeight() >= game.getHeight()) {
            setY(game.getHeight() - 50);
        }
        else if (getY() <= -10) {
            setY(-10);
        }
        preColision = colision;        
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


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
public class Player extends Item {

    private int direction;         //
    private int width;             //
    private int height;            //
    private Game game;             //
    private Animation playerAr;    //
    private Animation playerAb;    //
    private Animation playerDe;    //
    private Animation playerIz;    //
    private boolean caminaPasto;
    private boolean move;

    /**
     *
     * @param x
     * @param y
     * @param direction
     * @param width
     * @param height
     * @param game
     */
    public Player(int x, int y, int direction, int width, int height, Game game) {
        super(x, y);
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.game = game;
        this.playerAr = new Animation(Assets.playerAr, 10);
        this.playerAb = new Animation(Assets.playerAb, 100);
        this.playerDe = new Animation(Assets.playerDe, 100);
        this.playerIz = new Animation(Assets.playerIz, 100);
        caminaPasto = false;
    }

    /**
     *
     * @return
     */
    public int getDirection() {
        return direction;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @param direction
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     *
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    public void setCaminaPasto(boolean caminaPasto) {
        this.caminaPasto = caminaPasto;
    }
    
    

    /**
     *
     * @return
     */
    public Animation getPlayerAb() {
        return playerAb;
    }

    public Animation getPlayerAr() {
        return playerAr;
    }

    /**
     *
     * @return
     */
    public Animation getPlayerDe() {
        return playerDe;
    }

    /**
     *
     * @return
     */
    public Animation getPlayerIz() {
        return playerIz;
    }

    @Override
    public void tick() {
        move = false;
        if (game.getKeyManager().up) {
            setY(getY() - 3);
            move = true;
        }
        if (game.getKeyManager().down) {
            setY(getY() + 3);
            move = true;
        }
        if (game.getKeyManager().left) {
            setX(getX() - 3);
            move = true;
        }
        if (game.getKeyManager().right) {
            setX(getX() + 3);
            move = true;
        }
        if(move){
            if(caminaPasto){
                Assets.camina.play();                
            }
           /* else{
                Assets.camina.stop();
            }*/
        }
        /*else{
            Assets.camina.stop();
        }*/

        // reset x position and y position if colision
        if (getX() + getWidth() >= game.getWidth()) {
            setX(game.getWidth() - getWidth());
        } else if (getX() <= 0) {
            setX(0);
        }
        if (getY() + getHeight() >= game.getHeight()) {
            setY(game.getHeight() - getHeight());
        } else if (getY() <= -0) {
            setY(0);
        }
    }

    /**
     *
     * @return
     */
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void render(Graphics g) {
        if (game.getKeyManager().up) {
            g.drawImage(playerAr.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        } else if (game.getKeyManager().down) {
            g.drawImage(playerAb.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        } else if (game.getKeyManager().left) {
            g.drawImage(playerIz.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        } else if (game.getKeyManager().right) {
            g.drawImage(playerDe.getCurrentFrame(), getX(), getY(), getWidth(), getHeight(), null);
        } else {
            g.drawImage(Assets.player, getX(), getY(), getWidth(), getHeight(), null);
        }
    }
}

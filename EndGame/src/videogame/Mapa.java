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

    private int width;         // Mapa width
    private int height;        // Mapa height
    private Game game;         // game variable
    private int mN;
    /**
     * To create x, y, width, height and game variables
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game 
     */
    public Mapa(int x, int y, int width, int height, Game game, int mN) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        this.mN = mN;
    }
    /**
     * To get the width 
     *
     * @return an <code>int</code> value with the width
     */
    public int getWidth() {
        return width;
    }
    /**
     * To get the height
     *
     * @return an <code>int</code> value with the height
     */
    public int getHeight() {
        return height;
    }
    /**
     * To set width
     * @param width 
     */
    public void setWidth(int width) {
        this.width = width;
    }
    /**
     * To set height
     * @param height 
     */
    public void setHeight(int height) {
        this.height = height;
    }
    /**
     * Mapa tick
     */
    @Override
    public void tick() {
        if (game.getKeyManager().up) {
           setY(getY() + 3);
        }
        if (game.getKeyManager().down) {
           setY(getY() - 3);
        }
        if (game.getKeyManager().left) {
           setX(getX() + 3);
        }
        if (game.getKeyManager().right) {
           setX(getX() - 3);
        }
    }
    /**
     * Mapa render
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.map[mN], getX(), getY(), getWidth(), getHeight(), null);        
    }
}

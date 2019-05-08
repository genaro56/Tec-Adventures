/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Graphics;

/**
 *
 * @author jesus
 */
public abstract class Button extends Item {

    private int width;             // width
    private int height;            // height
    private Game game;             // game variable

    /**
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game
     */
    public Button(int x, int y, int width, int height, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
    }

    /**
     * Get height value
     *
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Get width value
     *
     * @return width
     */
    public int getWidth() {
        return width;
    }

    
    /**
     * 
     * @return 
     */
    public Game getGame() {
        return game;
    }
    
    
    public boolean clicked() {
        if (game.getMouseManager().isIzquierdo()) {
            int xm = game.getMouseManager().getX();
            int ym = game.getMouseManager().getY();
            if (xm >= getX() && xm <= getX() + getWidth()) {
                if (ym >= getY() && ym <= getY() + getHeight()) {
                    return true;
                }
                
            }
        } 
        return false;        
    }
}

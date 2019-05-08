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
public class pasto extends Obj{
    /**
     * To create x, y, width, height, game and edN variables
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game
     * @param edN 
     */
    public pasto(int x, int y, int width, int height, Game game, /*String name*/ int edN) {
        super(x, y,width,height,game);
    }
    /**
     * Pasto render
     * 
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

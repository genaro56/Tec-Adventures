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
<<<<<<< HEAD
    public pasto(int x, int y, int width, int height, Game game) {
=======
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
>>>>>>> a4daf64746ce1645513147357fd0aedda2310cd3
        super(x, y,width,height,game);
    }
    /**
     * Pasto render
     * 
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.boton, getX(), getY(), getWidth(), getHeight(), null);
    }
    
    
}

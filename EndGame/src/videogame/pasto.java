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
    public pasto(int x, int y, int width, int height, Game game) {
        super(x, y,width,height,game);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.boton, getX(), getY(), getWidth(), getHeight(), null);
    }
    
    
}

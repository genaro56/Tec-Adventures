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
public class obstacle  extends Obj{
    private int iNum;              // iNum var
    private int jNum;              // jNum var
    /**
     * To create x, y and game variables 
     * 
     * @param x
     * @param y
     * @param game 
     */
    public obstacle(int x, int y, Game game) {
        super(x, y,50,100,game);
        iNum = (int)(Math.random()* 5);
        jNum = (int)(Math.random()* 5);
    }
    /**
     * obstacle render
     * 
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.arbol, getX(), getY(), getWidth(), getHeight(), null);         
    }
    
}

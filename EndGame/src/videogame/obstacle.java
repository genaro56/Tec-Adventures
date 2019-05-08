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
    private int iNum;
    private int jNum;
    public obstacle(int x, int y, Game game) {
        super(x, y,25,25,game);
        iNum = (int)(Math.random()* 5);
        jNum = (int)(Math.random()* 5);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.arbol[iNum][jNum], getX(), getY(), getWidth(), getHeight(), null);         
    }
    
}

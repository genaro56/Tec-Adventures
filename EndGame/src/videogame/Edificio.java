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
public class Edificio extends Obj {    
    
    private int edN;   // numero edificio
    /**
     * To create x, y, widht, height, game and edN variable
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game
     * @param edN 
     */
    public Edificio(int x, int y, int width, int height, Game game,int edN) {
        
            super(x, y,width,height,game);            
        if(edN == 15){
            setY(getY()+100);
        }
        this.edN = edN;
    }
    /**
     * edificio render
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        if(edN == 15){
            g.drawImage(Assets.edificios[edN], getX(), getY()-100, getWidth(), getHeight(), null);
        } 
        else
            g.drawImage(Assets.edificios[edN], getX(), getY(), getWidth(), getHeight(), null);
    }
}

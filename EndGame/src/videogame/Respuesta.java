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
public class Respuesta extends Item{    
    private int width;
    private int height;
    private Game game;    
    private boolean isVisible;
    private int miniGame;
        
    public Respuesta(int x, int y, int width, int height, Game game) {
        super(x, y);        
        this.width = width;
        this.height = height;
        this.game = game;
        isVisible = false;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getMiniGame() {
        return miniGame;
    }

    public void setMiniGame(int miniGame) {
        this.miniGame = miniGame;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
    
    
    public void tick() {
        // moving player depending on flags
        if (isVisible && game.getMouseManager().isIzquierdo()) {
            int xm = game.getMouseManager().getX();
            int ym = game.getMouseManager().getY();
                    if(xm > getX() && xm < getX() + getWidth())
                        if(ym > getY() && ym < getY() + getHeight()){
                            //game.miniGame[miniGame].start();                           
                        }                                    
            //game.getMouseManager().setIzquierdo(false);
        }
    }
    
    
    public void render(Graphics g) {     
        if(isVisible)
            g.drawImage(Assets.boton, getX(), getY(), getWidth(), getHeight(), null);          
    }
    
}

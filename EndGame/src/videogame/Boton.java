/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Graphics;
import static java.time.Clock.system;
//import system

/**
 *
 * @author jesus
 */
public class Boton extends Item{    
    private int width;
    private int height;
    private Game game;    
    private boolean isVisible;
    private int edificioNo;
    private MiniGame minigame;
    private boolean clicked;
    
        
    public Boton(int x, int y, int width, int height, Game game) {
        super(x, y);        
        this.width = width;
        this.height = height;
        this.game = game;
        isVisible = false;
        clicked = false;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getEdificioNo() {
        return edificioNo;
    }

    public void setEdificioNo(int edificioNo) {
        this.edificioNo = edificioNo;
    }
   

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
    
    
    
    
    public void tick() {
        // moving player depending on flags
        //clicked = !clicked;
        if (isVisible && game.getMouseManager().isIzquierdo()) {
            //clicked = !clicked;
            int xm = game.getMouseManager().getX();
            int ym = game.getMouseManager().getY();
                    if(xm >= getX() && xm <= getX() + getWidth())
                        if(ym >= getY() && ym <= getY() + getHeight()){
                            //clicked = !clicked;
                            //game.miniGame[miniGame].start(); 
                            clicked = true;
                            System.out.println(clicked);
                            game.setMG(true);
                            //minigame = new MiniGame(game, edificioNo);
                            //minigame.run();
                        }                                    
            game.getMouseManager().setIzquierdo(false);
        }
        if(!isVisible)
            clicked = false;
    }
    
    
    public void render(Graphics g) {
        if (isVisible) {
            if (!clicked) {
                g.drawImage(Assets.boton, getX(), getY(), getWidth(), getHeight(), null);
            } else {
                g.drawImage(Assets.botonC, getX(), getY(), getWidth(), getHeight(), null);
            }
        }
    }
    
}

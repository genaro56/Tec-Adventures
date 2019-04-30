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
    private int number;
    private int orderNumber;
    private String respuesta;
    private boolean correct;
    private MiniGame minigame;
        
    public Respuesta(int x, int y, String respuesta, int number, int correct, int orderNumber, Game game, MiniGame minigame) {
        super(x, y);        
        width = 100;
        height = 50;
        this.respuesta = respuesta;
        this.game = game;
        this.minigame = minigame;
        this.number = number;
        this.orderNumber = orderNumber; //para saber en qué posición se encuentra
        if(number == correct){ // verifica si es el numero de la respuesta correcta
            this.correct = true;
        }else this.correct = false;
        
        //isVisible = false;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    /*public int getMiniGame() {
        return miniGame;
    }

    public void setMiniGame(int miniGame) {
        this.miniGame = miniGame;
    }*/

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }
    
    
    
    public void tick() {
        // moving player depending on flags
        if (game.getMouseManager().isIzquierdo()) {
            int xm = game.getMouseManager().getX();
            int ym = game.getMouseManager().getY();
                    if(xm >= getX() && xm <= getX() + getWidth())
                        if(ym >= getY() && ym <= getY() + getHeight()){
                            //game.miniGame[miniGame].start();
                            minigame.setAcierta(correct, orderNumber); // se verifica si es la respuesta correcta
                            minigame.setFalla(!correct, orderNumber);  
                            minigame.setCounter(30); // se inicia el conter del minigame
                        }                                    
            //game.getMouseManager().setIzquierdo(false);
        }
    }
    
    
    /**
     * Se imprime la respuesta
     * @param g 
     */
    public void render(Graphics g) {     
        /*if()
        g.drawImage(Assets.pregunta, getX(), getY(), 100, 50, null); */
           g.drawString(respuesta, getX()+25, getY()+25);          
    }
    
}

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
public class Respuesta extends Button {

    private int orderNumber;           // order number 
    private int number;                // number
    private String respuesta;          // respuesta     
    private boolean correct;           // bool de correcta
    private MiniGame minigame;         // variable minigame
    /**
     * To create x, y, widht, height, respuesta, number, correct, orderNumber, game, and minigame variables
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param respuesta
     * @param number
     * @param correct
     * @param orderNumber
     * @param game
     * @param minigame 
     */
    public Respuesta(int x, int y, int width, int height, String respuesta, int number, int correct,int orderNumber, Game game, MiniGame minigame) {
        super(x, y, width, height, game);

        this.respuesta = respuesta;
        this.minigame = minigame;
        this.orderNumber = orderNumber;
        this.number = number;
        if (number == correct) { // verifica si es el numero de la respuesta correcta
            this.correct = true;
        } else {
            this.correct = false;
        }
    }
    /**
     * Respuesta tick 
     *
     */
    public void tick() {
        // moving player depending on flags
        if (clicked()) {
            minigame.setAcierta(correct, orderNumber); // se verifica si es la respuesta correcta
            minigame.setFalla(!correct, orderNumber);
            minigame.setCounter(30); // se inicia el conter del minigame

        }
    }

    /**
     * Se imprime la respuesta
     *
     * @param g
     */
    @Override
    public void render(Graphics g) {
        /*if()
        g.drawImage(Assets.pregunta, getX(), getY(), 100, 50, null); */
        g.drawString(respuesta, getX() , getY() + 27);
    }

}

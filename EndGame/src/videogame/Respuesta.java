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

    private int number;
    private String respuesta;
    private boolean correct;
    private MiniGame minigame;

    public Respuesta(int x, int y, int width, int height, String respuesta, int number, int correct, Game game, MiniGame minigame) {
        super(x, y, width, height, game);

        this.respuesta = respuesta;
        this.minigame = minigame;
        this.number = number;
        if (number == correct) { // verifica si es el numero de la respuesta correcta
            this.correct = true;
        } else {
            this.correct = false;
        }
    }

    public void tick() {
        // moving player depending on flags
        if (clicked()) {
            minigame.setAcierta(correct, number); // se verifica si es la respuesta correcta
            minigame.setFalla(!correct, number);
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
        g.drawString(respuesta, getX() + 25, getY() + 25);
    }

}

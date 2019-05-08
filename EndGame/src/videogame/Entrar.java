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
public class Entrar extends Button {

    private boolean isVisible;     //
    private int edificioNo;        //

    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game
     */
    public Entrar(int x, int y, int width, int height, Game game) {
        super(x, y, width, height, game);
        isVisible = false;
    }

    /**
     *
     * @return
     */
    public int getEdificioNo() {
        return edificioNo;
    }

    /**
     *
     * @param edificioNo
     */
    public void setEdificioNo(int edificioNo) {
        this.edificioNo = edificioNo;
    }

    /**
     *
     * @param isVisible
     */
    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    /**
     *
     */
    public void tick() {
        if (isVisible) {
            if (getGame().getKeyManager().enter && getGame().getContEnter() <=0 || clicked()){
                //getGame().setMG(true);
                getGame().startMinigame(edificioNo);
                getGame().setContEnter(30);
                getGame().getKeyManager().enter = false;
            }
        }
    }

    /**
     *
     * @param g
     */
    public void render(Graphics g) {
        if (isVisible) {
            /*if (!clicked()) {*/
                g.drawImage(Assets.boton, getX(), getY(), getWidth(), getHeight(), null);
            /*} else {
                g.drawImage(Assets.botonC, getX(), getY(), getWidth(), getHeight(), null);
            }*/
        }
    }
}

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
public class Boton extends Item {

    private int width;             //
    private int height;            //
    private Game game;             //
    private boolean isVisible;     //
    private int edificioNo;        //
    private boolean clicked;       //

    /**
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game
     */
    public Boton(int x, int y, int width, int height, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        isVisible = false;
        clicked = false;
    }

    /**
     *
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
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
     * @param clicked
     */
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    /**
     *
     */
    public void tick() {
        if (isVisible) {
            if (game.getKeyManager().enter) {
                game.setMG(true);
            }
            if (game.getMouseManager().isIzquierdo()) {
                int xm = game.getMouseManager().getX();
                int ym = game.getMouseManager().getY();
                if (xm >= getX() && xm <= getX() + getWidth()) {
                    if (ym >= getY() && ym <= getY() + getHeight()) {
                        clicked = true;
                        System.out.println(clicked);
                        game.setMG(true);
                    }
                }
                game.getMouseManager().setIzquierdo(false);
            }
        }
        if (!isVisible) {
            clicked = false;
        }
    }

    /**
     * 
     * @param g 
     */
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

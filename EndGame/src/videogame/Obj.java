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
public abstract class Obj extends Item {

    private int width;                 // obj width
    private int height;                // obj height
    private Game game;                 // game variable
    
    /**
     * To create x, y, width, height and game variables
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game 
     */
    public Obj(int x, int y, int width, int height, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
    }
    /**
     * To get width
     * @return an <code>int</code> with the value of width
     */
    public int getWidth() {
        return width;
    }
    /**
     * To get height
     * @return an <code>int</code> with the value of height
     */
    public int getHeight() {
        return height;
    }
    /**
     * To set width
     * @param width 
     */
    public void setWidth(int width) {
        this.width = width;
    }
    /**
     * To set height
     * @param height 
     */
    public void setHeight(int height) {
        this.height = height;
    }
    /**
     * Obj tick
     * 
     */
    @Override
    public void tick() {
        if (game.getKeyManager().up) {
            setY(getY() + 3);
        }
        if (game.getKeyManager().down) {
            setY(getY() - 3);
        }
        if (game.getKeyManager().left) {
            setX(getX() + 3);
        }
        if (game.getKeyManager().right) {
            setX(getX() - 3);
        }
    }
    /**
     * To get perimetro
     * @return an <code>Rectangle</code> with the value of perimetro
     */
    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    /**
     * To get PerimetroO
     * @return an <code>int</code> with the value of perimetroO
     */
    public Rectangle getPerimetroO() {
        return new Rectangle(getX()+4, getY()+3, getWidth()-8, 3);
    }
    /**
     * To get perimetroU
     * @return an <code>int</code> with the value of perimetroU
     */
    public Rectangle getPerimetroU() {
        return new Rectangle(getX()+4, getY() + getHeight() - 6, getWidth()-8, 3);
    }
    /**
     * To get perimetroR
     * @return an <code>int</code> with the value of perimetroR
     */
    public Rectangle getPerimetroR() {
        return new Rectangle(getX() + getWidth() - 6, getY()+4,3, getHeight()-8);
    }
    /**
     * To get perimetroL
     * @return an <code>int</code> with the value of perimetroL
     */
    public Rectangle getPerimetroL() {
        return new Rectangle(getX()+3, getY()+4, 3, getHeight()-8);
    }
    /**
     * Chceck intersection
     * @param obj
     * @return 
     */
    public boolean intersecta(Player obj) {
        return getPerimetro().intersects(obj.getPerimetro());
    }
    /**
     * list of bool of intersection
     * @param obj
     * @return 
     */
    public boolean[] intersectar(Player obj) {
        boolean[] intersectar = new boolean[4];
        intersectar[0] = getPerimetroO().intersects(obj.getPerimetro());
        intersectar[1] = getPerimetroU().intersects(obj.getPerimetro());
        intersectar[2] = getPerimetroR().intersects(obj.getPerimetro());
        intersectar[3] = getPerimetroL().intersects(obj.getPerimetro());
        return intersectar;
    }
}

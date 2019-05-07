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
public class Edificio extends Item {

    private int width;
    private int height;
    private Game game;
    //private String name;
    private int edN;
    private int colision;

    public Edificio(int x, int y, int width, int height, Game game, /*String name*/ int edN) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
        //this.name = name;
        this.edN = edN;
        colision = 0;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColision(int colision) {
        this.colision = colision;
    }

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

    public Rectangle getPerimetro() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    public Rectangle getPerimetroO() {
        return new Rectangle(getX(), getY(), getWidth(), 3);
    }

    public Rectangle getPerimetroU() {
        return new Rectangle(getX(), getY() + getHeight() - 3, getWidth(), 3);
    }

    public Rectangle getPerimetroR() {
        return new Rectangle(getX() + getWidth() - 3, getY(),50, getHeight());
    }

    public Rectangle getPerimetroL() {
        return new Rectangle(getX(), getY(), 3, getHeight());
    }

    public boolean intersecta(Player obj) {
        return getPerimetro().intersects(obj.getPerimetro());
    }

    public boolean[] intersectar(Player obj) {
        boolean[] intersectar = new boolean[4];
        intersectar[0] = getPerimetroO().intersects(obj.getPerimetro());
        intersectar[1] = getPerimetroU().intersects(obj.getPerimetro());
        intersectar[2] = getPerimetroR().intersects(obj.getPerimetro());
        intersectar[3] = getPerimetroL().intersects(obj.getPerimetro());
        return intersectar;
    }

    @Override
    public void render(Graphics g) {
        /*switch (edN) {
            //case 1:*/
        g.drawImage(Assets.edificios[edN], getX(), getY(), getWidth(), getHeight(), null);
        /*  break;
            case 2:
                g.drawImage(Assets.A2, getX(), getY(), getWidth(), getHeight(), null);
                break;
        }     */
    }
}

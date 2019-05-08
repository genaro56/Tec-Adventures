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

    private int width;
    private int height;
    private Game game;

    public Obj(int x, int y, int width, int height, Game game) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.game = game;
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
        return new Rectangle(getX()+4, getY()+3, getWidth()-8, 3);
    }

    public Rectangle getPerimetroU() {
        return new Rectangle(getX()+4, getY() + getHeight() - 6, getWidth()-8, 3);
    }

    public Rectangle getPerimetroR() {
        return new Rectangle(getX() + getWidth() - 6, getY()+4,3, getHeight()-8);
    }

    public Rectangle getPerimetroL() {
        return new Rectangle(getX()+3, getY()+4, 3, getHeight()-8);
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
}

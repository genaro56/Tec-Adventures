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
public class Mapa  extends Item{

    private int width;
    private int height;
    private Game game;
    
    public Mapa(int x, int y, int width, int height, Game game) {
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
           setY(getY() + 1);
        }
        if (game.getKeyManager().down) {
           setY(getY() - 1);
        }
        if (game.getKeyManager().left) {
           setX(getX() + 1);
        }
        if (game.getKeyManager().right) {
           setX(getX() - 1);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.map, getX(), getY(), getWidth(), getHeight(), null);        
    }
}

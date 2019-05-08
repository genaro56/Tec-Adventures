/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasquetBall;
import java.awt.Graphics;
import java.awt.Rectangle;
import videogame.Game;
/**
 *
 * @author jesus
 */
public class Obj extends Item{

    private int velocity;
    private int width;
    private int height;
    private Game game;
    private int dirX;
    private int dirY;
    private int count;
    private BasketBall basket;
    
    public Obj(int x, int y, int velocity, int width, int height, Game game, BasketBall basket) {        
        super(x, y);
        this.velocity = 1;
        this.width = width;
        this.height = height;
        this.game = game;
        dirX = 0;
        dirY = 1;
        count = 0;
        this.basket = basket;
    }

    public int getvelocity() {
        return velocity;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setDirX(int dirX) {
        this.dirX = dirX;
    }

    public void setDirY(int dirY) {
        this.dirY = dirY;
    }

    public int getDirX() {
        return dirX;
    }

    public int getDirY() {
        return dirY;
    }
    
    

    @Override
    public void tick() {
       // moving obj down
        setY(getY() + velocity * dirY);
        setX(getX() + velocity * dirX);
        if( dirY == 0){
            count--;
            if (count <= 0){
                velocity = 1;
                dirY = 1;
            }
        }
       
        // reset x position and y position if colision        
        if (getY() + 20 >= game.getHeight()) {
            basket.setLife(basket.getLife() - 1);            
            count = 100;
            setX(game.getWidth()/2 - 10);
            setY(game.getHeight() - 100); 
            setDirX(0);
            setDirY(0);
            velocity = 0;            
            Assets.crash.play();
        }
        if (getY() <= 0){
            dirY = 1;
        }
        if (getX() <= 0){
            dirX = 1;
        }
        if (getX() + 20 >= game.getWidth()){
            dirX = -1;
        }
        
    }
    
    public Rectangle getPerimetro(){
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.obj, getX(), getY(), getWidth(), getHeight(), null);
    }
}

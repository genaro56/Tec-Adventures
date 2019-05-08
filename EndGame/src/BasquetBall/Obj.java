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

    private int velocity;     // velocity of the obj
    private int width;        // width of the obj
    private int height;       // height of the obj
    private Game game;        // to store the game variable
    private int dirX;         // x direction
    private int dirY;         // y direction
    private int count;        // count variable
    private BasketBall basket;// to store the basket variable
    /**
     * To create the x, y, velocity, widht, height, game and basket variables
     * 
     * @param x
     * @param y
     * @param velocity
     * @param width
     * @param height
     * @param game
     * @param basket 
     */
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
    /**
     * To get velocity
     * 
     * @return an <code>int</code> value with the velocity
     */
    public int getvelocity() {
        return velocity;
    }
    /**
     * To get width
     * 
     * @return an <code>int</code> value with the width
     */
    public int getWidth() {
        return width;
    }
    /**
     * To get height
     * 
     * @return an <code>int</code> value with the height
     */
    public int getHeight() {
        return height;
    }
    /**
     * To set the velocity
     * 
     * @param velocity 
     */
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
    /**
     *  To set the width
     * 
     * @param width 
     */
    public void setWidth(int width) {
        this.width = width;
    }
    /**
     * To set the height
     * 
     * @param height 
     */
    public void setHeight(int height) {
        this.height = height;
    }
    /**
     * To get velocity
     * 
     * @return an <code>int</code> value with the velocity
     */
    public int getVelocity() {
        return velocity;
    }
    /**
     * TO set x direction
     * 
     * @param dirX 
     */
    public void setDirX(int dirX) {
        this.dirX = dirX;
    }
    /**
     * To set y direction
     * 
     * @param dirY 
     */
    public void setDirY(int dirY) {
        this.dirY = dirY;
    }
    /**
     * To get x direction
     * 
     * @return an <code>int</code> value with the x direction
     */
    public int getDirX() {
        return dirX;
    }
    /**
     * To get y direction
     * 
     * @return an <code>int</code> value with the y direction
     */
    public int getDirY() {
        return dirY;
    }
    /**
     * Obj tick
     * 
     */
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
            setX(game.getWidth()/2 - 25);
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
        if (getX() + 50 >= game.getWidth()){
            dirX = -1;
        }
        
    }
    /**
     * To get the perimeter
     * 
     * @return an <code>Rectangle</code> value with the perimeter
     */
    public Rectangle getPerimetro(){
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    /**
     * Obj render
     * 
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.obj, getX(), getY(), getWidth(), getHeight(), null);
    }
}

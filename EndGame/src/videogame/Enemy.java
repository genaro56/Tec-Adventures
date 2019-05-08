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
public class Enemy extends Item{

    private int velocity;       // Item velocity
    private int width;          // Item width
    private int height;         // item height
    private int PWidth;         // Item PWidth
    private int PHeight;        // Item PHeight
    private int playerX;        // Enemys x position
    private int playerY;        // Enemys y positon
    private Game game;          // game variable
    private int colision;       // colision variable
    /**
     * To create x, y, width, height and game variables
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param game 
     */
    public Enemy(int x, int y, int width, int height, Game game) {
        super(x, y);
        this.velocity = 1;
        this.width = width;
        this.height = height;
        this.game = game;
        colision = 0;
    }
    /**
     * To get velocity
     * @return an <code>int</code> with the value of velocity
     */
    public int getvelocity() {
        return velocity;
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
     * To set velocity
     * @param velocity 
     */
    public void setVelocity(int velocity) {
        this.velocity = velocity;
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
     * To get PlayerX
     * @return an <code>int</code> with the value of PlayerY
     */
    public int getPlayerX() {
        return playerX;
    }
    /**
     * To get PlayerY
     * @return an <code>int</code> with the value of PlayerY
     */
    public int getPlayerY() {
        return playerY;
    }
    /**
     * TO set PlayerX
     * @param playerX 
     */
    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }
    /**
     * To set PlayerY
     * @param playerY 
     */
    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }
    /**
     * To get Pheight
     * @return an <code>int</code> with the value of Pheight
     */
    public int getPHeight() {
        return PHeight;
    }
    /**
     * To get PWidth
     * @return an <code>int</code> with the value of PWidth
     */
    public int getPWidth() {
        return PWidth;
    }
    /**
     * To set PHeight
     * @param PHeight 
     */
    public void setPHeight(int PHeight) {
        this.PHeight = PHeight;
    }
    /**
     * To set PWidth
     * @param PWidth 
     */
    public void setPWidth(int PWidth) {
        this.PWidth = PWidth;
    }
    /**
     * To set Colision
     * @param colision 
     */
    public void setColision(int colision) {
        this.colision = colision;
    }
    /**
     * Enemy render
     * 
     */
    @Override
    public void tick() {
        /*int factor;
        if((getX() != playerX) && (getY() != playerY)){
            factor =(int) ((getX() - playerX)/(getY() - playerY));
            setX(getX()+ velocity * factor);
            setY(getY()- velocity * (1/factor));
        }
        else if(getX() != playerX){
            setY(getY() - velocity);
        }
        else
            setX(getX() + velocity);*/
        
        // moving enemy depending on player position        
        
        if (playerX > getX()) {
           setX(getX() + velocity);
        }
        if (playerX < getX()) {
           setX(getX() - velocity);
        }
        if (playerY > getY()) {
           setY(getY() + velocity);
        }
        if (playerY < getY()) {
           setY(getY() - velocity);
        }
        
        
        
        // reset x position and y position if colision        
        if(colision > 0){
            colision--;
        }
    }
    /**
     * To get Perimetro
     * @return an <code>Rectangle</code> with the value of Perimetro
     */
    public Rectangle getPerimetro(){
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    /**
     * check intersection
     * @return an <code>bool</code> with the value of intersection
     */
    public boolean intersecta(Player obj){        
        return getPerimetro().intersects(obj.getPerimetro());
    }
    /**
     * Eneny render
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        /*if (colision > 0){
            g.drawImage(Assets.explotion, getX(), getY(), getWidth(), getHeight(), null);
        }
        else
            g.drawImage(Assets.asteroid, getX(), getY(), getWidth(), getHeight(), null);*/
    }
}

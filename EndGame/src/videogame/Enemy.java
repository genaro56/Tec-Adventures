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

    private int velocity;
    private int width;
    private int height;
    private int PWidth;
    private int PHeight;
    private int playerX;
    private int playerY;
    private Game game;
    private int colision; 
    
    public Enemy(int x, int y, int width, int height, Game game) {
        super(x, y);
        this.velocity = 1;
        this.width = width;
        this.height = height;
        this.game = game;
        colision = 0;
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

    public int getPlayerX() {
        return playerX;
    }

    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public int getPHeight() {
        return PHeight;
    }

    public int getPWidth() {
        return PWidth;
    }

    public void setPHeight(int PHeight) {
        this.PHeight = PHeight;
    }

    public void setPWidth(int PWidth) {
        this.PWidth = PWidth;
    }

    public void setColision(int colision) {
        this.colision = colision;
    }

    public int getVelocity() {
        return velocity;
    }
    
    

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
    
    public Rectangle getPerimetro(){
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    public boolean intersecta(Player obj){        
        return getPerimetro().intersects(obj.getPerimetro());
    }

    @Override
    public void render(Graphics g) {
        /*if (colision > 0){
            g.drawImage(Assets.explotion, getX(), getY(), getWidth(), getHeight(), null);
        }
        else
            g.drawImage(Assets.asteroid, getX(), getY(), getWidth(), getHeight(), null);*/
    }
}

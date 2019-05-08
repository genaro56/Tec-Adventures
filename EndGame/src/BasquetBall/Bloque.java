/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasquetBall;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author jesus
 */
public class Bloque extends Item{

    private int width;
    private int height;
    private int count;

    public Bloque(int x, int y, int width, int height, int count) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.count = count;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    
    
    
    public Rectangle getPerimetro(){
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }    
    
    public boolean intersecta(Obj obj){        
        return getPerimetro().intersectsLine(obj.getX(),obj.getY(),obj.getWidth()+obj.getX(),obj.getY()+obj.getHeight());
    }
    public Rectangle getPerimetroI(){
        return new Rectangle(getX(), getY(), getWidth()/3, getHeight());
    }
    
    public Rectangle getPerimetroC(){
        return new Rectangle(getX()+getWidth()/3, getY(), getWidth()/3, getHeight());
    }  
    
    public Rectangle getPerimetroD(){
        return new Rectangle(getX()+2*getWidth()/3, getY(), getWidth()/3, getHeight());
    }    
    
    public boolean intersectaC(Obj obj){        
        return getPerimetroC().intersectsLine(obj.getX(),obj.getY(),obj.getWidth()+obj.getX(),obj.getY()+obj.getHeight());
    }
    public boolean intersectaI(Obj obj){        
        return getPerimetroI().intersectsLine(obj.getX(),obj.getY(),obj.getWidth()+obj.getX(),obj.getY()+obj.getHeight());
    }
    public boolean intersectaD(Obj obj){        
        return getPerimetroD().intersectsLine(obj.getX(),obj.getY(),obj.getWidth()+obj.getX(),obj.getY()+obj.getHeight());
    }
    public Rectangle getPerimetroIS(){
        return new Rectangle(getX(), getY(), 1, getHeight()/2);    }
    
    public Rectangle getPerimetroII(){
        return new Rectangle(getX(), getY() + getHeight()/2, 1, getHeight()/2);
    }  
    public Rectangle getPerimetroDS(){
        return new Rectangle(getX() + getWidth()-1, getY(), 1, getHeight()/2);    }
    
    public Rectangle getPerimetroDI(){
        return new Rectangle(getX()+ getWidth()-1, getY() + getHeight()/2, 1, getHeight()/2);
    }  
    public boolean intersectaIS(Obj obj){        
        return getPerimetroI().intersectsLine(obj.getX(),obj.getY(),obj.getWidth()+obj.getX(),obj.getY()+obj.getWidth());
    }
    public boolean intersectaII(Obj obj){        
        return getPerimetroI().intersectsLine(obj.getX(),obj.getY(),obj.getWidth()+obj.getX(),obj.getY()+obj.getWidth());
    }
    public boolean intersectaDS(Obj obj){        
        return getPerimetroDS().intersectsLine(obj.getX(),obj.getY(),obj.getWidth()+obj.getX(),obj.getY()+obj.getWidth());
    }
    public boolean intersectaDI(Obj obj){        
        return getPerimetroDI().intersectsLine(obj.getX(),obj.getY(),obj.getWidth()+obj.getX(),obj.getY()+obj.getWidth());
    }

    @Override
    public void render(Graphics g) {
        //g.drawImage(Assets.brick[count], getX(), getY(), getWidth(), getHeight(), null);
        g.drawImage(Assets.meth, getX(), getY(), getWidth(), getHeight(), null);
    }

    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

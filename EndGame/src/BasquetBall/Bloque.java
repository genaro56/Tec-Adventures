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

    private int width;     // width of the item
    private int height;    // height of the item
    private int count;     // count 
    /**
     * To create x, y, width, height and count variables 
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param count 
     */
    public Bloque(int x, int y, int width, int height, int count) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.count = count;
    }
    /**
     * To get the height
     * 
     * @return an <code>int</code> value with the height
     */
    public int getHeight() {
        return height;
    }
    /**
     * To get the width
     * 
     * @return an <code>int</code> value with the width
     */
    public int getWidth() {
        return width;
    }
    /**
     * To get the rectangle Perimetro
     * 
     * @return an <code>Rectangle</code> value with the perimetro
     */
    public Rectangle getPerimetro(){
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
    /**
     * To check for intersection
     * 
     * @param obj
     * @return <code>bool</code> value with the intersection
     */
    public boolean intersecta(Obj obj){        
        return getPerimetro().intersectsLine(obj.getX(),obj.getY(),obj.getWidth()+obj.getX(),obj.getY()+obj.getHeight());
    }
    /**
     * To get the perimetroI
     * 
     * @return <code>Rectangel</code> value with the perimetroI
     */
    public Rectangle getPerimetroI(){
        return new Rectangle(getX(), getY(), getWidth()/3, getHeight());
    }
    /**
     * To get the perimetroC
     * 
     * @return <code>Rectangel</code> value with the perimetroC
     */
    public Rectangle getPerimetroC(){
        return new Rectangle(getX()+getWidth()/3, getY(), getWidth()/3, getHeight());
    }  
    /**
     * To get the perimetroD
     * 
     * @return an <code>Rectangle</code> value with the perimetroD
     */
    public Rectangle getPerimetroD(){
        return new Rectangle(getX()+2*getWidth()/3, getY(), getWidth()/3, getHeight());
    }    
    /**
     * To check intersectionC
     * 
     * @param obj
     * @return an <code>bool</code> value with the intersectionC
     */
    public boolean intersectaC(Obj obj){        
        return getPerimetroC().intersectsLine(obj.getX(),obj.getY(),obj.getWidth()+obj.getX(),obj.getY()+obj.getHeight());
    }
    /**
     * To check intersectionI
     * 
     * @param obj
     * @return an <code>bool</code> value with the intersectionI
     */
    public boolean intersectaI(Obj obj){        
        return getPerimetroI().intersectsLine(obj.getX(),obj.getY(),obj.getWidth()+obj.getX(),obj.getY()+obj.getHeight());
    }
    /**
     * To check intersectionD
     * 
     * @param obj
     * @return an <code>bool</code> value with the intersectionD
     */
    public boolean intersectaD(Obj obj){        
        return getPerimetroD().intersectsLine(obj.getX(),obj.getY(),obj.getWidth()+obj.getX(),obj.getY()+obj.getHeight());
    }
    /**
     * To get perimetroIS
     * 
     * @return an <code>Rectangle</code> value with the perimetroIS
     */
    public Rectangle getPerimetroIS(){
        return new Rectangle(getX(), getY(), 1, getHeight()/2);    }
    /**
     * To get perimetroII
     * 
     * @return an <code>Rectangle</code> value with the perimetroII
     */
    public Rectangle getPerimetroII(){
        return new Rectangle(getX(), getY() + getHeight()/2, 1, getHeight()/2);
    }
    /**
     * To get perimetroDS
     * 
     * @return an <code>Rectangle</code> value with the perimetroDS
     */
    public Rectangle getPerimetroDS(){
        return new Rectangle(getX() + getWidth()-1, getY(), 1, getHeight()/2);    }
    /**
     * To get perimetroDI
     * 
     * @return an <code>Rectangle</code> value with the perimetroDI
     */
    public Rectangle getPerimetroDI(){
        return new Rectangle(getX()+ getWidth()-1, getY() + getHeight()/2, 1, getHeight()/2);
    }
    /**
     * To check intersectionIS
     * 
     * @param obj
     * @return an <code>bool</code> value with the intersectionIS
     */
    public boolean intersectaIS(Obj obj){        
        return getPerimetroI().intersectsLine(obj.getX(),obj.getY(),obj.getWidth()+obj.getX(),obj.getY()+obj.getWidth());
    }
    /**
     * To check intersectionII
     * 
     * @param obj
     * @return an <code>bool</code> value with the intersectionII
     */
    public boolean intersectaII(Obj obj){        
        return getPerimetroI().intersectsLine(obj.getX(),obj.getY(),obj.getWidth()+obj.getX(),obj.getY()+obj.getWidth());
    }
    /**
     * To check intersectionDS
     * 
     * @param obj
     * @return an <code>bool</code> value with the intersectionDS
     */
    public boolean intersectaDS(Obj obj){        
        return getPerimetroDS().intersectsLine(obj.getX(),obj.getY(),obj.getWidth()+obj.getX(),obj.getY()+obj.getWidth());
    }
    /**
     * To check intersectionDI
     * 
     * @param obj
     * @return an <code>bool</code> value with the intersectionDI
     */
    public boolean intersectaDI(Obj obj){        
        return getPerimetroDI().intersectsLine(obj.getX(),obj.getY(),obj.getWidth()+obj.getX(),obj.getY()+obj.getWidth());
    }
    /**
     * Render Bloque
     * @param g 
     */
    @Override
    public void render(Graphics g) {
        //g.drawImage(Assets.brick[count], getX(), getY(), getWidth(), getHeight(), null);
        g.drawImage(Assets.meth, getX(), getY(), getWidth(), getHeight(), null);
    }
    /**
     * tick bloque
     * 
     */
    @Override
    public void tick() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

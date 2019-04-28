/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author jesus
 */
public class MouseManager  implements MouseListener, MouseMotionListener {
    private boolean izquierdo;          // to check if left has been pushed
    private boolean derecho;            // to check if right has been pushed
    private int x;                      // to get x position of the mouse
    private int y;                      // to get y position of the mouse
    
    public MouseManager() {
        izquierdo = false;
        derecho = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isIzquierdo() {
        return izquierdo;
    }

    public boolean isDerecho() {
        return derecho;
    }

    public void setIzquierdo(boolean izquierdo) {
        this.izquierdo = izquierdo;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            izquierdo = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            izquierdo = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1)
            izquierdo = false;
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) { 
        
    }
}

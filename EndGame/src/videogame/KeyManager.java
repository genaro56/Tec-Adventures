/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author jesus
 */
public class KeyManager implements KeyListener {
    
    public boolean up;           // flag to move up the player
    public boolean down;         // flag to move down the player
    public boolean left;         // flag to move left the player
    public boolean right;        // flag to move right the player
    public boolean pause;        // flag to pause game
    public boolean dpause;       // flag to pause game
    public boolean guardar;      // flag to save game
    public boolean cargar;       // flag to load game
    public boolean reiniciar;    // flag to load game
    public boolean exit;         // flag to load game
    public boolean enter;
    public boolean sig;
    public boolean mute;
    
    
    public boolean shot;

    private boolean keys[];  // to store all the flags for every key
    
    public KeyManager() {
        keys = new boolean[256];
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // set true to every key pressed
        if(e.getKeyCode() == 'P'){
            if(!keys['P'])                
              keys['P'] = true;  
        }
        else
           keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // set false to every key released
        if(e.getKeyCode() != 'P')
        keys[e.getKeyCode()] = false;
        else{ if(dpause){
            keys['P'] = false;
            dpause = false;
        }
        else
            dpause = true;
        }
    }
    
    
    /**
     * to enable or disable moves on every tick
     */
    public void tick() {
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        pause = keys[KeyEvent.VK_P];
        cargar = keys[KeyEvent.VK_C];
        guardar = keys[KeyEvent.VK_G];
        reiniciar = keys[KeyEvent.VK_R];
        shot = keys[KeyEvent.VK_SPACE];
        exit = keys[KeyEvent.VK_ESCAPE];
        enter = keys[KeyEvent.VK_ENTER];
        sig = keys[KeyEvent.VK_SPACE];
        mute = keys[KeyEvent.VK_M];
    }
}

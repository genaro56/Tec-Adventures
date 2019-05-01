/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jesus
 */
public class MiniGame {

    //private BufferStrategy bs;         // to have several buffers when displaying
    private Graphics g;                // to paint objects
    //private Display display;           // to display in the game
    private Game game;
    private int width;                 // width of the window
    private int height;                // height of the window
    private boolean acierta;           // to set the game 
    private boolean falla;
    private int life;                  // to manage the lifes 
    private String[] pregunta = new String[6];
    private String[][] respuesta = new String[6][5];
    private int level;
    private Respuesta[] respuestas = new Respuesta[5];
    private int[] res = new int[6];
    private int selected;
    
    

    /**
     * to create title, width and height and set the game is still not running
     *
     * @param title to set the title of the window
     * @param width to set the width of the window
     * @param height to set the height of the window
     */
    public MiniGame(Game game, int number){
        width = 800;
        height = 500;
        acierta = false;
        falla = false;
        //keyManager = new KeyManager();
        //mouseManager = new MouseManager();
        life = 5;
        level = 1;
        selected = 1;
        this.game = game;
        try {
                leeArchivo("edificio" + number);
            } catch (IOException ex) {
                System.out.println("Error en " + ex.toString());
            }
        iniciaRespuestas();
    }

    /**
     * To get the width of the game window
     *
     * @return an <code>int</code> value with the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * To get the height of the game window
     *
     * @return an <code>int</code> value with the height
     */
    public int getHeight() {
        return height;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setAcierta(boolean acierta, int n) {
        this.acierta = acierta;
        selected = n;
    }

    public void setFalla(boolean falla, int n) {
        this.falla = falla;
        selected = n;
    }
    
    

    
    

    public void tick() {
        game.getKeyManager().tick();
        if(acierta){//verifica si la respuesta fue correcta
            if(level  == 5){//es lo que hace cuando respondió todas las preguntas bien
                
            }else{//cuando aún no termina todas las preguntas
                level++;
                iniciaRespuestas();
            }
            acierta = false;
        }else{
            if(falla){//cuando la respuesta es incorrecta
                if(game.getKeyManager().enter || game.getKeyManager().exit)
                game.setMG(falla);
            }else{//cuando no ha respondido
                System.out.println("hola");
                     
                for(int i = 1; i < 5; i++){
                    respuestas[i].tick();
                }
                               
                /*if(game.getKeyManager().up){
                    selected--;
                }*/
                selected = (selected-1)%4 + 1;
                
                /*if(game.getKeyManager().enter){
                    setAcierta(selected == res[level], selected);
                    setFalla(!acierta, selected);
                }*/
                
                        
            }
        }
        
        
        //Aquí se activa cada tick del juego cuando no está pausado
        /*if (!getKeyManager().pause) {            
        
        for(int i = 1; i <= 10; i++){
        respuestas[i].tick();
        }
            
        }*/
    }

    

    public void render(Graphics g) {
        
            g.drawImage(Assets.background, 0, 0, width, height, null);
           
            g.drawImage(Assets.pregunta, 250, 50, 300, 100, null); 
            g.drawString(pregunta[level], 300, 100);            
           System.out.println(pregunta);
           
           for(int i = 1; i < 5; i++){
               g.drawImage(Assets.pregunta, 350, i*150, 100, 50, null); }
            g.drawImage(Assets.seleccion, 350, selected*150, 100, 50, null);
            if(acierta){
                g.drawImage(Assets.correcta, 350, selected*150, 100, 50, null);
            }
            if(falla){
                g.drawImage(Assets.incorrecta, 350, selected*150, 100, 50, null);
            }
            for(int i = 1; i < 5; i++){   
               respuestas[i].render(g);
           }
           /*g.drawImage(Assets.pregunta, 250, 175, 100, 50, null); 
           g.drawString(respuesta[level][1], 300, 200);
           
           g.drawImage(Assets.pregunta, 250, 275, 100, 50, null); 
            g.drawString(respuesta[level][2], 300, 300);
            
            g.drawImage(Assets.pregunta, 250, 375, 100, 50, null); 
            g.drawString(respuesta[level][3], 300, 400);
            
            g.drawImage(Assets.pregunta, 250, 475, 100, 50, null); 
            g.drawString(respuesta[level][4], 300, 500);*/
        
    }
    
    public void leeArchivo(String archivo) throws IOException {

        BufferedReader fileIn;
        try {
            fileIn = new BufferedReader(new FileReader(archivo));
        } catch (FileNotFoundException e) {
            File puntos = new File(archivo);
            PrintWriter fileOut = new PrintWriter(puntos);
            fileOut.println("100,demo");
            fileOut.close();
            fileIn = new BufferedReader(new FileReader(archivo));
        }
        for(int i = 1; i < 6; i++){
        pregunta[i] = fileIn.readLine();
        
        
        for (int j = 1; j < 5; j++) {            
            respuesta[i][j] = fileIn.readLine();            
        }
        String dato = fileIn.readLine();
        res[i] = (Integer.parseInt(dato));       
        }

        fileIn.close();
    }
    
    public void iniciaRespuestas(){
        for(int i = 1; i < 5; i++){
            respuestas[i] = new Respuesta(350, i*150, respuesta[level][i], i, res[i], game, this);
        }
    }



}

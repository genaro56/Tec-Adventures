/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

import java.awt.image.BufferedImage;

/**
 *
 * @author jesus
 */
public class Assets {
    public static BufferedImage background; // to store background image
    public static BufferedImage player;     // to store the player image
    public static BufferedImage asteroid;   // to store the player image
    public static BufferedImage colision;   // to store the player image
    public static BufferedImage explotion;  // to store the player image
    public static BufferedImage map;  // to store the player image
    public static SoundClip bomb;           // to store the sound
    public static BufferedImage end;        // to store the end image    
    public static BufferedImage rectoria;        // to store the end image    
    public static BufferedImage A2;
    public static BufferedImage boton;        // to store the button image 
    public static BufferedImage botonC;        // to store the button image
    //vamos a poner un menu de pausa, no solo una imagen
    public static BufferedImage pause;        // to store the pause image

    /**
     * initializing the images of the game
     */
    public static void init() {
        background = ImageLoader.loadImage("/images/Background.jpg");
        //background2 = ImageLoader.loadImage("/images/Fondo_BiblioTec.png");
        player = ImageLoader.loadImage("/images/Prototipo_2.png");
        asteroid = ImageLoader.loadImage("/images/asteroid.png");
        colision = ImageLoader.loadImage("/images/colision.png");
        explotion = ImageLoader.loadImage("/images/Explosion.png");
        end = ImageLoader.loadImage("/images/GameOver.png");
        rectoria = ImageLoader.loadImage("/images/Rectoria.png");
        A2 = ImageLoader.loadImage("/images/A-2.png");
        map = ImageLoader.loadImage("/images/map.jpg");
        boton = ImageLoader.loadImage("/images/boton.png");
        botonC = ImageLoader.loadImage("/images/botonC.png");
        pause = ImageLoader.loadImage("/images/pause.png");
        bomb = new SoundClip("/audio/crash.wav");
    }
    
}

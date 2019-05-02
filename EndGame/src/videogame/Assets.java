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
    public static BufferedImage pregunta;
    public static BufferedImage correcta;
    public static BufferedImage incorrecta;
    public static BufferedImage seleccion;
    public static BufferedImage lose;
    public static BufferedImage win;
    public static BufferedImage respuesta;
    public static BufferedImage start;

    /**
     * initializing the images of the game
     */
    public static void init() {
        background = ImageLoader.loadImage("/images/bg.png");
        player = ImageLoader.loadImage("/images/Prototipo_2.png");
        asteroid = ImageLoader.loadImage("/images/asteroid.png");
        colision = ImageLoader.loadImage("/images/colision.png");
        explotion = ImageLoader.loadImage("/images/Explosion.png");
        end = ImageLoader.loadImage("/images/GameOver.png");
        rectoria = ImageLoader.loadImage("/images/Rectoría_final.png");
        A2 = ImageLoader.loadImage("/images/Aulas2.png");
        map = ImageLoader.loadImage("/images/bg.png");
        boton = ImageLoader.loadImage("/images/enterButton.jpg");
        botonC = ImageLoader.loadImage("/images/botonC.png");
        pause = ImageLoader.loadImage("/images/pause.png");
        bomb = new SoundClip("/audio/crash.wav");
        respuesta = ImageLoader.loadImage("/images/botonAzul.png");
        pregunta = ImageLoader.loadImage("/images/preguntaButton.jpg.png");
        correcta = ImageLoader.loadImage("/images/correcta.png");
        incorrecta = ImageLoader.loadImage("/images/incorrecta.png");
        seleccion = ImageLoader.loadImage("/images/greenSelection.png");
         lose = ImageLoader.loadImage("/images/lose.png");
         win = ImageLoader.loadImage("/images/win.png");
         start = ImageLoader.loadImage("/images/start.png");

    }

}

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
    public static BufferedImage planet;     // to store the player image
    public static BufferedImage asteroid;   // to store the player image
    public static BufferedImage colision;   // to store the player image
    public static BufferedImage explotion;  // to store the player image
    public static BufferedImage map;  // to store the player image
    public static SoundClip bomb;           // to store the sound
    public static BufferedImage end;        // to store the end image    

    /**
     * initializing the images of the game
     */
    public static void init() {
        background = ImageLoader.loadImage("/images/Background.jpg");
        planet = ImageLoader.loadImage("/images/Prototipo_1.png");
        asteroid = ImageLoader.loadImage("/images/asteroid.png");
        colision = ImageLoader.loadImage("/images/colision.png");
        explotion = ImageLoader.loadImage("/images/Explosion.png");
        end = ImageLoader.loadImage("/images/GameOver.png");
        map = ImageLoader.loadImage("/images/map.jpg");
        bomb = new SoundClip("/audio/crash.wav");
    }
    
}

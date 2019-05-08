/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BasquetBall;

import java.awt.image.BufferedImage;

/**
 *
 * @author jesus
 */
public class Assets {
    public static BufferedImage background;  // to store background image
    public static BufferedImage player;      // to store the player image
    public static BufferedImage obj;         // to store the player image    
    public static BufferedImage end;         // to store the end image
    public static BufferedImage meth;        // to store the end image
    public static SoundClip eat;             // to store the sound
    public static SoundClip crash;           // to store the sound

    /**
     * initializing the images of the game
     */
    public static void init() {
        background = ImageLoader.loadImage("/imagesBasquet/Background.jpg");
        player = ImageLoader.loadImage("/imagesBasquet/barra.png");
        obj = ImageLoader.loadImage("/imagesBasquet/galleta.png");
        end = ImageLoader.loadImage("/imagesBasquet/GameOver.png");
        meth = ImageLoader.loadImage("/imagesBasquet/meth.jpg");
        eat = new SoundClip("/audioBasquet/Eat");
        crash = new SoundClip("/audioBasquet/Splat.wav");
    }   
}

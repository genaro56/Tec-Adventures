/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

/**
 *
 * @author berny
 */
import java.awt.image.BufferedImage;

/**
 *
 * @author berny
 */
public class Animation {

    private int speed;               //for the speed in every frame
    private int index;               //to get the index for the next frame
    private long lastTime;           //for the last time
    private long timer;              //to accumulate time
    private BufferedImage[][] frames;  //to store every image
    private int n;

    /**
     *
     * @param frames
     * @param speed
     */
    public Animation(BufferedImage[][] frames, int speed) {
        this.frames = frames;
        this.speed = speed;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
        n = 0;
    }

    /**
     *
     * @return
     */
    public BufferedImage getCurrentFrame() {
        return frames[n][index];
    }

    public void changeN() {
        n = (n+1)%2;
    }   

    /**
     *
     */
    public void tick() {
        //accumulating the time from previous tick
        timer += System.currentTimeMillis() - lastTime;
        //updating last time
        lastTime = System.currentTimeMillis();
        //check timer to increase index
        if (timer > speed) {
            index++;
            timer = 0;
            //check index
            if (index >= frames.length) {
                index = 0;
            }
        }
    }
}

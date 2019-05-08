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
public class SpreadSheet {
    private int n;

    private BufferedImage sheet;

    /**
     * Constructor of sheet
     * @param sheet
     */
    public SpreadSheet(BufferedImage sheet) {
        this.sheet = sheet;
        n = 0;
    }
    public void changeN(){
        n = (n+1)%2;
    }

    /**
     * To create BufferedImage
     * @param x
     * @param y
     * @param width
     * @param height
     * @return
     */
    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }
}

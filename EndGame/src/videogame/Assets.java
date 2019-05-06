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

    public static BufferedImage background;   // to store background image
    public static BufferedImage player;       // to store the player image
    public static BufferedImage playerSp;     // player sprites
    public static BufferedImage playerAr[];   // animacion arriba
    public static BufferedImage playerAb[];   // animacion abajo
    public static BufferedImage playerDe[];   // animacion derecha
    public static BufferedImage playerIz[];   // animacion izquierda
    //public static BufferedImage asteroid;     // to store the player image
    //public static BufferedImage colision;     // to store the player image
    //public static BufferedImage explotion;    // to store the player image
    public static BufferedImage map;          // to store the player image
    /* Lo podemos usar para introducir los sonidos
    //public static SoundClip bomb;             // to store the sound*/
    public static BufferedImage end;          // to store the end image    
    public static BufferedImage boton;        // to store the button image 
    public static BufferedImage botonC;       // to store the button image
    //vamos a poner un menu de pausa, no solo una imagen
    public static BufferedImage pause;        // to store the pause image
    public static BufferedImage pregunta;     // to store the question's background
    public static BufferedImage correcta;     // to store the correct answer cell
    public static BufferedImage incorrecta;   // to store the wrong answer cell
    public static BufferedImage seleccion;    // to store the selected question cell
    public static BufferedImage lose;         // to store the lose image
    public static BufferedImage win;          // to store the win image
    public static BufferedImage respuesta;    // to store the answer's background
    public static BufferedImage start;        //
    public static BufferedImage menu;         //
    public static BufferedImage menu2;        //
    public static BufferedImage[] edificios;  // to store buildings's images
    //public int cantEdif;         

    /**
     * initializing the images of the game
     */
    public static void init() {
        background = ImageLoader.loadImage("/images/edificio.jpg");
        player = ImageLoader.loadImage("/images/prot.png");

        end = ImageLoader.loadImage("/images/GameOver.png");
        map = ImageLoader.loadImage("/images/bg_alt.png");
        boton = ImageLoader.loadImage("/images/enterButton.jpg");
        botonC = ImageLoader.loadImage("/images/botonC.png");
        pause = ImageLoader.loadImage("/images/menupausa.png");
        //bomb = new SoundClip("/audio/crash.wav");
        respuesta = ImageLoader.loadImage("/images/botonAzul.png");
        pregunta = ImageLoader.loadImage("/images/preguntaButton.png");
        correcta = ImageLoader.loadImage("/images/correcta.png");
        incorrecta = ImageLoader.loadImage("/images/incorrecta.png");
        seleccion = ImageLoader.loadImage("/images/greenSelection.png");
        lose = ImageLoader.loadImage("/images/lose.png");
        win = ImageLoader.loadImage("/images/win.png");
        menu = ImageLoader.loadImage("/images/menu.jpeg");
        menu2 = ImageLoader.loadImage("/images/menu2.jpeg");
        edificios = new BufferedImage[30];

        for (int i = 0; i < 30; i++) {
            edificios[i] = ImageLoader.loadImage("/images/Edificios/edificio_" + i + ".jpg");
            System.out.println("exito" + i);
        }

        playerSp = ImageLoader.loadImage("/images/tec3.png");

        SpreadSheet spreadsheet = new SpreadSheet(playerSp);
        playerAr = new BufferedImage[9];
        playerAb = new BufferedImage[9];
        playerDe = new BufferedImage[9];
        playerIz = new BufferedImage[9];

        for (int x = 0; x < 9; x++) {
            playerAr[x] = spreadsheet.crop(x * 64, 0, 64, 64);
        }

        for (int x = 0; x < 9; x++) {
            playerAb[x] = spreadsheet.crop(x * 64, 128, 64, 64);
        }

        for (int x = 0; x < 9; x++) {
            playerDe[x] = spreadsheet.crop(x * 64, 192, 64, 64);
        }

        for (int x = 0; x < 9; x++) {
            playerIz[x] = spreadsheet.crop(x * 64, 64, 64, 64);
        }
    }

    /*public void setCantEdif(int cantEdif) {
        this.cantEdif = cantEdif;
    }*/
}

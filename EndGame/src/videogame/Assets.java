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
    public static BufferedImage playerSp;   // player sprites
    public static BufferedImage playerAr[]; // animacion arriba
    public static BufferedImage playerAb[]; // animacion abajo
    public static BufferedImage playerDe[]; // animacion derecha
    public static BufferedImage playerIz[]; // animacion izquierda
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

        background = ImageLoader.loadImage("/images/Background.jpg");
        player = ImageLoader.loadImage("/images/prot.png");

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

        playerSp = ImageLoader.loadImage("/images/tec3.png");
         
         SpreadSheet spreadsheet = new SpreadSheet(playerSp);
         playerAr = new BufferedImage[9];
         playerAb = new BufferedImage[9];
         playerDe = new BufferedImage[9];
         playerIz = new BufferedImage[9];
         
         for(int x=0; x<9; x++){
             playerAr[x] = spreadsheet.crop(x*64, 0, 64, 64); 
         }
         
         for(int x=0; x<9; x++){
             playerAb[x] = spreadsheet.crop(x*64, 128, 64, 64);
         }
         
         for(int x=0; x<9; x++){
             playerDe[x] = spreadsheet.crop(x*64, 192, 64, 64);
         }
         
         for(int x=0; x<9; x++){
             playerIz[x] = spreadsheet.crop(x*64, 64, 64, 64);
         }
         
    }

}

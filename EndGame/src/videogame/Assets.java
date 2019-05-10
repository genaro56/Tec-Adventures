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

    public static BufferedImage[] background;   // to store background image
    public static BufferedImage[] player;       // to store the player image
    public static BufferedImage[] playerSp;     // player sprites
    public static BufferedImage[][] playerAr;   // animacion arriba
    public static BufferedImage[][] playerAb;   // animacion abajo
    public static BufferedImage[][] playerDe;   // animacion derecha
    public static BufferedImage[][] playerIz;   // animacion izquierda
    public static BufferedImage[] map;          // to store the player image
    /* Lo podemos usar para introducir los sonidos
    //public static SoundClip bomb;             // to store the sound*/
    public static SoundClip music;             // to store the sound
    public static SoundClip camina;             // to store the sound
    public static SoundClip victory;             // to store the sound
    public static SoundClip derrota;             // to store the sound
    public static SoundClip falla;             // to store the sound
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
    public static BufferedImage intro;         //
    public static BufferedImage intro2;        //
    public static BufferedImage[] edificios;  // to store buildings's images
    public static BufferedImage[] nombres;  // to store buildings's images
    public static BufferedImage arbol;
    public static BufferedImage tabla;
    public static BufferedImage arboles;
    public static SpreadSheet[] spreadsheet;

    /**
     * initializing the images of the game
     */
    public static void init() {
        background = new BufferedImage[30];

        player = new BufferedImage[3];
        player[0] = ImageLoader.loadImage("/Images/prot.png").getSubimage(15, 10, 34, 54);
        player[1] = ImageLoader.loadImage("/Images/prot3.png").getSubimage(15, 10, 34, 54);

        end = ImageLoader.loadImage("/Images/GameOver.png");

        boton = ImageLoader.loadImage("/Images/enterButton.jpg");
        //botonC = ImageLoader.loadImage("/Images/botonC.png");
        pause = ImageLoader.loadImage("/Images/menupausa.png");
        music = new SoundClip("/Audio/reptilia.wav");
        camina = new SoundClip("/Audio/camina.wav");
        victory = new SoundClip("/Audio/victoryff.wav");
        derrota = new SoundClip("/Audio/pierde.wav");
        falla = new SoundClip("/Audio/falla.wav");
        respuesta = ImageLoader.loadImage("/Images/respuesta.png");
        pregunta = ImageLoader.loadImage("/Images/pregunta.png");
        correcta = ImageLoader.loadImage("/Images/correcta.png");
        incorrecta = ImageLoader.loadImage("/Images/incorrecta.png");
        seleccion = ImageLoader.loadImage("/Images/seleccion.png");
        lose = ImageLoader.loadImage("/Images/lose.png");
        win = ImageLoader.loadImage("/Images/win.png");
        menu = ImageLoader.loadImage("/Images/Menu.jpg");
        menu2 = ImageLoader.loadImage("/Images/Menu2.jpg");
        intro = ImageLoader.loadImage("/Images/intro.jpg");
        intro2 = ImageLoader.loadImage("/Images/intro2.jpg");
        tabla = ImageLoader.loadImage("/Images/tabla.png");
        edificios = new BufferedImage[30];
        nombres = new BufferedImage[30];
        map = new BufferedImage[2];

        map[0] = ImageLoader.loadImage("/Images/Map.png");
        map[1] = ImageLoader.loadImage("/Images/Arbolitos.png");

        for (int i = 0; i < 30; i++) {
            edificios[i] = ImageLoader.loadImage("/Images/Edificios/edificio_" + i + ".png");
            nombres[i] = ImageLoader.loadImage("/Images/nombres/edificio_" + i + ".png");
            background[i] = ImageLoader.loadImage("/Images/fondos/edificio_" + i + ".jpeg");
            System.out.println("exito" + i);
        }
        arbol = ImageLoader.loadImage("/Images/Arbol.png");
        arboles = ImageLoader.loadImage("/Images/Arbolitos.png");

        playerSp = new BufferedImage[2];
        playerSp[0] = ImageLoader.loadImage("/Images/tec3.png");
        playerSp[1] = ImageLoader.loadImage("/Images/tec3-2.png");

        spreadsheet = new SpreadSheet[2];
        spreadsheet[0] = new SpreadSheet(playerSp[0]);
        spreadsheet[1] = new SpreadSheet(playerSp[1]);
        playerAr = new BufferedImage[3][9];
        playerAb = new BufferedImage[3][9];
        playerDe = new BufferedImage[3][9];
        playerIz = new BufferedImage[3][9];

        for (int i = 0; i < 2; i++) {
            for (int x = 0; x < 9; x++) {
                playerAr[i][x] = spreadsheet[i].crop(x * 64 + 15, 10, 34, 54);
            }

            for (int x = 0; x < 9; x++) {
                playerAb[i][x] = spreadsheet[i].crop(x * 64 + 15, 138, 34, 54);
            }

            for (int x = 0; x < 9; x++) {
                playerDe[i][x] = spreadsheet[i].crop(x * 64 + 15, 202, 34, 54);
            }

            for (int x = 0; x < 9; x++) {
                playerIz[i][x] = spreadsheet[i].crop(x * 64 + 15, 74, 34, 54);
            }
        }
    }

    /*public void setCantEdif(int cantEdif) {
        this.cantEdif = cantEdif;
    }*/
}

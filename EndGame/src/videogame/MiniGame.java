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
public class MiniGame /*implements Runnable */ {

    //private BufferStrategy bs;         // to have several buffers when displaying
    //private Graphics g;                // to paint objects
    //private Display display;           // to display in the game
    private Game game;
    private int width;                                 // width of the window
    private int height;                                // height of the window
    //private Thread thread;                           // thread to create the game
    private boolean acierta;                           // to verify a correct answer 
    private boolean falla;                             // to verify an incorrect answer
    /*private KeyManager keyManager;                   // to manage the keyboard
    private MouseManager mouseManager;                 // to manage the mouse*/
    //Solo si vamos a dar una cierta cantida de respuestas incorrectas
    //private int life;                                  // to manage the lifes 
    /// Los tamaños de los areglos pueden variar dependiendo de
    // la cantidade de preguntas
    private String[] pregunta = new String[6];         // para guardar todas las preguntas del edifico
    // la cantidad de respuestas por pregunta
    private String[][] respuesta = new String[6][5];   // para guardar todas las respuestas de cada pregunta
    private int level;                                 // para controlar en qué número de pregunta se encuentra
    private Respuesta[] respuestas = new Respuesta[5]; // para crear todas las repuestas
    private int[] res = new int[6];                    // para almacenar el numero de la respuesta correcta de cada pregunta
    private int selected;                              // para identificar qué respuesta está seleccionada
    private int counter;                               // para crear retrasos en los tiempos
    private boolean finish;                            // para verificar si ya se terminó el minijuego
    private int contExit;
    private int cantQuestion;
    // Vamos  usarlas para que se desplieguen preguntas y respuestas en orden aleatorio
    private int[] questionOrder = new int[6];                       // para guardar el orden de las preguntas
    private int[] answerOrder = new int[5];                         // para guardar el orden de las respuestas


    /**
     * to create title, width and height and set the game is still not running
     *
     * @param title to set the title of the window
     * @param width to set the width of the window
     * @param height to set the height of the window
     */
    public MiniGame(Game game, int number, int width, int height) {
        this.width = width;
        this.height =  height;
        acierta = false;
        falla = false;
        this.game = game;
        //keyManager = new KeyManager();
        //mouseManager = new MouseManager();
        //life = 5;
        level = 1;
        contExit = 30;
        selected = 1; // comienza en la primer respuesta
        counter = 30; // se inicia con un retraso por si se accedió con un enter
        
        for (int i = 1; i < 6; i++) { // se crea el orden aleatorio de las preguntas
            boolean no;
            int iNum;
            do{// se crea valor aleatorio
                no =  false;
            iNum = (int)(Math.random()* 5+1);
            for(int j = 1; j < 5; j++){ // se verifica que no esté la pegunta
                if(iNum == questionOrder[j]){                    
                    no = true;
                }
            }
            }while(no);
            questionOrder[i] = iNum;// se guarda el numero de pregunta
        }

        // aquí lee el achivo dependiendo del número del edificio
        try {
            leeArchivo("edificio" + number);
        } catch (IOException ex) {
            System.out.println("Error en " + ex.toString());
        }
        iniciaRespuestas(); // para iniciar las respuestas iniciales
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

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void tick() {
        //keyManager.tick();
        if (acierta) {//verifica si la respuesta fue correcta
            if (level == cantQuestion) {//es lo que hace cuando respondió todas las preguntas bien                
                // botones para salir directamente o mostrar siguiente pantalla
                if(counter <= 0) {
                if(!finish){
                if (game.getKeyManager().sig || game.getKeyManager().exit || game.getKeyManager().enter || contExit <= 0) {
                    finish = true;
                    contExit = 60;
                    
                }}else {
                System.out.println(contExit);
                    if (game.getKeyManager().sig || game.getKeyManager().exit || game.getKeyManager().enter || contExit <= 0) {
                    game.setScore(game.getScore() + 10);
                    game.setContEnter(30);
                    game.setMG(!acierta); //finaliza el minigame
                    
                }}contExit--;}counter--;
            } else {//cuando aún no termina todas las preguntas
                if (/*game.getKeyManager().enter*/counter <= 0) {
                    ///System.out.println(level); //Solo era para revisión
                    level++; //se sube de nivel
                    //System.out.println(level); //Solo era para revisión
                    iniciaRespuestas(); // se inican las respuestas del nuevo ivel
                    acierta = false; //se actualiza para el neuvo nivel
                } else {
                    counter--; // se va actualizando contador para el retraso
                }
            }

        } else {
            if (falla) {//cuando la respuesta es incorrecta                
                if(counter <= 0) {
                if(!finish){
                    if (((game.getKeyManager().sig || game.getKeyManager().exit ||game.getKeyManager().enter) && !finish) || contExit <= 0) {
                    finish = true;
                    counter = 30;
                    contExit = 60;
                }}
                else{
                if(finish){  
                    System.out.println(contExit);
                if (game.getKeyManager().sig || game.getKeyManager().exit || game.getKeyManager().enter || contExit <= 0) {
                    //if(game.getKeyManager().exit)
                    game.setContEnter(30);
                    game.setMG(!falla);//finaliza el minigame

                    if(game.getScore() >= 2)
                    game.setScore(game.getScore() - 2);
                    else game.setScore(0);
                }
                }contExit--;}contExit--;}else counter--;
            } else {//cuando no ha respondido
                if (counter <= 0) {
                    for (int i = 1; i < 5; i++) { //se hace el tick de cada respuesta
                        Respuesta respond = respuestas[i];
                        respond.tick(); // es para poder verificar el mouse
                    }

                    // desplazamiento entre respuestas
                    if (game.getKeyManager().down) {
                        selected++;
                        counter = 10;
                    }
                    if (game.getKeyManager().up) {
                        selected--;
                        counter = 10;
                    }

                    // para que sea una selección entre 1 y 4
                    selected = (selected + 3) % 4 + 1;
                    //System.out.println(selected);
                    
                    // para seleccionar la respuesta
                    // podríamos usar espacio también
                    if (game.getKeyManager().enter || game.getKeyManager().sig) { //usamos enter
                        setAcierta(answerOrder[selected] == res[questionOrder[level]], selected); //verificamos si es correcta o no
                        setFalla(!acierta, selected);
                        counter = 30;
                    }
                } else {
                    counter--;
                }

            }
        }      
        /* Esto es sacado de game, pero se hace el tick en el mismo game
        //Aquí se activa cada tick del juego cuando no está pausado
        /*if (!getKeyManager().pause) {            
        
        for(int i = 1; i <= 10; i++){
        respuestas[i].tick();
        }
            
        }*/
    }

    public void render(Graphics g) {
        //se imprime el fondo (va a ser uno distinto por cada edificio)
        // vamos a hacer un array de fondos
        g.drawImage(Assets.background
                /*aquí irá el nombre del array y el numero de edificio*/
                , 0, 0, width, height, null);
        
        if (!finish) {//si no ha terminado
            //se despliegan las imágenes normales
            
            //el fondo para la pregunta y la pregunta
            int longitud =  pregunta[questionOrder[level]].length()*6;
            //System.out.println(longitud);
            /*g.drawImage(Assets.pregunta, game.getWidth()/2-longitud*4, 50, longitud * 8, 100, null);
            g.setColor(Color.white);
            g.drawString(pregunta[level], game.getWidth()/2-(int)(longitud*2.5), 100);*/
            g.drawImage(Assets.pregunta, (game.getWidth()-longitud)/2 -35, 50, longitud+70, 75, null);
            g.setColor(Color.white);
            g.drawString(pregunta[questionOrder[level]], (game.getWidth()-longitud)/2+10, 90);

            for (int i = 1; i < 5; i++) {//los fondos de las respuestas
                g.drawImage(Assets.respuesta, respuestas[i].getX()-25, i * 150, respuestas[i].getWidth()+ 50, 50, null);
            }
            // la imagen de selección(resalta la respuesta seleccionada)
            g.drawImage(Assets.seleccion, respuestas[selected].getX()-25, selected * 150, respuestas[selected].getWidth()+ 50, 50, null);
            
            //cuando se presiona una respuesta resalta dependiendo de si es correcta o incorrecta
            if (acierta) {
                g.drawImage(Assets.correcta, 350, selected * 150, 100, 50, null);
            }
            if (falla) {
                g.drawImage(Assets.incorrecta, 350, selected * 150, 100, 50, null);
            }
            
            // se imprime las respuestas
            for (int i = 1; i < 5; i++) {
                respuestas[answerOrder[i]].render(g);
            }
        } else { // se despliega una imagen si ya terminaron las preguntas
            if (acierta) {
                g.drawImage(Assets.win, game.getWidth() / 2 - 300, game.getHeight() / 2 - 300, 600, 600, null);
            } else if (falla) {
                g.drawImage(Assets.lose, game.getWidth() / 2 - 300, game.getHeight() / 2 - 300, 600, 600, null);

            }
        }
    }

    /**
     * Lee el archivo con las preguntas y respuestas de edificio
     * Se guardan los valores en 3 arreglos
     * Preguntas
     * Respuestas
     * Respuestas correctas
     * @param archivo
     * @throws IOException 
     */
    public void leeArchivo(String archivo) throws IOException {
        BufferedReader fileIn;
        try {
            fileIn = new BufferedReader(new FileReader(archivo));
        } catch (FileNotFoundException e) {
            File puntos = new File(archivo);
            PrintWriter fileOut = new PrintWriter(puntos);
            fileOut.println(5);
            for(int i = 0; i <5; i++){
            fileOut.println("Pregunta de prueba");
            fileOut.println("Respuesta 1");
            fileOut.println("Respuesta 2");
            fileOut.println("Respuesta 3");
            fileOut.println("Respuesta 4");
            fileOut.println(1);}            
            fileOut.close();
            fileIn = new BufferedReader(new FileReader(archivo));
        }
        String dato = fileIn.readLine();
        cantQuestion = (Integer.parseInt(dato));
        for (int i = 1; i <= cantQuestion; i++) {
            pregunta[i] = fileIn.readLine();

            for (int j = 1; j < 5; j++) {
                respuesta[i][j] = fileIn.readLine();
            }
            dato = fileIn.readLine();
            res[i] = (Integer.parseInt(dato));
        }

        fileIn.close();
    }

    /**
     * Para iniciar las repuestas de cada nivel
     *
     */
    public void iniciaRespuestas() {
        //int iNum = (int)(Math.random()* 4+1);
        System.out.println("hola");
        for(int j = 1; j < 5; j++){// se limpia el arreglo en cada nivel
            answerOrder[j] = 0;
        }
        for (int i = 1; i < 5; i++) {
            //respuestas[i] = new Respuesta(350, i * 150, respuesta[level][i], i, res[level], game, this);
            boolean no;
            int iNum;
            do{// se crea el orden aleatorio
                no =  false;
            iNum = (int)(Math.random()* 4+1);
            for(int j = 1; j < i; j++){//se verifica que no se haya insertado la respuestas
                if(iNum == answerOrder[j]){                    
                    no = true;
                }
            }
            }while(no);
            answerOrder[i] = iNum; //se inicia el arreglo del orden de respuestas
            // se inician las respuestas
            int x= (int)respuesta[questionOrder[level]][iNum].length()*6;
            respuestas[i] = new Respuesta((width-x)/2, i * 150,x,50, respuesta[questionOrder[level]][iNum], iNum, res[questionOrder[level]],i, game, this);
            
            //System.out.println(i + ": " +  res[level]);
        }
    }

    /*public void iniciaRespuestas() {
        for (int i = 1; i < 5; i++) {
            int x= (int)respuesta[level][i].length()*6;
            respuestas[i] = new Respuesta((width-x)/2, i * 150, x, 50 , respuesta[level][i], i, res[level], game, this);
            System.out.println(i + ": " +  (int)respuesta[level][i].length());
        }
        
    }*/

}

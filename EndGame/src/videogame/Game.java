/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videogame;

//import basquetball.Gameplay;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import BasquetBall.BasketBall;
import javax.swing.JFrame;

/**
 *
 * @author jesus
 */
public class Game implements Runnable {

    public BufferStrategy bs;                   // to have several buffers when displaying
    public Graphics g;                          // to paint objects
    public Display display;                     // to display in the game
    String title;                               // title of the window
    private int width;                          // width of the window
    private int height;                         // height of the window
    private Thread thread;                      // thread to create the game
    private boolean running;                    // to set the game
    private Player player;                      // to use a player
    /* Solo si si inlcuimos enemigos
    //private Enemy asteroid;                   // to have an enemy*/
    private Mapa map;                           // to move the map
    private Mapa arboles;                           // to move the map
    private KeyManager keyManager;              // to manage the keyboard
    private MouseManager mouseManager;          // to manage the mouse
    private int life;                           // to manage the lifes 
    private int score;                          // to manage the score
    private boolean inicio;                     // to move from the menu to the game
    private int dispMen;                        // to animation of menu
    private LinkedList<Edificio> edificios;     // to save the buidings
    private int cantEdif;                       // to manage the buildings' quantity

    private int[] posEdifX = new int[30];       // to save the buildings' possition X
    private int[] posEdifY = new int[30];       // to save the buildings' possition Y
    private int[] edifWidth = new int[30];      // to save the buildings' width
    private int[] edifHeight = new int[30];     // to save the buildings' height

    private Entrar boton;                        // to use a button to enter in a minigame
    private MiniGame minigame;                  // to use minigames
    private boolean MG;                         // to activate minigame
    private boolean intersectando;              // to verify player's intejections
    private boolean intro;
    private int contIntro;
    private int contEnter;
    boolean[] intersectar = new boolean[4];
    private int mute;

    Font vida = new Font("Bank Gothic", Font.BOLD, 36);
    Font stats = new Font("ink free", Font.PLAIN, 36);
    Font pregunta = new Font("OCR A Extended", Font.BOLD, 36);
    Font respuesta = new Font("Edwardian Script ITC", Font.BOLD, 36);

    private obstacle[] obs;
    private int cantObs;
    private int corriendo;
    private BasketBall basket;
    private int type;
    private boolean muted;
    private int cantPasto;
    private pasto[] pastos;
    private boolean caminaPasto;
    private int contQ;

    /**
     * to create title, width and height and set the game is still not running
     *
     * @param title to set the title of the window
     * @param width to set the width of the window
     * @param height to set the height of the window
     */
    public Game(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        running = false;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        edificios = new LinkedList<Edificio>();
        inicio = false;
        intro = false;
        contIntro = 0;
        life = 5;
        score = 0;
        MG = false;
        obs = new obstacle[10];
        mute = 0;
        muted = false;
        cantObs = 0;

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

    /**
     * To set the MG
     *
     * @param MG
     */
    public void setMG(boolean MG) {
        this.MG = MG;
    }

    /**
     * To get the score of the Game
     *
     * an <code>int</code> value with the Score
     *
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * To set the value of the score
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }
    /**
     * To set life
     * 
     * @param life 
     */
    public void setLife(int life) {
        this.life = life;
    }
    /**
     * To get the life value
     * 
     * @return an <code>int</code> value for the life
     */
    public int getLife() {
        return life;
    }
    
    /**
     * To set the value of the ContEnter
     *
     * @param contEnter
     */
    public void setContEnter(int contEnter) {
        this.contEnter = contEnter;
    }

    /**
     * To get the value of the ContEnter
     *
     * an <code>int</code> value with the ContEnter
     *
     * @return
     */
    public int getContEnter() {
        return contEnter;
    }

    /**
     * To set the value of the startMinigame
     *
     * @param i
     */
    public void startMinigame(int i) {
        type = i;
        if (i == 14) {
            startBasquetball();
        } else {
            minigame = new MiniGame(this, i, width, height);
        }
        setMG(true);

    }

    /**
     * initializing the basket variable
     */
    public void startBasquetball() {
        basket = new BasketBall(this);
    }

    /**
     * initializing the display window of the game
     */
    private void init() {
        display = new Display(title, getWidth(), getHeight());
        // Se lee el archivo para obetener la cantidad de edificios y sus ubicaciones
        try {
            leeArchivo("edificios.txt", true);
        } catch (IOException ex) {
            System.out.println("Error en " + ex.toString());
        }

        Assets.init();
        // Se crea el jugador
        player = new Player(0, 300, -20, 34, 54, this);
        // Se crea el mapa para que se pueda desplazar la vista
        map = new Mapa(0, -450, getHeight() * 3, getWidth() * 3, this,0);
        arboles = new Mapa(0, -450, getHeight() * 3, getWidth() * 3, this,1);
        // Se crea cada uno de los edificios
        for (int i = 0; i < cantEdif; i++) {
            edificios.add(new Edificio(posEdifX[i], posEdifY[i], edifWidth[i], edifHeight[i], this, i));
        }
        // Se crea el botón que se utilizará para entrar a los minijuegos
        boton = new Entrar(getWidth() - 125, getHeight() - 100, 125, 100, this);

        /*try {
            cargaObstaculos("obstaculos");
        } catch (IOException ex) {
            System.out.println("Error en " + ex.toString());
        }*/
        try {
            cargaObstaculos("pasto");
        } catch (IOException ex) {
            System.out.println("Error en " + ex.toString());
        }

        display.getJframe().addKeyListener(keyManager);
        display.getJframe().addMouseListener(mouseManager);
        display.getJframe().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
    }

    @Override
    public void run() {
        init();
        // frames per second
        int fps = 60;
        // time for each tick in nano segs
        double timeTick = 1000000000 / fps;
        // initializing delta
        double delta = 0;
        // define now to use inside the loop
        long now;
        // initializing last time to the computer time in nanosecs
        long lastTime = System.nanoTime();
        while (running) {
            // setting the time now to the actual time
            now = System.nanoTime();
            // acumulating to delta the difference between times in timeTick units
            delta += (now - lastTime) / timeTick;
            // updating the last time
            lastTime = now;

            // if delta is positive we tick the game
            //Tenemos que modificar la forma en que termina el juego y es aquí
            if (delta >= 1) {
                tick();
                render();
                if (life <= 0) {
                    render();
                    running = false;
                }
                delta--;
            }
        }
        stop();
    }

    /**
     * To get the value of KeyManager
     *
     * @return an  <code>KeyManager</code> value with the Key Manager
     */
    public KeyManager getKeyManager() {
        return keyManager;
    }

    /**
     * TO get the value of the Mouse Manager
     *
     *
     * @return <code>MouseManager</code> value with the MouseManager
     */
    public MouseManager getMouseManager() {
        return mouseManager;
    }

    private void tick() {
        keyManager.tick();
        if (inicio) {
            mute--;
            if (getKeyManager().mute && mute <= 0) {
                if (!muted) {
                    Assets.music.stop();
                } else {
                    Assets.music.play();
                    Assets.music.setLooping(true);
                }
                muted = !muted;
                mute = 30;
            }
            contQ--;
            if(getKeyManager().zaz && contQ <= 0){
                player.changeN();
                contQ = 30;
            }

            //Estos son las llamadas a los métodos para 
            //guardar cargar y reiniciar
            if (getKeyManager().guardar) {
                try {
                    //Graba los valores en el archivo.
                    grabaArchivo("guardado.txt");
                } catch (IOException ex) {
                    System.out.println("Error en " + ex.toString());
                }
            }
            if (getKeyManager().cargar) {
                try {
                    leeArchivo("guardado.txt", false);
                } catch (IOException ex) {
                    System.out.println("Error en " + ex.toString());
                }
            }
            /*if (getKeyManager().reiniciar) {
            for (int i = 0; i < cObject; i++) {
                Alien alien = aliens.get(i);
                alien.setDying(false);
            }
            try {
                leeArchivo("reinicio.txt");
            } catch (IOException ex) {
                System.out.println("Error en " + ex.toString());
            }
        }*/
            //Aquí se activa cada tick del juego cuando no está pausado
            if (!getKeyManager().pause) {
                if (!MG) {
                    mute--;
                    if (getKeyManager().mute && mute <= 0) {
                        if (!muted) {
                            Assets.music.stop();
                        } else {
                            Assets.music.play();
                            Assets.music.setLooping(true);
                        }
                        muted = !muted;
                        mute = 30;
                    }
                    contEnter--;
                    intersectando = false;
                    for (int i = 0; i < cantEdif; i++) {
                        Edificio edif = edificios.get(i);
                        if (edif.intersecta(player)) {
                            boton.setEdificioNo(i);
                            intersectar = edif.intersectar(player);
                            if (intersectar[3]) {
                                player.setX(player.getX() - 3);
                            }
                            if (intersectar[2]) {
                                player.setX(player.getX() + 3);
                            }
                            if (intersectar[1]) {
                                player.setY(player.getY() + 3);
                            }
                            if (intersectar[0]) {
                                player.setY(player.getY() - 3);
                            }
                            intersectando = true;
                        }
                    }
                    for (int i = 0; i < cantObs; i++) {
                        if (obs[i].intersecta(player)) {
                            intersectar = obs[i].intersectar(player);
                            if (intersectar[3]) {
                                player.setX(player.getX() - 3);
                            }
                            if (intersectar[2]) {
                                player.setX(player.getX() + 3);
                            }
                            if (intersectar[1]) {
                                player.setY(player.getY() + 3);
                            }
                            if (intersectar[0]) {
                                player.setY(player.getY() - 3);
                            }
                        }
                    }
                    player.setCaminaPasto(false);
                    for (int i = 0; i < cantPasto; i++) {
                        if (pastos[i].intersecta(player)) {
                            player.setCaminaPasto(true);
                        }
                    }
                    if (caminaPasto) {

                    }
                    if (intersectando) {
                        boton.tick();
                    }
                    boton.setIsVisible(intersectando);

                    move(getKeyManager());
                    // Esto podría funcionar solo si usamos enemigos
                    // y lo anterior se usaría para los enemigos
                    if (life < 0) {
                        stop();
                    }
                } else {
                    if (type == 14) {
                        basket.tick();
                    } else {
                        minigame.tick();
                    }
                }
            }
        } else {
            contIntro--;
            if (intro) {
                contEnter--;
                if (getKeyManager().enter && contEnter <= 0 || contIntro <= 0) {
                    inicio = true;
                    contEnter = 30;
                    Assets.music.play();
                    Assets.music.setLooping(true);
                }
            } else {
                if (getKeyManager().enter) {
                    intro = true;
                    contIntro = 1200;
                    contEnter = 30;
                }
            }
        }
    }

    //Esto sirve para sincronizar los movimientos del mapa y los edificios 
    //con el jugador
    /**
     *
     * @param km
     */
    private void move(KeyManager km) {
        if (km.down || km.left || km.up || km.right) {
            player.getPlayerAb().tick();
            player.getPlayerAr().tick();
            player.getPlayerDe().tick();
            player.getPlayerIz().tick();
            if (km.right && map.getX() <= getWidth() - map.getWidth()
                    || km.right && player.getX() <= getWidth() / 4 - 50
                    || km.left && map.getX() >= 0
                    || km.left && player.getX() >= getWidth() / 4 + 50
                    || km.up && map.getY() >= 0
                    || km.up && player.getY() >= getHeight() / 2 + 50
                    || km.down && map.getY() <= getHeight() - map.getHeight()
                    || km.down && player.getY() <= getHeight() / 2 - 50) {
                player.tick();

            } else {
                map.tick();
                arboles.tick();
                for (int i = 0; i < cantEdif; i++) {
                    edificios.get(i).tick();
                }
                for (int i = 0; i < cantObs; i++) {
                    obs[i].tick();
                }
                for (int i = 0; i < cantPasto; i++) {
                    pastos[i].tick();
                }
            }
        }
    }

    /**
     * Funcion que permite leer los archivos
     *
     * @param archivo
     * @param base
     * @throws IOException
     */
    public void leeArchivo(String archivo, boolean base) throws IOException {
        BufferedReader fileIn;
        try {
            fileIn = new BufferedReader(new FileReader(archivo));
        } catch (FileNotFoundException e) {
            File puntos = new File(archivo);
            PrintWriter fileOut = new PrintWriter(puntos);
            fileOut.println("Vidas");
            fileOut.println("5");
            fileOut.println("Edificios");
            fileOut.println("1");
            fileOut.println("Rectoria");
            fileOut.println("450");
            fileOut.println("186");
            fileOut.println("460");
            fileOut.println("280");
            fileOut.close();
            fileIn = new BufferedReader(new FileReader(archivo));

        }
        String dato = fileIn.readLine();
        dato = fileIn.readLine();
        life = (Integer.parseInt(dato));
        dato = fileIn.readLine();
        dato = fileIn.readLine();
        cantEdif = (Integer.parseInt(dato));
        System.out.println(cantEdif);
        for (int i = 0; i < cantEdif; i++) {
            dato = fileIn.readLine();
            dato = fileIn.readLine();
            posEdifX[i] = (Integer.parseInt(dato));
            dato = fileIn.readLine();
            posEdifY[i] = (Integer.parseInt(dato));
            dato = fileIn.readLine();
            edifWidth[i] = (Integer.parseInt(dato));
            dato = fileIn.readLine();
            edifHeight[i] = (Integer.parseInt(dato));
            if (!base) {
                Edificio edificio = edificios.get(i);
                edificio.setX(posEdifX[i]);
                edificio.setY(posEdifY[i]);
            }
        }
        if (!base) {
            dato = fileIn.readLine();
            player.setX(Integer.parseInt(dato));
            dato = fileIn.readLine();
            player.setY(Integer.parseInt(dato));
            dato = fileIn.readLine();
            score = (Integer.parseInt(dato));
            dato = fileIn.readLine();
            map.setX(Integer.parseInt(dato));
            dato = fileIn.readLine();
            map.setY(Integer.parseInt(dato));
        }

        fileIn.close();
    }

    /**
     * Funcion que permite grabar los archivos
     *
     * @param archivo
     * @throws IOException
     */
    public void grabaArchivo(String archivo) throws IOException {
        PrintWriter fileOut = new PrintWriter(new FileWriter(archivo));
        fileOut.println("");
        fileOut.println("" + life);
        fileOut.println("");
        fileOut.println("" + cantEdif);
        for (int i = 0; i < cantEdif; i++) {
            Edificio edificio = edificios.get(i);
            fileOut.println("");
            fileOut.println("" + edificio.getX());
            fileOut.println("" + edificio.getY());
            fileOut.println("" + edifWidth[i]);
            fileOut.println("" + edifHeight[i]);
        }
        fileOut.println("" + player.getX());
        fileOut.println("" + player.getY());
        fileOut.println("" + score);
        fileOut.println("" + map.getX());
        fileOut.println("" + map.getY());

        fileOut.close();
    }

    /**
     * Funcion que permite cargar los obstaculos del mapa
     *
     * @param archivo
     * @throws IOException
     */
    public void cargaObstaculos(String archivo) throws IOException {
        BufferedReader fileIn;
        try {
            fileIn = new BufferedReader(new FileReader(archivo));
        } catch (FileNotFoundException e) {
            File puntos = new File(archivo);
            PrintWriter fileOut = new PrintWriter(puntos);
            fileOut.println("Objetos");
            fileOut.println("1:");
            fileOut.println("0");
            fileOut.println("0");
            fileOut.close();
            fileIn = new BufferedReader(new FileReader(archivo));

        }
        String dato = fileIn.readLine();
        System.out.println(dato);
        dato = fileIn.readLine();
        System.out.println(dato);
        int x;
        int y;
        int n = (Integer.parseInt(dato));
        if (archivo == "obstaculos") {
            cantObs = n;
            obs = new obstacle[cantObs];
        } else if (archivo == "pasto") {
            cantPasto = n;
            pastos = new pasto[cantPasto];

        }
        for (int i = 0; i < n; i++) {
            dato = fileIn.readLine();
            dato = fileIn.readLine();
            x = (Integer.parseInt(dato));
            dato = fileIn.readLine();
            y = (Integer.parseInt(dato));

            if (archivo == "obstaculos") {
                obstacle obst = new obstacle(x, y, this);
                obs[i] = obst;
            } else if (archivo == "pasto") {
                int w, h;
                dato = fileIn.readLine();
                w = (Integer.parseInt(dato));
                dato = fileIn.readLine();
                System.out.println(dato);
                h = (Integer.parseInt(dato));
                pasto pasto = new pasto(x, y, w, h, this);
                pastos[i] = pasto;
            }

        }

        fileIn.close();
    }

    /**
     * Aqui se hace el render general del juego
     */
    private void render() {
        // get the buffer strategy from the display
        bs = display.getCanvas().getBufferStrategy();
        /* if it is null, we define one with 3 buffers to display images of
        the game, if not null, then we display every image of the game but
        after clearing the Rectanlge, getting the graphic object from the 
        buffer strategy element. 
        show the graphic and dispose it to the trash system
         */
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
        } else {

            g = bs.getDrawGraphics();
            //g.drawImage(Assets.background, 0, 0, width, height, null);
            if (inicio) {
                if (!MG) {

                    map.render(g);
                    for (int i = 0; i < cantObs; i++) {
                        obs[i].render(g);
                    }
                    player.render(g);
                    arboles.render(g);
                    for (int i = 0; i < cantEdif; i++) {
                        edificios.get(i).render(g);
                    }
                    /*for(int i = 0; i < cantPasto; i++){
                        pastos[i].render(g);
                    }*/
                    boton.render(g);

                    if (life <= 0) {
                        g.drawImage(Assets.end, (getWidth() / 2) - 450, (getHeight() / 2) - 150, 900, 300, null);
                    }
                    int y = 40;
                    if (getKeyManager().pause) {
                        g.drawImage(Assets.pause, 0, 0, getWidth(), getHeight(), null);
                        y+=40;
                    }
                    g.setColor(new Color(0, 0, 102));

                    g.setFont(pregunta);
                    g.drawImage(Assets.tabla, 0, y,300,100,null);
                    for(int i = 0; i < 10; i++){
                        for(int j = 0; j < 20; j++){
                            g.drawImage(Assets.arbol, 1317+(i*25), 1317+(j*50),50,100,null);
                        }
                    }

                    g.drawString("Vidas: " + life, 5, y+40);
                    g.drawString("Score: " + score, 5, y+80);//falta formato
                    /*g.setColor(Color.red);
                    g.setFont(stats);
                    g.drawString("Player X: " + (player.getX() - map.getX()), getWidth() - 250, 30);
                    g.drawString("Player y: " + (player.getY() - 450 - map.getY()), getWidth() - 250, 60);
                    g.drawString("map X: " + map.getX(), getWidth() - 250, 90);
                    g.drawString("map y: " + map.getY(), getWidth() - 250, 120);*/
                    
                    

                } else {
                    if (type == 14) {
                        basket.render(g);
                    } else {
                        minigame.render(g);
                    }
                    
                }
            } else {
                // Hacer que parpadee la imagen del menu
                if (intro) {
                    if (dispMen <= 0) {
                        g.drawImage(Assets.intro, 0, 0, getWidth(), getHeight(), null);

                        dispMen = dispMen <= -30 ? 30 : dispMen;
                    } else {
                        g.drawImage(Assets.intro2, 0, 0, getWidth(), getHeight(), null);
                    }
                } else {
                    if (dispMen <= 0) {
                        g.drawImage(Assets.menu, 0, 0, getWidth(), getHeight(), null);

                        dispMen = dispMen <= -30 ? 30 : dispMen;
                    } else {
                        g.drawImage(Assets.menu2, 0, 0, getWidth(), getHeight(), null);
                    }
                }
                dispMen--;
            }

            bs.show();
            g.dispose();
        }
    }

    /**
     * setting the thead for the game
     */
    public synchronized void start() {
        if (!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    /**
     * stopping the thread
     */
    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }
}

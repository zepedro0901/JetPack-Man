package io.codeforall.gameJam;

import io.codeforall.gameJam.GameLogic.Player;
import io.codeforall.gameJam.SimpleGx.Background;
import io.codeforall.gameJam.SimpleGx.Menu;
import io.codeforall.gameJam.SimpleGx.Pillar;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Game implements KeyboardHandler {
    private Canvas canvas;
    public Background background = new Background();
    private Player player = new Player();
    public Pillar[] pillarArray;
    Picture gameOver = new Picture(0, 0, "gameOver.png");
    public static boolean isGameOver = false;
    public Menu menu = new Menu();

    public Menu startingMenu = new Menu();
    public boolean startGameMenu = true;

    public Game() {


        keyboardSetup();

    }

    public void startGame() {

        if (isGameOver) {
            drawGameOver();
        } else {

            Canvas.limitCanvasHeight(524);
            Canvas.limitCanvasWidth(1190);
            Canvas.getInstance();

            pillarArray = new Pillar[100];
            for (int i = 0; i < 100; i++) {
                pillarArray[i] = new Pillar((int) Math.floor(Math.random() * -300) - 100);

            }

            background.startBackground();
            player.drawPlayer();
            fallDown();
            player.deletePlayer();
            background.deleteBackground();
        }

    }


    private void keyboardSetup() {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent startGame = new KeyboardEvent();
        startGame.setKey(KeyboardEvent.KEY_S);
        startGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(startGame);


        KeyboardEvent restartGame = new KeyboardEvent();
        restartGame.setKey(KeyboardEvent.KEY_R);
        restartGame.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(restartGame);


    }

    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_S:
                startingMenu.deleteStartingMenu();
                startGameMenu = false;

                break;
            case KeyboardEvent.KEY_R:
                if (isGameOver) {
                    removeGameOver();
                    player.playerP.delete();
                    player.hitBox.delete();
                    background.deleteBackground();
                    player.playerP.translate(0, -300);
                    player.hitBox.translate(0, -300);
                    isGameOver = false;
                }
                break;
        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


    public void drawGameOver() {

        gameOver.draw();

    }

    public void removeGameOver() {
        gameOver.delete();

    }

    public void fallDown() {
        int counter = 29;
        int index = 0;

        while (!isGameOver) {
            try {
                Thread.sleep(120);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            counter++;
            System.out.println(counter);

            if (counter % 30 == 0) {
                index++;
                pillarArray[index].pillarP.draw();
                pillarArray[index].hitBoxUp.draw();



            }
            for (int i = 0; i < index; i++) {
                pillarArray[i].pillarP.translate(-10, 0);
                pillarArray[i].hitBoxUp.translate(-10, 0);



                if (player.hitBox.getX()>100){

                    System.out.println("morreu");

                    isGameOver = true;

                    counter = 29;
                    index = 0;

                    //player.hitBox.getX() + player.hitBox.getY()    (Lado superior esquerdo)
                    //player.hitBox.getX()+(player.hitBox.getY()+player.hitBox.getHeight())  (lado inferior esquerdo)
                    //(player.hitBox.getX() + player.hitBox.getWidth()) + player.hitBox.getY() (lado superior direito)
                    //(player.hitBox.getX() + player.hitBox.getWidth()) + (player.hitBox.getY()+player.hitBox.getHeight())  (Lado inferior direito)
                    //player.hitBox.getX()+ player.hitBox.getWidth()+player.hitBox.getHeight()
                    //player.hitBox.getX() + player.hitBox.getHeight()

                    //

                    //player.hitBox.getY() + player.hitBox.getWidth()


                }


            }


            System.out.println(player.playerP.getY());
            if (player.playerP.getY() >= 450) {

                isGameOver = true;

                counter = 29;
                index = 0;
            }

            player.playerP.translate(0, 10);
            player.hitBox.translate(0, 10);
        }
    }
}








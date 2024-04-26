package io.codeforall.gameJam.GameLogic;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player  implements KeyboardHandler {

    Keyboard keyboard = new Keyboard(this);
     public Picture playerP;
     public Rectangle hitBox;
    public Player() {
        playerP = new Picture(50, 100, "Player.png");
        hitBox= new Rectangle(50,100,74,73);
        keyboardSetup();
    }



    public void drawPlayer() {
        playerP.draw();
        hitBox.draw();
    }

    public void deletePlayer(){
        playerP.delete();
    }



    private void keyboardSetup() {


        KeyboardEvent upSpace = new KeyboardEvent();
        upSpace.setKey(KeyboardEvent.KEY_SPACE);
        upSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(upSpace);

        KeyboardEvent downSpace = new KeyboardEvent();
        downSpace.setKey(KeyboardEvent.KEY_SPACE);
        downSpace.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(downSpace);


    }



    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE  && playerP.getY()>=25 ) {
            playerP.translate(0, -30);
            hitBox.translate(0,-30);


        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }


    }

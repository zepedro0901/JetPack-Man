package io.codeforall.gameJam.SimpleGx;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu {
    Picture startingMenu = new Picture(0, 0, "Starting Menu.png");

    public void drawMenu() {
        //Picture startingMenu= new Picture(10,10,"Starting Menu.png");
        Canvas.limitCanvasHeight(524);
        Canvas.limitCanvasWidth(1190);
        Canvas.getInstance();
        startingMenu.draw();



    }

    public void deleteStartingMenu() {
        startingMenu.delete();

    }
}

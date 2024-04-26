package io.codeforall.gameJam.SimpleGx;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

     public Picture background= new Picture(0,0, "PurplePlanetBackground1200x534.png");
    private Rectangle borders= new Rectangle(0,0,1200,534);

    public void startBackground(){
        background.draw();
        borders.draw();
    }

    public void deleteBackground(){
        background.delete();
    }


}

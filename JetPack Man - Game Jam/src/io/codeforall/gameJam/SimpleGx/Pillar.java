package io.codeforall.gameJam.SimpleGx;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import java.awt.*;

public class Pillar extends Thread {
    public Picture pillarP;
    public Rectangle hitBoxUp;
     public Rectangle hitBoxDown;
    public Pillar(int yLoc) {
        pillarP = new Picture(1200, yLoc, "Pillars Conjoined.png");
        hitBoxUp = new Rectangle(1210, yLoc+430, 150, 170);

    }
}


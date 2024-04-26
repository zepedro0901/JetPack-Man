package io.codeforall.gameJam;

import io.codeforall.gameJam.SimpleGx.Menu;
import io.codeforall.gameJam.SimpleGx.Pillar;


public class Main {
    public static void main(String[] args) {
      Game flappyBird= new Game();

        flappyBird.startingMenu.drawMenu();
         while(true) {
             try {
                 Thread.sleep(2);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);}



                 if(flappyBird.startGameMenu){
                     flappyBird.menu.drawMenu();


                 }else {flappyBird.startGame();}
             }

         }


       // Pillar pillar = new Pillar(1000,200);
        //pillar.drawPillar();
        //pillar.movePillar();
    //
    }

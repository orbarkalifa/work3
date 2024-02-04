package assign3_2;

import static java.lang.Thread.sleep;

public class Judge extends Thread{

    GamePlay game;
    public Judge(GamePlay game){
        this.game = game;

    }
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            game.makeCoinAvail(true);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Judge interrupted. exiting...");
                Thread.currentThread().interrupt();
                return;
            }
            game.makeCoinAvail(false);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Judge interrupted. exiting...");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

}

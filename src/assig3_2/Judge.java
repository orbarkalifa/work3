// Or Bar Califa 318279429
// Daniel Fradkin 316410885
// Git: https://github.com/orbarkalifa/work3.git

package assig3_2;


public class Judge extends Thread{

    GamePlay game;
    public Judge(GamePlay game){
        this.game = game;

    }
    public void run() {
        while (!isInterrupted()) {
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

package assign3_2;

public class Gamer extends Thread{

    private int goodFlipsCounter = 0;
    public GamePlay game;

    public Gamer(GamePlay game){
        this.game = game;
    }

    public synchronized void play(){
        while(!Thread.currentThread().isInterrupted() && game.getNumOfRounds() < 10){
            if (game.flipCoin()) goodFlipsCounter++;
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void run(){
        play();
    }

    public int getScore(){
        return goodFlipsCounter;
    }

}

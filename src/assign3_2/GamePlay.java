package assign3_2;

public class GamePlay {

    public boolean coin_available_ = false;
    public int rounds_counter = 0;
    public synchronized void makeCoinAvail(boolean val){
        coin_available_ = val;
        if (coin_available_) notifyAll();

    }

    public synchronized boolean flipCoin(){
        while (!coin_available_) {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting for coin...");
                wait();

            } catch (InterruptedException e) {
                System.out.println("Thread interrupted, exiting...");
                return false;
            }
        }

        System.out.println(Thread.currentThread().getName() + " is flipping coin...");
        makeCoinAvail(false);
        int toss = (int) Math.round(Math.random());
        makeCoinAvail(true);
        rounds_counter++;
        System.out.println(rounds_counter + " tosses so far");

        return (toss==1);

    }

    public int getNumOfRounds(){
        return rounds_counter;
    }
}

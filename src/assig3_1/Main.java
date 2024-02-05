package assig3_1;


class T1 implements Runnable {

    @Override
    public void run() {
        while (true) {
            while (Main.turn != 1){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.print(" A ");
            Main.turn = 2;

        }
    }
}

class T2 implements Runnable {
    @Override
    public void run() {
        while(true){
            while (Main.turn == 1 || Main.turn == 4){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.print(" B ");
                Main.turn = 3;

        }
    }
}
class T3 implements Runnable {
    @Override
    public void run() {
        while (true) {
            while (Main.turn != 3){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
                Main.turn = 4;
                System.out.print(" C ");
                Main.turn = 1;


        }
    }
}

public class Main {

    public static Integer turn = 1;


    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());
        Thread t3 = new Thread(new T3());
        t1.start();
        t2.start();
        t3.start();



    }
}

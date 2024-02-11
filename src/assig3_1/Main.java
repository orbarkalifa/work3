// Or Bar Califa 318279429
// Daniel Fradkin 316410885
// Git: https://github.com/orbarkalifa/work3.git

package assig3_1;

import static java.lang.Thread.sleep;

class T1 implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (Main.lock) {
                while (Main.turn != 1) {
                    try {
                        Main.lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.print(" A ");
                Main.turn = 2;
                Main.lock.notifyAll();
                try{
                    sleep(50);
                }catch (Exception ignored){}
            }
        }
    }
}

class T2 implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (Main.lock) {
                while (Main.turn == 1 || Main.turn == 4) {
                    try {
                        Main.lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.print(" B ");
                Main.turn = 3;
                Main.lock.notifyAll();
                try{
                    sleep(50);
                }catch (Exception ignored){}
            }
        }
    }
}

class T3 implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (Main.lock) {
                while (Main.turn != 3) {
                    try {
                        Main.lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                Main.turn = 4;
                System.out.print(" C ");
                Main.turn = 1;
                Main.lock.notifyAll();
                try{
                    sleep(50);
                }catch (Exception ignored){}
            }
        }
    }
}

public class Main {
    public static Integer turn = 1;
    public static final Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());
        Thread t3 = new Thread(new T3());
        t1.start();
        t2.start();
        t3.start();
    }
}

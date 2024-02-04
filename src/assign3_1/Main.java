package assign3_1;

class T1 extends Thread {
    boolean cDone = false;

    public void run(){
        while(true){
            // A
            while(!cDone){
                try {
                    wait();
                } catch (InterruptedException ignored) {}
            }
            System.out.println("A");
            notifyAll();

        }
    }
}
class T2 extends Thread {
    public boolean aDone = false;
    public int n=0;
    public void run(){
        while(true){
            // B
            while(!aDone){
                try {
                    wait();
                } catch (InterruptedException ignored) {}
            }
            System.out.println("B");

            notifyAll();

        }
    }
}
class T3 extends Thread {
    boolean bDone = false;
    public void run(){
        while(true){
            // C
            while(!bDone){
                try {
                    wait();
                } catch (InterruptedException ignored) {}
            }
            System.out.println("C");

            notifyAll();

        }
    }

}

public class Main {
    public static void main(String[] args) {

        T1 t1 = new T1();
        T2 t2 = new T2();
        T3 t3 = new T3();

        t1.start();
        t2.start();
        t3.start();


    }
}
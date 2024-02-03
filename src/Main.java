

public class Main {
    public static void main(String[] args) {

        new Thread(() -> {
            while(true){
                // A

                System.out.println("A");

            }
        }).start();


        new Thread(() -> {
            while(true){
                // B

                System.out.println("B");

            }
        }).start();

        new Thread(() -> {
            while(true){
                // C

                System.out.println("C");

            }
        }).start();




    }
}
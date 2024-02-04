package assign3_2;

public class Main {
    public static void main(String[] args) {
        GamePlay game = new GamePlay();
        Gamer g1 = new Gamer(game);
        Gamer g2 = new Gamer(game);
        Judge judge = new Judge(game);
        judge.start();

        g1.start();
        g2.start();

        try {
            g1.join(); // Wait for g1 to finish
            g2.join(); // Wait for g2 to finish
            judge.interrupt(); // Stop the judge after players finish
            judge.join(); // Wait for the judge to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (g1.getScore() > g2.getScore())
            System.out.println("Player 1 wins (" + g1.getScore() + "-" + g2.getScore() + ")");
        else if (g1.getScore() < g2.getScore())
            System.out.println("Player 2 wins (" + g2.getScore() + "-" + g1.getScore() + ")");
        else
            System.out.println("Tie! (" + g1.getScore() + "-" + g2.getScore() + ")");
    }
}

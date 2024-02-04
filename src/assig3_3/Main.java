package assig3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please Type How Many Salads To Prepare:");
		Scanner scan = new Scanner(System.in);
		final int numOfSaladsToPrepare = scan.nextInt();
		System.out.println("Preparing " + numOfSaladsToPrepare + " Salads...");

		// YOUR CODE HERE: use threads to prepare N salads (as the user requested)

		SlicerMachine machine = new SlicerMachine(numOfSaladsToPrepare);
		SlicerThread slicer = new SlicerThread(machine);
		TomatoesThread tomatoes = new TomatoesThread(slicer);
		CucumbersThread cucumbers = new CucumbersThread(slicer);
		tomatoes.start();
		cucumbers.start();
		slicer.start();


		try {
			while (!machine.isDone()) {
				Thread.sleep(100);
			}

			// Interrupt all threads when the desired number of salads have been prepared
			tomatoes.interrupt();
			cucumbers.interrupt();
			slicer.interrupt();

			// Wait for threads to finish
			tomatoes.join();
			cucumbers.join();
			slicer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Done");
		scan.close();
	}

}

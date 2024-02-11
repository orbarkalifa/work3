// Or Bar Califa 318279429
// Daniel Fradkin 316410885
// Git: https://github.com/orbarkalifa/work3.git

package assig3_3;

public class SlicerThread extends Thread {

    final SlicerMachine machine;

    public SlicerThread(SlicerMachine machine) {
        this.machine = machine;
    }

    @Override
    public void run() {

        while (!isInterrupted()) {
            synchronized (machine) {
                while (machine.numOfTomatoes < 2 || machine.numOfCucumbers < 3) {
                    try {
                        System.out.println("Slicer is waiting for veggies...");
                        machine.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Slicer interrupted. exiting...");
                    }
                }
                if (machine.isDone()) {
                    return;
                }
                machine.sliceVegetables();
                machine.notifyAll();

            }
        }
    }

}

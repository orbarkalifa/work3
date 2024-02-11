package assig3_3;

public class TomatoesThread extends Thread {
    final SlicerThread slicer;

    public TomatoesThread(SlicerThread slicer) {
        this.slicer = slicer;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            synchronized (slicer.machine) {
                while (slicer.machine.numOfTomatoes >= slicer.machine.tomatoesNeededForOneSalad) {
                    try {
                        slicer.machine.wait();
                    } catch (InterruptedException e) {
                        System.out.println("tomatoes interrupted. exiting...");
                        return;
                    }
                }
                slicer.machine.addOneTomato();
                slicer.machine.notifyAll();
            }
        }
    }
}
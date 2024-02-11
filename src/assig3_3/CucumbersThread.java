package assig3_3;

public class CucumbersThread extends Thread {
    final SlicerThread slicer;

    public CucumbersThread(SlicerThread slicer) {
        this.slicer = slicer;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            synchronized (slicer.machine) {
                while (slicer.machine.numOfCucumbers >= slicer.machine.cucumbersNeededForOneSalad) {
                    try {
                        slicer.machine.wait();
                    } catch (InterruptedException e) {
                        System.out.println("cucumbers interrupted. exiting...");
                        return;
                    }
                }
                slicer.machine.addOneCucumber();
                slicer.machine.notifyAll();
            }
        }
    }
}
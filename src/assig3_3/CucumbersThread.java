package assig3_3;


public class CucumbersThread extends Thread {
    SlicerThread slicer;
    public CucumbersThread(SlicerThread slicer){
        this.slicer = slicer;
    }

    public void run(){

        slicer.start();
    }
}

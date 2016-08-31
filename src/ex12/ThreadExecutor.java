package ex12;

/**
 * so what happens is that the two threads access the print method on the same object
 * and prints the same lines and the same time which makes in turn will break the print pattern
 * given enough time.
 * @author Nicklas Molving
 */
public class ThreadExecutor {

    
    
    public static void main(String[] args) {

//        Printer p = new Printer();
        
        
        
        
//        
//        Thread t1 = new Task1(p);
//        Thread t2 = new Task1(p);

        Thread t1 = new Task1();
        Thread t2 = new Task1();

        t1.start();
        t2.start();
        

    }

}

class Task1 extends Thread {

//    Printer p;

//    public Task1(Printer p) {
//        this.p = p;
//    }

    @Override
    public void run() {

        while (true) {
//            p.print();
              Printer.print();
        }
    }

}

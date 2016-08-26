package ex11;

// For week 1

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

// sestoft@itu.dk * 2014-08-21

public class TestLongCounterExperiments {
  public static void main(String[] args) {
    final LongCounter lc = new LongCounter();
    final int counts = 10_000_000;
    Thread t1 = new Thread(() -> {
      for (int i=0; i<counts; i++) 
	lc.increment();
    });
    Thread t2 = new Thread(() -> {
      for (int i=0; i<counts; i++) 
	lc.decrement();
    });
    t1.start(); t2.start();
    try { t1.join(); t2.join(); }
    catch (InterruptedException exn) { 
      System.out.println("Some thread was interrupted");
    }
    System.out.println("Count is " + lc.get() + " and should be " + 2*counts);
  }
}

class LongCounter {
  /**
   * both the increment and decrement should be synchronized as they are both changing the same variable,
   * this is likely to cause problems if they are allowed to change the variable at the same time.
   * 
   * furthermore I've added my own solution to this particular problem where I use an AtomicLong instead of synchronizing the methods.
   * this future proves the program in such a way that you never will be able to access the long with more than one thread at a time!
    */
  
  private AtomicLong count2 = new AtomicLong();
  private long count = 0;
  
  public LongCounter(){
      
  }
  
  public void increment() {
//    count = count + 1;
//    count += 1;
//    count++;
    count2.getAndIncrement();
  }
  public long get() { 
    return count2.get(); 
  }
  
  public void decrement(){
//      count--;
    count2.getAndDecrement();
  }
}

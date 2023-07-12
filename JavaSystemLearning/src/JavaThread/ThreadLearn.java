package JavaThread;

import MyTools.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * https://www.w3schools.com/java/java_threads.asp
 * A thread normally has 5 states:
 * <ul>
 * <li>New: A thread that has not yet started is in this state(Thread t = new
 * Thread())
 * <li>Runnable: A thread executing in the Java virtual machine is in this
 * state(t.start())
 * <li>Running: A thread that is executing, run() method is running
 * <li>Blocked: A thread that is blocked waiting for a monitor, sleep(), wait(),
 * suspend() could cause this state, during this state, the thread is not
 * running and not in the runnable queue, only when blocked condition is over.
 * <li>Timed waiting: A thread that is waiting for another thread to perform an
 * action for up to a specified waiting time is in this state.
 * <li>Terminated: A thread that has exited is in this state.
 * </ul>
 * 
 * @author Lizhenghe.Chen
 */
public class ThreadLearn {
    public static long globalStartTime = System.nanoTime();
    public static String[] colorList = { PrintTools.ANSI_Pink, PrintTools.ANSI_Green, PrintTools.ANSI_Blue };

    public static void main(String[] args) {
        new BaseLineThreadTest().BaseLine();
        globalStartTime = System.nanoTime();
        new MyThread().BasicThreadTest();
        globalStartTime = System.nanoTime();
        new MyRunnableThread().BasicRunnableThresdTest();
        globalStartTime = System.nanoTime();
        new MyCallableThread().BasicCallableThreadTest();
        globalStartTime = System.nanoTime();
        new UnamedThread().UnnamedThreadTest();
    }

    /**
     * Run a 100000 times loop with tough calculation
     * 
     * @param name  the name of the thread
     * @param color the color of the thread output
     */
    static String testThread(String name, String color) {
        BigDecimal loop = new BigDecimal(500);
        List<BigDecimal> list = new ArrayList<>();
        while (loop.compareTo(BigDecimal.ZERO) > 0) {
            loop = loop.subtract(BigDecimal.ONE);
            // list.add(Math.pow(loop * Math.random() / 1000 * Math.random(), loop));
            list.add((loop.multiply(new BigDecimal(Math.random())).multiply(new BigDecimal(Math.random())))
                    .pow(loop.intValue()));
            // PrintTools.println(name + " is running..." + loop, color);
        }
        PrintTools.println(name + " is dead", color);
        // keep 20 decimal places
        return "The 250th element round 20 decimals is "
                + list.get(250).setScale(20, BigDecimal.ROUND_HALF_UP).toString();
    }
}

class BaseLineThreadTest {
    /**
     * the BaseLine of the single thread, run three threads one by one, and print
     * the execution time
     */
    void BaseLine() {
        PrintTools.println("=====BaseLine Thread Test=====");
        for (int i = 0; i < 3; i++) {
            ThreadLearn.testThread("Thread" + (i + 1), ThreadLearn.colorList[i]);
        }
        PrintTools.PrintExecutionTime(ThreadLearn.globalStartTime);
    }
}
// Below is the thread test with three different syntax

/** Extend Syntax */
class MyThread extends Thread {
    private String name;
    private String color = PrintTools.ANSI_Normal;

    public MyThread(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public MyThread() {

    }

    @Override
    public void run() {
        ThreadLearn.testThread(name, color);
    }

    /**
     * Basic Thread Test, use the Thread class, and run three threads at the same
     * time, and print the execution time when all the threads are dead
     */
    void BasicThreadTest() {
        PrintTools.println("=====Basic Thread Test=====");
        MyThread[] threads = new MyThread[3];
        for (int i = 0; i < 3; i++) {
            threads[i] = new MyThread("Thread" + (i + 1), ThreadLearn.colorList[i]);
            threads[i].start();
        }
        // if all the thread is dead, then the main thread is dead
        try {
            for (MyThread myThread : threads) {
                myThread.join();
            }
        } catch (InterruptedException e) {
            PrintTools.println("Main thread is interrupted");
        }
        PrintTools.PrintExecutionTime(ThreadLearn.globalStartTime);
    }
}

/**
 * Implement Syntax, Better use this syntax
 * <ul>
 * <li>When we extend Thread class, we can’t extend any other class even we
 * require and When we implement Runnable, we can save a space for our class to
 * extend any other class in future or now.
 * </ul>
 * See more at:
 * <p>
 * https://www.geeksforgeeks.org/implement-runnable-vs-extend-thread-in-java/
 * <p>
 * https://stackoverflow.com/questions/15471432/why-implements-runnable-is-preferred-over-extends-thread
 */
class MyRunnableThread implements Runnable {
    private String name;
    private String color = PrintTools.ANSI_Normal;

    public MyRunnableThread(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public MyRunnableThread() {

    }

    @Override
    public void run() {
        ThreadLearn.testThread(name, color);
    }

    void BasicRunnableThresdTest() {
        PrintTools.println("=====Basic Runnable Thread Test=====");
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(new MyRunnableThread("Thread" + (i + 1), ThreadLearn.colorList[i]));
            threads[i].start();
        }
        // if all the thread is dead, then the main thread is dead
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            PrintTools.println("Main thread is interrupted");
        }
        PrintTools.PrintExecutionTime(ThreadLearn.globalStartTime);
    }
}

/**
 * The Callable interface is similar to Runnable, in that both are designed for
 * classes whose instances are potentially executed by another thread. A
 * Runnable, however, does not return a result and cannot throw a checked
 * exception, while a Callable does both.
 * 
 */
class MyCallableThread implements Callable<String> {
    private String name;
    private String color = PrintTools.ANSI_Normal;

    public MyCallableThread(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public MyCallableThread() {
    }

    @Override
    public String call() throws Exception {
        return ThreadLearn.testThread(name, color);
    }

    void BasicCallableThreadTest() {
        PrintTools.println("=====Basic Callable Thread Test=====");
        FutureTask<String>[] futureTasks = new FutureTask[3];
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            futureTasks[i] = new FutureTask<>(new MyCallableThread("Thread" + (i + 1), ThreadLearn.colorList[i]));
            threads[i] = new Thread(futureTasks[i]);
            threads[i].start();
        }
        // if all the thread is dead, then the main thread is dead
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            PrintTools.println("Main thread is interrupted");
        }
        for (FutureTask<String> futureTask : futureTasks) {
            try {
                PrintTools.println(futureTask.get(), PrintTools.ANSI_Green);
            } catch (Exception e) {
                PrintTools.println("FutureTask is interrupted");
            }
        }
        PrintTools.PrintExecutionTime(ThreadLearn.globalStartTime);
    }
}

class UnamedThread implements Runnable {

    private String color = PrintTools.ANSI_Normal;

    public UnamedThread() {
    }

    @Override
    public void run() {
        ThreadLearn.testThread(Thread.currentThread().getName(), color);
    }

    void UnnamedThreadTest() {
        PrintTools.println("===== Unnamed Thread Test =====");
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(new UnamedThread());
            threads[i].start();
        }

        // if all the thread is dead, then the main thread is dead
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            PrintTools.println("Main thread is interrupted");
        }
        new UnamedThread().run();// directly call the run method, it will be executed in the main thread
        PrintTools.PrintExecutionTime(ThreadLearn.globalStartTime);
    }
}
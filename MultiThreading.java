Process - Collection of threads are called process.
Thread - Thread is a light-weight sub process, the smallest unit of processing.

App ->  Listening to song -> Thread
        Downloading Song    -> Thread
        Playing Song        -> Thread

Collection of threads are called Process.
MultiThreading in Java is a process of executing multiple threads simultaneously.

interface Runnable{
    run();              implements
}                                           class MyThread{

                                            }

                        extends
class Thread{

}

- Starting Thread in Java

class MyThread implements Runnable{
    public void rrun(){
        //task
    }
}

MyThread t = new MyThread();
Thread thread = new Thread(t);
thread.start();



class MyThread extends Thread{
    public void rrun(){
        //task
    }
}

MyThread t = new MyThread();
t.start();

- Runnable doesnt have start method.z

- Life Cycle of Thread
New -> Runnable -> Running -> Terminated

- Thread class provides methods to perform operations with threads.
 This thread class is present in java.lang package. So, we don't need to import this package.

Some important threads methods
public string getName() -> return the name of thread.
public void setName(String name) -> set the name of the thread.
public void run() -> contains the task of thread.
public void start() -> start thread by allocating resources.
public long getId() -> returns the id of thread.
setPriority(p), getPriority() -> set and get the priority.
sleep(), join(), interrupt(), resume(), stop() etc.

- sleep method is a static method means directly use it by className.
- It can throw checked exception. So, use try-catch block.

- Daemon Thread - It is a service provider thread that provides services to the user thread.
setDaemon(Boolean)
public boolean isDaemon()
Garbage Collector is the best example of Daemon Thread. (It cleans up the garbage produced by threads)

example (Inter thread communication)- 
class Company{
    int n;
    boolean f = false;
    // f=false chance:producer
    // f=true  chance:consumer
    synchronized public void produce_item(int n){
        if(f){
            wait();
        }
        this.n = n;
        System.out.println("Produced " + this.n);
        f = true;
        notify();
    }
    synchronized public void consume_item(){
        if(!f){
            wait();
        }
        System.out.println("Consumed " + this.n);
        f = false;
        notify();
        return this.n;
    }
}

class Producer extends Thread{
    Company c;
    Producer(Company c){
        this.c = c;
    }
    public void run(){
        int i = 1;
        while(true){
            this.c.produce_item(i);
            try{Thread.sleep(1000);}catch(Exception e){}
            i++;
        }
    }
}

class Consumer extends Thread{
    Company c;
    Consumer(Company c){
        this.c = c;
    }
    public void run(){
        while(true){
            this.c.consume_item();
            try{Thread.sleep(1000);}catch(Exception e){}
        }
    }
}

class Main{
    public static void main(String[] args){
        Company comp = new Company();
        Producer p = new Producer();
        Consumer c = new Consumer();
        p.start();
        c.start();
    }
}
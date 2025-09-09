// Thread-Safe Singleton Pattern Implementation in Java with Double-Checked Locking allows for a more predictable and efficient way to ensure that only one instance of a class is created, even in a multi-threaded environment.


class ThreadSafeSingleton {
    // Step 1: Static instance of the Singleton class
    private static ThreadSafeSingleton instance = null;

    // Step2 ; Private constructor to prevent instantiation from outside the class
    private ThreadSafeSingleton() {
        System.out.println("Singleton instance created");
    }

    // Public method to provide access to the Singleton instance with double-checked locking
    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {  // First check (no synchronization)
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {  // Second check (with synchronization)
                    try {
                        Thread.sleep(100);  // Simulates delay
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}

class SingletonTestThread extends Thread {
    @Override
    public void run() {
        // Access the Singleton instance
        ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + " obtained Singleton instance: " + singleton);
    }
}

//@7d5a71a6 is the memory address (hash code) of the singleton instance.
//All threads (Thread-1, Thread-2, Thread-0) obtained the same object reference.
public class Main {
    public static void main(String[] args) {
        // Create multiple threads to test thread-safe Singleton
        SingletonTestThread thread1 = new SingletonTestThread();
        SingletonTestThread thread2 = new SingletonTestThread();
        SingletonTestThread thread3 = new SingletonTestThread();

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

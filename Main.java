class ThreadUnsafeSingleton {
    // Static instance of the Singleton class
    private static ThreadUnsafeSingleton instance = null;

    // Private constructor to prevent instantiation from outside the class
    private ThreadUnsafeSingleton() {
        System.out.println("Singleton instance created");
    }

    // Public method to provide access to the Singleton instance
    public static ThreadUnsafeSingleton getInstance() {
        if (instance == null) {
            // Simulate some delay to increase the chances of thread interference
            try {
                Thread.sleep(100);  // Simulates delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // If two threads come here concurrently, they may both create an instance
            instance = new ThreadUnsafeSingleton();
        }
        return instance;
    }
}

class SingletonTestThread extends Thread {
    @Override
    public void run() {
        // Access the Singleton instance
        ThreadUnsafeSingleton singleton = ThreadUnsafeSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + " obtained Singleton instance: " + singleton);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create multiple threads to test thread-unsafe Singleton
        SingletonTestThread thread1 = new SingletonTestThread();
        SingletonTestThread thread2 = new SingletonTestThread();
        SingletonTestThread thread3 = new SingletonTestThread();

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

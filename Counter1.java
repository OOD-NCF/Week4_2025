public class Counter1 extends Thread {
    private int start;
    private int distance;
    private String name;
    private int max;

    public Counter1(String name, int start, int distance, int max) {
        this.start = start;
        this.distance = distance;
        this.name = name;
        this.max = max;
    }

    public void count() {
        int current = this.start;
        for (int i = 0; i < this.max; i++) {
            System.out.println(this.name + "next in the series " + current);
            current += this.distance;
        }
    }

    public void run() {
        System.out.println(this.name + ": Printing the series");
        this.count();
        try {
            Thread.sleep(distance * 100);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "is in" + Thread.currentThread().getState() + "state");
            //e.printStackTrace();
        }
        System.out.println(this.name + ": Printing completed");
    }
}




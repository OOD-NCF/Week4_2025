// "Counter 2" → the name or label of the counter (used for output or identification)
// 10 → starting value of the counter
// 2  → distance (step size, i.e., how much to increment or decrement per tick)
// 100 → max value (the counter stops when it reaches this value)

public class Main {
    public static void main(String[] args) {
        Counter1 tick = new Counter1("Counter 1", 0, 1, 10);
        Counter1 tick1 = new Counter1("Counter 2", 10, 2, 100);
        Counter1 tick2 = new Counter1("Counter 3", 1, 3, 50);

        tick.start();
        tick1.start();
        tick2.start();
    }
}

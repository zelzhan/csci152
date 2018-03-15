package Clock;

public class ClockTest {
    public static void main(String[] args) {
        Clock cuteClock = new Clock(23, 59, 59);
        cuteClock.tick();
        System.out.println(cuteClock.toString());
        cuteClock.setMinutes(59);
        System.out.println(cuteClock.toString());
        cuteClock.setSeconds(60);
        System.out.println(cuteClock.toString());
        cuteClock.tick();
        cuteClock.setHours(25);
        System.out.println(cuteClock.toString());

    }
}

package Clock2;

public class ClockTest2 {
    public static void main(String[] args)  {
        try {
            Clock2 cuteClock = new Clock2(23, 59, 59);
            System.out.println(cuteClock.toString());
            try {
                cuteClock.setHours(22);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            try {
                cuteClock.setMinutes(01);
            } catch (Exception exc) {
                System.out.println(exc.getMessage());
            }
            System.out.println(cuteClock.toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }




    }
}

package Auto;

public class AutoTest {
    public static void main(String[] args) {
        Automobile car = new Automobile("0XNNAAA");
        car.startCar();
        car.pressGasPedal();
        System.out.println(car.getSpeed() + "\n");
        car.pressBrake();
        System.out.println(car.toString() + '\n');
        car.setPlate("00000x00");
        System.out.println(car.toString() + '\n');
    }
}

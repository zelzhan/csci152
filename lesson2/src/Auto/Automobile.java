package Auto;

public class Automobile {
    private boolean engineRunning;
    private double speed;
    private String plate;

    public Automobile() {
        engineRunning = false;
        speed = 0.0;
        plate = "0x00000";

    }

    public Automobile(String plate) {
        this.plate = plate;
    }

    public void startCar() {
        engineRunning = true;
    }

    public void pressGasPedal() {
        if (engineRunning){
            speed += 10.0;
        }
    }

    public void pressBrake() {
        speed = 0.0;
    }

    public void shutDown() {
        engineRunning = false;
    }

    public boolean isEngineRunning() {
        return engineRunning;
    }

    //getters

    /**
     * @return speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @return plate
     */
    public String getPlate() {
        return plate;
    }

    //setter

    /**
     * @param setter to set
     */
    public void setPlate(String setter) {
        plate = setter;
    }

    /**
     * Method intended to calculate the total distance travelled
     * @param time
     * @return total distance
     */
    public double calculateDistance(double time) {
        return speed * time;
    }

    /**
     * Allow this method to return all parameters of automobile
     * @return concatenated string
     */
    public String toString() {
        return "Engine is running: " + isEngineRunning() + "\nCurrent speed: " + getSpeed() + "\nLicense plate is: " +
        getPlate();
    }
}

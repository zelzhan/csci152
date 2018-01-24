package Auto2;

public class Automobile {
    private boolean engineRunning;
    private double speed;
    private String plate;

    /**
     * If the arguments of class is empty, creates this construct
     */
    public Automobile() {
        engineRunning = false;
        speed = 0.0;
        plate = "0x00000";
    }

    /**
     * Constructor
     * @param plate set plate
     * @throws Exception if the length of the plate is too big or too small
     */
    public Automobile(String plate) throws Exception{
        if (plate.length() > 10 || plate.length() < 5) {
            throw new Exception("Incorrect name of plate");
        }
        this.plate = plate;
    }

    /**
     * Starts a car
     */
    public void startCar() {
        engineRunning = true;
    }

    /**
     * After execution of method, the value of speed increasing by 10.0
     */
    public void pressGasPedal() {
        if (engineRunning){
            speed += 10.0;
        }
    }

    /**
     * Set the value of speed to zero
     */
    public void pressBrake() {
        speed = 0.0;
    }

    /**
     * Shut down the engine
     */
    public void shutDown() {
        engineRunning = false;
    }

    /**
     *
     * @return either true if the engine running or not if the engine is off
     */
    public boolean isEngineRunning() {
        return engineRunning;
    }

    //getters

    /**
     * @return value speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @return Plate
     */
    public String getPlate() {
        return plate;
    }

    //setter

    /**
     *
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

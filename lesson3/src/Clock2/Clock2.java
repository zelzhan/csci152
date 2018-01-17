package Clock2;

public class Clock2 {

    // Fields
    private int hours;
    private int minutes;
    private int seconds;

    // Constructor
    public Clock2(int h, int m, int s) throws Exception {
        if ((h < 0 || h > 23) || (m < 0 || m > 59) || (s<0 || s > 59)) {
            throw new Exception("Incorrect setting of time!");
        }
        hours = h; minutes = m; seconds = s;
    }

    public Clock2() {
        hours = 0; minutes = 0; seconds = 0;
    }

    // Reset method
    public void resetToMidnight() {
        hours = 0; minutes = 0; seconds = 0;
    }

    // Check if morning method
    public boolean isMorning() {
        return hours > 12;
    }

    // Advance one second method
    public void tick() {
        seconds++;
        if (seconds >= 60) {
            seconds = 0;
            minutes ++;
        }
        if (minutes >= 60) {
            minutes = 0;
            hours++;
        }
        if (hours >= 24) {
            hours = 0;
        }
    }

    /**
     * @return the hours
     */

    //getters
    public int getHours() {
        return hours;
    }

    /**
     * @return the minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * @return the seconds
     */
    public int getSeconds() {
        return seconds;
    }


    //setters

    /**
     * @param hours to set
     * @throws Exception if input is invalid
     */
    public void setHours(int hours) throws Exception {
        if (hours < 0 || hours > 23) {
            throw new Exception("Incorrect input of hours");
        }
        this.hours = hours;

    }


    /**
     * @param minutes to set
     * @throws Exception if input is invalid
     */
    public void setMinutes(int minutes) throws Exception{
        if (minutes > 59 || minutes < 0) {
            throw new Exception("Incorrect input of minutes");
        }
        this.minutes = minutes;
    }

    /**
     * @param seconds to set
     * @throws Exception if input is invalid
     */
    public void setSeconds(int seconds) throws Exception {
        if (seconds >59 || seconds < 0) {
            throw new Exception("Incorrect input of seconds");
        }
        this.seconds = seconds;
    }

    public String toString(){
        String strHours = hours+":", strMinutes = minutes + ":", strSeconds = seconds + "";
        if (hours < 9) {
            strHours = "0" + hours + ":";
        }
        if (minutes < 9) {
             strMinutes = "0" + minutes + ":";
        }
        if (seconds < 9) {
             strSeconds = "0" + seconds;
        }
        return strHours + strMinutes + strSeconds;
    }
}
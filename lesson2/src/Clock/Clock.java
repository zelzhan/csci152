package Clock;

public class Clock {

    // Fields
    private int hours;
    private int minutes;
    private int seconds;

    // Constructor
    public Clock(int h, int m, int s) {
        if ((h < 0 || h > 23) || (m < 0 || m > 59) || (s<0 || s > 59)) {
            hours = 0; minutes = 0; seconds = 0;
        }
        hours = h; minutes = m; seconds = s;
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

    //getters
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    //setters
    public void setHours(int inputHours){
        if (inputHours > 0 || inputHours < 24) {
            hours = inputHours;
        }
    }

    public void setMinutes(int inputMinutes){
        if (inputMinutes > 59) {
            minutes += inputMinutes % 60;
            hours += inputMinutes / 60;
        } else if (inputMinutes > 0){
            minutes = inputMinutes;
        }
    }

    public void setSeconds(int inputSeconds){
        if (inputSeconds > 59 && inputSeconds != 0) {
            seconds += inputSeconds%60;
            if (seconds == 0) {
                minutes++;
            }
            if (minutes > 59) {
                minutes = 0;
                hours++;
            }
            //hours += inputSeconds/3600;
        } else if (inputSeconds > 0){
            seconds = inputSeconds;
        }
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
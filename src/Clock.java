/**
 * Abstract base class representing a generic clock.
 * Defines common properties such as hour, minute, and second, as well as a method to convert
 * time from another Clock instance.
 */
public sealed abstract class Clock permits BRLClock, USClock {

    protected int hour;
    protected int minute;
    protected int seconds;

    // Getter and setter for hour
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour < 24) {
            this.hour = hour;
        }
    }

    // Getter and setter for minute
    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute < 60) {
            this.minute = minute;
        }
    }

    // Getter and setter for seconds
    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if (seconds >= 0 && seconds < 60) {
            this.seconds = seconds;
        }
    }

    // Format value to always show two digits
    private String format(int value) {
        return value < 10 ? "0" + value : String.valueOf(value);
    }

    /**
     * Returns the time in HH:MM:SS format.
     */
    public String getTime() {
        return format(hour) + ":" + format(minute) + ":" + format(seconds);
    }

    /**
     * Abstract method to be implemented by subclasses.
     * Copies time data from another Clock instance to the current one.
     *
     * @param clock another Clock instance
     * @return the updated current instance
     */
    public abstract Clock convert(Clock clock);
}

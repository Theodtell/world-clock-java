/**
 * USClock represents a 12-hour clock with AM/PM format.
 */
public non-sealed class USClock extends Clock {

    private String periodIndicator; // "AM" or "PM"

    public String getPeriodIndicator() {
        return periodIndicator;
    }

    public void setAfterMidday() {
        this.periodIndicator = "PM";
    }

    public void setBeforeMidday() {
        this.periodIndicator = "AM";
    }

    /**
     * Sets the hour in 12-hour format.
     * Converts from 24-hour if necessary.
     *
     * @param hour the hour in 24-hour format
     */
    @Override
    public void setHour(int hour) {
        if (hour >= 0 && hour < 24) {
            if (hour >= 12) {
                setAfterMidday();
                this.hour = (hour > 12) ? hour - 12 : 12;
            } else {
                setBeforeMidday();
                this.hour = (hour == 0) ? 12 : hour;
            }
        }
    }

    /**
     * Converts time from another Clock instance to US format.
     *
     * @param clock the Clock to convert from
     * @return this instance with updated time
     */
    @Override
    public Clock convert(Clock clock) {
        this.seconds = clock.getSeconds();
        this.minute = clock.getMinute();

        switch (clock) {
            case USClock usClock -> {
                this.hour = usClock.getHour();
                this.periodIndicator = usClock.getPeriodIndicator();
            }
            case BRLClock brlClock -> this.setHour(brlClock.getHour());
        }
        return this;
    }

    /**
     * Returns time in HH:MM:SS AM/PM format.
     */
    @Override
    public String getTime() {
        return super.getTime() + " " + this.periodIndicator;
    }
}

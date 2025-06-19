/**
 * BRLClock represents a 24-hour clock (Brazilian standard).
 */
public non-sealed class BRLClock extends Clock {

    /**
     * Converts time from another Clock instance to Brazilian format.
     *
     * @param clock the Clock to convert from
     * @return this instance with updated time
     */
    @Override
    public Clock convert(final Clock clock) {
        this.seconds = clock.getSeconds();
        this.minute = clock.getMinute();

        switch (clock) {
            case USClock usClock ->
                // Converts 12-hour format to 24-hour format
                    this.hour = "PM".equals(usClock.getPeriodIndicator()) ? usClock.getHour() + 12 : usClock.getHour();
            case BRLClock brlClock ->
                    this.hour = brlClock.hour;
        }
        return this;
    }
}

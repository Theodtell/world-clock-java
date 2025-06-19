public class Main {
    public static void main(String[] args) {
        BRLClock brClock = new BRLClock();
        brClock.setHour(15);
        brClock.setMinute(30);
        brClock.setSeconds(45);

        USClock usClock = new USClock();
        usClock.convert(brClock);

        System.out.println("Brazil Time: " + brClock.getTime());
        System.out.println("US Time: " + usClock.getTime());
    }
}

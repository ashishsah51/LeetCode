class Solution {
    public double angleClock(int hour, int minutes) {

        double hourHandPositionInMinuteScale =
                ((hour % 12) * 5.0) +
                (minutes == 0 ? 0.0 : (5.0 / (60.0 / minutes)));

        double minuteDifference =
                Math.abs(hourHandPositionInMinuteScale - minutes);

        if (hourHandPositionInMinuteScale <= minutes) {
            minuteDifference = Math.min(
                    60.0 - minutes + hourHandPositionInMinuteScale,
                    minuteDifference
            );
        } else {
            minuteDifference = Math.min(
                    60.0 - hourHandPositionInMinuteScale + minutes,
                    minuteDifference
            );
        }

        return minuteDifference * 6.0;
    }
}
package L3.Prob3;

public record Flight(String origin, String destination, float distance) {

    public Flight {
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance must be a positive number.");
        }

    }

    public double computeFlightTime(double avgSpeed) {
        if (avgSpeed <= 0) {
            throw new IllegalArgumentException("Average speed must be a positive number.");
        }
        return this.distance / avgSpeed;
    }


}

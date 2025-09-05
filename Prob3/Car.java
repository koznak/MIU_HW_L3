package L3.Prob3;

final class Car {

    private final String carModel;
    private final int days;
    private final double ratePerDay;
    private final double milesPerDay;

    public Car(String carModel, int days, double ratePerDay, double milesPerDay) {

        if (carModel == null || carModel.trim().isEmpty() || days <= 0 || ratePerDay <= 0 || milesPerDay < 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        this.carModel = carModel;
        this.days = days;
        this.ratePerDay = ratePerDay;
        this.milesPerDay = milesPerDay;
    }


    public double totalRentalCost() {
        return days * ratePerDay;
    }
    public double totalMilesAllowed() {
        return days * milesPerDay;
    }

}
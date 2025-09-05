package L3.Prob3;

public record Hotel(String hotelName, int nights, int pricePerNight) {

    public Hotel {
        if ( nights <= 0 || pricePerNight <= 0) {
            throw new IllegalArgumentException("Nights and Price Per Night must be a positive number.");
        }

    }

    public double totalCost() {
        return this.nights * this.pricePerNight;
    }
}

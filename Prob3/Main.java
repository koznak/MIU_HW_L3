package L3.Prob3;

import java.util.Scanner;

public class Main {
    private static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        char flag = 'Y';
        char input = 0;
        try {
            while (flag == 'Y') {
                System.out.println("\n===== Booking System =====");
                System.out.println("Enter F for Flight Booking \n" +
                        "Enter H for Hotel Booking \n" +
                        "Enter C for Car Rental");
                System.out.print("Please enter your choice: ");
                input = sc.nextLine().toUpperCase().charAt(0);
                switch (input) {
                    case 'F':
                        flightBooking();
                        break;
                    case 'H':
                        hotelBooking();
                        break;
                    case 'C':
                        carBooking();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
                System.out.print("\nDo you want to continue (Y/N)?: ");
                flag = sc.nextLine().toUpperCase().charAt(0);
            }
            System.out.println("Thank you for using!");

        } catch (Exception ex) {
            System.out.println("Illegal input!");
        } finally {
            sc.close();
        }
    }

    public static void flightBooking() {
        String origin;
        String destination;
        float distance = 0;
        float speed = 0;

        try {
            System.out.print("Enter origin: ");
            origin = sc.nextLine();
            System.out.print("Enter destination: ");
            destination = sc.nextLine();
            System.out.print("Enter distance in km: ");
            distance = Float.parseFloat(sc.nextLine());
            System.out.print("Enter average speed (km/h): ");
            speed = Float.parseFloat(sc.nextLine());
            var f = new Flight(origin, destination, distance);
            System.out.printf("Estimated Flight Time: %.2f hours", f.computeFlightTime(speed));
        } catch (Exception ex) {
            System.out.println("Illegal input!");
        }

    }

    public static void hotelBooking() {
        String hotelName;
        int nights;
        int pricePerNight;

        try {
            System.out.print("Enter hotel name: ");
            hotelName = sc.nextLine();
            System.out.print("Enter number of nights: ");

            //I had tried to use "nextLine" for an int value; however, "nextLine" is not working properly after "nextInt"
            //nights =sc.nextInt();
            nights = Integer.parseInt(sc.nextLine());
            System.out.print("Enter price per night: ");
            pricePerNight = Integer.parseInt(sc.nextLine());
            var h = new Hotel(hotelName, nights, pricePerNight);
            System.out.print("Total Hotel Cost: $" + h.totalCost());
        } catch (Exception ex) {
            System.out.println("Illegal input!");
        }

    }

    public static void carBooking() {
        String carModel;
        int days;
        double ratePerDay;
        double milesPerDay;


        try {
            System.out.print("Enter car model: ");
            carModel = sc.nextLine();
            System.out.print("Enter number of days: ");

            //I had tried to use "nextLine" for an int value; however, "nextLine" is not working properly after "nextInt"
            days = Integer.parseInt(sc.nextLine());
            System.out.print("Enter rate per day: ");
            ratePerDay = Double.parseDouble(sc.nextLine());
            System.out.print("Enter miles per day: ");
            milesPerDay = Double.parseDouble(sc.nextLine());
            var c = new Car(carModel, days, ratePerDay, milesPerDay);
            System.out.printf("Total Rental Cost: $%.2f\n", c.totalRentalCost());
            System.out.printf("Total Miles Allowed: %.2f\n", c.totalMilesAllowed());

        } catch (Exception ex) {
            System.out.println("Illegal input!" + ex.getMessage());
        }

    }
}

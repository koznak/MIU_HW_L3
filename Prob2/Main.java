package L3.Prob2;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {

    private static final DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy 'at' HH:mm '['VV']'");
    private static final ZoneId defaultTimeZone =ZoneId.systemDefault();
    private static final String[] tzList = {
            "America/Panama",
            "America/Chicago",
            "America/Indiana/Indianapolis",
            "America/Santiago",
            "America/Phoenix"
    };

    public static void main(String[] args) {

        String eName = "";
        String eDate = "";
        String eTime = "";

        Scanner sc = new Scanner(System.in);
        try
        {
        System.out.print("Pleas enter the event name: ");
        eName = sc.nextLine();
        System.out.print("Pleas enter the event date(e.g., YYYY-MM-DD) : ");
        eDate = sc.nextLine();
        System.out.print("Pleas enter the event time (e.g., HH:mm) : ");
        eTime = sc.nextLine();
        display(eName, eDate, eTime, tzList[1]);
        System.out.print("Do you want to display it in a different time zone? y/n: ");

        if (sc.next().charAt(0) == 'y') {
            displayTimezoneList();
            System.out.print("Please enter your Choice (1-5): ");
            int tz = sc.nextInt();
            display(eName, eDate, eTime, tzList[tz - 1]);

        } else {
            System.out.print("Thank you for using, Goodbye!");

        }
        }
        catch (Exception ex)
        {
            System.out.println("Invalid date or time format. Please use the specified format.");
        }
        finally {
            sc.close();
        }

    }

    public static void display(String eName, String eDate, String eTime,String timeZone)
    {
        LocalDate dt=LocalDate.parse(eDate);
        LocalTime tm=LocalTime.parse(eTime);
        LocalDateTime edt=LocalDateTime.of(dt,tm);

        ZoneId tzId = ZoneId.of(timeZone);

        ZonedDateTime zonedTime = ZonedDateTime.of(edt, defaultTimeZone);
        LocalDate ldt=LocalDate.now();


        System.out.println("--- Event Details ---");
        System.out.printf("The event %s is scheduled on %s\n",eName, zonedTime.withZoneSameInstant(tzId).format(dateformatter));
        if (dt.isLeapYear())
        {
            System.out.printf("The %s is a leap year.\n", dt.getYear());
        }


        System.out.println("Days until the event: " + ChronoUnit.DAYS.between(ldt, zonedTime));
    }
    public static void displayTimezoneList()
    {
        System.out.println("1: America/Panama.");
        System.out.println("2: America/Chicago.");
        System.out.println("3: America/Indiana/Indianapolis.");
        System.out.println("4: America/Santiago.");
        System.out.println("5: America/Phoenix.");

    }
}

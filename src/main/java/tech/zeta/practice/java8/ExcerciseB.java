package tech.zeta.practice.java8;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class ExcerciseB {
    //1. Date Arithmetic: Write a program that takes a date as input (year, month, day) and calculates the date 3 weeks from that date.
    static Scanner scanner = new Scanner(System.in);
    public static void one(){
        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        System.out.println("Enter month: ");
        int month = scanner.nextInt();
        System.out.println("Enter day: ");
        int day = scanner.nextInt();

        Date inputDate = new Date(year-1900,month-1,day);
        long threeWeeksInMillis = 21L * 24 * 60 * 60 * 1000;
        Date newDate = new Date(inputDate.getTime() + threeWeeksInMillis);

        System.out.println("Date after 3 weeks: " + newDate);


    }
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    //2. Time Zone Conversion: Given a specific LocalDateTime, convert it to ZonedDateTime for both "Asia/Tokyo" and "Europe/London" time zones and print the results.
    public static void two(){
        System.out.print("Enter date and time (yyyy-MM-dd HH:mm): ");
        LocalDateTime localDateTime = LocalDateTime.parse(scanner.nextLine(),formatter);
        System.out.println("Input date and time: " + localDateTime);
        System.out.println("Asia/Tokyo time zone: " + localDateTime.atZone(ZoneId.of("Asia/Tokyo")));
        System.out.println("Asia/Tokyo time zone: " + localDateTime.atZone(ZoneId.of("Europe/London")));
    }

    //3. Event Countdown: Create a program that calculates the number of days, hours, and minutes until a specific future event (e.g., a product launch, a birthday)
    public static void three(){
        System.out.print("Enter product launch datetime (yyyy-MM-dd HH:mm): ");
        LocalDateTime eventDateTime = LocalDateTime.parse(scanner.nextLine(),formatter);
        LocalDateTime currentDateTime = LocalDateTime.now();

        Duration duration = Duration.between(currentDateTime,eventDateTime);

        long days    = duration.toDays();
        long hours   = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        System.out.print("Time left until: ");
        System.out.println(days + " days, " + hours + " hours, "
                + minutes + " minutes, " + seconds + " seconds");
    }

    //4. Parse and Format: Take date in the format "MM/dd/yyyy hh:mm a" and convert to "yyyy-MM-dd HH:mm:ss"
    public static void four(){
        System.out.print("Enter date and time (MM/dd/yyyy HH:mm): ");
        LocalDateTime inputDateTime = LocalDateTime.parse(scanner.nextLine(),DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm"));

        String formattedDate = inputDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") );

        System.out.println("Formatted date and time: " + formattedDate);
    }

    public static void main(String[] args) {
        //one();
        //two();
        //three();
        four();
    }
}

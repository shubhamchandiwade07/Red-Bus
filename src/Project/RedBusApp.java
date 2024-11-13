package Project;

import java.util.ArrayList;
import java.util.Scanner;

// Bus Class
class Bus {
    private int busNumber;
    private String route;
    private int availableSeats;

    public Bus(int busNumber, String route, int availableSeats) {
        this.busNumber = busNumber;
        this.route = route;
        this.availableSeats = availableSeats;
    }

    public int getBusNumber() {
        return busNumber;
    }

    public String getRoute() { 
        return route;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }

    @Override
    public String toString() {
        return "Bus Number: "+busNumber+", Route: "+route+", Seats Available: "+availableSeats;
    }
}

// Booking Class
class Booking {
    private String passengerName;
    private int busNumber;

    public Booking(String passengerName, int busNumber) {
        this.passengerName = passengerName;
        this.busNumber = busNumber;
    }

    @Override
    public String toString() {
        return "Passenger: "+passengerName+", Bus Number: "+busNumber;
    }
}

// Main Class
public class RedBusApp {
    private static ArrayList<Bus> buses = new ArrayList<>();
    private static ArrayList<Booking> bookings = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBuses();
        int choice;
        do {
            System.out.println("\n=== RedBus App ===");
            System.out.println("1. View Buses");
            System.out.println("2. Book Ticket");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewBuses();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.out.println("Thank you for using RedBus!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }

    private static void initializeBuses() {
        buses.add(new Bus(101, "Mumbai to Pune", 30));
        buses.add(new Bus(102, "Pune to Bangalore", 25));
        buses.add(new Bus(103, "Delhi to Chandigarh", 20));
    }

    private static void viewBuses() {
        System.out.println("\nAvailable Buses:");
        for (Bus bus : buses) {
            System.out.println(bus);
        }
    }

    private static void bookTicket() {
        System.out.print("\nEnter your name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();
        System.out.print("Enter bus number to book: ");
        int busNumber = scanner.nextInt();

        Bus selectedBus = null;
        for (Bus bus : buses) {
            if (bus.getBusNumber() == busNumber) {
                selectedBus = bus;
                break;
            }
        }

        if (selectedBus != null && selectedBus.getAvailableSeats() > 0) {
            selectedBus.bookSeat();
            bookings.add(new Booking(name, busNumber));
            System.out.println("Ticket booked successfully!");
        } else {
            System.out.println("Sorry, no seats available or invalid bus number.");
        }
    }

    private static void viewBookings() {
        System.out.println("\nBookings:");
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        }
    }
}


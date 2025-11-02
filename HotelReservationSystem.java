import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String type;
    boolean isBooked;
    String bookedBy;

    Room(int roomNumber, String type) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.isBooked = false;
        this.bookedBy = "";
    }
}

public class HotelReservationSystem {
    static ArrayList<Room> rooms = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();

        int choice;
        do {
            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View All Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> viewAvailableRooms();
                case 2 -> bookRoom();
                case 3 -> cancelReservation();
                case 4 -> viewAllBookings();
                case 5 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    static void initializeRooms() {
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(103, "Suite"));
        rooms.add(new Room(104, "Standard"));
        rooms.add(new Room(105, "Deluxe"));
    }

    static void viewAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room r : rooms) {
            if (!r.isBooked) {
                System.out.println("Room " + r.roomNumber + " (" + r.type + ")");
            }
        }
    }

    static void bookRoom() {
        System.out.print("Enter room number to book: ");
        int number = sc.nextInt();
        sc.nextLine();
        for (Room r : rooms) {
            if (r.roomNumber == number && !r.isBooked) {
                System.out.print("Enter your name: ");
                String name = sc.nextLine();
                r.isBooked = true;
                r.bookedBy = name;
                System.out.println("Room " + r.roomNumber + " booked successfully by " + name + "!");
                return;
            }
        }
        System.out.println("Room not available or invalid room number.");
    }

    static void cancelReservation() {
        System.out.print("Enter room number to cancel booking: ");
        int number = sc.nextInt();
        sc.nextLine();
        for (Room r : rooms) {
            if (r.roomNumber == number && r.isBooked) {
                System.out.println("Booking canceled for " + r.bookedBy + ".");
                r.isBooked = false;
                r.bookedBy = "";
                return;
            }
        }
        System.out.println("No booking found for that room.");
    }

    static void viewAllBookings() {
        System.out.println("\nCurrent Bookings:");
        for (Room r : rooms) {
            if (r.isBooked) {
                System.out.println("Room " + r.roomNumber + " (" + r.type + ") booked by " + r.bookedBy);
            }
        }
    }
}

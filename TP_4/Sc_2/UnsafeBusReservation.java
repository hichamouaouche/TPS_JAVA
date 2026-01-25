class Bus {
    private int availableSeats;

    public Bus(int seats) {
        this.availableSeats = seats;
    }

    // Method is NOT synchronized - causing the race condition
    public void bookSeats(int seatsRequested, String passengerName) {
        System.out.println(passengerName + " entered.");
        System.out.println("Available seats: " + availableSeats);

        if (availableSeats >= seatsRequested) {
            // Simulating some processing time to ensure race condition occurs
            try { Thread.sleep(100); } catch (InterruptedException e) { }

            availableSeats = availableSeats - seatsRequested;
            System.out.println(passengerName + " booked " + seatsRequested + " seats.");
        } else {
            System.out.println(passengerName + " failed to book. Not enough seats.");
        }
        System.out.println("Seats left after " + passengerName + ": " + availableSeats);
        System.out.println("--------------------------------");
    }
}

class Passenger extends Thread {
    Bus bus;
    int seatsNeeded;

    public Passenger(Bus bus, int seats, String name) {
        this.bus = bus;
        this.seatsNeeded = seats;
        this.setName(name);
    }

    @Override
    public void run() {
        bus.bookSeats(seatsNeeded, getName());
    }
}

public class UnsafeBusReservation {
    public static void main(String[] args) {
        Bus bus = new Bus(3); // Total 3 seats

        // Both passengers want 2 seats (Total demand: 4)
        Passenger p1 = new Passenger(bus, 2, "Passenger 1");
        Passenger p2 = new Passenger(bus, 2, "Passenger 2");

        p1.start();
        p2.start();
    }
}
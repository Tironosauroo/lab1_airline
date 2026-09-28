package airline;

import airline.aircraft.Aircraft;
import airline.cargo.CargoAircraft;
import airline.combi.CombiAircraft;
import airline.company.Airline;
import airline.passenger.PassengerAircraft;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Airline airline = new Airline("SkyLine Airways");

        airline.addAircraft(new PassengerAircraft("Airbus A320", 6100, 2400, 180));
        airline.addAircraft(new PassengerAircraft("Boeing 777-300ER", 13650, 6800, 396));
        airline.addAircraft(new CargoAircraft("Boeing 747-8F", 8130, 11000, 137700));
        airline.addAircraft(new CargoAircraft("Antonov An-124", 4800, 15000, 150000));
        airline.addAircraft(new CombiAircraft("Boeing 737-800BCF Combi", 5400, 2600, 88, 19000));

        System.out.println("Airline: " + airline.getName());
        System.out.println("Number of aircraft in the fleet: " + airline.getFleetSize());
        System.out.println();

        System.out.println("Total passenger capacity: "
                + airline.getTotalPassengerCapacity() + " passengers");
        System.out.println("Total load capacity: "
                + airline.getTotalCargoCapacityKg() + " kg");
        System.out.println();

        airline.sortByFlightRange();
        System.out.println("Aircraft sorted by flight range:");
        for (Aircraft aircraft : airline.getFleet()) {
            System.out.println("  " + aircraft.getDescription());
        }
        System.out.println();

        double minFuel = 2500;
        double maxFuel = 7000;
        List<Aircraft> found = airline.findByFuelConsumptionRange(minFuel, maxFuel);
        System.out.println("Aircraft with fuel consumption from " + minFuel + " to " + maxFuel + " l/h:");
        if (found.isEmpty()) {
            System.out.println(" No aircraft matching the range were found");
        } else {
            for (Aircraft aircraft : found) {
                System.out.println("  " + aircraft.getDescription());
            }
        }
    }
}

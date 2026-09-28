package airline.company;

import airline.aircraft.Aircraft;
import airline.carrier.CargoCarrier;
import airline.carrier.PassengerCarrier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Airline {

    private final String name;
    private final List<Aircraft> fleet = new ArrayList<>();

    public Airline(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The airline name cannot be empty");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addAircraft(Aircraft aircraft) {
        if (aircraft == null) {
            throw new IllegalArgumentException("The aircraft cannot be null");
        }
        fleet.add(aircraft);
    }

    public List<Aircraft> getFleet() {
        return Collections.unmodifiableList(fleet);
    }

    public int getFleetSize() {
        return fleet.size();
    }

    public int getTotalPassengerCapacity() {
        int total = 0;
        for (Aircraft aircraft : fleet) {
            if (aircraft instanceof PassengerCarrier) {
                PassengerCarrier carrier = (PassengerCarrier) aircraft;
                total += carrier.getPassengerCapacity();
            }
        }
        return total;
    }

    public double getTotalCargoCapacityKg() {
        double total = 0;
        for (Aircraft aircraft : fleet) {
            if (aircraft instanceof CargoCarrier) {
                CargoCarrier carrier = (CargoCarrier) aircraft;
                total += carrier.getCargoCapacityKg();
            }
        }
        return total;
    }

    public void sortByFlightRange() {
        fleet.sort(Comparator.comparingDouble(Aircraft::getFlightRangeKm));
    }

    public List<Aircraft> findByFuelConsumptionRange(double minInclusive, double maxInclusive) {
        if (minInclusive > maxInclusive) {
            throw new IllegalArgumentException("The minimum of the range cannot exceed the maximum");
        }

        List<Aircraft> result = new ArrayList<>();
        for (Aircraft aircraft : fleet) {
            double consumption = aircraft.getFuelConsumptionPerHour();
            if (consumption >= minInclusive && consumption <= maxInclusive) {
                result.add(aircraft);
            }
        }
        return result;
    }
}

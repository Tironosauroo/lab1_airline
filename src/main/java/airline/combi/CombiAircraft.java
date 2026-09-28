package airline.combi;

import airline.aircraft.Aircraft;
import airline.carrier.CargoCarrier;
import airline.carrier.PassengerCarrier;

public class CombiAircraft extends Aircraft implements PassengerCarrier, CargoCarrier {

    private final int passengerCapacity;
    private final double cargoCapacityKg;

    public CombiAircraft(String name,
                          double flightRangeKm,
                          double fuelConsumptionPerHour,
                          int passengerCapacity,
                          double cargoCapacityKg) {
        super(name, flightRangeKm, fuelConsumptionPerHour);

        if (passengerCapacity <= 0) {
            throw new IllegalArgumentException("Passenger capacity must be positive");
        }
        if (cargoCapacityKg <= 0) {
            throw new IllegalArgumentException("Load capacity must be positive");
        }

        this.passengerCapacity = passengerCapacity;
        this.cargoCapacityKg = cargoCapacityKg;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getCargoCapacityKg() {
        return cargoCapacityKg;
    }

    @Override
    public String getDescription() {
        return "Combined-configuration aircraft \"" + getName() + "\": " + passengerCapacity
                + " passenger seats + " + cargoCapacityKg + " kg of cargo, range "
                + getFlightRangeKm() + " km";
    }
}

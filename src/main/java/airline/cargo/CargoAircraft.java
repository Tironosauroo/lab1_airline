package airline.cargo;

import airline.aircraft.Aircraft;
import airline.carrier.CargoCarrier;

public class CargoAircraft extends Aircraft implements CargoCarrier {

    private final double cargoCapacityKg;

    public CargoAircraft(String name,
                          double flightRangeKm,
                          double fuelConsumptionPerHour,
                          double cargoCapacityKg) {
        super(name, flightRangeKm, fuelConsumptionPerHour);

        if (cargoCapacityKg <= 0) {
            throw new IllegalArgumentException("Load capacity must be positive");
        }
        this.cargoCapacityKg = cargoCapacityKg;
    }

    @Override
    public double getCargoCapacityKg() {
        return cargoCapacityKg;
    }

    @Override
    public String getDescription() {
        return "Cargo aircraft \"" + getName() + "\": load-carrying capacity "
                + cargoCapacityKg + " kg, range " + getFlightRangeKm() + " km";
    }
}

package airline.passenger;

import airline.aircraft.Aircraft;
import airline.carrier.PassengerCarrier;

public class PassengerAircraft extends Aircraft implements PassengerCarrier {

    private final int passengerCapacity;

    public PassengerAircraft(String name,
                              double flightRangeKm,
                              double fuelConsumptionPerHour,
                              int passengerCapacity) {
        super(name, flightRangeKm, fuelConsumptionPerHour);

        if (passengerCapacity <= 0) {
            throw new IllegalArgumentException("Passenger capacity must be positive");
        }
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public String getDescription() {
        return "Passenger aircraft \"" + getName() + "\": " + passengerCapacity
                + " passenger seats, range " + getFlightRangeKm() + " km";
    }
}

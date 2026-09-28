package airline.aircraft;

public abstract class Aircraft {

    private final String name;
    private final double flightRangeKm;
    private final double fuelConsumptionPerHour;

    protected Aircraft(String name, double flightRangeKm, double fuelConsumptionPerHour) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The aircraft name cannot be empty");
        }
        if (flightRangeKm <= 0) {
            throw new IllegalArgumentException("The flight range must be positive");
        }
        if (fuelConsumptionPerHour <= 0) {
            throw new IllegalArgumentException("Fuel consumption must be positive");
        }

        this.name = name;
        this.flightRangeKm = flightRangeKm;
        this.fuelConsumptionPerHour = fuelConsumptionPerHour;
    }

    public String getName() {
        return name;
    }

    public double getFlightRangeKm() {
        return flightRangeKm;
    }

    public double getFuelConsumptionPerHour() {
        return fuelConsumptionPerHour;
    }

    public abstract String getDescription();

    @Override
    public String toString() {
        return getDescription();
    }
}

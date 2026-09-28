package airline.cargo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CargoAircraftTest {

    @Test
    void constructor_validData_createsAircraftWithCorrectFields() {
        CargoAircraft aircraft = new CargoAircraft("Boeing 747-8F", 8130, 11000, 137700);

        assertEquals("Boeing 747-8F", aircraft.getName());
        assertEquals(8130, aircraft.getFlightRangeKm());
        assertEquals(11000, aircraft.getFuelConsumptionPerHour());
        assertEquals(137700, aircraft.getCargoCapacityKg());
    }

    @Test
    void constructor_nonPositiveCargoCapacity_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new CargoAircraft("Boeing 747-8F", 8130, 11000, -1));
    }

    @Test
    void getDescription_containsNameAndCargoCapacity() {
        CargoAircraft aircraft = new CargoAircraft("Boeing 747-8F", 8130, 11000, 137700);

        String description = aircraft.getDescription();

        assertTrue(description.contains("Boeing 747-8F"));
        assertTrue(description.contains("137700"));
    }
}

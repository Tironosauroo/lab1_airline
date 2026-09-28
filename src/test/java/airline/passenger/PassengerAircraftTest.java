package airline.passenger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PassengerAircraftTest {

    @Test
    void constructor_validData_createsAircraftWithCorrectFields() {
        PassengerAircraft aircraft = new PassengerAircraft("Airbus A320", 6100, 2400, 180);

        assertEquals("Airbus A320", aircraft.getName());
        assertEquals(6100, aircraft.getFlightRangeKm());
        assertEquals(2400, aircraft.getFuelConsumptionPerHour());
        assertEquals(180, aircraft.getPassengerCapacity());
    }

    @Test
    void constructor_nonPositivePassengerCapacity_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new PassengerAircraft("Airbus A320", 6100, 2400, 0));
    }

    @Test
    void constructor_blankName_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new PassengerAircraft("  ", 6100, 2400, 180));
    }

    @Test
    void getDescription_containsNameAndCapacity() {
        PassengerAircraft aircraft = new PassengerAircraft("Airbus A320", 6100, 2400, 180);

        String description = aircraft.getDescription();

        assertTrue(description.contains("Airbus A320"));
        assertTrue(description.contains("180"));
    }
}

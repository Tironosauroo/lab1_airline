package airline.combi;

import airline.carrier.CargoCarrier;
import airline.carrier.PassengerCarrier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CombiAircraftTest {

    @Test
    void constructor_validData_createsAircraftWithBothCapacities() {
        CombiAircraft aircraft = new CombiAircraft("Boeing 737-800BCF Combi", 5400, 2600, 88, 19000);

        assertEquals(88, aircraft.getPassengerCapacity());
        assertEquals(19000, aircraft.getCargoCapacityKg());
    }

    @Test
    void combiAircraft_implementsBothCarrierInterfaces() {
        CombiAircraft aircraft = new CombiAircraft("Boeing 737-800BCF Combi", 5400, 2600, 88, 19000);

        assertInstanceOf(PassengerCarrier.class, aircraft);
        assertInstanceOf(CargoCarrier.class, aircraft);
    }

    @Test
    void constructor_nonPositivePassengerCapacity_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new CombiAircraft("Combi", 5400, 2600, 0, 19000));
    }

    @Test
    void constructor_nonPositiveCargoCapacity_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new CombiAircraft("Combi", 5400, 2600, 88, 0));
    }
}

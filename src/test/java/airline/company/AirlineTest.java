package airline.company;

import airline.aircraft.Aircraft;
import airline.cargo.CargoAircraft;
import airline.combi.CombiAircraft;
import airline.passenger.PassengerAircraft;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AirlineTest {

    private Airline airline;

    private PassengerAircraft a320;
    private PassengerAircraft boeing777;
    private CargoAircraft boeing747f;
    private CombiAircraft combi737;

    @BeforeEach
    void setUp() {
        airline = new Airline("SkyLine Airways");

        a320 = new PassengerAircraft("Airbus A320", 6100, 2400, 180);
        boeing777 = new PassengerAircraft("Boeing 777-300ER", 13650, 6800, 396);
        boeing747f = new CargoAircraft("Boeing 747-8F", 8130, 11000, 137700);
        combi737 = new CombiAircraft("Boeing 737-800BCF Combi", 5400, 2600, 88, 19000);
    }

    @Test
    void addAircraft_singleAircraft_increasesFleetSize() {
        airline.addAircraft(a320);

        assertEquals(1, airline.getFleetSize());
    }

    @Test
    void addAircraft_nullAircraft_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> airline.addAircraft(null));
    }

    @Test
    void getTotalPassengerCapacity_emptyFleet_returnsZero() {
        assertEquals(0, airline.getTotalPassengerCapacity());
    }

    @Test
    void getTotalPassengerCapacity_mixedFleet_sumsOnlyPassengerCarriers() {
        airline.addAircraft(a320);
        airline.addAircraft(boeing777);
        airline.addAircraft(boeing747f);
        airline.addAircraft(combi737);

        assertEquals(180 + 396 + 88, airline.getTotalPassengerCapacity());
    }

    @Test
    void getTotalCargoCapacityKg_emptyFleet_returnsZero() {
        assertEquals(0, airline.getTotalCargoCapacityKg());
    }

    @Test
    void getTotalCargoCapacityKg_mixedFleet_sumsOnlyCargoCarriers() {
        airline.addAircraft(a320);
        airline.addAircraft(boeing747f);
        airline.addAircraft(combi737);

        assertEquals(137700 + 19000, airline.getTotalCargoCapacityKg());
    }

    @Test
    void sortByFlightRange_ordersFleetAscendingByRange() {
        airline.addAircraft(boeing777);
        airline.addAircraft(a320);
        airline.addAircraft(combi737);

        airline.sortByFlightRange();

        List<Aircraft> sorted = airline.getFleet();
        assertEquals(combi737, sorted.get(0));
        assertEquals(a320, sorted.get(1));
        assertEquals(boeing777, sorted.get(2));
    }

    @Test
    void findByFuelConsumptionRange_returnsOnlyMatchingAircraft() {
        airline.addAircraft(a320);
        airline.addAircraft(combi737);
        airline.addAircraft(boeing747f);

        List<Aircraft> found = airline.findByFuelConsumptionRange(2000, 3000);

        assertEquals(2, found.size());
        assertTrue(found.contains(a320));
        assertTrue(found.contains(combi737));
    }

    @Test
    void findByFuelConsumptionRange_boundaryValues_areInclusive() {
        airline.addAircraft(a320);

        List<Aircraft> found = airline.findByFuelConsumptionRange(2400, 2400);

        assertEquals(1, found.size());
        assertTrue(found.contains(a320));
    }

    @Test
    void findByFuelConsumptionRange_noAircraftMatches_returnsEmptyList() {
        airline.addAircraft(a320);
        airline.addAircraft(boeing747f);

        List<Aircraft> found = airline.findByFuelConsumptionRange(5000, 6000);

        assertTrue(found.isEmpty());
    }

    @Test
    void findByFuelConsumptionRange_minGreaterThanMax_throwsException() {
        assertThrows(IllegalArgumentException.class,
                () -> airline.findByFuelConsumptionRange(5000, 1000));
    }

    @Test
    void getFleet_returnsUnmodifiableList() {
        airline.addAircraft(a320);

        List<Aircraft> fleet = airline.getFleet();

        assertThrows(UnsupportedOperationException.class, () -> fleet.add(boeing777));
    }
}

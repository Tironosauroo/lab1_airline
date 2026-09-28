package airline.company;

import airline.cargo.CargoAircraft;
import airline.passenger.PassengerAircraft;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AirlineMockitoTest {

    @Test
    void getTotalPassengerCapacity_usesStubbedValuesFromMocks() {
        Airline airline = new Airline("Mock Airways");

        PassengerAircraft mockAircraft1 = mock(PassengerAircraft.class);
        PassengerAircraft mockAircraft2 = mock(PassengerAircraft.class);
        when(mockAircraft1.getPassengerCapacity()).thenReturn(150);
        when(mockAircraft2.getPassengerCapacity()).thenReturn(250);

        airline.addAircraft(mockAircraft1);
        airline.addAircraft(mockAircraft2);

        int total = airline.getTotalPassengerCapacity();

        assertEquals(400, total);
    }

    @Test
    void getTotalPassengerCapacity_callsGetPassengerCapacityOnEachAircraft() {
        Airline airline = new Airline("Mock Airways");

        PassengerAircraft mockAircraft = mock(PassengerAircraft.class);
        when(mockAircraft.getPassengerCapacity()).thenReturn(180);
        airline.addAircraft(mockAircraft);

        airline.getTotalPassengerCapacity();

        verify(mockAircraft).getPassengerCapacity();
    }

    @Test
    void getTotalCargoCapacityKg_usesStubbedValuesFromMocks() {
        Airline airline = new Airline("Mock Airways");

        CargoAircraft mockCargo = mock(CargoAircraft.class);
        when(mockCargo.getCargoCapacityKg()).thenReturn(50000.0);
        airline.addAircraft(mockCargo);

        double total = airline.getTotalCargoCapacityKg();

        assertEquals(50000.0, total);
        verify(mockCargo).getCargoCapacityKg();
    }
}

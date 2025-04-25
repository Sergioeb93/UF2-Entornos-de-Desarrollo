import org.junit.jupiter.api.*;

class VehiculoTest {

    @Nested
    @DisplayName("Tests sobre la gestión de la velocidad")
    class TestVelocidad {

        @Test
        @DisplayName("Decremento normal de la velocidad")
        void reducirVelocidad() {
            vehiculo.setVelocidadActual(60);
            vehiculo.decelerar(20); // Se reduce la velocidad actual en 20
            assertEquals(40, vehiculo.getVelocidadActual());
        }

        @Test
        @DisplayName("Decremento de la velocidad por debajo de 0")
        void reducirVelocidadANegativo() {
            vehiculo.setVelocidadActual(20); 
            vehiculo.decelerar(vehiculo.getVelocidadActual() + 1); // Se reduce la velocidad por debajo del valor de velocidadActual
            assertEquals(0, vehiculo.getVelocidadActual()); // La velocidad mínima del vehículo ha de mantenerse en 0, nunca podrá ser negativa
        }
    }


    @Nested
    @DisplayName("Tests sobre vehículo de combustible")
    class TestVehiculoCombustible {

    }

    @Nested
    @DisplayName("Tests sobre vehículo eléctrico")
    class TestVehiculoElectrico {

    }

}


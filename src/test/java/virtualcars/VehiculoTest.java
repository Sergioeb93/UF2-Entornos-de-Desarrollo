import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;

import virtualcars.Vehiculo;

class VehiculoTest {

    Vehiculo vehiculo; 

    @BeforeEach
    void setUp() {
        vehiculo = new Vehiculo("Cupra", "Formentor", "Azul Oscuro", 300, 55, "diesel", 
                                1, 0, 2018, 5, 2020, 5);
        
        vehiculo.setEsActivo(true);
    }

    // ---------------------------------------------
    @Nested
    @DisplayName("Tests sobre la gestión de la velocidad")
    class TestVelocidad {

        @Test
        @DisplayName("Incremento normal de la velocidad")
        void aumentarVelocidad() {
            int velocidadInicial = vehiculo.getVelocidadActual(); 
            vehiculo.acelerar(50);  // Se incrementa la velocidad inicial en 50 km/h
            assertEquals(velocidadInicial + 50, vehiculo.getVelocidadActual());
        }

        @Test
        @DisplayName("Incremento superior al máximo de velocidad")
        void aumentarVelocidadSuperiorAlMax() {
            int velocidadInicial = vehiculo.getVelocidadMax();
            vehiculo.acelerar(velocidadInicial + 1); // Se incrementa la velocidad inicial en el máximo + 1
            assertEquals(vehiculo.getVelocidadMax(), vehiculo.getVelocidadActual()); // Se espera que NO supere el valor máximo
        }

        @Test
        @DisplayName("Incrementar velocidad con coche apagado")
        void aumentarVelocidadCocheApagado() {
            vehiculo.setEsActivo(false); // Se apaga el motor del coche
            assertThrows(IllegalStateException.class, () -> {
                vehiculo.acelerar(30); // Se intenta incrementar la velocida del coche en 30, habiendo de generar una excepción
            });     
        }
      
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

    // ---------------------------------------------
    @Nested
    @DisplayName("Tests específicos para vehículo de combustible")
    class TestVehiculoCombustible {
    }

    // ---------------------------------------------
    @Nested
    @DisplayName("Tests específicos para vehículo eléctrico")
    class TestVehiculoElectrico {

    }

}
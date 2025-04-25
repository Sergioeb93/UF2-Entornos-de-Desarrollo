package virtualcars;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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

    @Nested
    @DisplayName("Tests sobre el cambio de modo de conducción")
    class TestCambioModoConduccion {

        @Test
        @DisplayName("Cambiar modo de conducción a SPORT")
        void testCambiarModoConduccionSport() {
            vehiculo.cambiarModoConduccion("SPORT");
            assertEquals("SPORT", vehiculo.getModoConduccion(), "El modo de conducción debería ser SPORT.");
        }

        @Test
        @DisplayName("Cambiar modo de conducción a ECO")
        void testCambiarModoConduccionEco() {
            vehiculo.cambiarModoConduccion("ECO");
            assertEquals("ECO", vehiculo.getModoConduccion(), "El modo de conducción debería ser ECO.");
        }

        @Test
        @DisplayName("Cambiar modo de conducción a NORMAL")
        void testCambiarModoConduccionNormal() {
            vehiculo.cambiarModoConduccion("NORMAL");
            assertEquals("NORMAL", vehiculo.getModoConduccion(), "El modo de conducción debería ser NORMAL.");
        }

        @Test
        @DisplayName("Cambiar a un modo de conducción no válido")
        void testCambiarModoConduccionInvalido() {
            assertThrows(IllegalArgumentException.class, () -> {
                vehiculo.cambiarModoConduccion("INVALIDO");
            }, "Debería lanzar una excepción por un modo de conducción no válido.");
        }
    }

    // ---------------------------------------------
    @Nested
    @DisplayName("Tests sobre el modo ECO")
    class TestModoEco {

        @Test
        @DisplayName("Activar el modo ECO")
        void testActivarModoEco() {
            vehiculo.activarModoEco();
            assertEquals("ECO", vehiculo.getModoConduccion(), "El modo de conducción debería ser ECO.");
        }

        @Test
        @DisplayName("Activar el modo ECO con coche apagado")
        void testActivarModoEcoCocheApagado() {
            vehiculo.setEsActivo(false); // Desactivar el coche
            assertThrows(IllegalStateException.class, () -> {
                vehiculo.activarModoEco(); // Debería lanzar una excepción porque el coche está apagado
            });
        }
    }

    // ---------------------------------------------
    @Nested
    @DisplayName("Tests específicos para vehículo de combustible")
    class TestVehiculoCombustible {

        @Test
        @DisplayName("Frenado estándar de vehículo de combustible")
        void frenarCocheCombustible() {
            vehiculo.setVelocidadActual(100); 
            vehiculo.frenar(); 
            assertEquals(0, vehiculo.getVelocidadActual()); // La velocidad actual del vehículo se reduce a 0
        }

        @Test
        @DisplayName("Intentar cargar la batería de un vehículo de combustible")
        void cargarVehiculoCombustible() {
            assertThrows(UnsupportedOperationException.class, () -> {
                vehiculo.cargarBateria(20); // Se intenta cargar la batería de un coche de combustible, lo que debe lanzar una excepción.
            }); 
        } 
        
        @Test
        @DisplayName("Repostaje estándar del combustible del vehículo")
        void repostarVehiculo() {
            vehiculo.setCombustibleActual(10); 
            vehiculo.repostar(15, "diesel"); 
            assertEquals(25, vehiculo.getCombustibleActual()); 
        } 

        @Test
        @DisplayName("Repostaje superior al máximo de la capacidad del vehículo")
        void repostarVehiculoSuperiorAlMax() {
            vehiculo.setCombustibleActual(vehiculo.getCombustibleMax()); 
            vehiculo.repostar(30, "diesel"); 
            assertEquals(vehiculo.getCombustibleMax(), vehiculo.getCombustibleActual()); // El combustible actual del vehículo no podrá superar la capacidad máxima
        }  

        @Test
        @DisplayName("Repostaje del tipo de combustible incorrecto")
        void repostarCombustibleIncorrecto() {
            vehiculo.setCombustibleActual(15); 
            vehiculo.setTipoCombustible("diesel");
            vehiculo.repostar(30, "gasolina"); //Se reposta el vehículo con un tipo de combustible incorrecto
            assertTrue(vehiculo.isEsAveriado()); // El vehículo se avería por utilizar un combustible incorrecto
        }  
    }

    // ---------------------------------------------
    @Nested
    @DisplayName("Tests específicos para vehículo eléctrico")
    class TestVehiculoElectrico {

        Vehiculo vehiculoElectrico;

        @BeforeEach
        void setUp() {
            vehiculoElectrico = new Vehiculo("Tesla", "Model X", "Gris", 250,
                                            20, 0, 2023, 6, 2023, 4);
            vehiculoElectrico.setEsActivo(true);
        }

        @Test
        @DisplayName("Frenado de vehículo eléctrico con motor encendido:")
        void frenarCocheEléctricoEncendido() {
            vehiculoElectrico.setVelocidadActual(120); //velocidadPreFrenado será 120
            vehiculoElectrico.setBateriaActual(80); // El nivel de bateriaActual pre frenado será 80
            vehiculoElectrico.frenar(); // El motor está encendido, se debe ejecutar el freno regenerativo
            assertAll("Verificando el estado del vehículo eléctrico tras el freno:",
                () -> assertEquals(0, vehiculoElectrico.getVelocidadActual(), "Velocidad del vehículo reducida a 0 tras frenado."),
                () -> assertEquals(82, vehiculoElectrico.getBateriaActual(), "La cantidad de batería actual deberá ser 82, tras la activación del freno regenerativo.") // (80 + (int)(0.02 * 120) = 82
            );      
        }

        @Test
        @DisplayName("Frenado de vehículo eléctrico con motor apagado:")
        void frenarCocheEléctricoApagado() {
            vehiculoElectrico.setVelocidadActual(120); //velocidadPreFrenado será 120
            vehiculoElectrico.setBateriaActual(80); // El nivel de bateriaActual pre frenado será 80
            vehiculoElectrico.apagar(); // Se apaga el motor del coche en marcha, a partir de este momento sólo funcionarán los frenos tradicionales de disco/mano
            vehiculoElectrico.frenar(); // El motor está apagado, no se debe ejecutar el freno regenerativo
            assertAll("Verificando el estado del vehículo eléctrico tras el freno:",
                () -> assertEquals(0, vehiculoElectrico.getVelocidadActual(), "Velocidad del vehículo reducida a 0 tras frenado."),
                () -> assertEquals(80, vehiculoElectrico.getBateriaActual(), "La cantidad de batería actual deberá ser igual al nivel de batería prefrenado, sin activación del freno regenerativo.")
            );                                              
        }

        @Test
        @DisplayName("Carga estándar de la batería del vehículo")
        void cargarVehiculo() {
            vehiculoElectrico.setBateriaActual(80); 
            vehiculoElectrico.cargarBateria(15); // Se carga la batería
            assertEquals(95, vehiculoElectrico.getBateriaActual()); 
        } 

        @Test
        @DisplayName("Carga superior al máximo de la batería del vehículo")
        void cargarVehiculoSuperiorAlMax() {
            vehiculoElectrico.setBateriaActual(100);
            vehiculoElectrico.cargarBateria(vehiculoElectrico.getBateriaMax() + 15); // Se intenta cargar la batería por encima del valor máximo de la misma
            assertEquals(vehiculoElectrico.getBateriaMax(), vehiculoElectrico.getBateriaActual()); // La batería actual del vehículo no podrá superar la batería máxima
        }  

        @Test
        @DisplayName("Intentar repostar un vehículo eléctrico")
        void repostarVehiculoElectrico() {
            assertThrows(UnsupportedOperationException.class, () -> {
                vehiculoElectrico.repostar(15, "diesel"); // Se intenta repostar el combustible de un vehículo eléctrico, lo que debe lanzar una excepción.
            }); 
        } 
    }

    // ---------------------------------------------
    @Nested
    @DisplayName("Tests sobre la matrícula del vehículo")
    class TestMatricula {

        @Test
        @DisplayName("Generar una matrícula durante la construcción del objeto")
        void generarMatricula() {
            assertNotNull(vehiculo.getMatricula()); // El constructor del vehículo debe haber generado una matrícula automáticamente.
        }

        @Test
        @DisplayName("Verificar la longitud y el formato de la matrícula generada")
        void verificarFormatoMatricula() {
            assertAll("Verificando el formato de la matrícula generada:",
                () -> assertEquals(6, vehiculo.getMatricula().length(), "La longitud de la matrícula generada debe ser de 6 caracteres."),
                () -> assertTrue(vehiculo.getMatricula().matches("([A-Z][0-9]){3}"), "La matrícula debe estar conformada por 3 letras y 3 dígitos intercalados.")
            );   
        }

    }

    // ---------------------------------------------
    @Nested
    @DisplayName("Tests sobre la gestión de la ITV del vehículo")
    class TestITV {

        @Test
        @DisplayName("Actualizar la ITV del vehículo")
        void actualizarITV() {
            vehiculo.setUltimaRevisionITV(2018);
            vehiculo.pasarITV();
            assertEquals(2025, vehiculo.getUltimaRevisionITV());
        }

        @DisplayName("Verificar un vehículo con la ITV en rigor")
        void verificarITVActualizada() {
            vehiculo.setUltimaRevisionITV(2023);
            vehiculo.setPeriodoRevisionITV(5);
            assertTrue(vehiculo.verificarITV());
        }

        @Test
        @DisplayName("Verificar un vehículo con la ITV caducada")
        void verificarTIVCaducada() {
            vehiculo.setUltimaRevisionITV(2015);
            vehiculo.setPeriodoRevisionITV(3);
            assertFalse(vehiculo.verificarITV());
        }

    }


    // ---------------------------------------------
    @Nested
    @DisplayName("Test sobre el arranque y el apagado del motor")
    class TestArranqueYApagadoMotor {

        @DisplayName("Arrancar un vehículo en condiciones normales")
        void arrancarVehiculo() {
            vehiculo.setEsActivo(false);
            vehiculo.arrancar();
            assertTrue(vehiculo.isEsActivo());
        }

        @DisplayName("Arrancar un vehículo averiado")
        void arrancarVehiculoAveriado() {
            vehiculo.setEsAveriado(true);
            vehiculo.arrancar();
            assertThrows(IllegalStateException.class, () -> {
                vehiculo.arrancar(); // Se intenta arrancar un vehículo averiado, habiendo de generar una excepción
            });     
        }

        @DisplayName("Apagar el motor en condiciones normales")
        void apagarMotorEncendido() {
            vehiculo.setEsActivo(true);
            vehiculo.apagar();
            assertFalse(vehiculo.isEsActivo());
            assertAll("Verificando el apagado del motor:",
                () -> assertFalse(vehiculo.isEsActivo(), "El estado del vehículo debe pasar a inactivo."),
                () -> assertEquals(0, vehiculo.getVelocidadActual(), "La velocidad actual del vehículo debe reducirse a 0.")
            );   
        }

        @DisplayName("Apagar el motor de un coche que no estaba arrancado")
        void apagarMotorNoArrancado() {
            vehiculo.setEsActivo(false);
            assertThrows(IllegalStateException.class, () -> {
                vehiculo.arrancar(); // Se intenta apagar un vehículo que no había sido arrancado, generando una excepción
            });    
        }

    }
}
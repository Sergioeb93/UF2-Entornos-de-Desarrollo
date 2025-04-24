# Vehículo Eléctrico Urbano - Especificaciones

## Descripción
Este proyecto implementa un sistema de gestión para un vehículo eléctrico urbano, incluyendo funcionalidades de control de velocidad, gestión de batería y modos de conducción.

## Requisitos Funcionales

### Atributos del Vehículo
| Atributo           | Tipo   | Descripción                                      |
|--------------------|--------|--------------------------------------------------|
| **marca**          | String | Marca del vehículo                               |
| **modelo**         | String | Modelo del vehículo                              |
| **nivelBateria**   | int    | Porcentaje de carga (0-100%)                     |
| **velocidadActual**| int    | Velocidad en km/h                                |
| **velocidadMaxima**| int    | Límite de 120 km/h                               |
| **modoConduccion** | String | ECO/NORMAL/SPORT                                |
| **autonomiaRestante** | int  | Kilómetros restantes                            |

### Métodos Principales

| Método                        | Descripción                                                             |
|-------------------------------|-------------------------------------------------------------------------|
| **acelerar(int incremento)**   | Aumenta velocidad según modo de conducción.                             |
| **frenar(int decremento)**     | Reduce velocidad y activa freno regenerativo.                           |
| **cargarBateria(int tiempo)**  | Gestiona la carga de la batería.                                        |
| **cambiarModoConduccion(String modo)** | Cambia entre modos de conducción.                                 |
| **activarModoEco()**           | Activa modo de eficiencia energética.                                   |
| **getEstadoVehiculo()**        | Obtiene estado actual del vehículo.                                     |
| **calcularAutonomia()**        | Calcula autonomía restante.                                             |
| **activarFrenoRegenerativo()** | Gestiona recuperación de energía.                                       |

## Notas de Implementación
- Todos los atributos tendrán sus respectivos getters y setters.
- La velocidad máxima está limitada por software a 120 km/h.
- El modo ECO prioriza la eficiencia sobre el rendimiento.
- El freno regenerativo se activa automáticamente en frenadas.

# Vehículo - Especificaciones

## Descripción
Este proyecto implementa un sistema de gestión para el registro de un vehículo, incorporando información básica del mismo así como funcionalidades de control de velocidad, gestión de batería/combustible, y modos de conducción.

## Requisitos Funcionales

### Atributos del Vehículo
| Atributo              | Tipo   | Descripción                                                       |
|-----------------------|--------|-------------------------------------------------------------------|
| **marca**             | String | Marca del vehículo                                                |
| **modelo**            | String | Modelo del vehículo                                               |
| **color**             | String | Color del vehículo                                                |
| **esActivo**          | bool   | Estado actual _(true = encendido, false = apagado)_               |
| **esAveriado**        | bool   | Condición del vehículo _(true = averiado, false = no averiado)_   |
| **velocidadMax**      | int    | Velocidad máxima del vehículo en km/h                             |
| **velocidadActual**   | int    | Velocidad actual del vehículo en km/h                             |
| **esElectrico**       | bool   | Tipo de vehículo _(true = eléctrico, false = combustible)_        |
| **combustibleMax**    | int    | Capacidad máxima del depósito en litros                           |
| **combustibleActual** | int    | Combustible actual del depósito en litros                         |
| **tipoCombustible**   | String | Tipo de combustible del depósito _(diésel, gasolina)_             |
| **bateriaMax**        | int    | Capacidad máxima de la batería. Salvo avería, por defecto es 100% |
| **bateriaActual**     | int    | Porcentaje actual de carga de la batería (0-100%)                 |
| **modoConduccion**    | String | Modalidad de conducción _(`ECO`/`NORMAL`/`SPORT`)_                |
| **consumoPorKm**      | int    | Consumo de combustible _(litros)_ o batería _(%)_ por kilómetro   |
| **añoFabricacion**    | int    | Año de fabricación del vehículo                                   |
| **numPlazas**         | int    | Número de plazas del vehículo                                     |
| **numPasajerosActual**| int    | Número actual de pasajeros montados en el vehículo                |
| **kmRecorridos**      | int    | Kilometraje del vehículo                                          |
| **ultimaRevisionITV** | int    | Año de la última revisión de la ITV                               |
| **periodoRevisionITV**| int    | Período entre revisiones de la ITV para el vehículo               |
| **matricula**         | String | Matrícula del vehículo                                            |
  

### Métodos Principales

| Método                                 | Descripción                                                                     |
|----------------------------------------|---------------------------------------------------------------------------------|
| **arrancar()**                         | Enciende el motor del vehículo.                                                 |
| **acelerar(int velocidad)**            | Aumenta la velocidad del vehículo en el valor, en kilómetros, indicado.         |
| **decelerar (int velocidad)**          | Reduce la velocidad del vehículo en el valor, en kilómetros, indicado.          |
| **frenar()**                           | Reduce la velocidad a 0. En vehículos eléctricos activa el freno regenerativo.  |
| **activarFrenoRegenerativo()**         | Gestiona la recuperación de energía al frenar.                                  |
| **apagar()**                           | Apaga el motor del vehículo.                                                    |
| **cargarBateria(int carga)**           | Gestiona la carga de la batería, en vehículos eléctricos.                       |
| **repostar(int litros)**               | Repostaje del vehículo, en vehículos de combustible.                            |
| **cambiarModoConduccion(String modo)** | Alterna entre los diferentes modos de conducción.                               |
| **calcularAutonomia()**                | Calcula la autonomía restante en base al combustible/batería disponible.        |
| **incorporarPasajeros(int pasajeros)** | Incorpora nuevos pasajeros al vehículo.                                         |
| **pasarITV()**                         | Actualiza el año de la última revisión de la ITV al actual.                     |
| **verificarITV()**                     | Verifica si la ITV se encuentra actualmente caducada.                           |
| **generarMatricula()**                 | Genera de manera aleatoria una matrícula durante la creación del objeto.        | 

## Notas de Implementación
- Todos los atributos tendrán sus respectivos getters y setters.
- El modo ECO prioriza la eficiencia sobre el rendimiento.
- El freno regenerativo se activa automáticamente en frenadas para los coches eléctricos.
- La matrícula deberá generarse de manera aleatoria con una extensión de 6 caracteres alfanuméricos.
- El número de pasajeros del vehículo no podrá, en ningún caso, superar el número máximo de plazas del mismo.
- Un coche averiado NO podrá circular bajo ningún pretexto.
package virtualcars;

import java.time.LocalDate;
import java.util.Random;

public class Vehiculo {
    private String marca; 
    private String modelo; 
    private String color; 
    private boolean esActivo = false;
    private boolean esAveriado = false;
    private int velocidadMax; 
    private int velocidadActual = 0;
    private boolean esElectrico;
    private int combustibleMax; //Se inicializa con el valor proporcionado en caso de que esElectrico sea false
    private int combustibleActual = 0; 
    private String tipoCombustible; 
    private int bateriaMax; //Se inicializa en 100 en caso de que esElectrico sea true
    private int bateriaActual = 0; 
    private String modoConduccion;
    private int consumoPorKm;
    private int kmRecorridos;
    private int añoFabricacion; 
    private int numPlazas;
    private int numPasajerosActual;
    private int ultimaRevisionITV;  //Se registra únicamente el año de la última revisión
    private int periodoRevisionITV; //En número de años de vigencia desde la última revisión
    final private String matricula;

    // ----- | --------------- Constructores ----------------- | -----

    // ----- | ----- Constructor vehículo de combustible ----- | -----

    public Vehiculo(String marca, String modelo, String color, int velocidadMax, int combustibleMax, String tipoCombustible, 
                    int consumoPorKm, int kmRecorridos, int añoFabricacion, int numPlazas, int ultimaRevisionITV, 
                    int periodoRevisionITV) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.velocidadMax = velocidadMax;
        this.esElectrico = false;
        this.combustibleMax = combustibleMax;
        this.tipoCombustible = tipoCombustible.toLowerCase();
        this.consumoPorKm = consumoPorKm;
        this.kmRecorridos = kmRecorridos;
        this.añoFabricacion = añoFabricacion;
        this.numPlazas = numPlazas;
        this.ultimaRevisionITV = ultimaRevisionITV;
        this.periodoRevisionITV = periodoRevisionITV;
        this.matricula = generarMatricula();
    }

    // ----- | ------- Constructor vehículo eléctrico ------- | -----

    public Vehiculo(String marca, String modelo, String color, int velocidadMax, int consumoPorKm, int kmRecorridos, 
                    int añoFabricacion, int numPlazas, int ultimaRevisionITV, int periodoRevisionITV) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.velocidadMax = velocidadMax;
        this.esElectrico = true;
        this.bateriaMax = 100;
        this.consumoPorKm = consumoPorKm;
        this.kmRecorridos = kmRecorridos;
        this.añoFabricacion = añoFabricacion;
        this.numPlazas = numPlazas;
        this.ultimaRevisionITV = ultimaRevisionITV;
        this.periodoRevisionITV = periodoRevisionITV;
        this.matricula = generarMatricula();
    }

    // ----- | -------------- Getters y Setters -------------- | -----

    // ----- | -------------------- Getters ------------------ | -----

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public boolean isEsActivo() {
        return esActivo;
    }

    public boolean isEsAveriado() {
        return esAveriado;
    }

    public int getVelocidadMax() {
        return velocidadMax;
    }

    public int getVelocidadActual() {
        return velocidadActual;
    }

    public boolean isEsElectrico() {
        return esElectrico;
    }

    public int getCombustibleMax() {
        return combustibleMax;
    }

    public int getCombustibleActual() {
        return combustibleActual;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public int getBateriaMax() {
        return bateriaMax;
    }

    public int getBateriaActual() {
        return bateriaActual;
    }

    public String getModoConduccion() {
        return modoConduccion;
    }

    public int getConsumoPorKm() {
        return consumoPorKm;
    }

    public int getKmRecorridos() {
        return kmRecorridos;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public int getNumPasajerosActual() {
        return numPasajerosActual;
    }

    public int getUltimaRevisionITV() {
        return ultimaRevisionITV;
    }

    public int getPeriodoRevisionITV() {
        return periodoRevisionITV;
    }

    public String getMatricula() {
        return matricula;
    }

    // ----- | -------------------- Setters ------------------ | -----
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEsActivo(boolean esActivo) {
        this.esActivo = esActivo;
    }

    public void setEsAveriado(boolean esAveriado) {
        this.esAveriado = esAveriado;
    }

    public void setVelocidadMax(int velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    public void setCombustibleMax(int combustibleMax) {
        this.combustibleMax = combustibleMax;
    }

    public void setCombustibleActual(int combustibleActual) {
        this.combustibleActual = combustibleActual;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public void setBateriaMax(int bateriaMax) {
        this.bateriaMax = bateriaMax;
    }

    public void setBateriaActual(int bateriaActual) {
        this.bateriaActual = bateriaActual;
    }

    public void setModoConduccion(String modoConduccion) {
        this.modoConduccion = modoConduccion;
    }

    public void setConsumoPorKm(int consumoPorKm) {
        this.consumoPorKm = consumoPorKm;
    }

    public void setKmRecorridos(int kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    public void setNumPasajerosActual(int numPasajerosActual) {
        this.numPasajerosActual = numPasajerosActual;
    }

    public void setUltimaRevisionITV(int ultimaRevisionITV) {
        this.ultimaRevisionITV = ultimaRevisionITV;
    }

    public void setPeriodoRevisionITV(int periodoRevisionITV) {
        this.periodoRevisionITV = periodoRevisionITV;
    }


    // ----- | --------------- Métodos de la clase ---------------- | -----

    public void arrancar() {
        if (this.esAveriado) throw new IllegalStateException("El vehículo se ha averiado, no puede arrancar.");
        this.esActivo = true;
    }

    public void acelerar(int velocidad) {
        if (!esActivo) throw new IllegalStateException("El vehículo está apagado, no puede acelerar.");
        
        this.velocidadActual += velocidad;

        if (this.velocidadActual > velocidadMax) this.velocidadActual = velocidadMax; // En caso de superar el máximo, velocidadActual = velocidadMax
    } 


    public void decelerar(int velocidad) {
        if (!esActivo) throw new IllegalStateException("El vehículo está apagado, no puede decelerar.");

        this.velocidadActual = Math.max(0, this.velocidadActual - velocidad); // En caso de ser inferior a 0, se establece en 0.
    }

    public void apagar() {
        if (!this.esActivo) {
            throw new IllegalStateException("El vehículo ya está apagado.");
        }
        else
        {
            this.esActivo = false;
            frenar();
        }
    }

    public void frenar() {
        int velocidadPreFrenado = this.velocidadActual;
        this.velocidadActual = 0;
        if (this.esElectrico && isEsActivo()) activarFrenoRegenerativo(velocidadPreFrenado); // Se ejecuta el freno regenerativo en caso de que el coche sea eléctrico y el motor esté encendido
    }

    public void activarFrenoRegenerativo(int velocidadReducida) { 
        int cargaRecuperada = (int)(0.02 * velocidadReducida);
        cargarBateria(cargaRecuperada); // Se regenera un porcentaje de la energía cinética del coche en el momento de ejecutar el frenado
    }

    public void repostar(int litros, String tipoCombustible) {
        if (this.esElectrico) throw new UnsupportedOperationException("Se trata de un vehículo  eléctrico, no se puede repostar combustible.");
        this.combustibleActual += litros;

        if (this.combustibleActual > combustibleMax) this.combustibleActual = combustibleMax; // En caso de superar el máximo, combustibleActual = combustibleMax

        if (tipoCombustible.toLowerCase() != this.tipoCombustible.toLowerCase()) this.esAveriado = true;
    } 

    public void cargarBateria(int carga) {
        if (!this.esElectrico) throw new UnsupportedOperationException("Se trata de un vehículo de combustible, no se puede cargar.");

        this.bateriaActual += carga;

        if (this.bateriaActual > this.bateriaMax) this.bateriaActual = this.bateriaMax; // En caso de superar el máximo, bateriaActual = bateriaMax
    } 

    public void cambiarModoConduccion(String modo) {
        if (modo.equals("ECO") || modo.equals("NORMAL") || modo.equals("SPORT")) {
            this.modoConduccion = modo;
        } else {
            throw new IllegalArgumentException("Modo de conducción no válido.");
        }
    }
    
    public void activarModoEco() {
        if (!esActivo) {
            throw new IllegalStateException("El vehículo está apagado, no se puede activar el modo ECO.");
        }
        this.modoConduccion = "ECO";
    }


    public void calcularAutonomia() {
        // TODO: Implementar método calcularAutonomia
    } 

    public void incorporarPasajeros(int pasajeros ) {
        this.numPasajerosActual += pasajeros;
        // TODO: Implementar método incorporarPasajeros
    } 

    public void pasarITV() {
        this.ultimaRevisionITV = LocalDate.now().getYear();
    } 

    public boolean verificarITV() {
        int añoActual = LocalDate.now().getYear();
        if ((añoActual - this.ultimaRevisionITV ) > this.periodoRevisionITV) {
            System.out.println("La ITV del vehículo se encuentra caducada. Es necesario realizar pasar la ITV lo antes posible.");
            return false;
        } 
        else
        {
            System.out.println("La ITV del vehículo se encuentra en regla.");
            return true;
        }
    }

    private String generarMatricula() {
        Random rand = new Random();
        String matriculaAleatoria = "";
        
        for (int i = 0; i < 6; i++) { 
            if (i % 2 == 0) {
                matriculaAleatoria += (char)(rand.nextInt(26) + 'A');
                matriculaAleatoria += rand.nextInt(10);
            }
        }

        return matriculaAleatoria;
    }

    public String generarFichaTecnica() {
        String info = "";

        info += "Marca: " + marca + "\n";
        info += "Modelo: " + modelo + "\n";
        info += "Color: " + color + "\n";
        info += "Velocidad máxima: " + velocidadMax + " km/h\n";
        info += "Consumo por Km: " + consumoPorKm + " L/km\n";
        info += "Kilómetros recorridos: " + kmRecorridos + "\n";
        info += "Año de fabricación: " + añoFabricacion + "\n";
        info += "Número de plazas: " + numPlazas + "\n";
        info += "Última revisión ITV: " + ultimaRevisionITV + "\n";
        info += "Periodo de revisión ITV: " + periodoRevisionITV + " años\n";

        if (esElectrico == false) {
            info += "Tipo: Combustible\n";
            info += "Capacidad del depósito: " + combustibleMax + " litros\n";
            info += "Tipo de combustible: " + tipoCombustible + " \n";
        } else {
            info += "BateriaMax: " + bateriaMax + " \n";
            info += "Tipo: Eléctrico\n";
        
        }
        return info;
    }
}


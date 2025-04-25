package virtualcars;

public class Vehiculo {
    private String marca; 
    private String modelo; 
    private String color; 
    private boolean esActivo = false;
    private boolean esAveriado = false;
    private int velocidadMax; 
    private int velocidadActual = 0;
    private boolean esElectrico;
    private int combustibleMax; 
    private int combustibleActual = 0; 
    private int tipoCombustible; 
    private int bateriaMax; 
    private int bateriaActual = 0; 
    private int añoFabricacion; 

    //TODO: Finalizar el diseño de la clase vehículo


    // Métodos de la clase
    public void arrancar() {
        this.esActivo = true;
    }

    public void acelerar(int velocidad) {
        this.velocidadActual += velocidad;
    } 

    public void decelerar(int velocidad) {
        if (!esActivo) throw new IllegalStateException("El vehículo está apagado, no puede decelerar.");

        this.velocidadActual = Math.max(0, this.velocidadActual - velocidad); // En caso de ser inferior a 0, se establece en 0.
    }

    public void apagar() {
        this.esActivo = false;
    }

    public void frenar() {
        this.velocidadActual = 0;
    }

    public void repostar(int litros) {
        this.combustibleActual += litros;
    } 

    public void cargarBateria(int carga) {
        this.bateriaActual += carga;
    } 

}
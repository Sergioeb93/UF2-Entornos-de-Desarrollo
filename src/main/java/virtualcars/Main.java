package virtualcars;

import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {

        System.out.println("Virtual Cars: Gestión de coches virtuales");
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Registro de Nuevo Vehículo ===");

        System.out.print("Marca: ");
        String marca = scanner.nextLine();

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Color: ");
        String color = scanner.nextLine();

        System.out.println("Año de fabricación: ");
        int añoFabricacion = Integer.parseInt(scanner.nextLine());

        System.out.println("Número de plazas: ");
        int numPlazas = Integer.parseInt(scanner.nextLine());

        System.out.println("Velocidad máxima del vehículo: ");
        int velocidadMax = Integer.parseInt(scanner.nextLine());

        System.out.println("Consumo por kilómetro (en litros o porcentaje de bateria): ");
        int consumoPorKm = Integer.parseInt(scanner.nextLine());

        System.out.println("Kilometraje actual: ");
        int kmRecorridos = Integer.parseInt(scanner.nextLine());

        System.out.println("Año de la última revisión de la ITV: ");
        int ultimaRevisionITV = Integer.parseInt(scanner.nextLine());

        System.out.println("Años para renovación de la ITV: ");
        int periodoRevisionITV = Integer.parseInt(scanner.nextLine());

        System.out.print("¿Es eléctrico? (si/no): ");
        String esElectrico = scanner.nextLine().trim().toLowerCase();;

        Vehiculo vehiculo;

        if (esElectrico.equals("no")) {
            System.out.println("Capacidad máxima del depósito: ");
            int combustibleMax = Integer.parseInt(scanner.nextLine());


            System.out.println("Tipo de combustible(diesel/gasolina): ");
            String tipoCombustible = scanner.nextLine().toLowerCase();

            vehiculo = new Vehiculo(marca, modelo, color, velocidadMax, combustibleMax, tipoCombustible, 
                                    consumoPorKm, kmRecorridos, añoFabricacion, numPlazas, ultimaRevisionITV, periodoRevisionITV);
        }

        else {
            vehiculo = new Vehiculo(marca, modelo, color, velocidadMax,consumoPorKm, kmRecorridos, 
                                    añoFabricacion, numPlazas, ultimaRevisionITV, periodoRevisionITV);
        }

        scanner.close(); 

        System.out.println("\n=== Información del vehículo registrado ===");
        System.out.println(vehiculo.generarFichaTecnica());

    }
}
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

        System.out.print("¿Es eléctrico? (true/false): ");
        boolean esElectrico = Boolean.parseBoolean(scanner.nextLine());

        System.out.println("Año de fabricación: ");
        int añoFabricacion = Integer.parseInt(scanner.nextLine());

        //TODO: Finalizar la incorporación de sentencias con los parámetros que se añadan a la clase vehículo
        
        scanner.close(); 

        //TODO: Implementar cuando se termine de definir la clase vehículo
        //Vehiculo vehiculo = new Vehiculo(marca, modelo, color, esElectrico, añoFabricacion, tipoCombustible,[...]);

        System.out.println("\n=== Información del vehículo registrado ===");
        //vehiculo.fichaTecnica();

    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Tiendaexpress {

    private static final double IVA = 0.12; // 12%

    // --------- MAIN (orquestador) ---------
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        try (Scanner sc = new Scanner(System.in)) {
            List<Double> carrito = new ArrayList<>();
            
            int opcion;
            do {
                mostrarMenu();
                opcion = leerOpcion(sc);
                
                switch (opcion) {
                    case 1 -> {
                        double precio = leerPrecio(sc);
                        agregarProducto(carrito, precio);
                    }
                    case 3 -> pagar(carrito, sc);
                    case 4 -> System.out.println("Saliendo de la Tienda Express...");
                    default -> System.out.println("Opcion inválida, intente nuevamente.");
                }
            } while (opcion != 4);
        }
    }

    // --------- Métodos del flujo ---------
    static void mostrarMenu() {
        System.out.println("\n===== TIENDA EXPRESS =====");
        System.out.println("1. Agregar producto");
        System.out.println("3. Pagar");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    static int leerOpcion(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Ingrese un número (1, 3, 4): ");
            sc.next();
        }
        return sc.nextInt();
    }

    static void agregarProducto(List<Double> carrito, double precio) {
        if (precio <= 0) {
            System.out.println("El precio debe ser mayor que 0.");
            return;
        }
        carrito.add(precio);
        System.out.printf("Producto agregado: $%.2f%n", precio);
    }

    static double total(double subtotal, double impuesto) {
        return subtotal + impuesto;
    }

    static void confirmarCompra(String correo, double total) {
        System.out.printf("%nCompra confirmada para %s%n", correo);
        System.out.printf("TOTAL A PAGAR: $%.2f%n", total);
        System.out.println("¡Gracias por su compra!");
    }

    static void pagar(List<Double> carrito, Scanner sc) {
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío. Agregue productos primero.");
            return;
        }

        double subtotal = 0.0;
        for (double p : carrito) subtotal += p;
        double impuesto = subtotal * IVA;
        double total = total(subtotal, impuesto);

        // Reporte
        System.out.println("\n----- REPORTE DE COMPRA -----");
        for (int i = 0; i < carrito.size(); i++) {
            System.out.printf("Producto %d: $%.2f%n", i + 1, carrito.get(i));
        }
        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("IVA (%.0f%%): $%.2f%n", IVA * 100, impuesto);
        System.out.printf("TOTAL: $%.2f%n", total);

        // Limpiar buffer y pedir correo
        sc.nextLine();
        String correo;
        do {
            System.out.print("Ingrese su correo para confirmar la compra: ");
            correo = sc.nextLine().trim();
            if (!validarCorreo(correo)) {
                System.out.println("Correo inválido. Intente de nuevo.");
            }
        } while (!validarCorreo(correo));

        confirmarCompra(correo, total);
        carrito.clear();
        System.out.println("-----------------------------\n");
    }

    // --------- Helpers ---------
    static boolean validarCorreo(String correo) {
        return correo.matches("^[\\w.+-]+@[\\w.-]+\\.[A-Za-z]{2,}$");
    }

    static double leerPrecio(Scanner sc) {
        System.out.print("Ingrese el precio del producto: ");
        while (!sc.hasNextDouble()) {
            System.out.print("Precio inválido. Ingrese un número: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}
/*
}*/

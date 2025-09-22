public class CalculoDescuento {

    // Método que recibe el monto total y el porcentaje de descuento.
    public static double calcularDescuento(double montoTotal, double porcentajeDescuento) {
        double descuento = montoTotal * (porcentajeDescuento / 100);
        double montoFinal = montoTotal - descuento;

        System.out.println("Monto total: $" + montoTotal);
        System.out.println("Descuento aplicado (" + porcentajeDescuento + "%): $" + descuento);
        System.out.println("Monto final a pagar: $" + montoFinal);
        System.out.println("");

        return montoFinal;
    }

    // Sobrecarga: si no se pasa el porcentaje, aplica 10% por defecto.
    public static double calcularDescuento(double montoTotal) {
        return calcularDescuento(montoTotal, 12);
    }

    // Método principal.
    public static void main(String[] args) {
       
        calcularDescuento(185.86);

        calcularDescuento(536.22, 14);
    }
}


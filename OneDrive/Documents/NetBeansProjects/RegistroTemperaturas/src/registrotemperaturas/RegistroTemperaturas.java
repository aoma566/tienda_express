/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package registrotemperaturas;

/**
 *
 * @author Anderson M
 */

public class RegistroTemperaturas {

    public static void main(String[] args) {

        
        String[] ciudades = { "Junin", "Rocafuerte" };       // CIUDADES  
        String[] dias = {                                      
                "Lunes", "Martes", "Miércoles", "Jueves",   // SEMANAS = 7 DIAS
                "Viernes", "Sábado", "Domingo"
        };
        String[] semanas = { "Semana 1", "Semana 2" };        


        double[][][] temperaturas = {
                {  // JUNIN
                        {22, 23}, // LUNES
                        {25, 26}, // MARTES
                        {22, 23}, // MIERCOLES
                        {23, 24}, // JUEVES
                        {26, 27}, // VIERNES
                        {27, 28}, // SABADO
                        {28, 29}  // DOMINGO
                },
                {    // ROCAFUERTE
                        {28, 29}, // LUNES
                        {29, 30}, // MARTES
                        {30, 31}, // MIERCOLES
                        {29, 30}, // JUEVES
                        {30, 31}, // VIERNES
                        {31, 32}, // SABADO
                        {30, 31}  // DOMINGO
                }
        };


        for (int c = 0; c < ciudades.length; c++) {
            System.out.println("\nCiudad: " + ciudades[c]);

            for (int s = 0; s < semanas.length; s++) {
                double suma = 0.0;

                for (int d = 0; d < dias.length; d++) {
                    suma += temperaturas[c][d][s];
                }

                double promedio = suma / dias.length;
                System.out.printf("  %s -> Promedio: %.2f °C%n", semanas[s], promedio);
            }
        }
    }
}

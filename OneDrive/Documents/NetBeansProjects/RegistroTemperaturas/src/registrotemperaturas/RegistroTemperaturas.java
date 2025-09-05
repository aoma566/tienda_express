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

        
        String[] ciudades = { "Junin", "Rocafuerte" };         
        String[] dias = {                                      
                "Lunes", "Martes", "Miércoles", "Jueves",
                "Viernes", "Sábado", "Domingo"
        };
        String[] semanas = { "Semana 1", "Semana 2" };        


        double[][][] temperaturas = {
                {  
                        {22, 23}, 
                        {25, 26}, 
                        {22, 23},
                        {23, 24}, 
                        {26, 27}, 
                        {27, 28}, 
                        {28, 29} 
                },
                {   
                        {28, 29},
                        {29, 30}, 
                        {30, 31}, 
                        {29, 30},
                        {30, 31},
                        {31, 32}, 
                        {30, 31} 
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

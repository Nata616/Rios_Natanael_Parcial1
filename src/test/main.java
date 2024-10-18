/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import java.time.LocalDate;
import model.Servicio;
import model.Sistema;

/**
 *
 * @author Nata
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        
        
        // Prueba 1-1: Intentar crear Gastronomia con codigo incorrecto
        try{
            sistema.agregarGastronomia("1234", 15.0, true, "provoleta", 180.0, 4);
        }catch (IllegalArgumentException e){
            System.out.println("1-3: " + e.getMessage());
        }
        
        // Prueba 1-2: Crear Gastronomia con codigo correcto
        sistema.agregarGastronomia("123456", 15.0, true, "provoleta", 180, 4);
        System.out.println("1-2: Gastronomia creada correctamente");
        
        // Prueba 1-3: Intentar crear Hospedaje con codigo incorrecto
        try{
            sistema.agregarHospedaje("4567", 10.0, true, "bongalo para 1 persona", 1500.0);
        }catch (IllegalArgumentException e){
            System.out.println("1-3: " + e.getMessage());
        }
        
        // Prueba 1-4: Crear Hospedaje con codigo correcto
        sistema.agregarHospedaje("456789", 10.0, true, "bongalo para 1 persona", 1500.0);
        System.out.println("1-4 Hospedaje creado correctamente. ");
        
        // Prueba 2-1: Calcular precio final de Gastronomia
        LocalDate dia1 = LocalDate.of(2020, 10, 28);
        double precioFinalGastronomia = sistema.traerServicio("123456").calcularPrecioFinal(dia1);
        System.out.println("2-1: Precio final Gastronomia: " + precioFinalGastronomia);
        
        // Prueba 2-2: Calcular precio final de Hospedaje
        LocalDate dia2 = LocalDate.of(2020, 10, 27);
        double precioFinalHospedaje = sistema.traerServicio("456789").calcularPrecioFinal(dia2);
        System.out.println("2-2: Precio final Hospedaje: " + precioFinalHospedaje);
        
        // Agregar los servicios Solicitados
        sistema.agregarGastronomia("987789", 15.0, true, "Chorizo a la pomarola", 180, 4);
        sistema.agregarHospedaje("456654", 10.0, true, "Triple ambiente", 2500);
        sistema.agregarGastronomia("123321", 15.0, false, "Pepsi", 180, 4);
        sistema.agregarHospedaje("789987", 10.0, false, "Mono ambiente", 1000);
        
        // 3: imprimir lista de servicios
        System.out.println("Lista de servicios");
        sistema.imprimirServicios();
        
        // 4-1: Traer todos los servicios en promocion
        System.out.println("\nServicios en promocion:");
        for (Servicio s : sistema.traerServicio(true)){
            System.out.println(s);
        }
        
        // 4-2: Traer servicios del dia 2020-10-28 y en promocion
        LocalDate diaConsulta = LocalDate.of(20, 10, 28);
        System.out.println("\nServicios en promocion para el dia " + diaConsulta + ":");
        for (Servicio s : sistema.traerServicio(true, diaConsulta)){
            System.out.println(s);
        }
    }
    
}

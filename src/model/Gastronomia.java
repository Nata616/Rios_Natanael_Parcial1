/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Nata
 */
public class Gastronomia extends Servicio{
    private String gastronomia;
    private double precio;
    private int diaSemDesc; // Dia de la semana en que se aplica el descuento

    //  Constructor
    public Gastronomia(String gastronomia, double precio, int diaSemDesc, String codServicio, double porcentajeDescuento, boolean enPromocion) {
        super(codServicio, porcentajeDescuento, enPromocion);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }

    @Override
    public double calcularPrecioFinal(LocalDate dia) {
       if (enPromocion && dia.getDayOfWeek().getValue() == diaSemDesc){
           return precio - (precio * porcentajeDescuento / 100);
       }
       return precio;
    }

    // To String
    @Override
    public String toString() {
        return "Gastronomia{codServicio=" + codServicio + "gastronomia=" + gastronomia + ", precio=" + precio + ", diaSemDesc=" + diaSemDesc + '}';
    }
    
    
}

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
// Clase abstracta, sirve como base para los servicios hospedaje y gastronomia
public abstract class Servicio {
    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;

    // Constructor
    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion) {
        if (codServicio.length() != 6){
            throw new IllegalArgumentException("El codigo de servicio tiene que tener 6 caracteres");
        }
        this.codServicio = codServicio;
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
    }
    
    // Getters
    public String getCodServicio() {
        return codServicio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }
    
    // Metodo abstracto para calcular precio final
    public abstract double calcularPrecioFinal(LocalDate dia);
}

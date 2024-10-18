/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nata
 */
public class Sistema {
    private List<Servicio> primerServicio;

    // Constructor
    public Sistema() {
        this.primerServicio = new ArrayList<>();
    }
    
    // Traer servicio por codigo
    public Servicio traerServicio(String codServicio){
        for (Servicio s : primerServicio){
            if(s.getCodServicio().equals(codServicio)){
                return s;
            }
        }
        return null;
    }
    
    // Traer servicios en promocion
    public List<Servicio> traerServicio(boolean enPromocion){
        List<Servicio> result = new ArrayList<>();
        for (Servicio s : primerServicio){
            if (s.isEnPromocion() == enPromocion){
                result.add(s);
            }
        }
        return result;
    }
    
    // Traer servicios por promocion y fecha
    public List<Servicio> traerServicio(boolean enPromocion, LocalDate dia){
        List<Servicio> result = new ArrayList<>();
        for (Servicio s : primerServicio){
            if (s.isEnPromocion() == enPromocion && s.calcularPrecioFinal(dia) > 0){
                result.add(s);
            }
        }
        return result;
    }
    
    // Agregar Gastronomia
    public boolean agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion,String gastronomia, double precio, int diaSemDesc) {
        if (traerServicio(codServicio) != null) {
            throw new IllegalArgumentException("El servicio con el código " + codServicio + " ya existe.");
        }
        primerServicio.add(new Gastronomia(codServicio, porcentajeDescuento, enPromocion, gastronomia, precio, diaSemDesc));
        return true;
    }
    // Agregar Hospedaje
    public boolean agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche){
        if (traerServicio(codServicio) != null){
            throw new IllegalArgumentException("El servicio con el codigo " + codServicio + "ya existe.");
        }
        primerServicio.add(new Hospedaje(codServicio, porcentajeDescuento, enPromocion, hospedaje, precioPorNoche));
        return true;
    }
    
    // Metodo imprimir servicios
    public void imprimirServicios(){
        for(Servicio s : primerServicio){
            System.out.println(s);
        }
    }
}

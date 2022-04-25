/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosAUsar;

import java.util.Date;

/**
 *
 * @author alfar
 */
public class Cosecha {
    String tipoCultivo;
    int idCosecha;
    Date fechacultivo;
    Date fechacosecha;
    String nombreCampoCultivo;
    double cantidadKilos;
    double precioPorKilo;

    public Cosecha() {
    }

    public Cosecha(String tipoCultivo, int idCosecha, Date fechacultivo, Date fechacosecha, String nombreCampoCultivo, double cantidadKilos, double precioPorKilo) {
        this.tipoCultivo = tipoCultivo;
        this.idCosecha = idCosecha;
        this.fechacultivo = fechacultivo;
        this.fechacosecha = fechacosecha;
        this.nombreCampoCultivo = nombreCampoCultivo;
        this.cantidadKilos = cantidadKilos;
        this.precioPorKilo = precioPorKilo;
    }

    public String getTipoCultivo() {
        return tipoCultivo;
    }

    public void setTipoCultivo(String tipoCultivo) {
        this.tipoCultivo = tipoCultivo;
    }

    public int getIdCosecha() {
        return idCosecha;
    }

    public void setIdCosecha(int idCosecha) {
        this.idCosecha = idCosecha;
    }

    public Date getFechacultivo() {
        return fechacultivo;
    }

    public void setFechacultivo(Date fechacultivo) {
        this.fechacultivo = fechacultivo;
    }

    public Date getFechacosecha() {
        return fechacosecha;
    }

    public void setFechacosecha(Date fechacosecha) {
        this.fechacosecha = fechacosecha;
    }

    public String getNombreCampoCultivo() {
        return nombreCampoCultivo;
    }

    public void setNombreCampoCultivo(String nombreCampoCultivo) {
        this.nombreCampoCultivo = nombreCampoCultivo;
    }

    public double getCantidadKilos() {
        return cantidadKilos;
    }

    public void setCantidadKilos(double cantidadKilos) {
        this.cantidadKilos = cantidadKilos;
    }

    public double getPrecioPorKilo() {
        return precioPorKilo;
    }

    public void setPrecioPorKilo(double precioPorKilo) {
        this.precioPorKilo = precioPorKilo;
    }
    
     
}

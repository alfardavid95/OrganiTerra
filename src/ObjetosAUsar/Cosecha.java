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

    Date fechacultivo;
    Date fechacosecha;
    Date fechaRecogida;
    String nombreCampoCultivo;
    int  cantidadKilos;
    double precioPorKilo;
    public int idCosecha;
    int IdcampoCultivo;

    public Cosecha() {
    }

    public Cosecha(String tipoCultivo, int idCosecha, Date fechacultivo, Date fechacosecha, String nombreCampoCultivo, int  cantidadKilos, double precioPorKilo) {
        this.tipoCultivo = tipoCultivo;
        this.fechacultivo = fechacultivo;
        this.fechacosecha = fechacosecha;
        this.nombreCampoCultivo = nombreCampoCultivo;
        this.cantidadKilos = cantidadKilos;
    }
    public Cosecha(int idCosecha){
        this.idCosecha= idCosecha;
    }

    public String getTipoCultivo() {
        return tipoCultivo;
    }

    public void setTipoCultivo(String tipoCultivo) {
        this.tipoCultivo = tipoCultivo;
    }

    public int getIdcampoCultivo() {
        return IdcampoCultivo;
    }

    public Date getFechaRecogida() {
        return fechaRecogida;
    }

    public void setFechaRecogida(Date fechaRecogida) {
        this.fechaRecogida = fechaRecogida;
    }
    

    public void setIdcampoCultivo(int IdcampoCultivo) {
        this.IdcampoCultivo = IdcampoCultivo;
    }
    

    public int getIdCosecha() {
        return idCosecha;
    }

    public void setIdCosecha(int idCosecha) {
        this.idCosecha=idCosecha;
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

    public int getCantidadKilos() {
        return cantidadKilos;
    }

    public void setCantidadKilos(int  cantidadKilos) {
        this.cantidadKilos = cantidadKilos;
    }

    public double getPrecioPorKilo() {
        return precioPorKilo;
    }

    public void setPrecioPorKilo(double precioPorKilo) {
        this.precioPorKilo = precioPorKilo;
    }
    
     
}

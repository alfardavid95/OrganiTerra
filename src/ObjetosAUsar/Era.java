/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosAUsar;

import java.util.Random;
//probando cambios
/**
 *
 * @author alfar
 */
public class Era {
    String tiposuelo;//arcilloso  o arenoso
    int aireacion; //un valor entre 70-100%
    int nivelDehumedad;//debe estar entre un 70-100% recomendada%
    int nitrogeno, fosforo, potasio, calcio, azufre, magnesio, hierro, zinc, manganeso, boro, cobre, cloro, molibdeno;// se mide de 70-100%
    double ph;// valor tiene que esta entre 5.5 y 8
    boolean tieneMaleza;
    boolean tieneHongos;
    boolean tieneinsectos;
    int valorMaximoParametro = 100;
    int valorMinimoparametro = 70;
    
    public Era(){
        /*
            esta parte es para poder escoger el tipo de suelo
        */
        int selectorArcillosoOArenoso =(int) (Math.random() * 2) + 1;
        switch(selectorArcillosoOArenoso){
            case 1:
                tiposuelo="arcilloso";
                break;
            case 2:
                tiposuelo="arenoso";
                break;
            default:
                tiposuelo= "arcilloso";
        }
        //esta parte es para darle valores random a todas las variables de la era
        aireacion =(int) (Math.random() * valorMaximoParametro) + valorMinimoparametro;
        nivelDehumedad =(int) (Math.random() * valorMaximoParametro) + valorMinimoparametro;
        nitrogeno =(int) (Math.random() * valorMaximoParametro) + valorMinimoparametro;
        fosforo =(int) (Math.random() * valorMaximoParametro) + valorMinimoparametro;
        potasio =(int) (Math.random() * valorMaximoParametro) + valorMinimoparametro;
        calcio =(int) (Math.random() * valorMaximoParametro) + valorMinimoparametro;
        azufre =(int) (Math.random() * valorMaximoParametro) + valorMinimoparametro;
        magnesio =(int) (Math.random() * valorMaximoParametro) + valorMinimoparametro;
        hierro =(int) (Math.random() * valorMaximoParametro) + valorMinimoparametro;
        zinc =(int) (Math.random() * valorMaximoParametro) + valorMinimoparametro;
        manganeso =(int) (Math.random() * valorMaximoParametro) + valorMinimoparametro;
        boro =(int) (Math.random() * valorMaximoParametro) + valorMinimoparametro;
        cobre =(int) (Math.random() * valorMaximoParametro) + valorMinimoparametro;
        cloro =(int) (Math.random() * valorMaximoParametro) + valorMinimoparametro;
        molibdeno =(int) (Math.random() * valorMaximoParametro) + valorMinimoparametro;
        
        Random randomdMaleza = new Random();// esto es para crear booleans random
        Random randomdHongos = new Random();
        Random randomdinsectos = new Random();
        tieneMaleza=randomdMaleza.nextBoolean();
        tieneHongos=randomdHongos.nextBoolean();
        tieneinsectos=randomdinsectos.nextBoolean();
                
    }

    public String getTiposuelo() {
        return tiposuelo;
    }

    public void setTiposuelo(String tiposuelo) {
        this.tiposuelo = tiposuelo;
    }

    public int getAireacion() {
        return aireacion;
    }

    public void setAireacion(int aireacion) {
        this.aireacion = aireacion;
    }

    public int getNivelDehumedad() {
        return nivelDehumedad;
    }

    public void setNivelDehumedad(int nivelDehumedad) {
        this.nivelDehumedad = nivelDehumedad;
    }

    public int getNitrogeno() {
        return nitrogeno;
    }

    public void setNitrogeno(int nitrogeno) {
        this.nitrogeno = nitrogeno;
    }

    public int getFosforo() {
        return fosforo;
    }

    public void setFosforo(int fosforo) {
        this.fosforo = fosforo;
    }

    public int getPotasio() {
        return potasio;
    }

    public void setPotasio(int potasio) {
        this.potasio = potasio;
    }

    public int getCalcio() {
        return calcio;
    }

    public void setCalcio(int calcio) {
        this.calcio = calcio;
    }

    public int getAzufre() {
        return azufre;
    }

    public void setAzufre(int azufre) {
        this.azufre = azufre;
    }

    public int getMagnesio() {
        return magnesio;
    }

    public void setMagnesio(int magnesio) {
        this.magnesio = magnesio;
    }

    public int getHierro() {
        return hierro;
    }

    public void setHierro(int hierro) {
        this.hierro = hierro;
    }

    public int getZinc() {
        return zinc;
    }

    public void setZinc(int zinc) {
        this.zinc = zinc;
    }

    public int getManganeso() {
        return manganeso;
    }

    public void setManganeso(int manganeso) {
        this.manganeso = manganeso;
    }

    public int getBoro() {
        return boro;
    }

    public void setBoro(int boro) {
        this.boro = boro;
    }

    public int getCobre() {
        return cobre;
    }

    public void setCobre(int cobre) {
        this.cobre = cobre;
    }

    public int getCloro() {
        return cloro;
    }

    public void setCloro(int cloro) {
        this.cloro = cloro;
    }

    public int getMolibdeno() {
        return molibdeno;
    }

    public void setMolibdeno(int molibdeno) {
        this.molibdeno = molibdeno;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public boolean isTieneMaleza() {
        return tieneMaleza;
    }

    public void setTieneMaleza(boolean tieneMaleza) {
        this.tieneMaleza = tieneMaleza;
    }

    public boolean isTieneHongos() {
        return tieneHongos;
    }

    public void setTieneHongos(boolean tieneHongos) {
        this.tieneHongos = tieneHongos;
    }

    public boolean isTieneinsectos() {
        return tieneinsectos;
    }

    public void setTieneinsectos(boolean tieneinsectos) {
        this.tieneinsectos = tieneinsectos;
    }

    public int getValorMaximoParametro() {
        return valorMaximoParametro;
    }

    public void setValorMaximoParametro(int valorMaximoParametro) {
        this.valorMaximoParametro = valorMaximoParametro;
    }

    public int getValorMinimoparametro() {
        return valorMinimoparametro;
    }

    public void setValorMinimoparametro(int valorMinimoparametro) {
        this.valorMinimoparametro = valorMinimoparametro;
    }
    
    
    
}

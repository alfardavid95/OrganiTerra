/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ObjetosAUsar;
import java.util.Calendar;
import java.util.Date;
import Estructuras.*;


/**
 *
 * @author alfar
 */
public class CampoCultivo {
    private String nombreCampoCultivo;
    private String tipoCultivo;
    private int id;
    private Date fechaCosecha;
    private Date fechaSiembra;
    private Date fechaCreacionTerreno;
    //private ListaEnlazadaEras listaEras;
    private int cantidadEras;
    boolean notienepiedras = false;
    boolean tienedrenaje = false;
    boolean tieneAgua = false;
    boolean noestaSucio = false;
    int canteras;
    ListaCircularSimpleEras listaEras = new ListaCircularSimpleEras();

    public CampoCultivo() {
    }

    public CampoCultivo(String nombreCampoCultivo, int id, Date fechaCreacionTerreno, int canEras) {
        this.nombreCampoCultivo = nombreCampoCultivo;
        this.id = id;
        this.fechaCreacionTerreno = fechaCreacionTerreno;
        this.canteras =canEras;
        for (int i=0; i<canEras; i++){// en este ciclo crea la lista con la cantidad de eras que se definio al momento de la creacion
            Era era = new Era();
            listaEras.insertar(era);
        }
    }

    public String getNombreCampoCultivo() {
        return nombreCampoCultivo;
    }

    public void setNombreCampoCultivo(String nombreCampoCultivo) {
        this.nombreCampoCultivo = nombreCampoCultivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaCosecha() {
        return fechaCosecha;
    }

    public void setFechaCosecha(Date fechaCosecha) {
        this.fechaCosecha = fechaCosecha;
    }

    public Date getFechaSiembra() {
        return fechaSiembra;
    }

    public void setFechaSiembra(Date fechaSiembra) {
        this.fechaSiembra = fechaSiembra;
    }

    public Date getFechaCreacionTerreno() {
        return fechaCreacionTerreno;
    }

    public void setFechaCreacionTerreno(Date fechaCreacionTerreno) {
        this.fechaCreacionTerreno = fechaCreacionTerreno;
    }

    public int getCantidadEras() {
        return cantidadEras;
    }

    public void setCantidadEras(int cantidadEras) {
        this.cantidadEras = cantidadEras;
    }

    public boolean isNotienepiedras() {
        return notienepiedras;
    }

    public void setNotienepiedras(boolean notienepiedras) {
        this.notienepiedras = notienepiedras;
    }

    public boolean isTienedrenaje() {
        return tienedrenaje;
    }

    public void setTienedrenaje(boolean tienedrenaje) {
        this.tienedrenaje = tienedrenaje;
    }

    public boolean isTieneAgua() {
        return tieneAgua;
    }

    public void setTieneAgua(boolean tieneAgua) {
        this.tieneAgua = tieneAgua;
    }

    public boolean isNoestaSucio() {
        return noestaSucio;
    }

    public void setNoestaSucio(boolean noestaSucio) {
        this.noestaSucio = noestaSucio;
    }

    public String getTipoCultivo() {
        return tipoCultivo;
    }

    public void setTipoCultivo(String tipoCultivo) {
        this.tipoCultivo = tipoCultivo;
    }

    public ListaCircularSimpleEras getListaEras() {
        return listaEras;
    }

    public void setListaEras(ListaCircularSimpleEras listaEras) {
        this.listaEras = listaEras;
    }

    @Override
    public String toString() {
        return "CampoCultivo{" + "nombreCampoCultivo=" + nombreCampoCultivo +  
                ", id=" + id + ", fechaCreacionTerreno=" + fechaCreacionTerreno +  "}";
    }
    
    
    
    
    public boolean EstaListaParaCosechar(Date fechaHoy, Date FechaCosecha){
        boolean estaListoParaCosechar = false;
        //aca me tiene que devolver un boolean al comparar la fecha de hoy con la fecha de la cosecha
        
        /*escribir codigo aca
        Calendar cal1 = Calendar.getInstance();
        if(getFechaCosecha()<)
        */
        return estaListoParaCosechar;
    }
    
    
    
    
    
    
    
}

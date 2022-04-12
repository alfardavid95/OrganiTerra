/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;
import ObjetosAUsar.*;

/**
 *
 * @author alfar
 */
public class NodoEras {
    
    private NodoEras next;
    private Era era;
    
    //constructor para cuando hay nodos 
    public NodoEras(Era era){
        this(era,null);
    }
    
    //constructor cuando no hay nodos
    public NodoEras(Era dato, NodoEras next) {
        this.era = dato;
        this.next=this;
    }

    public NodoEras getNext() {
        return next;
    }

    public void setNext(NodoEras next) {
        this.next = next;
    }


    public Era getPersona() {
        return era;
    }

    public void setPersonita(Era era) {
        this.era = era;
    }
    
}

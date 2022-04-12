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
public class NodoCamposCultivo {

    private NodoCamposCultivo next, back;
    private  CampoCultivo campito;
    
    //constructor para cuando hay nodos 

    public NodoCamposCultivo(CampoCultivo campito) {
        this.campito = campito;
    }

   
    

    public NodoCamposCultivo getNext() {
        return next;
    }

    public void setNext(NodoCamposCultivo next) {
        this.next = next;
    }

    public NodoCamposCultivo getBack() {
        return back;
    }

    public void setBack(NodoCamposCultivo back) {
        this.back = back;
    }

    public CampoCultivo getCampito() {
        return campito;
    }

    public void setCampito(CampoCultivo campito) {
        this.campito = campito;
    }
   
}

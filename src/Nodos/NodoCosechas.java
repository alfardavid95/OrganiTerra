/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodos;

import ObjetosAUsar.*;


public class NodoCosechas {
    
    private Cosecha cosechita;
    private NodoCosechas atras;

    public NodoCosechas() {
    }

    public NodoCosechas(Cosecha cosechita) {
        this.cosechita = cosechita;
    }

    public Cosecha getCosechita() {
        return cosechita;
    }

    public void setCosechita(Cosecha cosechita) {
        this.cosechita = cosechita;
    }

    public NodoCosechas getAtras() {
        return atras;
    }

    public void setAtras(NodoCosechas atras) {
        this.atras = atras;
    }
    
    
    
    
    
}

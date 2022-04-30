
package Estructuras;

import Nodos.NodoCitaTurista;




public class ColaCitaTurista {
    
    private NodoCitaTurista frente;
    private NodoCitaTurista ultimo;
    
    public void enCola(NodoCitaTurista NewElement0){
        
        if(frente==null){
        frente=NewElement0;
        ultimo=NewElement0;
        }else{
        ultimo.setAtras(NewElement0);
        ultimo=NewElement0;}
    }
 //////////////////////////////////////////////////////////////////   
    public NodoCitaTurista atiende(){

NodoCitaTurista aux= frente;

if (frente!=null){
    if(frente==ultimo){ultimo=null;}
    
    frente=frente.getAtras();
    aux.setAtras(null);}
return aux;}
    
 /////////////////////////////////////////////////////////////   
    public boolean ColaVacia(){
    if(frente==null){return true;
    }else{return false;}
    }
    
}

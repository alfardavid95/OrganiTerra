
package Estructuras;

import Nodos.NodoCosechas;




public class ColaCosechas {
    
    private NodoCosechas frente;
    private NodoCosechas ultimo;
    
    public void enCola(NodoCosechas NewElement0){
        
        if(frente==null){
        frente=NewElement0;
        ultimo=NewElement0;
        }else{
        ultimo.setAtras(NewElement0);
        ultimo=NewElement0;}
    }
 //////////////////////////////////////////////////////////////////   
    public NodoCosechas atiende(){

NodoCosechas aux= frente;

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


package Estructuras;

import Nodos.NodoArmarioHerramientas;
import javax.swing.JOptionPane;


public class PilaArmarioHerramientas {
    
    private NodoArmarioHerramientas top;
    
    public void push(NodoArmarioHerramientas elemento){
        elemento.setNext(top);
        top=elemento;  
    }

    public NodoArmarioHerramientas getTop() {
        return top;
    }
    
    public NodoArmarioHerramientas pop(){
        NodoArmarioHerramientas aux=top;
        if(PilaVacia()==true){
            JOptionPane.showMessageDialog(null,"No hay Objetos ni Herramientas en el armario...");
            
        }else{
            
        top=top.getNext();
        aux.setNext(null);}
        return aux;
        
    
    }
    
    public boolean PilaVacia(){
    
    if(top==null){
    return true;
    }else{return false;}
    
    }
    
}

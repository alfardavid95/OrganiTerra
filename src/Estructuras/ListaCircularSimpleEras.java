/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;
/**
 *
 * @author alfar
 */
import Nodos.*;
import ObjetosAUsar.*;
import javax.swing.JOptionPane;
 
/**
 *
 * @author alfar
 */
public class ListaCircularSimpleEras {
    NodoEras ultimo;
    
    public ListaCircularSimpleEras(){
        ultimo=null;
    }
    

    //metodo para saber cuando la lista esta vacia
    public  boolean estaVacia(){
        return ultimo==null;
    }
    
     //metodo para insertar nodos
    public ListaCircularSimpleEras insertar(Era p){
        NodoEras nuevo= new NodoEras(p);
        if(ultimo!=null){
            nuevo.setNext(ultimo.getNext());
            ultimo.setNext(nuevo);
        }
        ultimo= nuevo;
        return this;
        
    }
    
    //metodo para recorre la lista 
    public void mostarLista(){
        NodoEras aux;
        aux = ultimo.getNext();// con esto apuntamos al primero de toda la lista
        String cadenaDeCaracteres = "";
        do {
            cadenaDeCaracteres = cadenaDeCaracteres + "["+ aux.getPersona().toString()+"]->\n";
            aux=aux.getNext();
        }while(aux!=ultimo.getNext());
        JOptionPane.showMessageDialog(null, cadenaDeCaracteres, "Mostrando la lista circular", JOptionPane.INFORMATION_MESSAGE);     
    }
    
    //eliminar un Nodo de una lista
    public boolean eliminar (Era persona){
        NodoEras actual;
        boolean encontrado = false;
        actual=ultimo;
        while (actual.getNext()!= ultimo && !encontrado){ //si recorre toda la lista y no lo encuentra no hace nada pero si recorre toda la lista y lo encuentra lo borra
            encontrado= (actual.getNext().getPersona().equals(persona));//verificar si existe o no de acuerdo a la data que se pidio
            if(!encontrado){//si no lo encuentra siga recorriendo 
                actual = actual.getNext();
            }
        }
        encontrado = (actual.getNext().getPersona().equals(this));
        if (encontrado){
            NodoEras aux = actual.getNext();
            if (ultimo.equals(ultimo.getNext())){
                ultimo=null;
            }else{
                if(aux.equals(ultimo)){
                    ultimo=actual;
                }
                actual.setNext(aux.getNext());
            }
            aux=null;
        }
        return encontrado;
    }

    
}


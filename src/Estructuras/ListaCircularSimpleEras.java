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
    public void mostarLista(int selector_de_variables_a_revisar){
        NodoEras aux;
        aux = ultimo.getNext();// con esto apuntamos al primero de toda la lista
        String cadenaDeCaracteres = "";
        switch (selector_de_variables_a_revisar){
            case 1://Revisar aireacion, humedad y PH\n"
                do {
                    cadenaDeCaracteres = cadenaDeCaracteres + "La era con el ID ["+ aux.getDato().getId()+"]\n"
                            + "Nivel de aireacion [" +aux.getDato().getAireacion()+"]\n"
                            + "Nivel de humedad["+aux.getDato().getNivelDehumedad()+"]\n"
                            + "Nivel de ph["+aux.getDato().getPh()+"]\n\n";
                    aux=aux.getNext();
                }while(aux!=ultimo.getNext());    
                break;
            case 2://Revisar Plagas\n
                do {
                    cadenaDeCaracteres = cadenaDeCaracteres + "La era con el ID ["+ aux.getDato().getId()+"]\n"
                            + "Tiene las siguientes plagas"
                            + "Tiene Hongos [" +aux.getDato().isTieneHongos()+"]\n"
                            + "Tiene maleza["+aux.getDato().isTieneMaleza()+"]\n"
                            + "Nive insectos["+aux.getDato().isTieneinsectos()+"]\n\n";
                    aux=aux.getNext();
                }while(aux!=ultimo.getNext());                  
                break;
            case 3://Revisar Minerales\n"
                do {
                    cadenaDeCaracteres = cadenaDeCaracteres + "["+ aux.getDato().toString()+"]->\n";
                    aux=aux.getNext();
                }while(aux!=ultimo.getNext());                  
                break;
            case 4://Revisar tipo de suelo\n"
                do {
                    cadenaDeCaracteres = cadenaDeCaracteres + "["+ aux.getDato().toString()+"]->\n";
                    aux=aux.getNext();
                }while(aux!=ultimo.getNext());                  
                break;
                
        }

        JOptionPane.showMessageDialog(null, cadenaDeCaracteres, "Mostrando informacion de eras y campo de cultivo", JOptionPane.INFORMATION_MESSAGE);     
    }
    
    
    
    
    //eliminar un Nodo de una lista
    public boolean eliminar (Era persona){
        NodoEras actual;
        boolean encontrado = false;
        actual=ultimo;
        while (actual.getNext()!= ultimo && !encontrado){ //si recorre toda la lista y no lo encuentra no hace nada pero si recorre toda la lista y lo encuentra lo borra
            encontrado= (actual.getNext().getDato().equals(persona));//verificar si existe o no de acuerdo a la data que se pidio
            if(!encontrado){//si no lo encuentra siga recorriendo 
                actual = actual.getNext();
            }
        }
        encontrado = (actual.getNext().getDato().equals(this));
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


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
    public NodoEras ultimo;
    
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
                            + "Tiene las siguientes plagas\n"
                            + "Tiene Hongos [" +aux.getDato().isTieneHongos()+"]\n"
                            + "Tiene maleza["+aux.getDato().isTieneMaleza()+"]\n"
                            + "Tiene insectos["+aux.getDato().isTieneinsectos()+"]\n\n";
                    aux=aux.getNext();
                }while(aux!=ultimo.getNext());                  
                break;
            case 3://Revisar Minerales\n"
                do {
                    cadenaDeCaracteres = cadenaDeCaracteres + "La era con el ID ["+ aux.getDato().getId()+"]\n"
                            + "Tiene las siguientes concentraciones de minerales\n"
                            + "Concentracion de Calcio [" +aux.getDato().getCalcio()+"]\n"
                            + "Concentracion de Nitrogeno["+aux.getDato().getNitrogeno()+"]\n"
                            + "Concentracion de Potasio["+aux.getDato().getPotasio()+"]\n"
                            + "Concentracion de Magnesio["+aux.getDato().getMagnesio()+"]\n"
                            + "Concentracion de Hierro["+aux.getDato().getHierro()+"]\n"
                            + "Concentracion de Azufre["+aux.getDato().getAzufre()+"]\n"
                            + "Concentracion de Zinc["+aux.getDato().getZinc()+"]\n"
                            + "Concentracion de Fosforo["+aux.getDato().getFosforo()+"]\n"
                            + "Concentracion de Boro["+aux.getDato().getBoro()+"]\n\n";
                    aux=aux.getNext();
                }while(aux!=ultimo.getNext());                  
                break;
            case 4://Revisar tipo de suelo\n"
                do {
                    cadenaDeCaracteres = cadenaDeCaracteres + "La era con el ID ["+ aux.getDato().getId()+"]\n"
                            + "Tiene el siguiente tipo de suelo [" +aux.getDato().getTiposuelo()+"]\n\n";
                    aux=aux.getNext();
                }while(aux!=ultimo.getNext());                  
                break;
                
        }

        JOptionPane.showMessageDialog(null, cadenaDeCaracteres, "Mostrando informacion de eras y campo de cultivo", JOptionPane.INFORMATION_MESSAGE);     
    }
    
    public void incrementarAireacion(){
        NodoEras aux;
        aux = ultimo.getNext();// con esto apuntamos al primero de toda la lista
        JOptionPane.showMessageDialog(null, "Ha decidido airear la tierra estos son los valores previo a la aireacion");
        mostarLista(1);
        JOptionPane.showMessageDialog(null, "Incrementa la aireacion a todas las eras del campo con menos de 96 por 5 puntos");
        do {
            if(aux.getDato().getAireacion()<96){
                aux.getDato().setAireacion(aux.getDato().getAireacion()+5);// esto lo que hace es incrementar por 5 la aireacion si la aereacion es menor de 95
            }
            aux=aux.getNext();
        }while(aux!=ultimo.getNext());
        mostarLista(1);
        
    }
    
    public void agregarAgua(){
        NodoEras aux;
        aux = ultimo.getNext();// con esto apuntamos al primero de toda la lista
        JOptionPane.showMessageDialog(null, "Ha decidido incrementar la humedad de las eras\n"
                + "los valores mostrados a continuacion son previos a agregarle humedad a las eras");
        mostarLista(1);
        JOptionPane.showMessageDialog(null, "Incrementa la humedad a todas las eras del campo con menos de 96 por 5 puntos");
        do {
            if(aux.getDato().getNivelDehumedad()<96){
                aux.getDato().setNivelDehumedad(aux.getDato().getNivelDehumedad()+5);// esto lo que hace es incrementar por 5 la aireacion si la aereacion es menor de 95
            }
            aux=aux.getNext();
        }while(aux!=ultimo.getNext());
        mostarLista(1);
        
    }
    public boolean revisionHayPlagasEnLasEras(){
        NodoEras aux;
        boolean noHayPlagas = true;
        aux = ultimo.getNext();// con esto apuntamos al primero de toda la lista
        
        do {
            if(aux.getDato().isTieneHongos()||aux.getDato().isTieneMaleza()||aux.getDato().isTieneinsectos()){
                noHayPlagas= false;
            }
            aux=aux.getNext();
        }while(aux!=ultimo.getNext());

        return noHayPlagas;
    }
    
            
    
        public void incrementarMinerales(int mineralID){
        if(!(mineralID==10)){
        NodoEras aux;
        aux = ultimo.getNext();// con esto apuntamos al primero de toda la lista
        JOptionPane.showMessageDialog(null, "Ha decidido incrementar las concentraciones recomendadas de minerales de la tierra\n"
                + "estos son los valores de antes de hacerle un incremento");
        mostarLista(3);
        JOptionPane.showMessageDialog(null, "Incrementa en 5 la concentracion recomendada a cualquier valor menor de 96");
        do {
            switch (mineralID){
                case 1://calcio
                    if(aux.getDato().getCalcio()<=95){
                        aux.getDato().setCalcio(aux.getDato().getCalcio()+5);// esto lo que hace es incrementar por 5 el nivel de calcio siempre y cuando sea menor o igual de 95
                    }
                break;
                case 2://nitrogeno
                    if(aux.getDato().getNitrogeno()<=95){
                        aux.getDato().setNitrogeno(aux.getDato().getNitrogeno()+5);// esto lo que hace es incrementar por 5 el nivel de nitrogeno siempre y cuando sea menor o igual de 95
                    }
                break;
                case 3://Potasio
                    if(aux.getDato().getPotasio()<=95){
                        aux.getDato().setPotasio(aux.getDato().getPotasio()+5);// esto lo que hace es incrementar por 5 el nivel de potasio siempre y cuando sea menor o igual de 95
                    }                    
                break;
                case 4://Magnesio
                    if(aux.getDato().getMagnesio()<=95){
                        aux.getDato().setMagnesio(aux.getDato().getMagnesio()+5);// esto lo que hace es incrementar por 5 el nivel de magnesio siempre y cuando sea menor o igual de 95
                    }
                break;
                case 5://Hierro
                    if(aux.getDato().getHierro()<=95){
                        aux.getDato().setHierro(aux.getDato().getHierro()+5);// esto lo que hace es incrementar por 5 el nivel de hierro siempre y cuando sea menor o igual de 95
                    }
                break;
                case 6://Azufre
                    if(aux.getDato().getAzufre()<=95){
                        aux.getDato().setAzufre(aux.getDato().getAzufre()+5);// esto lo que hace es incrementar por 5 el nivel de azufre siempre y cuando sea menor o igual de 95
                    }
                break;
                case 7://Zinc
                    if(aux.getDato().getZinc()<=95){
                        aux.getDato().setZinc(aux.getDato().getZinc()+5);// esto lo que hace es incrementar por 5 el nivel de zinc siempre y cuando sea menor o igual de 95
                    }
                break;
                case 8://Fosforo
                    if(aux.getDato().getFosforo()<=95){
                        aux.getDato().setFosforo(aux.getDato().getFosforo()+5);// esto lo que hace es incrementar por 5 el nivel de fosforo siempre y cuando sea menor o igual de 95
                    }
                break;
                case 9://Boro
                    if(aux.getDato().getBoro()<=95){
                        aux.getDato().setBoro(aux.getDato().getBoro()+5);// esto lo que hace es incrementar por 5 el nivel de boro siempre y cuando sea menor o igual de 95
                    }
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Seleccion de mineral equivocada");
                break;
            }
            aux=aux.getNext();
        }while(aux!=ultimo.getNext());
        mostarLista(3);
        }
    }
    
        public void AgregarPesticida(int seleccion){
            NodoEras aux;
            aux = ultimo.getNext();// con esto apuntamos al primero de toda la lista
            do {
            switch(seleccion){
                case 1:
                    aux.getDato().setTieneMaleza(false);
                    break;
                case 2:
                    aux.getDato().setTieneHongos(false);
                    break;
                case 3:
                    aux.getDato().setTieneinsectos(false);
                    break;
            }
            aux=aux.getNext();
            }while(aux!=ultimo.getNext());
            mostarLista(2);//aca muestra si tiene alguna plaga o no
            
        }
    
    public boolean revisionNoHacenFaltaMinerales(){
        int valorMinimo=85;
        NodoEras aux;
        boolean banderaEstaBienDeCalcio =false;
        boolean banderaEstaBienDenitrogeno =false;
        boolean banderaEstaBienDePotasio =false;
        boolean banderaEstaBienDeMagnesio =false;
        boolean banderaEstaBienDeHierro =false;
        boolean banderaEstaBienDeAzufre =false;
        boolean banderaEstaBienDeZinc =false;
        boolean banderaEstaBienDeFosforo =false;
        boolean banderaEstaBienDeBoro =false;
        boolean noHaceFaltaMinerales =false;
        
        
        for(int mineralID=1;mineralID<=9;mineralID++){
            
        
        aux = ultimo.getNext();// con esto apuntamos al primero de toda la lista
        do {
            switch (mineralID){
                case 1://calcio
                    if(aux.getDato().getCalcio()<=valorMinimo && !banderaEstaBienDeCalcio){
                        banderaEstaBienDeCalcio=true;
                    }
                break;
                case 2://nitrogeno
                    if(aux.getDato().getNitrogeno()<=valorMinimo && !banderaEstaBienDenitrogeno){
                        banderaEstaBienDenitrogeno=true;
                    }
                break;
                case 3://Potasio
                    if(aux.getDato().getPotasio()<=valorMinimo && !banderaEstaBienDePotasio){
                        banderaEstaBienDePotasio=true;// esto lo que hace es incrementar por 5 el nivel de potasio siempre y cuando sea menor o igual de 95
                    }                    
                break;
                case 4://Magnesio
                    if(aux.getDato().getMagnesio()<=valorMinimo && !banderaEstaBienDeMagnesio){
                        banderaEstaBienDeMagnesio=true;// esto lo que hace es incrementar por 5 el nivel de magnesio siempre y cuando sea menor o igual de 95
                    }
                break;
                case 5://Hierro
                    if(aux.getDato().getHierro()<=valorMinimo){
                        banderaEstaBienDeHierro =true;// esto lo que hace es incrementar por 5 el nivel de hierro siempre y cuando sea menor o igual de 95
                    }
                break;
                case 6://Azufre
                    if(aux.getDato().getAzufre()<=valorMinimo){
                        banderaEstaBienDeAzufre=true;// esto lo que hace es incrementar por 5 el nivel de azufre siempre y cuando sea menor o igual de 95
                    }
                break;
                case 7://Zinc
                    if(aux.getDato().getZinc()<=valorMinimo){
                        banderaEstaBienDeZinc=true;// esto lo que hace es incrementar por 5 el nivel de zinc siempre y cuando sea menor o igual de 95
                    }
                break;
                case 8://Fosforo
                    if(aux.getDato().getFosforo()<=valorMinimo){
                        banderaEstaBienDeFosforo=true;// esto lo que hace es incrementar por 5 el nivel de fosforo siempre y cuando sea menor o igual de 95
                    }
                break;
                case 9://Boro
                    if(aux.getDato().getBoro()<=valorMinimo){
                        banderaEstaBienDeBoro=true;// esto lo que hace es incrementar por 5 el nivel de boro siempre y cuando sea menor o igual de 95
                    }
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Seleccion de mineral equivocada");
                break;
            }
            aux=aux.getNext();
        }while(aux!=ultimo.getNext());
        }
        
        if(banderaEstaBienDeAzufre&&banderaEstaBienDeBoro&&banderaEstaBienDeCalcio&&banderaEstaBienDeFosforo&&
           banderaEstaBienDeHierro&&banderaEstaBienDeMagnesio&&banderaEstaBienDePotasio&&banderaEstaBienDeZinc&&banderaEstaBienDenitrogeno){
           noHaceFaltaMinerales =true; 
        }   
        return noHaceFaltaMinerales;
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


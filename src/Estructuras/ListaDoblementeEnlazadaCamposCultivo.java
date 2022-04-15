/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Estructuras;
//me
import javax.swing.JOptionPane;
import Nodos.*;
import ObjetosAUsar.*;

/**
 *
 * @author alfar
 */
public class ListaDoblementeEnlazadaCamposCultivo {
    
    private NodoCamposCultivo inicio, fin;
    
    //metodo para inicializar la lista
    public ListaDoblementeEnlazadaCamposCultivo(){
        inicio = fin = null;
    }
    
    //metodo para saber si la lista esta vacia
    public boolean estaVacia(){
        boolean estavacio;
        estavacio = inicio==null;
        return estavacio;
    }
    
    /// agregar un nodo al final
    // si la lista no esta vacia entonces fin = nuevo Nodo Doble (elemento nulo fin)
    public void agregarAlFinal(CampoCultivo campito){
        if(!estaVacia()){
            fin = new NodoCamposCultivo(campito);
            fin.getBack().setNext(fin);
        }else{
            inicio= fin= new NodoCamposCultivo(campito);
        }
    }
    
    /// agregar un nodo al inicio
    // si la lista no esta vacia entonces fin = nuevo Nodo Doble (elemento nulo fin)
    
    
    
    public void AgregarAlInicio(CampoCultivo persona){
        //if(!estaVacia()){
            //inicio= new NodoCamposCultivo(persona);
           // inicio.getNext().setBack(inicio);
        //}else{
            //inicio= fin= new NodoCamposCultivo(persona);
        //} 
        
        if (inicio==null){
           inicio = new NodoCamposCultivo(persona);
           fin=inicio;
           fin.setNext(inicio);
           fin.setBack(fin);
           
       } else if (persona.getId() < inicio.getCampito().getId()){
           
           NodoCamposCultivo aux=new NodoCamposCultivo(persona);
           aux.setNext(inicio);
           inicio=aux;
           fin.setNext(inicio);
           inicio.setBack(fin);
           
       }else if(fin.getCampito().getId() <= persona.getId()){
           
           
           fin.setNext(new NodoCamposCultivo(persona));
           fin=fin.getNext();
           fin.setNext(inicio);
           inicio.setBack(fin);
           
           
       
       }else{
       
       NodoCamposCultivo aux = inicio;
       
       while(aux.getNext().getCampito().getId() < persona.getId()){
           aux=aux.getNext();
       }
       
       NodoCamposCultivo temp=new NodoCamposCultivo(persona);
       temp.setNext(aux.getNext());
       temp.setBack(aux);
       aux.setNext(temp);
       temp.getNext().setBack(temp);
      }
   fin.setNext(inicio);
   inicio.setBack(fin);
      
    }
    
    
    
    
    
    
    
    
    
    //mostrar de inicio a fin la lista
    public void MostrarDeInicioAFin(){
        
       NodoCamposCultivo aux=inicio;
 
       String s="\n";
       if (aux!=null) {

                      s=s + "Nombre del Campo: "+aux.getCampito().getNombreCampoCultivo()+"\n"
                        + "Id del Campo: "+aux.getCampito().getId()+"\n"
                       + "Fecha de creacion: "+aux.getCampito().getFechaCreacionTerreno()
                        + "\n<===========================>\n";
                
           aux=aux.getNext();
           
           while(aux!=inicio){
           s=s+"Nombre del Campo: "+aux.getCampito().getNombreCampoCultivo()+"\n"
                        + "Id del Campo: "+aux.getCampito().getId()+"\n"
                       + "Fecha de creacion: "+aux.getCampito().getFechaCreacionTerreno()
                        + "\n<===========================>\n";
           aux = aux.getNext();}
           JOptionPane.showMessageDialog(null, s);
       }else{
           
           JOptionPane.showMessageDialog(null, "No hay Campos de cultivos registados");
        
       }}
   
        
    public void eliminarConID(int idEliminar){
        
        
        if(inicio != null ){
           
            
            
        if(idEliminar==fin.getCampito().getId() && idEliminar==inicio.getCampito().getId()){   
        inicio = null;
        fin=null;
        }else{
       
       if(inicio.getCampito().getId() <= idEliminar && idEliminar <= fin.getCampito().getId()){
           
           if(inicio.getCampito().getId() == idEliminar){
           inicio=inicio.getNext();
           fin.setNext(inicio);
           fin.setNext(inicio);
           fin.setBack(fin);
           }else{
           
           NodoCamposCultivo aux= inicio;
           
           while(aux.getNext() != inicio && aux.getNext().getCampito().getId() < idEliminar){aux=aux.getNext();}
           
           if(aux.getNext().getCampito().getId() == idEliminar  ){
               if(aux.getNext()==fin){fin=aux;}
               aux.setNext(aux.getNext().getNext());
           }
       }
       }}
   
}
        
        
    }
    
    public CampoCultivo eliminarDelInicio(){
        
        CampoCultivo persona = inicio.getCampito();
        if(inicio==fin){
            inicio=fin=null;
        }else{
            inicio=inicio.getNext();
            inicio.setBack(null);
            }
        return persona;
    }
    public CampoCultivo eliminarDelFinal(){
        
        CampoCultivo persona = fin.getCampito();
        if(inicio==fin){
            inicio=fin=null;
        }else{
            fin=fin.getBack();
            fin.setNext(null);
            }
        return persona;
    }
    
    public CampoCultivo buscarPorNombreCampoCultivo(String nombreCampo){
        NodoCamposCultivo auxiliar = inicio;
        NodoCamposCultivo temp=inicio;
        
        if(auxiliar.getCampito().getNombreCampoCultivo().equals(nombreCampo)){CampoCultivo campito=temp.getCampito();
        return campito;
        }
        while(auxiliar != null && !auxiliar.getCampito().getNombreCampoCultivo().equals(nombreCampo)){
            temp= auxiliar;
            auxiliar = auxiliar.getNext();
        }
        CampoCultivo campito=temp.getNext().getCampito();
        
        return campito;
    }
    
    public CampoCultivo buscarPorIDCampoCultivo(int idCampoCultivo){
        NodoCamposCultivo auxiliar = inicio;
        NodoCamposCultivo temp=inicio;
        
        if(auxiliar.getCampito().getId()==idCampoCultivo){CampoCultivo campito=temp.getCampito();
        return campito;
        }
        while(auxiliar != null && !(auxiliar.getCampito().getId()==idCampoCultivo)){
            temp= auxiliar;
            auxiliar = auxiliar.getNext();
        }
        CampoCultivo campito=temp.getNext().getCampito();
        
        return campito;
    }
    
    public void SobreescribirDatoEnLista(CampoCultivo cam){
        if(inicio != null){
           
           if(cam.getId() >= inicio.getCampito().getId() && cam.getId() <= fin.getCampito().getId()){
           
           NodoCamposCultivo aux= inicio;
           
           while(aux!=fin && aux.getCampito().getId() < cam.getId()){aux=aux.getNext();}
           
           if(aux.getCampito().getId() == cam.getId())
           {aux.getCampito().setNombreCampoCultivo(cam.getNombreCampoCultivo()); }
       
       
           }}
    }
    
    public boolean existe(int id){
       boolean esta= false;
       
       
       
       if(inicio !=null){
           if(id >= inicio.getCampito().getId() && id <= fin.getCampito().getId()){
           NodoCamposCultivo aux= inicio;
           
           while(aux!=fin && aux.getCampito().getId() < id ){aux=aux.getNext();}
           
           esta = (aux.getCampito().getId() == id);
       }}
       
       return esta; }
    
    
    
    

}


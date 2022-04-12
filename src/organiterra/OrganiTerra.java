/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organiterra;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import ObjetosAUsar.*;
import Estructuras.*;
import java.lang.invoke.MethodHandles;
/**
 *
 * @author alfar
 */

///probando cambios
public class OrganiTerra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws ParseException{
        // TODO code application logic here
                int opcionMainMenu;
                int opcionInterna;
                int IntCantidadEras;
                Date fechaDeHoy;
                String tipoCultivo;
                int cantEras;
                int cantidadEras;
                String nombreCampoCultivo;
                int idCultivo=1000;
                ListaDoblementeEnlazadaCamposCultivo listaCultivos = new ListaDoblementeEnlazadaCamposCultivo();
                CampoCultivo campito = null;
                

        do{
            try{
            opcionMainMenu=Integer.parseInt(JOptionPane.showInputDialog(""
                    + "1. Crear campo de cultivo nuevo\n"
                    + "2. Verificar informacion de campos de cultivo \n"//aca muestra en una lista enlazada 
                    + "3. Admistrar campo de cultivo\n"
                    + "4. Eliminar campo de cultivo\n"
                    + "5. Salir\n"));}catch(Exception e){opcionMainMenu=0;}
            
            switch(opcionMainMenu ){
                case 1:
                    //Menu Principal/1.Crear campo de cultivo nuevo
                    JOptionPane.showMessageDialog(null,"Ha elegido crear un campo de tultivo");
                    Calendar calFechacreacionTerreno = Calendar.getInstance();
                    Date dateCreacionTerreno = calFechacreacionTerreno.getTime();
                    
                    nombreCampoCultivo = JOptionPane.showInputDialog("Digite el nombre de campo del campo cultivo");
                    
                    
                    cantEras=Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de Eras"));
                    CampoCultivo campitoCultivo = new CampoCultivo(nombreCampoCultivo, idCultivo, dateCreacionTerreno,cantEras);
                    idCultivo++;
                    
                    
                     try{
                    listaCultivos.AgregarAlInicio(campitoCultivo);}catch(Exception e){listaCultivos.agregarAlFinal(campitoCultivo); };
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "El campo de cultivo creado es:\n"
                            + "nombre: {"+campitoCultivo.getNombreCampoCultivo()+"}\n"
                                    + "id: {"+campitoCultivo.getId()+"}");
                    break; 
                    
                case 2:
                    //Menu Principal/ 2.Verificar informacion de campo de cultivo o eras
                    JOptionPane.showMessageDialog(null, "Ha elegido desplegar la informacion de los campos de cultivo");
                    // aca tiene que ir un display que muestre todos los campos de cultivos existentes (ojala en una lista enlazada simple con todos los campos que vaya sumandose como un string)
                    //y que muestre el nombre del campo de cultivo, el id del campo de cultivo, si tiene sembrado algo, que cultivo tiene sembrado si tiene algo sembrado y cuando es la fecha de la cosecha, y cuantos dias faltan
                    //if(!listaCultivos.estaVacia()){
                   
                        listaCultivos.MostrarDeInicioAFin();
                    
                    
                    //}else{
                        //JOptionPane.showMessageDialog(null, "no hay nodos");
                    //}
                    break;
                    
                case 3:
                    //Menu Principal/ 3.Admistrar campo de cultivo
                    JOptionPane.showMessageDialog(null, "Ha eligido administrar campo de cultivo");
                    
                        /*
                        En esta parte lo que hace primero es ver si la lista de capos de cultivo esta vacia,
                        si no lo esta va a preguntar cual es el ID del campo o el nombre del campo de cultivo
                        */                    
                    if(!listaCultivos.estaVacia()){                      
                        
                        boolean seleccionValida= false;

                       
                                int idABuscarCampoCultivo=Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del campo de cultivo que desea buscar"));
                                
                                
                                if(listaCultivos.existe(idABuscarCampoCultivo)==true){campito=listaCultivos.buscarPorIDCampoCultivo(idABuscarCampoCultivo);
                                seleccionValida= true;}else{}
                                              
                        /*
                        En caso de que haya encontrado un elemento de campo cultivo lo va a retornar al main class
                        para poder ser manipulado de no ser asi  va a salir al menu principal, aca mas abajo viene el menu de opciones
                        */
                        
                        
                        if(seleccionValida && campito!=null){
                            JOptionPane.showMessageDialog(null,"Su campo de cultivo si existe");
                            int eleccionAdministrarCampo = Integer.parseInt(JOptionPane.showInputDialog(
                            "Ha decidido administrar el campo :\n"
                            + "ID:{"+campito.getId()+"} Nombre:{"+campito.getNombreCampoCultivo()+"}\n\n"
                                
                            +"1. Elegir cultivo para sembrar\n"
                            +"2. Escanear campo de cultivo y las eras\n"
                            +"3. Limpiar terreno\n"// quitar maleza
                            +"4. Abonar y enriquecer la tierra\n" 
                            +"5. Airear terreno\n" 
                            +"6. Agregar pestizida\n"
                            +"7. Revisar estado de la tierra\n"
                            +"8. Salir\n"));
                    
                            switch(eleccionAdministrarCampo){
                                case 1://MenuPrincipal/3.Administrar cultivos/1. Elegir cultivo para sembrar
                                    int opcionTipoCultiivo =Integer.parseInt(JOptionPane.showInputDialog("Elija el tipo de cultivo\n"
                                    + "1:Papa\n"
                                    + "2.Chayote\n"
                                    + "3.Culantro\n"
                                    + "4.Zanahoria\n"
                                    + "5.Trigo\n"
                                    + "6.Fresa\n"));
                    
                                    switch(opcionTipoCultiivo){
                                        case 1:
                                        //1:Papa
                                        tipoCultivo = "Papa";
                                        break;
                            
                                        case 2:
                                        //2.Chayote
                                        tipoCultivo = "Sandia";
                                        break;
                            
                                        case 3:
                                        //3.Culantro
                                        tipoCultivo = "Melon";
                                        break;
                            
                                        case 4:
                                        //4.Zanahoria
                                        tipoCultivo = "Zanahoria";
                                        break;
                            
                                        case 5:
                                        //5.Trigo
                                        tipoCultivo = "Trigo";
                                        break;
                            
                                        case 6:
                                        //6.Fresa
                                        tipoCultivo = "Fresa";
                                        break;
                            
                                        default:
                                        tipoCultivo = "default";
                                        break;
                                    }   
                    
                                    if (!tipoCultivo.equals("default")){
                                        JOptionPane.showMessageDialog(null, "ha elegido el cultivo que desea cultivar: {"+tipoCultivo+"}");
                                        campito.setTipoCultivo(tipoCultivo);
                                        listaCultivos.SobreescribirDatoEnLista(campito);
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Tiene que escoger un tipo de cultivo valido");
                                    }
                                break;
                                case 2:
                                //2. //MenuPrincipal/3.Administrar cultivos/2.Escanear campo de cultivo y las eras
                                    //Escanear campo de cultivo para ver si esta vacio
                                    campito.getListaEras().mostarLista();

                                break;
                            
                                case 3:
                                ////MenuPrincipal/3.Administrar cultivos/3. Limpiar terreno q
                                break;
                            
                                case 4:
                                ////MenuPrincipal/3.Administrar cultivos/4. Preparar terreno para iniciar plantacion
                                break;
                            
                                case 5:
                                //5//MenuPrincipal/3.Administrar cultivos/.Airear terreno
                                break;
                            
                                case 6:
                                ////MenuPrincipal/3.Administrar cultivos/6.Abonar y enriquecer la tierra
                                break;
                            
                                case 7:
                                ////MenuPrincipal/3.Administrar cultivos/7.Revisar estado de la tierra
                                break;
                            
                                case 8:
                                ////MenuPrincipal/3.Administrar cultivos/8.salir a menu principal
                                break;
                                
                                default:
                                ////MenuPrincipal/3.Administrar cultivos/ default:salir a menu principal
                                break;
                            
                            
                            }
                    
                    
                        }else{
                            JOptionPane.showMessageDialog(null, "El campo que busca no existe...\n");
                            
                        }

                    }else{
                        JOptionPane.showMessageDialog(null, "Lista de campos de cultivo esta vacia\n"
                                + "salir al menu principal");
                    }
                        
                    break;
                case 4:
                    //Menu Principal /4.Eliminar campo de cultivo
                    JOptionPane.showMessageDialog(null, "Ha escogido eliminar un campo de cultivo");
                    if(!listaCultivos.estaVacia()){
                        JOptionPane.showMessageDialog(null, "La lista si tiene elementos");
                        
                                int idEliminar=Integer.parseInt(JOptionPane.showInputDialog(""
                            + "Escoger el ID del campo de cultivo a eliminar"));
                                listaCultivos.eliminarConID(idEliminar);//aca falta seguir 
                        
                    }else{
                       JOptionPane.showMessageDialog(null, "La lista no tiene elementos");
                    }
                    break;
                case 5:
                    //5.Salir
                    JOptionPane.showMessageDialog(null, "Salir");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, " Digite alguna opcion valida");
                    break;                    
                
            }
            
        }while(opcionMainMenu != 5);
    }
        
}
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organiterra;
//Si sirve
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
                int eleccionAdministrarCampo =0;
                

        do{
            try{
            opcionMainMenu=Integer.parseInt(JOptionPane.showInputDialog(""
                    + "Menu Principal:\n"
                    + "1. Crear campo de cultivo nuevo\n"
                    + "2. Verificar informacion general de campos de cultivo \n"//aca muestra en una lista enlazada 
                    + "3. Admistrar campo de cultivo (sub-menu)\n"
                    + "4. Eliminar campo de cultivo\n"
                    + "5. Salir\n"));}catch(Exception e){opcionMainMenu=0;}
            
            switch(opcionMainMenu ){
                case 1:
                    //Menu Principal/1.Crear campo de cultivo nuevo
                    JOptionPane.showMessageDialog(null,"Ha elegido crear un campo de cultivo");
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
                    JOptionPane.showMessageDialog(null, "Ha elegido desplegar la informacion general de los campos de cultivo");
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
                            do{
                                try{
                            eleccionAdministrarCampo = Integer.parseInt(JOptionPane.showInputDialog(
                            "Menu de administracion del campo :\n"
                            + "ID:{"+campito.getId()+"} Nombre:{"+campito.getNombreCampoCultivo()+"}\n\n"
                                
                            +"1. Elegir cultivo para sembrar\n"
                            +"2. Revision de Eras y campo de cultivo (submenu)\n"
                            +"3. Limpiar terreno\n"// quitar maleza
                            +"4. Abonar y enriquecer la tierra\n" 
                            +"5. Airear terreno\n" 
                            +"6. Agregar pestizida\n"
                            +"7. Revisar estado de la tierra\n"
                            +"8. Salir\n"));}catch(Exception e){eleccionAdministrarCampo=0;}
                    
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
                                    JOptionPane.showMessageDialog(null, "Ha escogido revisar campo de cultivo y las eras");
                                    int selector_deVisualizacion =0;
                                    int salirEscanearCampodeCultivoEras =7;
                                    do{

                                    selector_deVisualizacion = Integer.parseInt(JOptionPane.showInputDialog("Menu de revision de Eras :\n"
                                    + "ID:{"+campito.getId()+"} Nombre:{"+campito.getNombreCampoCultivo()+"}\n\n"
                                
                                    +"1. Revisar aireacion, humedad y PH\n"//se ve en la lista de eras
                                    +"2. Revisar Plagas\n"//se ve en la lista de eras
                                    +"3. Revisar Minerales\n"//se ve en la lista de eras
                                    +"4. Revisar tipo de suelo de cada era\n"//se ve en la lista de eras
                                    +"5. Revisar tipo de cultivo actual, fecha de siembra y cosecha y cuantos dias faltan para recoger la cosecha\n"//se se jala del objeto campito
                                    +"6. Revisar drenaje e irrigacion de campo de cultivo\n"//se se jala del objeto campito
                                    +"7. Salir\n"));
                                    
                                   
                                            if(!(selector_deVisualizacion==salirEscanearCampodeCultivoEras)&&!(selector_deVisualizacion>=5)){
                                            campito.getListaEras().mostarLista(selector_deVisualizacion);
                                            }else if(selector_deVisualizacion<salirEscanearCampodeCultivoEras ){
                                                switch(selector_deVisualizacion){
                                                    case 5:
                                                        JOptionPane.showMessageDialog(null, "Nombre de campo de cultivo: [" + campito.getNombreCampoCultivo()+"]\n"
                                                                + "ID del campo de cultivo: [" + campito.getId()+"]\n"
                                                                + "Tipo de cultivo:["+campito.getTipoCultivo()+"] \n"
                                                                + "falta poner la fecha de siembra y la fecha esperada de cosecha y los dias que hacen falta a partir de la fecha de hoy");
                                                        break;
                                                    case 6:
                                                        JOptionPane.showMessageDialog(null, "Nombre de campo de cultivo: [" + campito.getNombreCampoCultivo()+"]\n"
                                                                + "ID del campo de cultivo: [" + campito.getId()+"]\n"
                                                                + "Tiene drenaje:["+campito.isTienedrenaje()+"] \n"
                                                                + "Tiene irrigacion:["+campito.isTieneAgua()+"] \n");
                                                        break;
                                                }
                                            }
                                    }while(!(selector_deVisualizacion==salirEscanearCampodeCultivoEras));
                                    JOptionPane.showMessageDialog(null, "Sale al menu de administracion de campo de cultivo");

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
                                    JOptionPane.showMessageDialog(null, "salir al menu principal");
                                break;
                                
                                default:
                                ////MenuPrincipal/3.Administrar cultivos/ default:salir a menu principal
                                    JOptionPane.showMessageDialog(null, "Digite una opcion valida");
                                break;
                            
                            
                            }
                        }while(!(eleccionAdministrarCampo==8));
                            
                        
                    
                        }else{
                            JOptionPane.showMessageDialog(null, "El campo que busca no existe...\n"
                            + "salir al menu principal");
                            
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
                    JOptionPane.showMessageDialog(null, "Cerrando Sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, " Digite alguna opcion valida");
                    break;                    
                
            }
            
        }while(opcionMainMenu != 5);
    }
        
}
    


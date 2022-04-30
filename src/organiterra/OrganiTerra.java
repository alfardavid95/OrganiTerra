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
import Nodos.NodoArmarioHerramientas;
import Nodos.NodoCosechas;
import java.lang.invoke.MethodHandles;


public class OrganiTerra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws ParseException{
        // TODO code application logic here
                int opcionMainMenu;
                int opcionInterna;
                int IntCantidadEras;
                Calendar fechaDeHoy = Calendar.getInstance();
                String tipoCultivo;
                int cantEras;
                int cantidadEras;
                String nombreCampoCultivo;
                int idCultivo=1000;
                ListaDoblementeEnlazadaCamposCultivo listaCultivos = new ListaDoblementeEnlazadaCamposCultivo();
                PilaArmarioHerramientas armario = new PilaArmarioHerramientas();
                ColaCosechas MostrarCosecha = new ColaCosechas();
                CampoCultivo campito = null;
                int eleccionAdministrarCampo =0;
                int idCosecha = 10000;

        do{
            try{
            opcionMainMenu=Integer.parseInt(JOptionPane.showInputDialog(""
                    + "Menu Principal:\n"
                    + "1. Crear campo de cultivo nuevo\n"
                    + "2. Verificar informacion general de campos de cultivo \n"//aca muestra en una lista enlazada 
                    + "3. Admistrar campo de cultivo (sub-menu)\n"
                    + "4. Eliminar campo de cultivo\n"
                    + "5. Incrementar la fecha de hoy (Demostracion)\n"
                    + "6. Armario de Herramientas\n"
                    + "7. Mostrar Cola de Cosechas\n"
                    + "8. Salir de sistema"));}catch(Exception e){opcionMainMenu=0;}
            
            switch(opcionMainMenu ){
                case 1:
                    //Menu Principal/1.Crear campo de cultivo nuevo
                    JOptionPane.showMessageDialog(null,"Ha elegido crear un campo de cultivo");
                    
                    Date dateCreacionTerreno = fechaDeHoy.getTime();
                    
                    nombreCampoCultivo = JOptionPane.showInputDialog("Digite el nombre de campo del campo cultivo");
                    
                    
                    cantEras=Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de Eras"));
                    CampoCultivo campitoCultivo = new CampoCultivo(nombreCampoCultivo, idCultivo, dateCreacionTerreno,cantEras);
                    idCultivo++;
                    
                    
                     try{
                    listaCultivos.AgregarAlInicio(campitoCultivo);}catch(Exception e){listaCultivos.agregarAlFinal(campitoCultivo); };
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "El campo de cultivo creado es:\n"
                            + "Nombre: {"+campitoCultivo.getNombreCampoCultivo()+"}\n"
                                    + "ID: {"+campitoCultivo.getId()+"}\n"
                                            + "Cantidad de eras: {"+campitoCultivo.getCantidadEras()+"}");
                    break; 
                    
                case 2:
                    //Menu Principal/ 2.Verificar informacion de campo de cultivo o eras
                    JOptionPane.showMessageDialog(null, "Ha elegido desplegar la informacion general de los campos de cultivo");
                    // aca tiene que ir un display que muestre todos los campos de cultivos existentes (ojala en una lista enlazada simple con todos los campos que vaya sumandose como un string)
                    //y que muestre el nombre del campo de cultivo, el id del campo de cultivo, si tiene sembrado algo, que cultivo tiene sembrado si tiene algo sembrado y cuando es la fecha de la cosecha, y cuantos dias faltan
                    //if(!listaCultivos.estaVacia()){
                   
                        listaCultivos.MostrarDeInicioAFin();
                    
   
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
                            ListaCircularSimpleEras listitaErasDelCampitoSeleccionado=campito.getListaEras();
                            JOptionPane.showMessageDialog(null,"Su campo de cultivo si existe");
                            do{
                                try{
                            eleccionAdministrarCampo = Integer.parseInt(JOptionPane.showInputDialog(
                            "Menu de administracion del campo :\n"
                            + "ID:{"+campito.getId()+"} Nombre:{"+campito.getNombreCampoCultivo()+"}\n\n"
                                
                            +"1. Ejecutar cambios a las eras y campo de cultivo(submenu)\n"
                            +"2. Revision de Eras y campo de cultivo (submenu)\n"
                            +"3. Salir al menu principal\n"));}catch(Exception e){eleccionAdministrarCampo=0;}
                    
                            switch(eleccionAdministrarCampo){
                                case 1://MenuPrincipal/3.Administrar cultivos/1. Ejecutar cambios a las Eras y al campo de cultivo(submenu)
                                    int eleccionEjecutarcambiosErasYcampo=0;
                                    JOptionPane.showMessageDialog(null, "He elegido realizar cambios a las eras y el campo");
                                    do{
                                       try{
                                    eleccionEjecutarcambiosErasYcampo=Integer.parseInt(JOptionPane.showInputDialog("Ejecutar cambios a las eras y campo de cultivo\n"
                                            + "1.Escoger tipo de cultivo que se va a cultivar en el campo\n"
                                            + "2.Airear terreno\n"
                                            + "3.Abonar la tierra (submenu)\n"
                                            + "4.Agregar pestizida (submenu)\n"
                                            + "5.Agregar agua\n"
                                            + "6.Sembrar campo\n"
                                            + "7.Cosechar campo\n"
                                            + "8.Salir al menu de administracion\n"));
                                    }catch(Exception e){eleccionAdministrarCampo=0;}
                                    
                                    switch (eleccionEjecutarcambiosErasYcampo){
                                        case 1: //MenuPrincipal/3.Administrar cultivos/1. Ejecutar cambios a las Eras y Terreno(submenu)/1.Elija tipo de cultivo
                                            if(!campito.isEstaSembrado()){
                                            int opcionTipoCultiivo =0;
                                            do{
                                                try{
                                                opcionTipoCultiivo =Integer.parseInt(JOptionPane.showInputDialog("Elija el tipo de cultivo\n"
                                                + "1:Papa\n"
                                                + "2.Sandia\n"
                                                + "3.Melon\n"
                                                + "4.Zanahoria\n"
                                                + "5.Trigo\n"
                                                + "6.Fresa\n"));
                                                }catch(Exception e){eleccionAdministrarCampo=0;}
                    
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
                                                JOptionPane.showMessageDialog(null, "Ha elegido el cultivo que desea cultivar: {"+tipoCultivo+"}");
                                                campito.setTipoCultivo(tipoCultivo);
                                                listaCultivos.SobreescribirDatoEnLista(campito);
                                            }else{
                                            JOptionPane.showMessageDialog(null, "Tiene que escoger un tipo de cultivo valido");
                                            }
                                            }while((opcionTipoCultiivo>=7)||(opcionTipoCultiivo<=0));
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Ya el campo de cultivo esta sembrado");
                                            }
                                        break;
                                        
                                        case 2://MenuPrincipal/3.Administrar cultivos/1. Ejecutar cambios a las Eras y Terreno(submenu)/2.Airear terreno
                                            listitaErasDelCampitoSeleccionado.incrementarAireacion();          
                                        break;
                                        case 3:
                                            //MenuPrincipal/3.Administrar cultivos/1. Ejecutar cambios a las Eras y Terreno(submenu)/3. abonar el terreno(submenu)
                                            int sleccionMineralaAbonar=0;
                                            JOptionPane.showMessageDialog(null, "Va a entrar al submenu de abonos para incrementar minerales");
                                            do{
                                                try{
                                                    sleccionMineralaAbonar=Integer.parseInt(JOptionPane.showInputDialog("Seleccione el mineral que desea incrementar la concentracion\n"
                                                        + "1.Calcio\n"
                                                        + "2.Nitrogeno\n"
                                                        + "3.Potasio\n"
                                                        + "4.Magnesio\n"
                                                        + "5.Hierro\n"
                                                        + "6.Azufre\n"
                                                        + "7.Zinc\n"
                                                        + "8.Fosforo\n"
                                                        + "9.Boro\n"
                                                        + "10.Salir al menu de ejecucion de cambios de Eras y Campo de cultivo\n"));
                                                    listitaErasDelCampitoSeleccionado.incrementarMinerales(sleccionMineralaAbonar);
                                                }catch(Exception e){eleccionAdministrarCampo=0;}
                                            }while(!(sleccionMineralaAbonar==10));
                                        break;
                                        case 4:
                                            //MenuPrincipal/3.Administrar cultivos/1. Ejecutar cambios a las Eras y Terreno(submenu)/4. agregar insecticida(submenu)
                                            
                                            
                                            int selectorPesticida=0;
                                            JOptionPane.showMessageDialog(null, "Va a entrar al submenu de agregar pesticida");
                                            do{
                                                try{
                                                    selectorPesticida=Integer.parseInt(JOptionPane.showInputDialog("Seleccione el mineral que desea incrementar la concentracion\n"
                                                        + "1.herbicida\n"
                                                        + "2.fungicida\n"
                                                        + "3.insecticida\n"
                                                        + "4.Salir al menu de ejecucion de cambios de Eras y Campo de cultivo"));
                                                    }catch(Exception e){selectorPesticida=0;}
                                                    switch(selectorPesticida){
                                                        case 1:
                                                            JOptionPane.showMessageDialog(null, "Esto muestra el estatus actual antes de poner herbicida antes de ser aplicado a ver si hay hierbas");
                                                            listitaErasDelCampitoSeleccionado.mostarLista(2);
                                                            JOptionPane.showMessageDialog(null, "Ha seleccionado poner herbicida");
                                                            break;
                                                        case 2:
                                                            JOptionPane.showMessageDialog(null, "Esto muestra el estatus actual antes de poner fungicida antes de ser aplicado a ver si hay hongos");
                                                            listitaErasDelCampitoSeleccionado.mostarLista(2);
                                                            JOptionPane.showMessageDialog(null, "Ha seleccionado poner fungicida");
                                                            break;
                                                        case 3:
                                                            JOptionPane.showMessageDialog(null, "Esto muestra el estatus actual antes de poner insecticida antes de ser aplicado a ver si hay bichos");
                                                            listitaErasDelCampitoSeleccionado.mostarLista(2);
                                                            JOptionPane.showMessageDialog(null, "Ha seleccionado poner insecticida");
                                                            break;
                                                        case 4:
                                                            JOptionPane.showMessageDialog(null, "Ha decidido regresar al menu de ejecucion de eras y campos de cultivo");
                                                            break;
                                                        default:
                                                            JOptionPane.showMessageDialog(null, "Digite una opcion valida");
                                                            break;
                                                    }
                                                    if(selectorPesticida>=1&& selectorPesticida<=3){  
                                                        listitaErasDelCampitoSeleccionado.AgregarPesticida(selectorPesticida);
                                                    }
                                                
                                            }while(!(selectorPesticida==4));
                                                     
                                        break;
                                        case 5:
                                            //MenuPrincipal/3.Administrar cultivos/1. Ejecutar cambios a las Eras y Terreno(submenu)/5. agregar agua
                                            if(campito.isTieneAgua()&&campito.isTienedrenaje()){
                                                listitaErasDelCampitoSeleccionado.agregarAgua();
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Necesita poner un flujo de agua y drenaje en este campo."
                                                        + "\nDe no ser asi no va a poder incrementar la humedad.");
                                                int selectoragua =0;
                                                do{
                                                    try{
                                                selectoragua=Integer.parseInt(JOptionPane.showInputDialog("Desea conectar las fuentes de agua\n"
                                                        + "1.Poner drenaje\n"
                                                        + "2.Poner fuente de agua\n"
                                                        + "3.Mostrar estado del agua y drenaje en el campo\n"
                                                        + "4.Agregar humedad a las eras\n"
                                                        + "5.Salir al menu de ejecucion de cambios de Eras y Campo de cultivo\n"));
                                                }catch(Exception e){selectorPesticida=0;}
                                                switch (selectoragua){
                                                    case 1:
                                                        JOptionPane.showMessageDialog(null, "Activa el drenaje");
                                                        campito.setTienedrenaje(true);
                                                    break;
                                                    case 2:
                                                        JOptionPane.showMessageDialog(null, "Activa la toma de agua");
                                                        campito.setTieneAgua(true);
                                                    break;
                                                    case 3:
                                                        JOptionPane.showMessageDialog(null, "Estatus del agua en el campo {"+campito.getNombreCampoCultivo()+"} con el ID {"+campito.getId()+"}\n"
                                                                + "Tiene drenaje ["+campito.isTienedrenaje()+"]\n"
                                                                + "Tiene agua ["+campito.isTieneAgua()+"]");
                                                    break;
                                                    case 4:
                                                        if (campito.isTieneAgua()&&campito.isTienedrenaje()){
                                                            listitaErasDelCampitoSeleccionado.agregarAgua();
                                                        }else{
                                                            JOptionPane.showMessageDialog(null, "Necesita poner un flujo de agua y drenaje en este campo."
                                                        + "\nDe no ser asi no va a poder incrementar la humedad.");
                                                        }
                                                    break;
                                                    case 5:
                                                        JOptionPane.showMessageDialog(null, "Salir al menu de seleccion de ejecucion de cambio de eras y campos de cultivo");
                                                    break;
                                                    default:
                                                        JOptionPane.showMessageDialog(null, "Digite una opcion valida de seleccion de agua");
                                                    break;
                                                }
                                                
                                                }while(!(selectoragua==5)); 
                                            }
                                            
                                            
                                        break;
                                        case 6:
                                            //MenuPrincipal/3.Administrar cultivos/1. Ejecutar cambios a las Eras y Terreno(submenu)/6. sembrar
                                            if(!campito.isEstaSembrado()){
                                                
                                            
                                            boolean bypass = true;
                                            boolean tieneSistemaAgua =false;
                                            boolean tieneCultivoDefinido= false;
                                            boolean noHayplagasEnLasEras= false;
                                            boolean noHaceFaltaAbono= false;
                                            boolean noTieneMalaAireacion = false;
                                            boolean noTieneMalaHumedad = false;
                                            String cosasQueHacenFaltaParaSembrar = "";
                                            
                                            //aca se revisa que el sistema de agua este presente
                                            if(campito.isTieneAgua()&&campito.isTienedrenaje()){
                                                tieneSistemaAgua=true;
                                            }else{
                                                cosasQueHacenFaltaParaSembrar=cosasQueHacenFaltaParaSembrar+"++El sistema de agua y drenaje no esta listo y es posible que falte hidratacion en la tierra\n";
                                            }
                                            //aca se revisa que haya un tipo de cultivo definido
                                            if(!(campito.getTipoCultivo().equals(""))){
                                                System.out.println("campito.tipocultivo = {"+campito.getTipoCultivo()+"}<-----" );
                                                tieneCultivoDefinido =true;
                                                
                                            }else{
                                                cosasQueHacenFaltaParaSembrar=cosasQueHacenFaltaParaSembrar+"++El tipo de cultivo no esta definido\n";
                                            }
                                            //aca se revisa que no haya plagas en ninguna de las eras
                                            if(listitaErasDelCampitoSeleccionado.revisionHayPlagasEnLasEras()){
                                                noHayplagasEnLasEras = true;
                                            }else{
                                                cosasQueHacenFaltaParaSembrar=cosasQueHacenFaltaParaSembrar+"++Hay plagas presentes en las eras\n";
                                            }
                                            //aca se revisa todos los minerales a ver que no haga falta nada 
                                            if(listitaErasDelCampitoSeleccionado.revisionNoHacenFaltaMinerales(campito.getCantidadEras())){
                                                noHaceFaltaAbono =true;
                                            }else{
                                                cosasQueHacenFaltaParaSembrar=cosasQueHacenFaltaParaSembrar+"++Hace falta que los minerales esten por arriba del 85\n";
                                            }
                                            //aca comprueba en todas las eras a ver si tiene aireacion mas alla del 85
                                            if(!listitaErasDelCampitoSeleccionado.tieneMalaAireacionEnEras(campito.getCantidadEras())){
                                                noTieneMalaAireacion = true;
                                            }else{
                                                cosasQueHacenFaltaParaSembrar=cosasQueHacenFaltaParaSembrar+"++Hay mal nivel de aireacion de la tierra, es menor de 85, debe tener un valor superior a 85\n";
                                            }
                                            //aca comprueba en todas las eras a ver si tiene humedad mas alla del 85
                                            if(!listitaErasDelCampitoSeleccionado.tieneMalaHumedad(campito.getCantidadEras())){
                                                noTieneMalaHumedad = true;
                                            }else{
                                                cosasQueHacenFaltaParaSembrar=cosasQueHacenFaltaParaSembrar+"++Hay mal nivel de humedad de la tierra, es menor de 85, debe tener un valor superior a 85\n";
                                            }
                                             
                                            //cuando tenga todos estos voy a hacer un if que permita sembrar si se cumplen todas estas condiciones
                                            System.out.println("\n\nIf para poder Sembrar"
                                                    + "noTieneMalaHumedad(true)= " +noTieneMalaHumedad+ "\n"
                                                    + "noTieneMalaAireacion(true) = "+ noTieneMalaAireacion +"\n"
                                                    + "noHaceFaltaAbono(true) = "+ noHaceFaltaAbono+"\n"
                                                    + "noHayplagasEnLasEras(true) = "+noHayplagasEnLasEras+"\n"
                                                    + "tieneCultivoDefinido(true) = " +tieneCultivoDefinido+"\n"
                                                    + "tieneSistemaAgua (true) = " +tieneSistemaAgua+ "\n" );
                                            
                                            
                                            if ((tieneSistemaAgua&&noHayplagasEnLasEras&&tieneCultivoDefinido&&noHaceFaltaAbono&&noTieneMalaAireacion&&noTieneMalaHumedad)|| bypass){
                                                JOptionPane.showMessageDialog(null, "Si puede sembrar el cultivo");
                                                
                                                   
                                                Cosecha cosechita1 = new Cosecha(idCosecha);//creo una instancia de cosecha y solo le pongo el ID
                                                campito.setCosechita(cosechita1);//agrego la instancia nueva de cosecha y la inserto a campo
                                                idCosecha++;//incremento el ID de las cosechas para que cada una sea unica
                                                campito.getCosechita().setNombreCampoCultivo(campito.getNombreCampoCultivo());
                                                campito.getCosechita().setIdcampoCultivo(campito.getId());
                                                
                                                Calendar fechaDeCosecha= (Calendar)fechaDeHoy.clone();// aca igualo la fechade cosecha de la fecha de hoy con la de la cosecha creando otra instancia para cosecha para despues incrementar los valores de cosecha
                                                Date dateSetFechaSiembra = fechaDeHoy.getTime(); //aca tomamos el valor de calendar de fecha de Hoy y lo convertimos en Date
                                                campito.getCosechita().setFechacultivo(dateSetFechaSiembra);//aca asigno el valor de la fecha de siembra a la cosecha
                                                
                                                //agrego la fecha de cosecha al campo de cultivo depende del cultivo sembrado
                                                //si el cultivo es papa, sandia, melon o zanahoria dura 90 dias ,si no dura 70
                                                if((campito.getTipoCultivo().equals("Papa"))||(campito.getTipoCultivo().equals("Sandia"))||(campito.getTipoCultivo().equals("Zanahoria"))||(campito.getTipoCultivo().equals("Melon"))){
                                                    
                                                    fechaDeCosecha.add(Calendar.DATE, 90);// defino la fecha de la cosecha en 90 dias a partir de hoy 

                                                }else{
                                                    fechaDeCosecha.add(Calendar.DATE, 70);// defino la fecha de la cosecha en 70 dias
                                                }
                                                    
                                                    Date dateFechaCosecha = fechaDeCosecha.getTime();//aca solo jala la fecha cosecha en calendar a convertirla a Date
                                                    campito.getCosechita().setFechacosecha(dateFechaCosecha);//aca le pone la fecha de la cosecha al campo
                                                    
                                                //agrego el estado de estar sembrado al campo de cultivo
                                                campito.setEstaSembrado(true);
                                                //fecha de cosecha puesta
                                                System.out.println("fecha siembra = " + campito.getCosechita().getFechacultivo());
                                                System.out.println("fecha cosecha = " + campito.getCosechita().getFechacosecha());
                                                
                                                
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Aun no puede sembrar\n"
                                                        + "Revisiones que hacer antes de sembrar:\n"
                                                        + cosasQueHacenFaltaParaSembrar);
                                            }
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Ya se encuentra sembrado, debe esperar a la cosecha para volver a Sembrar");
                                            }
                                        break;
                                        case 7:
                                            //MenuPrincipal/3.Administrar cultivos/1. Ejecutar cambios a las Eras y Terreno(submenu)/6. cosechar
                                            //si la fecha actual es menor que le fecha de la cosecha no se puede cosechar
                                            if(campito.isEstaSembrado()){
                                                Date dateCosecha = campito.getCosechita().getFechacosecha();//llamamos a la fecha de la cosecha del campo
                                                Calendar fechaCalendarCosecha=convertDatetoCalendar(dateCosecha);//la convertimos en tipo calendar
                                            
                                            
                                            
                                            if(fechaDeHoy.after(fechaCalendarCosecha)){
                                                JOptionPane.showMessageDialog(null, "Si puede cosechar");
                                                int cantidadKilosCultivo = 0;//inicializa la cantida de kilos a recoger
                                                Date fechaDeRecogida=fechaDeHoy.getTime();//toma la fecha del dia del que se hace la recogida
                                                campito.getCosechita().setFechaRecogida(fechaDeRecogida);//guarda el dia donde se hace la recogida
                                                listitaErasDelCampitoSeleccionado=campito.getListaEras();//agarra referencia al las eras
                                                campito.getCosechita().setTipoCultivo(campito.getTipoCultivo());//agarra el tipo de cultivo del campo y lo agrega a la cosecha
                                                
                                                //si el suelo es arcilloso para papa sandia zanahoria o melon da 50 kilos
                                                if ((campito.getTipoCultivo().equals("Papa")||campito.getTipoCultivo().equals("Sandia")||campito.getTipoCultivo().equals("Zanahoria")||campito.getTipoCultivo().equals("Melon"))){
                                                    
                                                     cantidadKilosCultivo=campito.getListaEras().devolverKilosdeCultivo(1);
                                                    
                                                }else{
                                                    cantidadKilosCultivo=campito.getListaEras().devolverKilosdeCultivo(2);
                                                }
                                                campito.getCosechita().setCantidadKilos(cantidadKilosCultivo);
                                                JOptionPane.showMessageDialog(null, "Estadisticas de la cosecha:\n"
                                                        + "La cosecha con el ID:{"+campito.getCosechita().getIdCosecha()+"}\n"
                                                        + "La cosecha se realizo en el campo con el nombre {"+campito.getNombreCampoCultivo()+"}\n"
                                                        + "La cosecha se realizo en el campo de cultivo con el ID: {"+campito.getId()+"}\n"
                                                        + "Se recogieron {"+campito.getCosechita().getCantidadKilos()+"}\n"
                                                        + "Tipo cultivo {"+campito.getCosechita().getTipoCultivo()+"}\n"
                                                        + "La fecha de siembra fue {"+campito.getCosechita().getFechacultivo()+"}\n"
                                                        + "La fecha estimada para la cosecha es{"+campito.getCosechita().getFechacosecha()+"}\n"
                                                        + "La fecha cuando fue recogido es de {"+campito.getCosechita().getFechaRecogida()+"}\n");
                                                
                                                      MostrarCosecha.enCola(new NodoCosechas(campito.getCosechita()));
                                                campito.setEstaSembrado(false);//ya la era dejo de estar sembrada
                                                //
                                            }else if (campito.isEstaSembrado()){
                                                JOptionPane.showMessageDialog(null, "Aun debe esperar la cosecha pero ya esta sembrado\n"
                                                                + "La fecha de hoy es: {"+fechaDeHoy.getTime()+"}\n"
                                                                + "La fecha de cosecha debe ser mayor a {"+campito.getCosechita().getFechacosecha()+"}");
                                            }
                                            }else{
                                                JOptionPane.showMessageDialog(null, "No se puede cosechar aun por que no se ha sembrado...");
                            
                                            }
                          
                                        break;
                                        case 8:
                                            JOptionPane.showMessageDialog(null, "Sale al menu de administracion de campo de cultivo");
                                        break;
                                        default:
                                            JOptionPane.showMessageDialog(null, "Digite una opcion valida");
                                        break;
                                    }
                                    
                                    }while(!(eleccionEjecutarcambiosErasYcampo==8));
                                        
                                break;
                                case 2:
                                    //2. //MenuPrincipal /3.Administrar cultivos/2.Escanear campo de cultivo y las eras
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
                                    +"5. Revisar tipo de cultivo actual, fecha de siembra y cosecha y estado de siembra\n"//se se jala del objeto campito y campito.cosecha
                                    +"6. Revisar drenaje e irrigacion de campo de cultivo\n"//se se jala del objeto campito
                                    +"7. Salir al menu de administracion de campo\n"));
                                    
                                   
                                            if(!(selector_deVisualizacion==salirEscanearCampodeCultivoEras)&&!(selector_deVisualizacion>=5)){
                                                campito.getListaEras().mostarLista(selector_deVisualizacion);
                                            }else if(selector_deVisualizacion<salirEscanearCampodeCultivoEras ){
                                                switch(selector_deVisualizacion){
                                                    case 5:
                                                        String mostarInfo = "";
                                                        mostarInfo = "Nombre de campo de cultivo: [" + campito.getNombreCampoCultivo()+"]\n"
                                                                + "ID del campo de cultivo: [" + campito.getId()+"]\n"
                                                                + "Tipo de cultivo:["+campito.getTipoCultivo()+"] \n";
                                                        if(campito.isEstaSembrado()){
                                                            mostarInfo= mostarInfo + "Fecha de siembra ["+campito.getCosechita().getFechacultivo()+"]\n"
                                                                + "Fecha de cosecha ["+campito.getCosechita().getFechacosecha()+"]\n";
                                                        }
                                                        mostarInfo=mostarInfo+"Esta sembrado: ["+campito.isEstaSembrado()+"]\n";
                                                        
                                                        JOptionPane.showMessageDialog(null, mostarInfo);
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
                                ////MenuPrincipal/3.Administrar cultivos/3. csalir al menu principal
                                    JOptionPane.showMessageDialog(null, "Salir al menu principal");
                                break;
                                
                                default:
                                ////MenuPrincipal/3.Administrar cultivos/ default:salir a menu principal
                                    JOptionPane.showMessageDialog(null, "Digite una opcion valida");
                                break;
                            
                            
                            }
                        }while(!(eleccionAdministrarCampo==3));
                            
                        
                    
                        }else{
                            JOptionPane.showMessageDialog(null, "El campo con ese ID  que busca no existe...\n"
                            + "Salir al menu principal");
                            
                        }

                    }else{
                        JOptionPane.showMessageDialog(null, "Lista de campos de cultivo esta vacia\n"
                        + "Salir al menu principal");
                    }
                        
                    break;
                case 4:
                    //Menu Principal /4.Eliminar campo de cultivo
                    JOptionPane.showMessageDialog(null, "Ha escogido eliminar un campo de cultivo");
                    if(!listaCultivos.estaVacia()){
                        JOptionPane.showMessageDialog(null, "La lista si tiene elementos");
                        
                                int idEliminar=Integer.parseInt(JOptionPane.showInputDialog(""
                            + "Escoger el ID del campo de cultivo a eliminar"));
                                listaCultivos.eliminarConID(idEliminar);//aca se le manda el id y se borra en la lista
                        
                    }else{
                       JOptionPane.showMessageDialog(null, "La lista no tiene elementos");
                    }
                    break;
                case 5:
                    Date fechaDateHoy=fechaDeHoy.getTime();
                    
                    JOptionPane.showMessageDialog(null, "Fecha de hoy antes del cambio: " +fechaDateHoy);
                    int diasAIncrementar;
                    do{
                    diasAIncrementar=Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de dias que va a incrementar"));
                    if(diasAIncrementar < 1){JOptionPane.showMessageDialog(null, "Valor no valido...");}}while(diasAIncrementar <1);
                    
                    fechaDeHoy.add(Calendar.DATE, diasAIncrementar);
                    fechaDateHoy=fechaDeHoy.getTime();
                    JOptionPane.showMessageDialog(null, "Fecha de hoy despues del cambio: " +fechaDateHoy);
                    break;
                case 6:
                    int cajaOpcion=0;
                    do{
                    do{
                         try{
                    cajaOpcion=Integer.parseInt(JOptionPane.showInputDialog(
                            
                    "1. Agregar Objeto o Herramienta al Armario\n"+
                    "2. Sacar ultimo Objeto o Herramienta agregado al Armario\n"+
                    "3. Atras"));}catch(Exception e){}
                    
                    if(cajaOpcion < 1){JOptionPane.showMessageDialog(null, "Elija una opcion validad...");}
                    if(cajaOpcion > 3){JOptionPane.showMessageDialog(null, "Elija una opcion validad...");}
                    
                    }while(cajaOpcion <1 || cajaOpcion >3);
                    /////////////////////////////////////////////////////////////////////////////
                    
                    switch (cajaOpcion) {
                        case 1:
                            armario.push(new NodoArmarioHerramientas(JOptionPane.showInputDialog("Ingrese Nombre del Objeto/Herramienta que desea agregar")));
                            JOptionPane.showMessageDialog(null,"Agregado con exito!");
                            break;
                        case 2:
                            
                            NodoArmarioHerramientas herramienta=armario.pop();
                            
                           if(herramienta == null){}else{
                               
                            JOptionPane.showMessageDialog(null,"    >>> Objeto sacado del armario <<<\n\n"
                            +"        🡆🡆 "+herramienta.getObjeto()+" ");}
                            
                    }
                    }while(cajaOpcion != 3);
                    //////////////////////////////////////////////////////////////////////////////
                    break;
                    
                case 7:
                   if (!MostrarCosecha.ColaVacia()){
                     NodoCosechas cosechha=MostrarCosecha.atiende();
                    
                    JOptionPane.showMessageDialog(null, "Estadisticas de la cosecha:\n"
                                                        + "La cosecha con el ID:{"+cosechha.getCosechita().getIdCosecha()+"}\n"
                                                        + "La cosecha se realizo en el campo con el nombre {"+cosechha.getCosechita().getNombreCampoCultivo()+"}\n"
                                                        + "La cosecha se realizo en el campo de cultivo con el ID: {"+cosechha.getCosechita().getIdcampoCultivo()+"}\n"
                                                        + "Se recogieron {"+cosechha.getCosechita().getCantidadKilos()+"}\n"
                                                        + "Tipo cultivo {"+campito.getCosechita().getTipoCultivo()+"}\n"
                                                        + "La fecha de siembra fue {"+cosechha.getCosechita().getFechacultivo()+"}\n"
                                                        + "La fecha estimada para la cosecha es{"+cosechha.getCosechita().getFechacosecha()+"}\n"
                                                        + "La fecha cuando fue recogido es de {"+cosechha.getCosechita().getFechaRecogida()+"}\n");
                    
                    
                              
                   }
                    
                   
                       break;     
                    
                case 8:
                    //5.Salir
                    JOptionPane.showMessageDialog(null, "Cerrando aplicación...");
                    
                    break;
                default:
                    JOptionPane.showMessageDialog(null, " Digite alguna opcion valida");
                    break;                    
                
            }
            
        }while(opcionMainMenu != 8);
    }
    public static Calendar convertDatetoCalendar(Date d){                                     
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);                                 
        return   cal;
    }
        
}
    


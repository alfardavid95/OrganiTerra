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
                            + "Tiene las siguientes concentraciones de minerales:\n"
                            + "Concentracion de Calcio [" +aux.getDato().getCalcio()+"]\n"
                            + "Concentracion de Nitrogeno["+aux.getDato().getNitrogeno()+"]\n"
                            + "Concentracion de Potasio["+aux.getDato().getPotasio()+"]\n"
                            + "Concentracion de Magnesio["+aux.getDato().getMagnesio()+"]\n"
                            + "Concentracion de Hierro["+aux.getDato().getHierro()+"]\n"
                            + "Concentracion de Azufre["+aux.getDato().getAzufre()+"]\n"
                            + "Concentracion de Zinc["+aux.getDato().getZinc()+"]\n"
                            + "Concentracion de Fosforo["+aux.getDato().getFosforo()+"]\n"
                            + "Concentracion de Boro["+aux.getDato().getBoro()+"]\n";
                    
                            if(aux.getDato().getCalcio()<85|| aux.getDato().getNitrogeno()<85 || aux.getDato().getPotasio()<85 || aux.getDato().getMagnesio()<85||aux.getDato().getHierro()<85||
                                    aux.getDato().getAzufre()<85||aux.getDato().getZinc()<85||aux.getDato().getFosforo()<85||aux.getDato().getBoro()<85){
                                cadenaDeCaracteres = cadenaDeCaracteres + "Revise:";
                            }else{
                                cadenaDeCaracteres = cadenaDeCaracteres + "Concentracion saludable de minerales en esta era";
                            }
                            if(aux.getDato().getCalcio()<85){
                                cadenaDeCaracteres = cadenaDeCaracteres + "calcio, ";
                            }
                            if(aux.getDato().getNitrogeno()<85){
                                cadenaDeCaracteres = cadenaDeCaracteres + "Nitrogeno, ";
                            }
                            if(aux.getDato().getPotasio()<85){
                                cadenaDeCaracteres = cadenaDeCaracteres + "Potasio, ";
                            }
                            if(aux.getDato().getMagnesio()<85){
                                cadenaDeCaracteres = cadenaDeCaracteres + "Magnesio, ";
                            }
                            if(aux.getDato().getHierro()<85){
                                cadenaDeCaracteres = cadenaDeCaracteres + "Hierro, ";
                            }
                            if(aux.getDato().getAzufre()<85){
                                cadenaDeCaracteres = cadenaDeCaracteres + "Azufre, ";
                            }
                            if(aux.getDato().getZinc()<85){
                                cadenaDeCaracteres = cadenaDeCaracteres + "Zinc, ";
                            }
                            if(aux.getDato().getFosforo()<85){
                                cadenaDeCaracteres = cadenaDeCaracteres + "Fosforo, ";
                            }
                            if(aux.getDato().getBoro()<85){
                                cadenaDeCaracteres = cadenaDeCaracteres + "Boro, ";
                            }
                            cadenaDeCaracteres = cadenaDeCaracteres + "\n\n";
                            
                            
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
    public int devolverKilosdeCultivo(int identificador){
        int cantidadKIlosCultivo = 0;
        
        NodoEras aux;
        aux = ultimo.getNext();
        
        do {
            if(1==identificador){//si viene 1 significa que son melon sandia papa o zanahoria
                System.out.println("identificador de tipo de cultivo por kilo"+ identificador);
                System.out.println("tipo de suelo:"+ aux.getDato().getTiposuelo()+"\n"
                                + "cantidad de kilos antes de salir del while "+ cantidadKIlosCultivo);
                if(aux.getDato().getTiposuelo().equals("arenoso")){
                    cantidadKIlosCultivo=cantidadKIlosCultivo+21;
                }else if(aux.getDato().getTiposuelo().equals("arcilloso")){
                    cantidadKIlosCultivo=cantidadKIlosCultivo+40;
                }
                
            }else{
                if(aux.getDato().getNivelDehumedad()>=95){
                    cantidadKIlosCultivo=cantidadKIlosCultivo+42;
                }else if(aux.getDato().getNivelDehumedad()>=90){
                    cantidadKIlosCultivo=cantidadKIlosCultivo+25;
                }
                else if (aux.getDato().getNivelDehumedad()<90 ){
                    cantidadKIlosCultivo=cantidadKIlosCultivo+13;
                }
            } 
            System.out.println("Cantidad Kilos Cultivo era "+ cantidadKIlosCultivo);
            aux=aux.getNext();
        }while(aux!=ultimo.getNext());
        
        return cantidadKIlosCultivo;
    }
    
    /*
    
    String tipoSueloDe=listitaErasDelCampitoSeleccionado.ultimo.getNext().getDato().getTiposuelo();
                                                        if (tipoSueloDe.equals("arenoso")){
                                                            cantidadKilos+=30;
                                                        }else if(tipoSueloDe.equals("arcilloso")){
                                                            cantidadKilos+=50;
                                                        }
    */
    
            
    
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
    
    public boolean revisionNoHacenFaltaMinerales(int cantEras){
        int valorMinimo=85;
        NodoEras aux;
        
        Boolean[] EstaBienDeCalcio = new Boolean[cantEras];
        Boolean[] EstaBienDenitrogeno = new Boolean[cantEras];
        Boolean[] EstaBienDePotasio = new Boolean[cantEras];
        Boolean[] EstaBienDeMagnesio = new Boolean[cantEras];
        Boolean[] EstaBienDeHierro = new Boolean[cantEras];
        Boolean[] EstaBienDeAzufre = new Boolean[cantEras];
        Boolean[] EstaBienDeZinc = new Boolean[cantEras];
        Boolean[] EstaBienDeFosforo = new Boolean[cantEras];
        Boolean[] EstaBienDeBoro = new Boolean[cantEras];
        
        
        boolean banderaEstaMalDeCalcio = false;
        boolean banderaEstamalDenitrogeno = false;
        boolean banderaEstaMalDePotasio = false;
        boolean banderaEstaMalDeMagnesio = false;
        boolean banderaEstaMalDeHierro = false;
        boolean banderaEstaMalDeAzufre = false;
        boolean banderaEstaMalDeZinc = false;
        boolean banderaEstaMalDeFosforo = false;
        boolean banderaEstaMalDeBoro = false;
        boolean noHaceFaltaMinerales =false;
        
        
        //revisar Calcio
        aux = ultimo.getNext();
        for (int i=0; i<cantEras; i++){
            if(aux.getDato().getCalcio()>=valorMinimo){
                EstaBienDeCalcio[i]=true;
                //System.out.println("calcio true");
            }else{
                EstaBienDeCalcio[i]=false;
               // System.out.println("calcio false");
            }
            aux= aux.getNext();
        }
        for (int i=0; i<cantEras; i++){
            if(EstaBienDeCalcio[i]==false){
                banderaEstaMalDeCalcio=true;
            }
            //System.out.println("EstaBienDeCalcio[i]= "+ EstaBienDeCalcio[i]+"\n"
            //        + "banderaMalCalcio = " + banderaEstaMalDeCalcio);
        }
        
        //revisar  nitrogeno
        aux = ultimo.getNext();
        for (int i=0; i<cantEras; i++){
            if(aux.getDato().getNitrogeno()>=valorMinimo){
                EstaBienDenitrogeno[i]=true;
               // System.out.println("nitrogeno true");
            }else{
                EstaBienDenitrogeno[i]=false;
               // System.out.println("nitrogeno false");
            }
            aux= aux.getNext();
        }
        for (int i=0; i<cantEras; i++){
            if(EstaBienDenitrogeno[i]==false){
                banderaEstamalDenitrogeno=true;
            }
            //System.out.println("EstaBienDeN[i]= "+ EstaBienDenitrogeno[i]+"\n"
            //        + "banderaMalN = " + banderaEstamalDenitrogeno);
        }
        
        //revisarPotasio
        aux = ultimo.getNext();
        for (int i=0; i<cantEras; i++){
            if(aux.getDato().getPotasio()>=valorMinimo){
                EstaBienDePotasio[i]=true;
                //System.out.println("potasio true");
            }else{
                EstaBienDePotasio[i]=false;
                //System.out.println("potasio false");
            }
            aux= aux.getNext();
        }
        for (int i=0; i<cantEras; i++){
            if(EstaBienDePotasio[i]==false){
                banderaEstaMalDePotasio=true;
            }
            //System.out.println("EstaBienDepotasio[i]= "+ EstaBienDePotasio[i]+"\n"
            //        + "banderaMalPotasio = " + banderaEstaMalDePotasio);
        }
        //revisar magnesio
        aux = ultimo.getNext();
        for (int i=0; i<cantEras; i++){
            if(aux.getDato().getMagnesio()>=valorMinimo){
                EstaBienDeMagnesio[i]=true;
                //System.out.println("magnesio true");
            }else{
                EstaBienDeMagnesio[i]=false;
                //System.out.println("magnesio false");
            }
            aux= aux.getNext();
        }
        for (int i=0; i<cantEras; i++){
            if(EstaBienDeMagnesio[i]==false){
                banderaEstaMalDeMagnesio=true;
            }
            //System.out.println("EstaBienDemagnesio[i]= "+ EstaBienDeMagnesio[i]+"\n"
                    //+ "banderaMalMagnesio = " + banderaEstaMalDeMagnesio);
        }
        //revisarHierro
        aux = ultimo.getNext();
        for (int i=0; i<cantEras; i++){
            if(aux.getDato().getHierro()>=valorMinimo){
                EstaBienDeHierro[i]=true;
                //System.out.println("hierro true");
            }else{
                EstaBienDeHierro[i]=false;
                //System.out.println("hierro false");
            }
            aux= aux.getNext();
        }
        for (int i=0; i<cantEras; i++){
            if(EstaBienDeHierro[i]==false){
                banderaEstaMalDeHierro=true;
            }
            //System.out.println("EstaBienDeHierro[i]= "+ EstaBienDeHierro[i]+"\n"
                    //+ "banderaMalHierro = " + banderaEstaMalDeHierro);
        }
        //revisar Azufre
        aux = ultimo.getNext();
        for (int i=0; i<cantEras; i++){
            if(aux.getDato().getAzufre()>=valorMinimo){
                EstaBienDeAzufre[i]=true;
                //System.out.println("azufre true");
            }else{
                EstaBienDeAzufre[i]=false;
                //System.out.println("azufre false");
            }
            aux= aux.getNext();
        }
        for (int i=0; i<cantEras; i++){
            if(EstaBienDeAzufre[i]==false){
                banderaEstaMalDeAzufre=true;
            }
            //System.out.println("EstaBienDeAzufre[i]= "+ EstaBienDeAzufre[i]+"\n"
                    //+ "banderaMalAzufre = " + banderaEstaMalDeAzufre);
        }
        
        //revisar Zinc
        aux = ultimo.getNext();
        for (int i=0; i<cantEras; i++){
            if(aux.getDato().getZinc()>=valorMinimo){
                EstaBienDeZinc[i]=true;
                //System.out.println("zinc true");
            }else{
                EstaBienDeZinc[i]=false;
                //System.out.println("zinc false");
            }
            aux= aux.getNext();
        }
        for (int i=0; i<cantEras; i++){
            if(EstaBienDeZinc[i]==false){
                banderaEstaMalDeZinc=true;
            }
        }
        //revisar Fosforo
        aux = ultimo.getNext();
        for (int i=0; i<cantEras; i++){
            if(aux.getDato().getFosforo()>=valorMinimo){
                EstaBienDeFosforo[i]=true;
                //System.out.println("fosforo true");
            }else{
                EstaBienDeFosforo[i]=false;
                //System.out.println("fosforo false");
            }
            aux= aux.getNext();
        }
        for (int i=0; i<cantEras; i++){
            if(EstaBienDeFosforo[i]==false){
                banderaEstaMalDeFosforo=true;
            }
        }
        //revisar Boro
        aux = ultimo.getNext();
        for (int i=0; i<cantEras; i++){
            if(aux.getDato().getBoro()>=valorMinimo){
                EstaBienDeBoro[i]=true;
                //System.out.println("boro true");
            }else{
                EstaBienDeBoro[i]=false;
                //System.out.println("boro false");
            }
            aux= aux.getNext();
        }
        for (int i=0; i<cantEras; i++){
            if(EstaBienDeBoro[i]==false){
                banderaEstaMalDeBoro=true;
            }
        }
        
        if(banderaEstaMalDeAzufre||banderaEstaMalDeBoro||banderaEstaMalDeCalcio||banderaEstaMalDeFosforo||
           banderaEstaMalDeHierro||banderaEstaMalDeMagnesio||banderaEstaMalDePotasio||banderaEstaMalDeZinc||banderaEstamalDenitrogeno){
           noHaceFaltaMinerales =false;
            //System.out.println("no se puede todavia");
        }else{
            noHaceFaltaMinerales =true;
            //System.out.println("todo esta permitido");
        }
        return noHaceFaltaMinerales;
    }
    
    public boolean tieneMalaAireacionEnEras(int cantEras){
        Boolean[] estaBienDeAireacion = new Boolean[cantEras];
        boolean tieneMalaAireacionBandera = false;
        NodoEras aux;
        aux = ultimo.getNext();// con esto apuntamos al primero de toda la lista
        int counter = 0;
        do {
            
            if(aux.getDato().getAireacion()>=85 ){
                estaBienDeAireacion[counter] = true;
                System.out.println("aireacion mayor o igual de 85");
            }else{
                estaBienDeAireacion[counter] = false;
                System.out.println("aireacion menor que 85");
            }
            aux= aux.getNext();
            counter++;
        }while(aux!=ultimo.getNext());
        
        for(int i= 0; i<cantEras; i++){
            if(!estaBienDeAireacion[i]){
                
                tieneMalaAireacionBandera= true;
            }
            System.out.println("estaBienDeAireacion[i] =" + estaBienDeAireacion[i]+"\n"
            +"tieneMalaAireacionBandera ="+ tieneMalaAireacionBandera);
        }
        
        return tieneMalaAireacionBandera;
    }
    
    public boolean tieneMalaHumedad(int cantEras){
        Boolean[] estaBienDeHumedad= new Boolean[cantEras];
        boolean tieneMalaHumedad = false;
        NodoEras aux;
        aux = ultimo.getNext();// con esto apuntamos al primero de toda la lista
        int counter = 0;
        do {
            if(aux.getDato().getNivelDehumedad()>=85 ){
                estaBienDeHumedad[counter] = true;
            }else{
                estaBienDeHumedad[counter] = false;
            }
            aux= aux.getNext();
            counter++;
        }while(aux!=ultimo.getNext());
        
        for(int i= 0; i<cantEras; i++){
            if(estaBienDeHumedad[i]==false){
                tieneMalaHumedad= true;
            }
        }        
        
        return tieneMalaHumedad;
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


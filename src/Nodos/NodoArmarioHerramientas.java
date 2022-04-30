
package Nodos;


public class NodoArmarioHerramientas {
    
    
    private String Objeto;
    
    private NodoArmarioHerramientas next;

    public NodoArmarioHerramientas(String Objeto) {
        this.Objeto = Objeto;
        
    }

    public String getObjeto() {
        return Objeto;
    }

    public void setObjeto(String Objeto) {
        this.Objeto = Objeto;
    }

    public NodoArmarioHerramientas getNext() {
        return next;
    }

    public void setNext(NodoArmarioHerramientas next) {
        this.next = next;
    }
    
    
    
    
    
}

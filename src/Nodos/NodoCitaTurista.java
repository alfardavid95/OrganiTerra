
package Nodos;


public class NodoCitaTurista {
    
   private long Cedula;
   private String Nombre;
   private int NumeroDeAcompañantes;
   

   private NodoCitaTurista atras;

    public NodoCitaTurista(long Cedula, String Nombre, int NumeroDeAcompañantes) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.NumeroDeAcompañantes = NumeroDeAcompañantes;
    }

    public int getNumeroDeAcompañantes() {
        return NumeroDeAcompañantes;
    }

    public void setNumeroDeAcompañantes(int NumeroDeAcompañantes) {
        this.NumeroDeAcompañantes = NumeroDeAcompañantes;
    }

    public long getCedula() {
        return Cedula;
    }

    public void setCedula(long Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public NodoCitaTurista getAtras() {
        return atras;
    }

    public void setAtras(NodoCitaTurista atras) {
        this.atras = atras;
    }
   
   
    
    
}

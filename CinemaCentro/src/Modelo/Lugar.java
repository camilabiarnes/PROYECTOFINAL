package Modelo;

public class Lugar {
    private int idLugar;
    private Proyeccion proyeccion;
    private Asiento asiento;
    private String estado;

  
    public Lugar() {
    }

  
    public Lugar(Proyeccion proyeccion, Asiento asiento, String estado) {
        this.proyeccion = proyeccion;
        this.asiento = asiento;
        this.estado = estado;
    }


    public Lugar(int idLugar, Proyeccion proyeccion, Asiento asiento, String estado) {
        this.idLugar = idLugar;
        this.proyeccion = proyeccion;
        this.asiento = asiento;
        this.estado = estado;
    }


    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public Proyeccion getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(Proyeccion proyeccion) {
        this.proyeccion = proyeccion;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Lugar{" + "idLugar=" + idLugar + ", fila=" + asiento.getFila() + ", numero=" + asiento.getNumero() + ", estado=" + estado + '}';
    }
}
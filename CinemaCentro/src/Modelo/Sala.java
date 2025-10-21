package Modelo;

public class Sala {
    private int idSala;
    private int nroSala;
    private boolean apta3D;
    private int capacidad;
    private String estado;


    public Sala() {
    }

 
    public Sala(int nroSala, boolean apta3D, int capacidad, String estado) {
        this.nroSala = nroSala;
        this.apta3D = apta3D;
        this.capacidad = capacidad;
        this.estado = estado;
    }

   
    public Sala(int idSala, int nroSala, boolean apta3D, int capacidad, String estado) {
        this.idSala = idSala;
        this.nroSala = nroSala;
        this.apta3D = apta3D;
        this.capacidad = capacidad;
        this.estado = estado;
    }

  
    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public int getNroSala() {
        return nroSala;
    }

    public void setNroSala(int nroSala) {
        this.nroSala = nroSala;
    }

    public boolean isApta3D() {
        return apta3D;
    }

    public void setApta3D(boolean apta3D) {
        this.apta3D = apta3D;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Sala{" + "idSala=" + idSala + ", nroSala=" + nroSala + ", apta3D=" + apta3D + ", capacidad=" + capacidad + ", estado=" + estado + '}';
    }
}
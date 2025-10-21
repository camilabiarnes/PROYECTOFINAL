package Modelo;

public class Asiento {
    private int idAsiento;
    private Sala sala;
    private char fila;
    private int numero;


    public Asiento() {
    }


    public Asiento(Sala sala, char fila, int numero) {
        this.sala = sala;
        this.fila = fila;
        this.numero = numero;
    }

  
    public Asiento(int idAsiento, Sala sala, char fila, int numero) {
        this.idAsiento = idAsiento;
        this.sala = sala;
        this.fila = fila;
        this.numero = numero;
    }

 
    public int getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public char getFila() {
        return fila;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Asiento{" + "idAsiento=" + idAsiento + ", fila=" + fila + ", numero=" + numero + ", sala=" + sala.getNroSala() + '}';
    }
}
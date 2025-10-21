package Modelo;

import java.time.LocalTime;

public class Proyeccion {
    private int idProyeccion;
    private Pelicula pelicula;
    private Sala sala;
    private String idioma;
    private boolean es3D;
    private boolean subtitulada;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private double precio;


    public Proyeccion() {
    }
 
    public Proyeccion(Pelicula pelicula, Sala sala, String idioma, boolean es3D, boolean subtitulada, LocalTime horaInicio, LocalTime horaFin, double precio) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.idioma = idioma;
        this.es3D = es3D;
        this.subtitulada = subtitulada;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.precio = precio;
    }


    public Proyeccion(int idProyeccion, Pelicula pelicula, Sala sala, String idioma, boolean es3D, boolean subtitulada, LocalTime horaInicio, LocalTime horaFin, double precio) {
        this.idProyeccion = idProyeccion;
        this.pelicula = pelicula;
        this.sala = sala;
        this.idioma = idioma;
        this.es3D = es3D;
        this.subtitulada = subtitulada;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.precio = precio;
    }


    public int getIdProyeccion() {
        return idProyeccion;
    }

    public void setIdProyeccion(int idProyeccion) {
        this.idProyeccion = idProyeccion;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public boolean isEs3D() {
        return es3D;
    }

    public void setEs3D(boolean es3D) {
        this.es3D = es3D;
    }

    public boolean isSubtitulada() {
        return subtitulada;
    }

    public void setSubtitulada(boolean subtitulada) {
        this.subtitulada = subtitulada;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Proyeccion{" + "idProyeccion=" + idProyeccion + ", pelicula=" + pelicula.getTitulo() + ", sala=" + sala.getNroSala() + ", horaInicio=" + horaInicio + ", es3D=" + es3D + ", precio=" + precio + '}';
    }
}
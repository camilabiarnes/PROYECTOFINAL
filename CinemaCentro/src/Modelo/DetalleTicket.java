package Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DetalleTicket {
    private int idTicket;
    private LocalDateTime fechaCompra;
    private LocalDate fechaFuncion;
    private double monto;
    private Comprador comprador;
    private List<DetalleTicket> detalles;


    public DetalleTicket() {
        this.detalles = new ArrayList<>();
    }

  
    public DetalleTicket(LocalDateTime fechaCompra, LocalDate fechaFuncion, double monto, Comprador comprador) {
        this.fechaCompra = fechaCompra;
        this.fechaFuncion = fechaFuncion;
        this.monto = monto;
        this.comprador = comprador;
        this.detalles = new ArrayList<>();
    }

  
    public DetalleTicket(int idTicket, LocalDateTime fechaCompra, LocalDate fechaFuncion, double monto, Comprador comprador) {
        this.idTicket = idTicket;
        this.fechaCompra = fechaCompra;
        this.fechaFuncion = fechaFuncion;
        this.monto = monto;
        this.comprador = comprador;
        this.detalles = new ArrayList<>();
    }


    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public LocalDate getFechaFuncion() {
        return fechaFuncion;
    }

    public void setFechaFuncion(LocalDate fechaFuncion) {
        this.fechaFuncion = fechaFuncion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public List<DetalleTicket> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleTicket> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "TicketCompra{" + "idTicket=" + idTicket + ", fechaCompra=" + fechaCompra + ", fechaFuncion=" + fechaFuncion + ", monto=" + monto + ", comprador=" + comprador.getNombre() + '}';
    }
}
package modelo;

import java.time.LocalDate;
public class Nota {
    private double numero;
    private int dni;
    private String tipo;
    private int nroTri;
    private LocalDate fecha;
    
    public Nota(double n, int d, String t, int nt, LocalDate f){
        this.numero = n;
        this.dni = d;
        this.tipo = t;
        this.nroTri = nt;
        this.fecha = f;
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNroTri() {
        return nroTri;
    }

    public void setNroTri(int nroTri) {
        this.nroTri = nroTri;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
package modelo;

import java.util.ArrayList;
public class AlumnoPOO {
    private int dni;
    private Nombre nombre;
    private String correo;
    private ArrayList<Nota> listaNotas = new ArrayList();
    
    public AlumnoPOO(Nombre n, int d, String c){
        this.nombre = n;
        this.dni = d;
        this.correo = c;
    }
    
    public double calcularPromedio(){
        double prom = 0;
        for (int i = 0; i < this.listaNotas.size(); i++) {
            prom += this.listaNotas.get(i).getNumero();
        }
        prom /= this.listaNotas.size();
        return prom;
    }
    
    @Override
    public String toString(){
        String s = "El Alumno: " + this.nombre.getApellido() + " " + this.nombre.getNombre() + "\n DNI: " + this.dni +  "\n Mail: " + this.correo + "\n El promedio es: " + calcularPromedio();
        return s;
    }
    
    public void AgregarNota(Nota n){
        this.listaNotas.add(n);
    }
    
    public void MostrarNotas(){
        for (int i = 0; i < this.listaNotas.size(); i++) {
            System.out.println("Nota: " + this.listaNotas.get(i).getNumero() + " Trimestre: " + this.listaNotas.get(i).getNroTri());
        }
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ArrayList<Nota> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(ArrayList<Nota> listaNotas) {
        this.listaNotas = listaNotas;
    }
}
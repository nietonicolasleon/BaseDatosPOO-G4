package bddjava;

import accesoDatos.accesoDatos;
import modelo.AlumnoPOO;
import modelo.Nombre;
import modelo.Nota;
import java.time.LocalDate;
import java.util.ArrayList;
public class Bddjava {
    
    public static void main(String[] args) {
        LocalDate fecha = LocalDate.now();
        Nombre n1 = new Nombre("José Juan", "Sánchez");
        Nota nota1 = new Nota(9.0, 46144202, "ORAL", 1, fecha);
        Nota nota2 = new Nota(6.9, 46144202, "ESCRITA", 1, fecha);
        Nota nota3 = new Nota(8, 46144202, "ESCRITA", 2, fecha);
        AlumnoPOO a1 = new AlumnoPOO(n1, 46144202, "josejuansanchez@mail.com");
        a1.AgregarNota(nota1);
        a1.AgregarNota(nota3);
        accesoDatos bdd = new accesoDatos();
        bdd.insertarAlumno(a1);
        bdd.insertarNota(nota2);
        ArrayList<ArrayList<String>> lista = bdd.dameTabla();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        System.out.println("El dni de Jose Juan Sanchez es: " + bdd.dameDNI("Sánchez"));
    }
}

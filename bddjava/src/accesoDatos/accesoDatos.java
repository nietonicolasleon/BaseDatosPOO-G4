package accesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.AlumnoPOO;
import modelo.Nombre;
import modelo.Nota;

public class accesoDatos {
    private Connection conn;
    private Statement comandos;

    public accesoDatos(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/notasQuinto", "root", "");
            comandos = conn.createStatement();
        }catch(ClassNotFoundException ex){
            System.out.println("No se encontró la BDD.");
        }catch(SQLException ex){
            System.out.println("Error: Usuario o Password incorrectas.");
        }
    }
    
    public void insertarAlumno(AlumnoPOO unAl){
        String sql = "insert into alumnoPOO values("+unAl.getDni() + ", '" + unAl.getNombre().getNombre() + "', '" + unAl.getNombre().getApellido() + "', '" + unAl.getCorreo() + "')";
        System.out.println(sql);
        try {
            comandos.executeUpdate(sql);
        } catch(SQLException ex){
            System.out.println("Error en la sintaxis SQL.");
        }
    }
    
    public ArrayList<AlumnoPOO> dameLista(){
        ArrayList<AlumnoPOO> aux = new ArrayList();
        String sql = "select nombre, apellido, dni from alumnoPoo";
        try {
            ResultSet tabla = comandos.executeQuery(sql);
            while(tabla.next()){
                String nombre = tabla.getString("nombre");
                String apellido = tabla.getString("apellido");
                int dni = tabla.getInt("dni");
                AlumnoPOO unAl = new AlumnoPOO(new Nombre(nombre, apellido), dni, "");
                aux.add(unAl);
            }
        } catch(SQLException ex){
            System.out.println("Error " + ex.toString());
        }
        return aux;
    }
    
    public ArrayList<ArrayList<String>> dameTabla(){
        String sql = "select nombre, apellido, dni from alumnopoo";
        ArrayList<ArrayList<String>> aux = new ArrayList<ArrayList<String>>();
            ResultSet tabla;
        try{
            tabla = comandos.executeQuery(sql);
            while(tabla.next()){
                String nombre = tabla.getString("nombre");
                String apellido = tabla.getString("apellido");
                String dni = tabla.getString("dni");
                ArrayList<String> fila = new ArrayList<String>();
                fila.add(nombre);
                fila.add(apellido);
                fila.add(dni);
                aux.add(fila);
            }
        } catch(SQLException ex){
            System.out.println("Error " + ex.toString());
        }
        return aux;
    }
    
    public String dameDNI(String apellido){
        String dni = "";
        String sql = "select dni from alumnopoo where apellido='"+apellido+"'";
        try {
            ResultSet registro = comandos.executeQuery(sql);
            registro.next();
            dni = "" + registro.getInt("dni");
        } catch(SQLException ex){
            Logger.getLogger(accesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dni;
    }
    
    public void insertarNota(Nota n){
        String sql = "insert into nota(dni, trimestre, valor, motivo) values("+n.getDni()+", "+n.getNroTri()+", "
                + n.getNumero() + ", '" + n.getTipo()+"');"; 
        System.out.println(sql);
        try{
            comandos.executeUpdate(sql);
        } catch(SQLException ex){
            System.out.println("Error " + ex.toString());
        }
    }
}

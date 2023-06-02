package Daos;


import Beans.Reproduccion;
import Beans.Tour;

import java.sql.*;
import java.util.ArrayList;

public class RecomendadoDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
    public ArrayList<Reproduccion> obtenerListaRecomendado(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Reproduccion> listaRecomendado = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select * from reproduccion")) {

            while (rs.next()) {
                int cancion_idcancion = rs.getInt(1);
                int idreproduccion = rs.getInt(2);
                listaRecomendado.add(new Reproduccion(cancion_idcancion,idreproduccion));
            }

        } catch (SQLException e) {
            System.out.println("No se pudo realizar la busqueda");
        }
        return listaRecomendado;
    }
}



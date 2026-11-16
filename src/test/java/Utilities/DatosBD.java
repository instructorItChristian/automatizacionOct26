package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class DatosBD {

    /**
     * Ejecuta una query SELECT y devuelve el resultado como Object[][]
     * (una fila por registro, una columna por campo), listo para un @DataProvider.
     */
    public static Object[][] leerBD(String dbUrl, String usuario, String clave, String query) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        List<Object[]> filas = new ArrayList<>();

        // try-with-resources: cierra Connection, Statement y ResultSet automaticamente
        try (Connection con = DriverManager.getConnection(dbUrl, usuario, clave);
             PreparedStatement ps = con.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            ResultSetMetaData meta = rs.getMetaData();
            int columnas = meta.getColumnCount();

            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    fila[i] = rs.getString(i + 1);
                }
                filas.add(fila);
            }
        }

        return filas.toArray(new Object[0][]);
    }
}

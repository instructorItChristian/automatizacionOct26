package com.automatizacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//objetivo: conectarse a una base de datos

import org.testng.annotations.Test;

public class ejer14 {

    @Test 
    public void testBaseDatos() throws ClassNotFoundException, SQLException{

        //estos datos desde la linea 15 a la 21 son unicamente para la base del profe. 
        // si lo quiero probar tenga que cambairlos


        //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
        String dbUrl = "jdbc:mysql://192.168.56.101:3306/digitalers2023";					

		//Database Username		
		String username = "root2";	
            
		//Database Password		
		String password = "@DjvjhWfTYRl(NIE";	


        String query ="select * from usuarios";

        Class.forName("com.mysql.cj.jdbc.Driver");
            //conetarse a la base
        Connection com = DriverManager.getConnection(dbUrl, username, password);
            //crear objeto para la base
        Statement stmt = com.createStatement();
            //ejecutamos sql

            ResultSet rs = stmt.executeQuery(query);

            int count = 0;

            while (rs.next()){
                count = rs.getInt(1);
                }	

                System.out.println("numero de registros en la base: "+count);
                com.close();

        }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class PersonLoader {

    public static ArrayList read() throws ClassNotFoundException, SQLException {
        ArrayList<Person1> lista = new ArrayList<>();

        Class.forName("org.sqlite.JDBC");
        Connection conect = DriverManager.getConnection("jdbc:sqlite:KATA.sDB");
        Statement state = conect.createStatement();
        ResultSet rs = state.executeQuery("Select * FROM People");
        while (rs.next()) {
            Integer id = rs.getInt(1);
            String name = rs.getString(2);
            String genero = rs.getString(3);
            String fechaNacimiento = rs.getString(4);
            Float perso = rs.getFloat(5);
            String mail = rs.getString(6);
            lista.add(new Person1(id, name, genero, fechaNacimiento, perso, mail));
        }
    return lista;
    }
}

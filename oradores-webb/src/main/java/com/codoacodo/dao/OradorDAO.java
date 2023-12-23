package com.codoacodo.dao;

import static com.codoacodo.dao.Conexion.*;
import com.codoacodo.model.Orador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OradorDAO {
    
    static Logger logger = LoggerFactory.getLogger(OradorDAO.class);
    
    private static final String SQL_SELECT = "SELECT * FROM oradores";
    private static final String SQL_INSERT = "INSERT INTO oradores(nombre, apellido, mail, tema) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE oradores SET nombre = ?, apellido = ?, mail = ?, tema = ? WHERE ID_ORADOR = ?";
    private static final String SQL_DELETE = "DELETE FROM oradores WHERE ID_ORADOR = ?";
    
    public List<Orador> selectOradores() {
        List<Orador> oradores = new ArrayList<>();
        
        try (Connection conn = getConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL_SELECT)) {

            while (rs.next()) {
                Long idOrador = rs.getLong("ID_ORADOR");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String mail = rs.getString("mail");
                String tema = rs.getString("tema");
                Timestamp fechaAlta = rs.getTimestamp("fecha_alta");

                Orador orador = new Orador(idOrador, nombre, apellido, mail, tema, fechaAlta);
                oradores.add(orador);
            }

        } catch (SQLException | NullPointerException ex) {
            ex.printStackTrace(System.out);
        }
        return oradores;
    }

    public int insertarOrador(Orador oraUno) {
        int registros = 0;

        try (Connection conn = getConexion();
             PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {

            stmt.setString(1, oraUno.getNombre());
            stmt.setString(2, oraUno.getApellido());
            stmt.setString(3, oraUno.getMail());
            stmt.setString(4, oraUno.getTema());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return registros;
    }

    public int actualizarOrador(Orador ora) {
        int registros = 0;

        try (Connection conn = getConexion();
             PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {

            stmt.setString(1, ora.getNombre());
            stmt.setString(2, ora.getApellido());
            stmt.setString(3, ora.getMail());
            stmt.setString(4, ora.getTema());
            stmt.setLong(5, ora.getId());

            registros = stmt.executeUpdate();

        } catch (SQLException | NullPointerException ex) {
            ex.printStackTrace(System.out);
        }
        return registros;
    }

    public int eliminarOrador(Long i) {
        int registros = 0;

        try (Connection conn = getConexion();
             PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {

            stmt.setLong(1, i);
            registros = stmt.executeUpdate();

        } catch (SQLException | NullPointerException ex) {
            ex.printStackTrace(System.out);
        }
        return registros;
    }

    // Otros métodos si es necesario
}

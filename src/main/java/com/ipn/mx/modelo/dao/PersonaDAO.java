package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.PersonaDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDAO {

    private static final String SQL_INSERT = "insert into Persona (nombrePersona,correoPersona,numeroPersona) values (?,?,?)";
    private static final String SQL_UPDATE = "update Persona set nombrePersona = ?, correoPersona = ?, numeroPersona = ? where idPersona = ?";
    private static final String SQL_DELETE = "delete from Persona where idPersona = ?";
    private static final String SQL_SELECT = "select * from Persona where idPersona = ?";
    private static final String SQL_SELECT_ALL = "select * from Persona";

    private Connection conexion;

    private void obtenerConexion() {
        String usuario = "onnmvthqocwomw";
        String clave = "137aa7c6b304f445caf05d6adc74246ca1cec4872dc64e0e9344a156985262f2";
        String url = "jdbc:postgresql://ec2-3-224-8-189.compute-1.amazonaws.com:5432/d4ss4kcssslh6p";
        String driverPostgreSql = "org.postgresql.Driver";

        try {
            Class.forName(driverPostgreSql);
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void create(PersonaDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombrePersona());
            ps.setString(2, dto.getEntidad().getCorreoPersona());
            ps.setString(3, dto.getEntidad().getNumeroPersona());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void update(PersonaDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombrePersona());
            ps.setString(2, dto.getEntidad().getCorreoPersona());
            ps.setString(3, dto.getEntidad().getNumeroPersona());
            ps.setInt(4, dto.getEntidad().getIdPersona());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void delete(PersonaDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdPersona());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public PersonaDTO read(PersonaDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement(SQL_SELECT);
            ps.setInt(1, dto.getEntidad().getIdPersona());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (PersonaDTO) resultados.get(0);
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public List readAll() throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while (rs.next()) {
            PersonaDTO dto = new PersonaDTO();
            dto.getEntidad().setIdPersona(rs.getInt("idPersona"));
            dto.getEntidad().setNombrePersona(rs.getString("nombrePersona"));
            dto.getEntidad().setCorreoPersona(rs.getString("correoPersona"));
            dto.getEntidad().setNumeroPersona(rs.getString("numeroPersona"));
            resultados.add(dto);
        }
        return resultados;
    }
}

package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.LibroDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibroDAO {

    private static final String SQL_INSERT = "insert into Libro (autorLibro, tituloLibro, statusLibro, generoLibro, idSucursal,codigoUnico)"
            + "values (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "update Libro set autorLibro = ?, tituloLibro =?, statusLibro=?, generoLibro=?,idSucursal=?,codigoUnico=? "
            + "where codigoLibro = ?";
    private static final String SQL_DELETE = "delete from Libro where codigoLibro = ?";
    private static final String SQL_SELECT = "select * from Libro where codigoLibro = ?";
    private static final String SQL_SELECT_ALL = "select * from Libro;";

    private Connection conexion;

    private void obtenerConexion() {
        //Heroku
        String usuario = "onnmvthqocwomw";
        String clave = "137aa7c6b304f445caf05d6adc74246ca1cec4872dc64e0e9344a156985262f2";
        String url = "jdbc:postgresql://ec2-3-224-8-189.compute-1.amazonaws.com:5432/d4ss4kcssslh6p"; // ?sslmode=require

        String driverPostgreSql = "org.postgresql.Driver";
        try {
            Class.forName(driverPostgreSql);
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void create(LibroDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getAutorLibro());
            ps.setString(2, dto.getEntidad().getTituloLibro());
            ps.setString(3, dto.getEntidad().getStatusLibro());
            ps.setString(4, dto.getEntidad().getGeneroLibro());
            ps.setInt(5, dto.getEntidad().getIdSucursal());
            ps.setInt(6, dto.getEntidad().getCodigoUnico());
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

    public void update(LibroDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getAutorLibro());
            ps.setString(2, dto.getEntidad().getTituloLibro());
            ps.setString(3, dto.getEntidad().getStatusLibro());
            ps.setString(4, dto.getEntidad().getGeneroLibro());
            ps.setInt(5, dto.getEntidad().getIdSucursal());
            ps.setInt(6, dto.getEntidad().getCodigoUnico());
            ps.setInt(7, dto.getEntidad().getCodigoLibro());
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

    public void delete(LibroDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getCodigoLibro());
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

    public LibroDTO read(LibroDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_SELECT);
            ps.setInt(1, dto.getEntidad().getCodigoLibro());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (LibroDTO) resultados.get(0);
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
                System.out.println("readAll");
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
            LibroDTO dto = new LibroDTO();
            dto.getEntidad().setCodigoLibro(rs.getInt("codigoLibro"));
            dto.getEntidad().setAutorLibro(rs.getString("autorLibro"));
            dto.getEntidad().setTituloLibro(rs.getString("tituloLibro"));
            dto.getEntidad().setStatusLibro(rs.getString("statusLibro"));
            dto.getEntidad().setGeneroLibro(rs.getString("generoLibro"));
            dto.getEntidad().setIdSucursal(rs.getInt("IdSucursal"));
            dto.getEntidad().setCodigoUnico(rs.getInt("codigoUnico"));
            resultados.add(dto);
        }
        return resultados;
    }
}

package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.SucursalDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SucursalDAO {

    private static final String SQL_INSERT = "insert into sucursal (direccionSucursal, codigoPostal, numeroTelefono) values (?, ?, ?);";
    private static final String SQL_UPDATE = "update sucursal set direccionSucursal = ?, codigoPostal = ?, numeroTelefono = ? where idSucursal = ?";
    private static final String SQL_DELETE = "delete from sucursal where idsucursal= ?";
    private static final String SQL_SELECT = "select * from sucursal where idsucursal = ?";
    private static final String SQL_SELECT_ALL = "select * from sucursal";

    private Connection conexion;

    private void obtenerConexion() {
        String usuario = "onnmvthqocwomw";
        String clave = "137aa7c6b304f445caf05d6adc74246ca1cec4872dc64e0e9344a156985262f2";
        String url = "jdbc:postgresql://ec2-3-224-8-189.compute-1.amazonaws.com:5432/d4ss4kcssslh6p";// ?sslmode=require

        String driverPostgreSql = "org.postgresql.Driver";
        try {
            Class.forName(driverPostgreSql);
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(SucursalDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void create(SucursalDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getDireccionSucursal());
            ps.setString(2, dto.getEntidad().getCodigoPostal());
            ps.setString(3, dto.getEntidad().getNumeroTelefono());
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

    public void update(SucursalDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getDireccionSucursal());
            ps.setString(2, dto.getEntidad().getCodigoPostal());
            ps.setString(3, dto.getEntidad().getNumeroTelefono());
            // O J O pa update nomas
            ps.setInt(4, dto.getEntidad().getIdSucursal());
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

    public void delete(SucursalDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdSucursal());
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

    public SucursalDTO read(SucursalDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_SELECT);
            ps.setInt(1, dto.getEntidad().getIdSucursal());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (SucursalDTO) resultados.get(0);
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
            SucursalDTO dto = new SucursalDTO();
            dto.getEntidad().setIdSucursal(rs.getInt("idSucursal"));
            dto.getEntidad().setDireccionSucursal(rs.getString("direccionSucursal"));
            dto.getEntidad().setCodigoPostal(rs.getString("codigoPostal"));
            dto.getEntidad().setNumeroTelefono(rs.getString("numeroTelefono"));
            resultados.add(dto);
        }
        return resultados;
    }

}

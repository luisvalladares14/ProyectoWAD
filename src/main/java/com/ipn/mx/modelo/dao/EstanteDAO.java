package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.EstanteDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstanteDAO {
    private static final String SQL_INSERT = "insert into estante (numeroPiso, numeroPasillo, numeroSeccion, idSucursal) values (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "update estante set numeroPiso = ?, numeroPasillo = ?, numeroSeccion = ?, idSucursal = ? where codigoUnico = ?";
    private static final String SQL_DELETE = "delete from estante where codigoUnico= ?";
    private static final String SQL_SELECT = "select * from estante where codigoUnico = ?";
    private static final String SQL_SELECT_ALL = "select * from estante order by idsucursal";
    
    private Connection conexion;
    
    private void obtenerConexion() {
        
        String usuario = "onnmvthqocwomw";
        String clave = "137aa7c6b304f445caf05d6adc74246ca1cec4872dc64e0e9344a156985262f2";
        String url = "jdbc:postgresql://ec2-3-224-8-189.compute-1.amazonaws.com:5432/d4ss4kcssslh6p"; // ?sslmode=require
        
        
        String driverPostgreSql = "org.postgresql.Driver";
        try {
            Class.forName(driverPostgreSql);
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(EstanteDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void create(EstanteDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setInt(1, dto.getEntidad().getNumeroPiso());
            ps.setInt(2, dto.getEntidad().getNumeroPasillo());
            ps.setInt(3, dto.getEntidad().getNumeroSeccion());
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

    public void update(EstanteDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setInt(1, dto.getEntidad().getNumeroPiso());
            ps.setInt(2, dto.getEntidad().getNumeroPasillo());
            ps.setInt(3, dto.getEntidad().getNumeroSeccion());
            ps.setInt(4, dto.getEntidad().getIdSucursal());
            ps.setInt(5, dto.getEntidad().getCodigoUnico());
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

    public void delete(EstanteDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getCodigoUnico());
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

    public EstanteDTO read(EstanteDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_SELECT);
            ps.setInt(1, dto.getEntidad().getCodigoUnico());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (EstanteDTO) resultados.get(0);
            } 
            else {
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
            }
            else {
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
        while(rs.next()) {
            EstanteDTO dto = new EstanteDTO();
            dto.getEntidad().setCodigoUnico(rs.getInt("codigoUnico"));
            dto.getEntidad().setNumeroPiso(rs.getInt("numeroPiso"));
            dto.getEntidad().setNumeroPasillo(rs.getInt("numeroPasillo"));
            dto.getEntidad().setNumeroSeccion(rs.getInt("numeroSeccion"));
            dto.getEntidad().setIdSucursal(rs.getInt("idSucursal"));
            resultados.add(dto);
        }
        return resultados;
    }
}

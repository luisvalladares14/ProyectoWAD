package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.TransaccionDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransaccionDAO {

    private static final String SQL_INSERT = "insert into Transaccion (fechaTransaccion,horaTransaccion,codigoLibro, idPersona) values (?,?,?,?)";
    private static final String SQL_UPDATE = "update Transaccion set fechaTransaccion = ?, horaTransaccion = ?, codigoLibro = ?, idPersona = ? where numeroTransaccion = ?";
    private static final String SQL_DELETE = "delete from Transaccion where numeroTransaccion = ?";
    private static final String SQL_SELECT = "select * from Transaccion where numeroTransaccion= ?";
    private static final String SQL_SELECT_ALL = "select * from Transaccion";

    private Connection conexion;

    private void obtenerConexion() {
        String usuario = "cpyffhiouinhtf";
        String clave = "a547dc7f629d0fd35c884b623eec3adcd15988a687513cc0c29668a901d44879";
        String url = "jdbc:postgresql://ec2-34-232-245-127.compute-1.amazonaws.com:5432/deveveie33un21";
        String driverPostgreSql = "org.postgresql.Driver";

        try {
            Class.forName(driverPostgreSql);
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void create(TransaccionDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getFechaTransaccion());
            ps.setString(2, dto.getEntidad().getHoraTransaccion());
            ps.setInt(3, dto.getEntidad().getCodigoLibro());
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

    public void update(TransaccionDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getFechaTransaccion());
            ps.setString(2, dto.getEntidad().getHoraTransaccion());
            ps.setInt(3, dto.getEntidad().getCodigoLibro());
            ps.setInt(4, dto.getEntidad().getIdPersona());
            ps.setInt(5, dto.getEntidad().getNumeroTransaccion());
            
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

    public void delete(TransaccionDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getNumeroTransaccion());
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

    public TransaccionDTO read(TransaccionDTO dto) throws SQLException {
        obtenerConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conexion.prepareStatement(SQL_SELECT);
            ps.setInt(1, dto.getEntidad().getNumeroTransaccion());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (TransaccionDTO) resultados.get(0);
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

    private List obtenerResultados(ResultSet rs) throws SQLException{
        List resultados = new ArrayList();
        while(rs.next()){
            TransaccionDTO dto = new TransaccionDTO();
            dto.getEntidad().setNumeroTransaccion(rs.getInt("numeroTransaccion"));
            dto.getEntidad().setFechaTransaccion(rs.getString("fechaTransaccion"));
            dto.getEntidad().setHoraTransaccion(rs.getString("horaTransaccion"));
            dto.getEntidad().setCodigoLibro(rs.getInt("codigoLibro"));
            dto.getEntidad().setIdPersona(rs.getInt("idPersona"));
            resultados.add(dto);
        }
        return resultados;
    }
}


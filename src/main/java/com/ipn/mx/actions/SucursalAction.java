package com.ipn.mx.actions;

import com.ipn.mx.modelo.dao.SucursalDAO;
import com.ipn.mx.modelo.dto.SucursalDTO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SucursalAction extends ActionSupport {
    private List<SucursalDTO> sucursales = new ArrayList<>();
    private SucursalDTO dto;

    private final SucursalDAO dao = new SucursalDAO();

    public String listarSucursales() {
        try {
            this.sucursales = dao.readAll();
            
        } catch (SQLException ex) {
            Logger.getLogger(SucursalAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }

    public String almacenarSucursal() {
        try {
            if (dto.getEntidad().getIdSucursal() == 0) {
                dao.create(dto);
            } else {
                dao.update(dto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SucursalAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public String eliminarSucursal(){
        try {
            dto = dao.read(dto);
            dao.delete(dto);
        } catch (SQLException ex) {
            Logger.getLogger(SucursalAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public String actualizarSucursal(){
        try {
            dto=dao.read(dto);
        } catch (SQLException ex) {
            Logger.getLogger(SucursalAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public String agregarSucursal(){
        dto = new SucursalDTO();
        return SUCCESS;
    }
    public String verSucursal(){
        try {
            dto=dao.read(dto);
        } catch (SQLException ex) {
            Logger.getLogger(SucursalAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    
    public List<SucursalDTO> getSucursals() {
        return sucursales;
        
    }

    public void setSucursals(List<SucursalDTO> sucursales) {
        this.sucursales = sucursales;
    }

    public SucursalDTO getDto() {
        return dto;
    }

    public void setDto(SucursalDTO dto) {
        this.dto = dto;
    }
    /*METODOS PARA RECUPERAR TEXTOS*/
    public String getTitulo(){
        return getText("sucursal.titulo");
    }
    public String getIdSucursal(){
        return getText("sucursal.idSucursal");
    }
    public String getDireccionSucursal(){
        return getText("sucursal.direccionSucursal");
    }
    public String getCodigoPostal(){
        return getText("sucursal.codigoPostal");
    }
    public String getNumeroTelefono(){
        return getText("sucursal.numeroTelefono");
    }
    public String getNuevo(){
        return getText("sucursal.boton.nuevo");
    }
    public String getGuardar(){
        return getText("sucursal.boton.guardar");
    }
    public String getActualizar(){
        return getText("sucursal.boton.actualizar");
    }
    public String getEliminar(){
        return getText("sucursal.boton.eliminar");
    }
}

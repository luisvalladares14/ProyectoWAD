package com.ipn.mx.actions;

import com.ipn.mx.modelo.dao.EstanteDAO;
import com.ipn.mx.modelo.dto.EstanteDTO;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstanteAction extends ActionSupport{
   private List<EstanteDTO> estantes = new ArrayList<>();
    private EstanteDTO dto;

    private final EstanteDAO dao = new EstanteDAO();

    public String listarEstantes() {
        try {
            this.estantes = dao.readAll();
            
        } catch (SQLException ex) {
            Logger.getLogger(EstanteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }

    public String almacenarEstante() {
        try {
            if (dto.getEntidad().getCodigoUnico()== 0) {
                dao.create(dto);
            } else {
                dao.update(dto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstanteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public String eliminarEstante(){
        try {
            dto = dao.read(dto);
            dao.delete(dto);
        } catch (SQLException ex) {
            Logger.getLogger(EstanteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public String actualizarEstante(){
        try {
            dto=dao.read(dto);
        } catch (SQLException ex) {
            Logger.getLogger(EstanteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public String agregarEstante(){
        dto = new EstanteDTO();
        return SUCCESS;
    }
    public String verEstante(){
        try {
            dto=dao.read(dto);
        } catch (SQLException ex) {
            Logger.getLogger(EstanteAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    
    public List<EstanteDTO> getEstantes() {
        return estantes;
        
    }

    public void setEstantes(List<EstanteDTO> estantes) {
        this.estantes = estantes;
    }

    public EstanteDTO getDto() {
        return dto;
    }

    public void setDto(EstanteDTO dto) {
        this.dto = dto;
    }
    /*METODOS PARA RECUPERAR TEXTOS*/
    public String getTitulo(){
        return getText("estante.titulo");
    }
    public String getCodigoUnico(){
        return getText("estante.codigoUnico");
    }
    public String getNumeroPiso(){
        return getText("estante.numeroPiso");
    }
    public String getNumeroPasillo(){
        return getText("estante.numeroPasillo");
    }
    public String getNumeroSeccion(){
        return getText("estante.numeroSeccion");
    }
    public String getIdSucursal(){
        return getText("estante.idSucursal");
    }
    public String getNuevo(){
        return getText("estante.boton.nuevo");
    }
    public String getGuardar(){
        return getText("estante.boton.guardar");
    }
    public String getActualizar(){
        return getText("estante.boton.actualizar");
    }
    public String getEliminar(){
        return getText("estante.boton.eliminar");
    }
}

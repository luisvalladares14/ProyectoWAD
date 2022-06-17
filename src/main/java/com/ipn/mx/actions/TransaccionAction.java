package com.ipn.mx.actions;

import com.ipn.mx.modelo.dao.TransaccionDAO;
import com.ipn.mx.modelo.dto.TransaccionDTO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransaccionAction extends ActionSupport {
    private List<TransaccionDTO> transacciones = new ArrayList<>();
    private TransaccionDTO dto;

    private final TransaccionDAO dao = new TransaccionDAO();

    public String listarTransaccions() {
        try {
            this.transacciones = dao.readAll();
            
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }

    public String almacenarTransaccion() {
        try {
            if (dto.getEntidad().getNumeroTransaccion()== 0) {
                dao.create(dto);
            } else {
                dao.update(dto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public String eliminarTransaccion(){
        try {
            dto = dao.read(dto);
            dao.delete(dto);
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public String actualizarTransaccion(){
        try {
            dto=dao.read(dto);
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public String agregarTransaccion(){
        dto = new TransaccionDTO();
        return SUCCESS;
    }
    public String verTransaccion(){
        try {
            dto=dao.read(dto);
        } catch (SQLException ex) {
            Logger.getLogger(TransaccionAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    
    public List<TransaccionDTO> getTransaccions() {
        return transacciones;
        
    }

    public void setTransaccions(List<TransaccionDTO> transacciones) {
        this.transacciones = transacciones;
    }

    public TransaccionDTO getDto() {
        return dto;
    }

    public void setDto(TransaccionDTO dto) {
        this.dto = dto;
    }
    /*METODOS PARA RECUPERAR TEXTOS*/
    public String getTitulo(){
        return getText("transaccion.titulo");
    }
    public String getNumeroTransaccion(){
        return getText("transaccion.numeroTransaccion");
    }
    public String getFechaTransaccion(){
        return getText("transaccion.fechaTransaccion");
    }
    public String getHoraTransaccion(){
        return getText("transaccion.horaTransaccion");
    }
    public String getCodigoLibro(){
        return getText("transaccion.codigoLibro");
    }
    public String getIdPersona(){
        return getText("transaccion.idPersona");
    }
    public String getNuevo(){
        return getText("transaccion.boton.nuevo");
    }
    public String getGuardar(){
        return getText("transaccion.boton.guardar");
    }
    public String getActualizar(){
        return getText("transaccion.boton.actualizar");
    }
    public String getEliminar(){
        return getText("transaccion.boton.eliminar");
    }
}

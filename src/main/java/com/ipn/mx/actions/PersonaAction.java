package com.ipn.mx.actions;

import com.ipn.mx.modelo.dao.PersonaDAO;
import com.ipn.mx.modelo.dto.PersonaDTO;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaAction extends ActionSupport {
    private List<PersonaDTO> personas = new ArrayList<>();
    private PersonaDTO dto;

    private final PersonaDAO dao = new PersonaDAO();

    public String listarPersonas() {
        try {
            this.personas = dao.readAll();
            
        } catch (SQLException ex) {
            Logger.getLogger(PersonaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }

    public String almacenarPersona() {
        try {
            if (dto.getEntidad().getIdPersona() == 0) {
                dao.create(dto);
            } else {
                dao.update(dto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public String eliminarPersona(){
        try {
            dto = dao.read(dto);
            dao.delete(dto);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public String actualizarPersona(){
        try {
            dto=dao.read(dto);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public String agregarPersona(){
        dto = new PersonaDTO();
        return SUCCESS;
    }
    public String verPersona(){
        try {
            dto=dao.read(dto);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    
    public List<PersonaDTO> getPersonas() {
        return personas;
        
    }

    public void setPersonas(List<PersonaDTO> personas) {
        this.personas = personas;
    }

    public PersonaDTO getDto() {
        return dto;
    }

    public void setDto(PersonaDTO dto) {
        this.dto = dto;
    }
    /*METODOS PARA RECUPERAR TEXTOS*/
    public String getTitulo(){
        return getText("persona.titulo");
    }
    public String getIdPersona(){
        return getText("persona.idPersona");
    }
    public String getNombrePersona(){
        return getText("persona.nombrePersona");
    }
    public String getCorreoPersona(){
        return getText("persona.correoPersona");
    }
    public String getNumeroPersona(){
        return getText("persona.numeroPersona");
    }
    public String getNuevo(){
        return getText("persona.boton.nuevo");
    }
    public String getGuardar(){
        return getText("persona.boton.guardar");
    }
    public String getActualizar(){
        return getText("persona.boton.actualizar");
    }
    public String getEliminar(){
        return getText("persona.boton.eliminar");
    }
}

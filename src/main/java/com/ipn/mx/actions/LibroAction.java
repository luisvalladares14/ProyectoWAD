package com.ipn.mx.actions;

import com.ipn.mx.modelo.dao.LibroDAO;
import com.ipn.mx.modelo.dto.LibroDTO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibroAction extends ActionSupport{
   private List<LibroDTO> libros = new ArrayList<>();
    private LibroDTO dto;

    private final LibroDAO dao = new LibroDAO();

    public String listarLibros() {
        try {
            this.libros = dao.readAll();
            
        } catch (SQLException ex) {
            Logger.getLogger(LibroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }

    public String almacenarLibro() {
        try {
            if (dto.getEntidad().getCodigoLibro()== 0) {
                dao.create(dto);
            } else {
                dao.update(dto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LibroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public String eliminarLibro(){
        try {
            dto = dao.read(dto);
            dao.delete(dto);
        } catch (SQLException ex) {
            Logger.getLogger(LibroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public String actualizarLibro(){
        try {
            dto=dao.read(dto);
        } catch (SQLException ex) {
            Logger.getLogger(LibroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public String agregarLibro(){
        dto = new LibroDTO();
        return SUCCESS;
    }
    public String verLibro(){
        try {
            dto=dao.read(dto);
        } catch (SQLException ex) {
            Logger.getLogger(LibroAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    
    public List<LibroDTO> getLibros() {
        return libros;
        
    }

    public void setLibros(List<LibroDTO> libros) {
        this.libros = libros;
    }

    public LibroDTO getDto() {
        return dto;
    }

    public void setDto(LibroDTO dto) {
        this.dto = dto;
    }
    /*METODOS PARA RECUPERAR TEXTOS*/
    public String getTitulo(){
        return getText("libro.titulo");
    }
    public String getCodigoLibro(){
        return getText("libro.codigoLibro");
    }
    public String getAutorLibro(){
        return getText("libro.autorLibro");
    }
    public String getTituloLibro(){
        return getText("libro.tituloLibro");
    }
    public String getStatusLibro(){
        return getText("libro.statusLibro");
    }
    public String getIdSucursal(){
        return getText("libro.idSucursal");
    }
    public String getCodigoUnico(){
        return getText("libro.codigoUnico");
    }
    public String getNuevo(){
        return getText("libro.boton.nuevo");
    }
    public String getGuardar(){
        return getText("libro.boton.guardar");
    }
    public String getActualizar(){
        return getText("libro.boton.actualizar");
    }
    public String getEliminar(){
        return getText("libro.boton.eliminar");
    }
}

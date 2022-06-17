package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Libro;
import java.io.Serializable;
import lombok.Data;

@Data

public class LibroDTO implements Serializable{
    private Libro entidad;
    
    public LibroDTO(){
        entidad = new Libro();
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Clave Libro").append(getEntidad().getCodigoLibro()).append("\n");
        sb.append("Autor Libro").append(getEntidad().getAutorLibro()).append("\n");
        sb.append("Titulo Libro").append(getEntidad().getTituloLibro()).append("\n");
        sb.append("Estatus Libro").append(getEntidad().getStatusLibro()).append("\n");
        sb.append("Genero Libro").append(getEntidad().getGeneroLibro()).append("\n");
        sb.append("Clave Sucursal").append(getEntidad().getIdSucursal()).append("\n");
        sb.append("Clave Estante").append(getEntidad().getCodigoUnico()).append("\n");
        return sb.toString();
    }
}

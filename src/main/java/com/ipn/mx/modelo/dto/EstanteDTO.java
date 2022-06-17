package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Estante;
import java.io.Serializable;
import lombok.Data;

@Data
public class EstanteDTO implements Serializable{
    private Estante entidad;
    
    public EstanteDTO(){
        entidad = new Estante();
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("Codigo : ").append(getEntidad().getCodigoUnico()).append("\n");
        sb.append("Piso : ").append(getEntidad().getNumeroPiso()).append("\n");
        sb.append("Pasillo : ").append(getEntidad().getNumeroPasillo()).append("\n");
        sb.append("Seccion : ").append(getEntidad().getNumeroSeccion()).append("\n");
        sb.append("Sucursal : ").append(getEntidad().getIdSucursal()).append("\n");
        
        return sb.toString();
    }
}

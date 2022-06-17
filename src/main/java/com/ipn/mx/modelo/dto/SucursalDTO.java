package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Sucursal;
import java.io.Serializable;
import lombok.Data;

@Data
public class SucursalDTO implements Serializable{
    private Sucursal entidad;
    
    public SucursalDTO(){
        entidad = new Sucursal();
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("ID : ").append(getEntidad().getIdSucursal()).append("\n");
        sb.append("Direccion : ").append(getEntidad().getDireccionSucursal()).append("\n");
        sb.append("Codigo postal : ").append(getEntidad().getCodigoPostal()).append("\n");
        sb.append("Telefono : ").append(getEntidad().getNumeroTelefono()).append("\n");
        
        return sb.toString();
    }
}

package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Persona;
import java.io.Serializable;
import lombok.Data;

@Data
public class PersonaDTO implements Serializable{
    private Persona entidad;
    
    public PersonaDTO (){
        this.entidad = new Persona();
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Clave: ").append(getEntidad().getIdPersona()).append("\n");
        sb.append("Nombre: ").append(getEntidad().getNombrePersona()).append("\n");
        sb.append("Correo: ").append(getEntidad().getCorreoPersona()).append("\n");
        sb.append("Numero: ").append(getEntidad().getNumeroPersona()).append("\n");
        return sb.toString();
    }
}

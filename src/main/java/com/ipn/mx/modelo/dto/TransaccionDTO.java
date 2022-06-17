package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Transaccion;
import java.io.Serializable;
import lombok.Data;

@Data
public class TransaccionDTO implements Serializable{
    private Transaccion entidad;
    
    public TransaccionDTO(){
        this.entidad = new Transaccion();
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Numero: ").append(getEntidad().getNumeroTransaccion()).append("\n");
        sb.append("Fecha: ").append(getEntidad().getFechaTransaccion()).append("\n");
        sb.append("Hora: ").append(getEntidad().getHoraTransaccion()).append("\n");
        sb.append("Codigo Libro: ").append(getEntidad().getCodigoLibro()).append("\n");
        sb.append("Clave Persona: ").append(getEntidad().getIdPersona()).append("\n");
        return sb.toString();
    }
}

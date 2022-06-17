package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Persona implements Serializable{
    private int idPersona;
    private String nombrePersona;
    private String correoPersona;
    private String numeroPersona;
}

package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Sucursal implements Serializable{
    private int idSucursal;
    private String direccionSucursal;
    private String codigoPostal;
    private String numeroTelefono;

}
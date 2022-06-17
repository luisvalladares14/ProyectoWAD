package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Libro implements Serializable{
    private int codigoLibro;
    private String autorLibro;
    private String tituloLibro;
    private String statusLibro;
    private String generoLibro;
    private int idSucursal;
    private int codigoUnico;
}

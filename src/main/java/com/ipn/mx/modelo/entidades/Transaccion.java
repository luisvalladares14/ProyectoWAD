package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaccion implements Serializable{
    private int numeroTransaccion;
    private String fechaTransaccion;
    private String horaTransaccion;
    private int codigoLibro;
    private int idPersona;
}

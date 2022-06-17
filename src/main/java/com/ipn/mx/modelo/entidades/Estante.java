package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Estante implements Serializable{
    private int codigoUnico;
    private int numeroPiso;
    private int numeroPasillo;
    private int numeroSeccion;
    private int idSucursal;

}
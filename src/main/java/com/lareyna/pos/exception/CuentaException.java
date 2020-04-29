package com.lareyna.pos.exception;

import java.math.BigDecimal;

public class CuentaException extends Exception{

    int[] cantidades;
    BigDecimal extra;

    public CuentaException(String message,  int[] cantidades, BigDecimal extra){
        super(message);
        this.cantidades = cantidades;
        this.extra = extra;
    }

    public int[] getCantidades(){
        return cantidades;
    }
}
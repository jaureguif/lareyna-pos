package com.lareyna.pos;

import java.math.BigDecimal;

import com.lareyna.pos.exception.CuentaException;
import com.lareyna.pos.gui.NumberField;

public class Cuenta {

    //TODO load precios
    private static BigDecimal[] precios = new BigDecimal[]{
        BigDecimal.valueOf(1.0),
        BigDecimal.valueOf(2.0),
        BigDecimal.valueOf(3.0),
        BigDecimal.valueOf(4.0),
        BigDecimal.valueOf(5.0),
        BigDecimal.valueOf(6.0),
        BigDecimal.valueOf(7.0),
        BigDecimal.valueOf(8.0),
        BigDecimal.valueOf(9.0),
        BigDecimal.valueOf(1.0),
        BigDecimal.valueOf(2.0),
        BigDecimal.valueOf(3.0),
        BigDecimal.valueOf(4.0),
    };

    public void setValues(NumberField[] ida, NumberField[] regreso, double d) {
    }

    public static BigDecimal calculaResultado(int[] cantidades, BigDecimal extra) throws CuentaException {
        Cuenta.valida(cantidades, extra);
        BigDecimal result = BigDecimal.ZERO;
        result = result.setScale(2, BigDecimal.ROUND_CEILING);
        for (int i = 0; i < precios.length; i++){
            result = result.add(precios[i].multiply(BigDecimal.valueOf(cantidades[i])));
        }
        result = result.add(extra);
        return result.stripTrailingZeros();
    }

    protected static void valida(int[] cantidades, BigDecimal extra) throws CuentaException {
        boolean valid = true;
        for(int cantidad : cantidades) {
            if (cantidad < 0){
                valid = false;
            }
        }
        if(extra.compareTo(BigDecimal.ZERO) == -1){
            valid = false;
        }

        if(!valid){
            throw new CuentaException("Error, cantidades negativas", cantidades, extra);
        }
    }

}

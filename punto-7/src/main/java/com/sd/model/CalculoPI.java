package com.sd.model;

import com.sd.interfaces.Tarea;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * User: fcatania
 * Date: 26/3/2019
 * Time: 10:22
 */
public class CalculoPI implements Tarea {

    private int precision;

    public CalculoPI(int precision) {
        this.precision = precision;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    private BigDecimal calcularArcoTangente(double x, int iteraciones){
        MathContext mc = new MathContext(this.precision);
        BigDecimal result = new BigDecimal("0.00", mc);
        BigDecimal uno = new BigDecimal("1.00");
        for(int i = 0; i < iteraciones; i++){
            double div = (2.00*i+1.00) *
                    (Math.pow(1.00/x, 2.00 * i + 1.00));
            BigDecimal divisor = new BigDecimal(String.valueOf(div));
            if(i % 2 == 0){
                result = result.add(uno.divide(divisor, mc));
            }else{
                result = result.subtract(uno.divide(divisor, mc));
            }
        }
        return result;
    }
    public Object ejecutar() {

        //Gauss
        BigDecimal pi = calcularArcoTangente(1.00/18.00, 60)
                .multiply(new BigDecimal("12.00"))
                .add(calcularArcoTangente(1.00/57.00, 60)
                        .multiply(new BigDecimal("8.00"))
                        .subtract(calcularArcoTangente(1.00/239.00, 60)
                                .multiply(new BigDecimal("5.00")))
                );
        return pi.multiply(new BigDecimal("4.00"));

    }
}
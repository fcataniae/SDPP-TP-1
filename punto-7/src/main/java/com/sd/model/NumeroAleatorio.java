package com.sd.model;

import com.sd.interfaces.Tarea;

import java.security.SecureRandom;

/**
 * User: fcatania
 * Date: 26/3/2019
 * Time: 14:12
 */
public class NumeroAleatorio implements Tarea{

    private int lon;

    public NumeroAleatorio(int lon) {
        this.lon = lon;
    }

    @Override
    public Object ejecutar() {

        SecureRandom sr = new SecureRandom();
        byte[] b = new byte[this.lon];
        sr.setSeed(b);
        sr.setSeed(System.currentTimeMillis());


        return sr.nextInt();

    }
}
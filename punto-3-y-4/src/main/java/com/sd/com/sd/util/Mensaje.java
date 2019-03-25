package com.sd.com.sd.util;

import java.io.Serializable;

/**
 * User: fcatania
 * Date: 25/3/2019
 * Time: 11:33
 */
public class Mensaje implements Serializable{

    private int id_origen;
    private int id_destino;
    private String asunto;
    private String mensaje;

    @Override
    public String toString() {
        return "Mensaje{" +
                "id_origen=" + id_origen +
                ", id_destino=" + id_destino +
                ", asunto='" + asunto + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }

    public int getId_origen() {
        return id_origen;
    }

    public void setId_origen(int id_origen) {
        this.id_origen = id_origen;
    }

    public int getId_destino() {
        return id_destino;
    }

    public void setId_destino(int id_destino) {
        this.id_destino = id_destino;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Mensaje(int id_origen, int id_destino, String asunto, String mensaje) {

        this.id_origen = id_origen;
        this.id_destino = id_destino;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }
}
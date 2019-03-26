package com.sd.cliente.impl;

import com.sd.interfaces.InterfazRemota;
import com.sd.model.CalculoPI;
import com.sd.model.NumeroAleatorio;

import java.math.BigDecimal;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * User: fcatania
 * Date: 26/3/2019
 * Time: 10:40
 */
public class Cliente {

    private int port;
    private String host;


    public Cliente(int port, String host) {
        this.port = port;
        this.host = host;
    }


    public void conexionRemota() throws RemoteException, NotBoundException {

        Registry cliente = LocateRegistry.getRegistry(this.host,this.port);

        System.out.println("Creando la conexion con la interfaz remota");

        InterfazRemota remote = (InterfazRemota) cliente.lookup("InterfazRemota");

        CalculoPI cal = new CalculoPI(5000);

        System.out.println("Calculo PI con presicion 5000: " + remote.ejecutar(cal).toString());

        NumeroAleatorio n = new NumeroAleatorio(5000);

        System.out.println("Genero un numero aleatorio: " + remote.ejecutar(n).toString());

    }
}
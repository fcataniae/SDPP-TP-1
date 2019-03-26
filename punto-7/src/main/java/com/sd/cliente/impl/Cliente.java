package com.sd.cliente.impl;

import com.sd.interfaces.InterfazRemota;
import com.sd.model.CalculoPI;

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

        System.out.println("Resultado de la consulta contra el servidor remoto: " + (remote.ejecutar(cal)).toString());

    }
}
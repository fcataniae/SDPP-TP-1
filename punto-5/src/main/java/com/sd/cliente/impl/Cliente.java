package com.sd.cliente.impl;

import com.sd.interfaces.InterfazRemota;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

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

        System.out.println("Clima servidor RMI: " + remote.getInformacionClimaServer());

    }
}
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

        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();

        l1.add(1);
        l1.add(2);
        l1.add(3);
        l2.add(1);
        l2.add(2);
        l2.add(3);

        System.out.println(l1.toString() + "\n" + l2.toString());

        ArrayList<Integer> l3 = (ArrayList<Integer>) remote.sumaVectores(l1,l2);

        System.out.println(l1.toString() + "\n" + l2.toString());
        System.out.println(l3.toString());

    }
}
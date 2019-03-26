package com.sd.server;

import com.sd.interfaces.InterfazRemota;
import com.sd.server.impl.ServerImplementation;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * User: fcatania
 * Date: 26/3/2019
 * Time: 10:14
 */
public class ServerRMI {


    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        String port = "8080";

        if(args.length != 0)
            port = args[0];
        else
            System.out.println("Se utilizara el puerto por defecto 8080");

        if(!port.matches("\\d*")) throw new NumberFormatException("El puerto ingresado debe contener solo numeros");

        ServerImplementation server = new ServerImplementation();

        Registry registry = LocateRegistry.createRegistry(Integer.valueOf(port));

        InterfazRemota service = (InterfazRemota) UnicastRemoteObject.exportObject(server, 65000);

        registry.bind("InterfazRemota",service);

        System.out.println("Servidor escuchando en el puerto " + port);

        while(true){}
    }
}
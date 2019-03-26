package com.sd.cliente;

import com.sd.cliente.impl.Cliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * User: fcatania
 * Date: 26/3/2019
 * Time: 10:14
 */
public class ClienteRMI {

    public static void main(String[] args) throws RemoteException, NotBoundException {

        String host = "localhost";
        String port = "8080";
        if(args.length == 2){
            host = args[0];
            port = args[1];
        }else{
            System.out.println("No se ingreso ip y puerto, se utilizara por defecto localhost:8080");

        }
        if(!port.matches("\\d*")) throw new NumberFormatException("El puerto ingresado debe contener solo numeros");

        Cliente c  = new Cliente(Integer.valueOf(port),host);

        c.conexionRemota();
    }
}
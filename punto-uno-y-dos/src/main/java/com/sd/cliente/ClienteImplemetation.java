package com.sd.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * User: fcatania
 * Date: 25/3/2019
 * Time: 10:42
 */
public class ClienteImplemetation {

    public static void main(String[] args) {

        String host = "localhost";
        String port = "8080";
        if(args.length == 2){
            host = args[0];
            port = args[1];
        }else{
            System.out.println("No se ingreso ip y puerto, se utilizara por defecto localhost:8080");

        }

        if(!port.matches("\\d*")) throw new NumberFormatException("El puerto ingresado debe contener solo numeros");

        Client client = new Client(host,port);

    }


}
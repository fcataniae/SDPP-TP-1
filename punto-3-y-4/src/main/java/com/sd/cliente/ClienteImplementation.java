package com.sd.cliente;

/**
 * User: fcatania
 * Date: 25/3/2019
 * Time: 11:32
 */
public class ClienteImplementation {

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
package com.sd.server;

/**
 * User: fcatania
 * Date: 25/3/2019
 * Time: 11:32
 */
public class ServerImplementation {


    public static void main(String[] args) {

        String port = "8080";

        if(args.length != 0){
            port = args[0];
        }else{
            System.out.println("No se definio un parametro para el puerto, se utilizara por defecto el 8080");

        }

        if(!port.matches("\\d*")) throw new NumberFormatException("El puerto ingresado debe contener solo numeros");

        Server server = new Server(Integer.valueOf(port));
    }

}
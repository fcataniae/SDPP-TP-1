package com.sd.cliente;

import com.sd.com.sd.util.Mensaje;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * User: fcatania
 * Date: 25/3/2019
 * Time: 11:04
 */
public class Client {

    public Client(String host, String port){

        try (
                Socket s  = new Socket (host, Integer.valueOf(port))

        ){

            System.out.println(" Client connection ok");

            ObjectInputStream inputChannel = new ObjectInputStream (s.getInputStream());
            ObjectOutputStream outputChannel = new ObjectOutputStream(s.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.println("Encolar mensaje? 1");
            System.out.println("Recuperar mensaje? 2");
            System.out.println("Ingrese su opcion: ");

            String op = scanner.nextLine();

            switch (op) {

                case "1":   System.out.println("Ingrese su mensaje: ");
                            String msj = scanner.nextLine();
                            System.out.println("Ingrese su id de origen: ");
                            String idor = scanner.nextLine();
                            System.out.println("Ingrese su id de destino: ");
                            String idde = scanner.nextLine();
                            System.out.println("Ingrese su asunto: ");
                            String asunto = scanner.nextLine();

                            Mensaje m = new Mensaje(Integer.valueOf(idor), Integer.valueOf(idde), asunto, msj);
                            outputChannel.writeObject(m);

                            System.out.println("Mensaje enviado correctamente");
                            break;

                case "2":   System.out.println("Ingrese su id: ");
                            String id = scanner.nextLine();
                            outputChannel.writeObject(id);

                            Mensaje men = (Mensaje)inputChannel.readObject();

                            System.out.println("Mensaje recibido desde el servidor: "+ men);
                            outputChannel.writeUTF("ACK");
                            System.out.println("ACK Enviado");
                            break;
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
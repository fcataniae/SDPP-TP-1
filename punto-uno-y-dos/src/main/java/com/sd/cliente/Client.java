package com.sd.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
            BufferedReader inputChannel = new BufferedReader (new InputStreamReader(s.getInputStream()));
            PrintWriter outputChannel = new PrintWriter (s.getOutputStream(),true);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Ingrese su mensaje: ");
            String msj = scanner.nextLine();

            outputChannel.println (msj);

            String response = inputChannel.readLine();

            System.out.println(" Response from server: "+response);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
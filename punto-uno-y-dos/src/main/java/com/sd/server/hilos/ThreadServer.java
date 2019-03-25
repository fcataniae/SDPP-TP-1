package com.sd.server.hilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * User: fcatania
 * Date: 25/3/2019
 * Time: 11:10
 */
public class ThreadServer implements Runnable{

    private Socket client;
    private int idSession;

    public ThreadServer (Socket client, int id) {
        this.idSession = id;
        this.client = client;
    }

    public void run() {

        System.out.println("Corriendo thread con id: " + this.idSession);
        try {
            BufferedReader inputChannel = new BufferedReader (new InputStreamReader(this.client.getInputStream()));
            PrintWriter outputChannel = new PrintWriter (this.client.getOutputStream(),true);

            String msg = inputChannel.readLine();
            System.out.println(" MSG from client: "+msg);
            msg+=" from server";
            outputChannel.println(msg);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
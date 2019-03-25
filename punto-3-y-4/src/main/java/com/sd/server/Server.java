package com.sd.server;

import com.sd.com.sd.util.Mensaje;
import com.sd.server.hilos.ThreadServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * User: fcatania
 * Date: 25/3/2019
 * Time: 11:09
 */
public class Server {

    int port;
    private List<Mensaje> mensajes = new ArrayList<>();
    public Server(int i) {
        this.port = i;
        this.startServer();

    }
    private void startServer() {
        try (
                ServerSocket ss = new ServerSocket (this.port);
                ){

            System.out.println(" Iniciando servidor en: "+this.port);


            int id = 0;
            while (true) { //NOSONAR:

                Socket client = ss.accept();
                System.out.println("Cliente conectado desde: "+client.getInetAddress().getCanonicalHostName()+" : "+client.getPort());

                ThreadServer ts = new ThreadServer(client, id, mensajes);
                Thread tsThread = new Thread (ts);
                tsThread.start();
                id++;
            }
        } catch (IOException e) {
            System.out.println(" port in use");
        }
    }

}
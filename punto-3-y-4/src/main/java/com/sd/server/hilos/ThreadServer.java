package com.sd.server.hilos;

import com.sd.com.sd.util.Mensaje;

import java.io.*;
import java.net.Socket;
import java.util.List;

/**
 * User: fcatania
 * Date: 25/3/2019
 * Time: 11:10
 */
public class ThreadServer implements Runnable{

    private Socket client;
    private int idSession;
    private List<Mensaje> mensajes;

    public ThreadServer (Socket client, int id, List<Mensaje> list) {
        this.idSession = id;
        this.client = client;
        this.mensajes = list;
    }

    public void run() {

        System.out.println("Corriendo thread con id: " + this.idSession);
        try {
            ObjectInputStream inputChannel = new ObjectInputStream(this.client.getInputStream());
            ObjectOutputStream outputChannel = new ObjectOutputStream(this.client.getOutputStream());

            Object o = inputChannel.readObject();

            if(o instanceof Mensaje){
                Mensaje msg = (Mensaje) o;
                System.out.println(" MSG from client: " + msg);

                this.mensajes.add(msg);
            }else{
                String s = (String) o;
                Mensaje m = null;
                for(Mensaje men: this.mensajes){
                    if(men.getId_destino() == Integer.valueOf(s))
                        m = men;
                }

                outputChannel.writeObject(m);
                String ack = inputChannel.readUTF();
                if(ack.equals("ACK"))
                    mensajes.remove(m);
                else
                    System.out.println("No se recibio ningun ACK.");
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.mensajes.toString());
            this.client.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
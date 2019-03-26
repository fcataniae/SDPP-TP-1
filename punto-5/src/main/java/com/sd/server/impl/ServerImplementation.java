package com.sd.server.impl;

import com.sd.interfaces.InterfazRemota;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * User: fcatania
 * Date: 26/3/2019
 * Time: 10:17
 */
public class ServerImplementation implements InterfazRemota {


    private static String[] estados = {"Nublado","Soleado","con LLuvias", "con Nieve", "Parcialmente Nublado"};



    @Override
    public Object getInformacionClimaServer() throws RemoteException {
        String ob = "";

        Random r = new Random();
        int n = r.nextInt(5);

        ob = "El dia estara " + estados[n] ;

        int tempAux = r.nextInt(80) - 37;
        int tempAux2 = r.nextInt(80) - 37;



        if(tempAux > tempAux2)
            ob += " con Maxima de " + tempAux +"°C y minima de " + tempAux2 + "°C.";
        else
            ob += " con Maxima de " + tempAux2 +"°C y minima de " + tempAux + "°C.";


        return ob;
    }
}
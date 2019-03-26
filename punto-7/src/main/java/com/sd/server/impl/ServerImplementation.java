package com.sd.server.impl;

import com.sd.interfaces.InterfazRemota;
import com.sd.interfaces.Tarea;

import java.rmi.RemoteException;

/**
 * User: fcatania
 * Date: 26/3/2019
 * Time: 10:17
 */
public class ServerImplementation implements InterfazRemota {


    public Object ejecutar(Tarea t) throws RemoteException {
        return t.ejecutar();
    }
}
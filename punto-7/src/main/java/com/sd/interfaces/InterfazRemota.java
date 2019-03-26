package com.sd.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * User: fcatania
 * Date: 26/3/2019
 * Time: 10:15
 */
public interface InterfazRemota  extends Remote{

    Object ejecutar(Tarea t) throws RemoteException;

}
package com.sd.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * User: fcatania
 * Date: 26/3/2019
 * Time: 10:15
 */
public interface InterfazRemota  extends Remote{

    Object getInformacionClimaServer() throws RemoteException;

}
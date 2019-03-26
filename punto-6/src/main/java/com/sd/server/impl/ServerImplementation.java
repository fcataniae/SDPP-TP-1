package com.sd.server.impl;

import com.sd.interfaces.InterfazRemota;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * User: fcatania
 * Date: 26/3/2019
 * Time: 10:17
 */
public class ServerImplementation implements InterfazRemota {



    @Override
    public Object sumaVectores(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        ArrayList<Integer> l3 = new ArrayList<>();

        Iterator i1 = l1.listIterator();
        Iterator i2 = l2.listIterator();

        while(i1.hasNext() && i2.hasNext()){
            Integer integ = (Integer) i1.next() + (Integer) i2.next();
            l3.add(integ);
        }

        return l3;
    }
}
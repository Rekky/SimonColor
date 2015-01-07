package com.ziroudev.simoncolor.simoncolor;

/**
 * Created by Rekky on 03/01/2015.
 */
public class Secuencia {
    int n;
    String[] vectorSimon = new String[100];

    public Secuencia(){

        for(int i=0; i< vectorSimon.length; i++) {
            n = (int)(Math.random()*(100-0)+0);
            if (n >= 0 && n < 25)
                vectorSimon[i] = "Rojo";
            else if (n >= 25 && n < 50)
                vectorSimon[i] = "Azul";
            else if (n >= 50 && n < 75)
                vectorSimon[i] = "Verde";
            else if (n >= 75 && n < 100)
                vectorSimon[i] = "Azul";
        }
    }
}

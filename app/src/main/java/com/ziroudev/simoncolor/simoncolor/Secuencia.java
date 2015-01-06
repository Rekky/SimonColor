package com.ziroudev.simoncolor.simoncolor;

/**
 * Created by Rekky on 03/01/2015.
 */
public class Secuencia {
    int n;
    String[] vectorSecuencia = new String[100];

    public Secuencia(){

        for(int i=0; i<vectorSecuencia.length; i++) {
            n = (int)(Math.random()*(100-0)+0);
            if (n > 0 && n < 25)
                vectorSecuencia[i] = "Rojo";
            else if (n > 25 && n < 50)
                vectorSecuencia[i] = "Azul";
            else if (n > 50 && n < 75)
                vectorSecuencia[i] = "Verde";
            else if (n > 75 && n < 100)
                vectorSecuencia[i] = "Azul";
        }
    }
}

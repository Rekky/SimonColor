package com.ziroudev.simoncolor.simoncolor;

/**
 * Created by Rekky on 03/01/2015.
 */
public class Secuencia {
    int n;
    String[] vectorSimon = new String[100];

    public Secuencia(){

        for(int i=0; i< vectorSimon.length; i++) {
            n = (int)(Math.random()*(40-0)+0);
            if (n >= 0 && n < 10)
                vectorSimon[i] = "Rojo";
            else if (n >= 10 && n < 20)
                vectorSimon[i] = "Azul";
            else if (n >= 20 && n < 30)
                vectorSimon[i] = "Verde";
            else if (n >= 30 && n <= 40)
                vectorSimon[i] = "Amarillo";
        }
    }
}

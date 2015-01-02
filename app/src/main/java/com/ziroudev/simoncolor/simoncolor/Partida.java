package com.ziroudev.simoncolor.simoncolor;

import android.graphics.Color;
import android.widget.Button;

/**
 * Created by Rekky on 01/01/2015.
 */
public class Partida extends Thread{
    int n;

    public Button genera(Button button) {

            n = (int) (Math.random() * (100 - 0) + 0);

            if(n > 0 && n < 25)
                button.setBackgroundColor(Color.rgb(160, 255, 160));
            else if(n > 25 && n < 50)
                button.setBackgroundColor(Color.CYAN);
            else if(n > 50 && n < 75)
                button.setBackgroundColor(Color.GRAY);
            else if(n > 75 && n < 100)
                button.setBackgroundColor(Color.WHITE);

            return button;
    }

}

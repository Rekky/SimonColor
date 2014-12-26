package com.ziroudev.simoncolor.simoncolor;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class Nivel1 extends ActionBarActivity {

    //rango para el random
    private int max,min,n;
    private ImageView vi1, vi2, vi3, vi4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel1);

        vi1 = (ImageView) findViewById(R.id.image1);
        vi2 = (ImageView) findViewById(R.id.image2);
        vi3 = (ImageView) findViewById(R.id.image3);
        vi4 = (ImageView) findViewById(R.id.image4);
    }

    //metodo que retorna sun numero aleatorio entre min y max
    public int  random(int max,int min){
        n = (int)(Math.random()*(max-min)+min);
        return n;
    }

    public void cambiaImagen(){
        // vi1.setBackgroundColor(new Color(34,43,5));

    }

    //metodo que hace una accion al clicar cualquier imageView
    public void onClick(View v){

        if(v.getId() == R.id.image1){

        }
        else if(v.getId() == R.id.image2){

        }
        else if(v.getId() == R.id.image3){

        }
        else if(v.getId() == R.id.image4){

        }
    }
}

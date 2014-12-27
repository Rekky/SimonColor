package com.ziroudev.simoncolor.simoncolor;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.annotation.Target;


public class Nivel1 extends ActionBarActivity implements View.OnTouchListener{
    //con esta variable sabemos que cololes de botones tenemos
    private int estado;
    //rango para el random
    private int max,min,n;
    private Button but1, but2, but3, but4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel1);

        estado=0;
        but1 = (Button) findViewById(R.id.button1);
        but2 = (Button) findViewById(R.id.button2);
        but3 = (Button) findViewById(R.id.button3);
        but4 = (Button) findViewById(R.id.button4);

        //añado el touchListener a cada boton
        but1.setOnTouchListener(this);
        but2.setOnTouchListener(this);
        but3.setOnTouchListener(this);
        but4.setOnTouchListener(this);

        iniciarBotones();
    }

    //metodo que retorna sun numero aleatorio entre min y max
    public int  random(int max,int min){
        n = (int)(Math.random()*(max-min)+min);
        return n;
    }

    //metodo para iniciar los colores aleatoriamente
    public void iniciarBotones(){
        n = random(0,20);
        Toast.makeText(this,n+"",Toast.LENGTH_LONG).show();
        //orden rojo,verde,azul,amarillo
        if(n>=0 && n<5){
            Toast.makeText(this,"de 0 a 5", Toast.LENGTH_LONG).show();
            but1.setBackgroundColor(Color.rgb(255, 0, 0));
            but2.setBackgroundColor(Color.rgb(0, 255, 0));
            but3.setBackgroundColor(Color.rgb(0, 0, 255));
            but4.setBackgroundColor(Color.rgb(255, 255, 0));
            estado=1;
        }
        //orden amarillo,azul,verde,rojo
        else if(n>=5 && n<10){
            Toast.makeText(this,"de 5 a 10", Toast.LENGTH_LONG).show();
            but1.setBackgroundColor(Color.rgb(255, 255, 0));
            but2.setBackgroundColor(Color.rgb(0, 0, 255));
            but3.setBackgroundColor(Color.rgb(0, 255, 0));
            but4.setBackgroundColor(Color.rgb(255, 0, 0));
            estado=2;
        }
        //orden azul,amarillo,rojo,verde
        else if(n>=10 && n<15){
            Toast.makeText(this,"de 10 a 15", Toast.LENGTH_LONG).show();
            but1.setBackgroundColor(Color.rgb(0, 0, 255));
            but2.setBackgroundColor(Color.rgb(255, 255, 0));
            but3.setBackgroundColor(Color.rgb(255, 0, 0));
            but4.setBackgroundColor(Color.rgb(0, 255, 0));
            estado=3;
        }
        //verde,rojo,amarillo,azul
        else if(n>=15 && n<20){
            Toast.makeText(this,"de 15 a 20", Toast.LENGTH_LONG).show();
            but1.setBackgroundColor(Color.rgb(0, 255, 0));
            but2.setBackgroundColor(Color.rgb(255, 0, 0));
            but3.setBackgroundColor(Color.rgb(255, 255, 0));
            but4.setBackgroundColor(Color.rgb(0, 0, 255));
            estado=4;
        }
    }

    //metodo que hace una accion al clicar cualquier imageView
    public void onClick(View v){

        if(v.getId() == R.id.button1){
            //but1.setBackgroundColor(Color.rgb(54, 235, 111));
            //envio el boton1
            onTouch(but1,null);

        }
        else if(v.getId() == R.id.button2){
            //but2.setBackgroundColor(Color.rgb(253,23,23));
            //envio el boton2
            onTouch(but2,null);

        }
        else if(v.getId() == R.id.button3){
            //but3.setBackgroundColor(Color.rgb(23,253,23));
            //envio el boton3
            onTouch(but3,null);

        }
        else if(v.getId() == R.id.button4){
            //but4.setBackgroundColor(Color.rgb(245, 3, 4));
            //envio el boton4
            onTouch(but4,null);

        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //orde de colores 1 rojo,verde,azul,amarillo
        if(estado == 1) {
            //al dar clic a los botones cambian de color
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //cambia solo el boton seleccionado
                if( v.getId() == R.id.button1){
                    but1.setBackgroundColor(Color.rgb(255, 160, 160));
                }
                else if(v.getId() == R.id.button2) {
                    but2.setBackgroundColor(Color.rgb(160, 255, 160));
                }
                else if(v.getId() == R.id.button3){
                    but3.setBackgroundColor(Color.rgb(160, 160, 255));
                }
                else if(v.getId() == R.id.button4){
                    but4.setBackgroundColor(Color.rgb(255, 255, 160));
                }

            }
            //al dejar de dar click regresan a su color actual
            if (event.getAction() == MotionEvent.ACTION_UP) {
                but1.setBackgroundColor(Color.rgb(255, 0, 0));
                but2.setBackgroundColor(Color.rgb(0, 255, 0));
                but3.setBackgroundColor(Color.rgb(0, 0, 255));
                but4.setBackgroundColor(Color.rgb(255, 255, 0));
            }
        }
        else if(estado == 2){
            //al dar clic a los botones cambian de color
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                if(v.getId() == R.id.button1){
                    but1.setBackgroundColor(Color.rgb(255, 255, 160));
                }
                else if(v.getId() == R.id.button2){
                    but2.setBackgroundColor(Color.rgb(160, 160, 255));
                }
                else  if(v.getId() == R.id.button3){
                    but3.setBackgroundColor(Color.rgb(160, 255,160));
                }
                else if(v.getId() == R.id.button4){
                    but4.setBackgroundColor(Color.rgb(255, 160, 160));
                }
            }
            //al dejar de dar click regresan a su color actual
            if (event.getAction() == MotionEvent.ACTION_UP) {
                but1.setBackgroundColor(Color.rgb(255, 255, 0));
                but2.setBackgroundColor(Color.rgb(0, 0, 255));
                but3.setBackgroundColor(Color.rgb(0, 255, 0));
                but4.setBackgroundColor(Color.rgb(255, 0, 0));
            }
        }
        else if(estado == 3){
                //al dar clic a los botones cambian de color
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    if(v.getId() == R.id.button1) {
                        but1.setBackgroundColor(Color.rgb(160, 160, 255));
                    }
                    else if(v.getId() == R.id.button2){
                        but2.setBackgroundColor(Color.rgb(255, 255, 160));
                    }
                    else if(v.getId() == R.id.button3){
                        but3.setBackgroundColor(Color.rgb(255, 160, 160));
                    }
                    else if(v.getId() == R.id.button4) {
                        but4.setBackgroundColor(Color.rgb(160, 255, 160));
                    }
                }
                //al dejar de dar click regresan a su color actual
                if(event.getAction() == MotionEvent.ACTION_UP){
                    but1.setBackgroundColor(Color.rgb(0, 0, 255));
                    but2.setBackgroundColor(Color.rgb(255, 255, 0));
                    but3.setBackgroundColor(Color.rgb(255, 0, 0));
                    but4.setBackgroundColor(Color.rgb(0, 255, 0));
                }
        }
        else if(estado == 4) {
                //al dar clic a los botones cambian de color
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if(v.getId() == R.id.button1) {
                        but1.setBackgroundColor(Color.rgb(160, 255, 160));
                    }
                    else if(v.getId() == R.id.button2) {
                        but2.setBackgroundColor(Color.rgb(255, 160, 160));
                    }
                    else if(v.getId() == R.id.button3){
                        but3.setBackgroundColor(Color.rgb(255, 255, 160));
                    }
                    else if(v.getId() == R.id.button4){
                        but4.setBackgroundColor(Color.rgb(160, 160, 255));
                    }
                }
                //al dejar de dar click regresan a su color actual
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    but1.setBackgroundColor(Color.rgb(0, 255, 0));
                    but2.setBackgroundColor(Color.rgb(255, 0, 0));
                    but3.setBackgroundColor(Color.rgb(255, 255, 0));
                    but4.setBackgroundColor(Color.rgb(0, 0, 255));
                }
        }
        return true;
    }
}

package com.ziroudev.simoncolor.simoncolor;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;


public class Nivel1 extends ActionBarActivity implements View.OnTouchListener{
    //con esta variable sabemos que cololes de botones tenemos
    private int estado;

    //variables de dialogo
    private Dialog dialog;

    //variables generales
    Secuencia secuencia = new Secuencia();
    private int contador = 3;
    private int max,min,n;
    Button but1, but2, but3, but4;
    TextView text;
    int xi=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel1);

        //creacion dialogo del contador{
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogo);
        text = (TextView) dialog.findViewById(R.id.textViewDialog);
        text.setText(""+contador+"");
        dialog.setCancelable(false);
        //}

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

        //llama al metodo de inciar botones aleatoriamente
        iniciarBotones();
        cuentaAtras();
    }

    //metodo que retorna sun numero aleatorio entre min y max
    public int  random(int max,int min){
        n = (int)(Math.random()*(max-min)+min);
        return n;
    }

    //metodo para iniciar los colores aleatoriamente
    public void iniciarBotones(){
        n = random(0,20);
        //Toast.makeText(this,n+"", LENGTH_SHORT).show();
        //orden rojo,verde,azul,amarillo
        if(n>=0 && n<5){
            Toast.makeText(this,"de 0 a 5", LENGTH_SHORT).show();
            but1.setBackgroundColor(Color.rgb(255, 0, 0));
            but2.setBackgroundColor(Color.rgb(0, 255, 0));
            but3.setBackgroundColor(Color.rgb(0, 0, 255));
            but4.setBackgroundColor(Color.rgb(255, 255, 0));
            estado=1;
        }
        //orden amarillo,azul,verde,rojo
        else if(n>=5 && n<10){
            Toast.makeText(this,"de 5 a 10", LENGTH_SHORT).show();
            but1.setBackgroundColor(Color.rgb(255, 255, 0));
            but2.setBackgroundColor(Color.rgb(0, 0, 255));
            but3.setBackgroundColor(Color.rgb(0, 255, 0));
            but4.setBackgroundColor(Color.rgb(255, 0, 0));
            estado=2;
        }
        //orden azul,amarillo,rojo,verde
        else if(n>=10 && n<15){
            Toast.makeText(this,"de 10 a 15", LENGTH_SHORT).show();
            but1.setBackgroundColor(Color.rgb(0, 0, 255));
            but2.setBackgroundColor(Color.rgb(255, 255, 0));
            but3.setBackgroundColor(Color.rgb(255, 0, 0));
            but4.setBackgroundColor(Color.rgb(0, 255, 0));
            estado=3;
        }
        //verde,rojo,amarillo,azul
        else if(n>=15 && n<20){
            Toast.makeText(this,"de 15 a 20", LENGTH_SHORT).show();
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
            onTouch(but1,null);
        }
        else if(v.getId() == R.id.button2){
            onTouch(but2,null);
        }
        else if(v.getId() == R.id.button3){
            onTouch(but3,null);
        }
        else if(v.getId() == R.id.button4){
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
                if( v.getId() == R.id.button1)
                    but1.setBackgroundColor(Color.rgb(255, 160, 160));
                else if(v.getId() == R.id.button2)
                    but2.setBackgroundColor(Color.rgb(160, 255, 160));
                else if(v.getId() == R.id.button3)
                    but3.setBackgroundColor(Color.rgb(160, 160, 255));
                else if(v.getId() == R.id.button4)
                    but4.setBackgroundColor(Color.rgb(255, 255, 160));
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
                if(v.getId() == R.id.button1)
                    but1.setBackgroundColor(Color.rgb(255, 255, 160));
                else if(v.getId() == R.id.button2)
                    but2.setBackgroundColor(Color.rgb(160, 160, 255));
                else  if(v.getId() == R.id.button3)
                    but3.setBackgroundColor(Color.rgb(160, 255,160));
                else if(v.getId() == R.id.button4)
                    but4.setBackgroundColor(Color.rgb(255, 160, 160));
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
                    if(v.getId() == R.id.button1)
                        but1.setBackgroundColor(Color.rgb(160, 160, 255));
                    else if(v.getId() == R.id.button2)
                        but2.setBackgroundColor(Color.rgb(255, 255, 160));
                    else if(v.getId() == R.id.button3)
                        but3.setBackgroundColor(Color.rgb(255, 160, 160));
                    else if(v.getId() == R.id.button4)
                        but4.setBackgroundColor(Color.rgb(160, 255, 160));
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
                    if(v.getId() == R.id.button1)
                        but1.setBackgroundColor(Color.rgb(160, 255, 160));
                    else if(v.getId() == R.id.button2)
                        but2.setBackgroundColor(Color.rgb(255, 160, 160));
                    else if(v.getId() == R.id.button3)
                        but3.setBackgroundColor(Color.rgb(255, 255, 160));
                    else if(v.getId() == R.id.button4)
                        but4.setBackgroundColor(Color.rgb(160, 160, 255));
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

    //sale el dialogo de la cuenta atras antes de inciar partida
    public void cuentaAtras(){
        new CuentaAtras().execute();
    }

    //metodo que empieza a mostrar el patron a seguir de simon
    public void empiezaPartida(){

        Thread the = new Thread(){
                @Override
                public void run () {

                    for(xi=0; xi<secuencia.vectorSecuencia.length; xi++) {
                        try {
                            synchronized (this) {
                                Log.e("zirou",""+secuencia.vectorSecuencia[xi]);
                                sleep(500);
                                //el run siguiente hace pueda cojer los recursos del thread principal
                                //para poder cambiar los colores de los buttons
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if(estado == 1){
                                            if(secuencia.vectorSecuencia[xi] == 'R')
                                                but1.setBackgroundColor(Color.rgb(255, 160, 160));
                                            else if(secuencia.vectorSecuencia[xi] == 'V')
                                                but2.setBackgroundColor(Color.rgb(160, 255, 160));
                                            else if(secuencia.vectorSecuencia[xi] == 'Z')
                                                but3.setBackgroundColor(Color.rgb(160, 160, 255));
                                            else if(secuencia.vectorSecuencia[xi] == 'A')
                                                but4.setBackgroundColor(Color.rgb(255, 255, 160));
                                        }
                                        else if(estado == 2){
                                            if(secuencia.vectorSecuencia[xi] == 'A')
                                                but1.setBackgroundColor(Color.rgb(255, 255, 160));
                                            else if(secuencia.vectorSecuencia[xi] == 'Z')
                                                but2.setBackgroundColor(Color.rgb(160, 160, 255));
                                            else if(secuencia.vectorSecuencia[xi] == 'V')
                                                but3.setBackgroundColor(Color.rgb(160, 255,160));
                                            else if(secuencia.vectorSecuencia[xi] == 'R')
                                                but4.setBackgroundColor(Color.rgb(255, 160, 160));
                                        }
                                        else if(estado == 3){
                                            if(secuencia.vectorSecuencia[xi] == 'Z')
                                                but1.setBackgroundColor(Color.rgb(160, 160, 255));
                                            else if(secuencia.vectorSecuencia[xi] == 'A')
                                                but2.setBackgroundColor(Color.rgb(255, 255, 160));
                                            else if(secuencia.vectorSecuencia[xi] == 'R')
                                                but3.setBackgroundColor(Color.rgb(255, 160, 160));
                                            else if(secuencia.vectorSecuencia[xi] == 'V')
                                                but4.setBackgroundColor(Color.rgb(160, 255, 160));
                                        }
                                        else if(estado == 4) {
                                            if(secuencia.vectorSecuencia[xi] == 'V')
                                                but1.setBackgroundColor(Color.rgb(160, 255, 160));
                                            else if(secuencia.vectorSecuencia[xi] == 'R')
                                                but2.setBackgroundColor(Color.rgb(255, 160, 160));
                                            else if(secuencia.vectorSecuencia[xi] == 'A')
                                                but3.setBackgroundColor(Color.rgb(255, 255, 160));
                                            else if(secuencia.vectorSecuencia[xi] == 'Z')
                                                but4.setBackgroundColor(Color.rgb(160, 160, 255));
                                        }
                                    }
                                });

                                sleep(500);//duerme el thread//

                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                            if(estado == 1){
                                                but1.setBackgroundColor(Color.rgb(255, 0, 0));
                                                but2.setBackgroundColor(Color.rgb(0, 255, 0));
                                                but3.setBackgroundColor(Color.rgb(0, 0, 255));
                                                but4.setBackgroundColor(Color.rgb(255, 255, 0));
                                            }else if(estado == 2){
                                                but1.setBackgroundColor(Color.rgb(255, 255, 0));
                                                but2.setBackgroundColor(Color.rgb(0, 0, 255));
                                                but3.setBackgroundColor(Color.rgb(0, 255, 0));
                                                but4.setBackgroundColor(Color.rgb(255, 0, 0));
                                            }else if(estado == 3){
                                                but1.setBackgroundColor(Color.rgb(0, 0, 255));
                                                but2.setBackgroundColor(Color.rgb(255, 255, 0));
                                                but3.setBackgroundColor(Color.rgb(255, 0, 0));
                                                but4.setBackgroundColor(Color.rgb(0, 255, 0));
                                            }else if(estado == 4){
                                                but1.setBackgroundColor(Color.rgb(0, 255, 0));
                                                but2.setBackgroundColor(Color.rgb(255, 0, 0));
                                                but3.setBackgroundColor(Color.rgb(255, 255, 0));
                                                but4.setBackgroundColor(Color.rgb(0, 0, 255));
                                            }
                                    }
                                });

                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
            }

        };
        the.start();


    }

    private class comenzarPartida extends AsyncTask<View, View, Void>{

        @Override
        protected Void doInBackground(View... params) {
            for(int i=0; i < 4; i++){
                n = (int) (Math.random() * (100 - 0) + 0);

                if(n > 0 && n < 25)
                    but1.setBackgroundColor(Color.DKGRAY);
                else if(n > 25 && n < 50)
                    but2.setBackgroundColor(Color.CYAN);
                else if(n > 50 && n < 75)
                    but3.setBackgroundColor(Color.GRAY);
                else if(n > 75 && n < 100)
                    but4.setBackgroundColor(Color.WHITE);
                Log.e("hola",""+n);

            }
            return null;
        }
    }


    /**
     * subclase Asyncrona para llevar el dialogo del contador
     */
    private class CuentaAtras extends AsyncTask<String, Float, Integer> {

        protected void onPreExecute() {
            dialog.show(); //Mostramos el diálogo antes de comenzar
        }

        protected Integer doInBackground(String... urls) {
            for (int i = 3; i > 0; i--) {
                //Simulamos cierto retraso
                try {
                    Thread.sleep(1000);
                    contador--;
                }
                catch (InterruptedException e){}
                publishProgress(i/250f);

            }
            return contador;
        }

        protected void onProgressUpdate (Float... valores) {
            text.setText(""+contador+"");
        }

        protected void onPostExecute(Integer bytes) {
            dialog.dismiss();
            empiezaPartida();
        }
    }
}

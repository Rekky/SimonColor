package com.ziroudev.simoncolor.simoncolor;

import android.app.Dialog;
import android.graphics.Color;
import android.os.AsyncTask;
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

    //con esta variable sabemos que colores de botones tenemos
    private int estado;
    private int score = 0;

    //variables de dialogo
    Dialog dialog;
    DialogFallo dialogFallo = new DialogFallo();

    //variables generales
    private boolean turnoSimon = true;
    Secuencia secuencia = new Secuencia();
    Button but1, but2, but3, but4;
    private TextView text, textoScore;
    private int contadorDialogo = 3;
    private int contadorSecuencia = 3;
    private int contadorComprueba = 0;
    private int n;
    int xi=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel1);

        //creacion dialogo del contadorDialogo{
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogo);
        text = (TextView) dialog.findViewById(R.id.textViewDialog);
        text.setText(""+ contadorDialogo +"");
        dialog.setCancelable(false);

        //text de score
        textoScore = (TextView) findViewById(R.id.textScore);

        //botones
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

    //metodo para iniciar los colores aleatoriamente
    public void iniciarBotones(){
        n = (int)(Math.random()*(20-0)+0);

        //orden rojo,verde,azul,amarillo
        if(n>=0 && n<5){
            but1.setBackgroundColor(Color.rgb(255, 0, 0));
            but2.setBackgroundColor(Color.rgb(0, 255, 0));
            but3.setBackgroundColor(Color.rgb(0, 0, 255));
            but4.setBackgroundColor(Color.rgb(255, 255, 0));
            estado=1;
        }
        //orden amarillo,azul,verde,rojo
        else if(n>=5 && n<10){
            but1.setBackgroundColor(Color.rgb(255, 255, 0));
            but2.setBackgroundColor(Color.rgb(0, 0, 255));
            but3.setBackgroundColor(Color.rgb(0, 255, 0));
            but4.setBackgroundColor(Color.rgb(255, 0, 0));
            estado=2;
        }
        //orden azul,amarillo,rojo,verde
        else if(n>=10 && n<15){
            but1.setBackgroundColor(Color.rgb(0, 0, 255));
            but2.setBackgroundColor(Color.rgb(255, 255, 0));
            but3.setBackgroundColor(Color.rgb(255, 0, 0));
            but4.setBackgroundColor(Color.rgb(0, 255, 0));
            estado=3;
        }
        //verde,rojo,amarillo,azul
        else if(n>=15 && n<20){
            but1.setBackgroundColor(Color.rgb(0, 255, 0));
            but2.setBackgroundColor(Color.rgb(255, 0, 0));
            but3.setBackgroundColor(Color.rgb(255, 255, 0));
            but4.setBackgroundColor(Color.rgb(0, 0, 255));
            estado=4;
        }
    }

    //metodo que hace una accion al clicar cualquier imageView
    public void onClick(View v){
        if(turnoSimon == false){

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
        }else{}
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
                    comprueba("Rojo");
                }
                else if(v.getId() == R.id.button2){
                    but2.setBackgroundColor(Color.rgb(160, 255, 160));
                    comprueba("Verde");
                }
                else if(v.getId() == R.id.button3){
                    but3.setBackgroundColor(Color.rgb(160, 160, 255));
                    comprueba("Azul");
                }
                else if(v.getId() == R.id.button4){
                    but4.setBackgroundColor(Color.rgb(255, 255, 160));
                    comprueba("Amarillo");
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
                    comprueba("Amarillo");
                }
                else if(v.getId() == R.id.button2){
                    but2.setBackgroundColor(Color.rgb(160, 160, 255));
                    comprueba("Azul");
                }
                else  if(v.getId() == R.id.button3){
                    but3.setBackgroundColor(Color.rgb(160, 255,160));
                    comprueba("Verde");
                }
                else if(v.getId() == R.id.button4){
                    but4.setBackgroundColor(Color.rgb(255, 160, 160));
                    comprueba("Rojo");
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
                    if(v.getId() == R.id.button1){
                        but1.setBackgroundColor(Color.rgb(160, 160, 255));
                        comprueba("Azul");
                    }
                    else if(v.getId() == R.id.button2){
                        but2.setBackgroundColor(Color.rgb(255, 255, 160));
                        comprueba("Amarillo");
                    }
                    else if(v.getId() == R.id.button3){
                        but3.setBackgroundColor(Color.rgb(255, 160, 160));
                        comprueba("Rojo");
                    }
                    else if(v.getId() == R.id.button4){
                        but4.setBackgroundColor(Color.rgb(160, 255, 160));
                        comprueba("Verde");
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
                    if(v.getId() == R.id.button1){
                        but1.setBackgroundColor(Color.rgb(160, 255, 160));
                        comprueba("Verde");
                    }
                    else if(v.getId() == R.id.button2){
                        but2.setBackgroundColor(Color.rgb(255, 160, 160));
                        comprueba("Rojo");
                    }
                    else if(v.getId() == R.id.button3){
                        but3.setBackgroundColor(Color.rgb(255, 255, 160));
                        comprueba("Amarillo");
                    }
                    else if(v.getId() == R.id.button4){
                        but4.setBackgroundColor(Color.rgb(160, 160, 255));
                        comprueba("Azul");
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

    //sale el dialogo de la cuenta atras antes de inciar partida
    public void cuentaAtras(){
        new CuentaAtras().execute();
    }

    //metodo que empieza a mostrar el patron a seguir de simon
    public void empiezaPartida(){

        Toast.makeText(this, "TURNO DE SIMON", LENGTH_SHORT).show();
        turnoSimon = true;

        Thread threadSecuencia = new Thread(){
                @Override
                public void run () {

                    for(xi=0; xi<contadorSecuencia; xi++) {
                        try {
                            synchronized (this) {
                                Log.e("SIMON",""+secuencia.vectorSimon[xi]);
                                sleep(400);
                                //el run siguiente hace pueda cojer los recursos del thread principal
                                //para poder cambiar los colores de los buttons
                                //cambia el color a un color iluminado
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if(estado == 1){
                                            if(secuencia.vectorSimon[xi] == "Rojo")
                                                but1.setBackgroundColor(Color.rgb(255, 160, 160));
                                            else if(secuencia.vectorSimon[xi] == "Verde")
                                                but2.setBackgroundColor(Color.rgb(160, 255, 160));
                                            else if(secuencia.vectorSimon[xi] =="azul")
                                                but3.setBackgroundColor(Color.rgb(160, 160, 255));
                                            else if(secuencia.vectorSimon[xi] == "Amarillo")
                                                but4.setBackgroundColor(Color.rgb(255, 255, 160));
                                        }
                                        else if(estado == 2){
                                            if(secuencia.vectorSimon[xi] == "Amarillo")
                                                but1.setBackgroundColor(Color.rgb(255, 255, 160));
                                            else if(secuencia.vectorSimon[xi] == "Azul")
                                                but2.setBackgroundColor(Color.rgb(160, 160, 255));
                                            else if(secuencia.vectorSimon[xi] == "Verde")
                                                but3.setBackgroundColor(Color.rgb(160, 255,160));
                                            else if(secuencia.vectorSimon[xi] == "Rojo")
                                                but4.setBackgroundColor(Color.rgb(255, 160, 160));
                                        }
                                        else if(estado == 3){
                                            if(secuencia.vectorSimon[xi] == "Azul")
                                                but1.setBackgroundColor(Color.rgb(160, 160, 255));
                                            else if(secuencia.vectorSimon[xi] == "Amarillo")
                                                but2.setBackgroundColor(Color.rgb(255, 255, 160));
                                            else if(secuencia.vectorSimon[xi] == "Rojo")
                                                but3.setBackgroundColor(Color.rgb(255, 160, 160));
                                            else if(secuencia.vectorSimon[xi] == "Verde")
                                                but4.setBackgroundColor(Color.rgb(160, 255, 160));
                                        }
                                        else if(estado == 4) {
                                            if(secuencia.vectorSimon[xi] == "Verde")
                                                but1.setBackgroundColor(Color.rgb(160, 255, 160));
                                            else if(secuencia.vectorSimon[xi] == "Rojo")
                                                but2.setBackgroundColor(Color.rgb(255, 160, 160));
                                            else if(secuencia.vectorSimon[xi] == "Amarillo")
                                                but3.setBackgroundColor(Color.rgb(255, 255, 160));
                                            else if(secuencia.vectorSimon[xi] == "Azul")
                                                but4.setBackgroundColor(Color.rgb(160, 160, 255));
                                        }
                                    }
                                });

                                sleep(400);//duerme el thread//
                                //devuleve el color a su estado original
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
        threadSecuencia.start();
        turnoSimon = false;
    }

    //clase que es llamada para comprobar si es correcta la secuencia del jugador
    public void comprueba(String color){
        Log.e("CONTADOR_AHORA", ""+contadorComprueba);
        Log.e("","VECTOR_SIMON_AHORA"+secuencia.vectorSimon[contadorComprueba]);
        //comparo el parametro que paso de color con el color del vector simon
        if(color == secuencia.vectorSimon[contadorComprueba]){
            contadorComprueba++;

            if(contadorComprueba == contadorSecuencia){
                //score
                score = score+1;
                textoScore.setText(String.valueOf(score));

                contadorSecuencia++;
                contadorComprueba = 0;
                empiezaPartida();
            }
        }else{
            dialogFallo.show(getFragmentManager(),"tagFallo");
        }

    }


    /**
     * subclase Asyncrona para llevar el dialogo del contadorDialogo
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
                    contadorDialogo--;
                }
                catch (InterruptedException e){}
                publishProgress(i/250f);

            }
            return contadorDialogo;
        }

        protected void onProgressUpdate (Float... valores) {
            text.setText(""+ contadorDialogo +"");
        }

        protected void onPostExecute(Integer bytes) {
            dialog.dismiss();
            empiezaPartida();
        }
    }

}

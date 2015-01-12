package com.ziroudev.simoncolor.simoncolor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Principal extends ActionBarActivity {
    Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        buttonStart = (Button) findViewById(R.id.buttonStart);
    }

    //metodo que llama al nivel de juego
    public void empiezaJuego(View v){
        Intent i = new Intent(this, Nivel1.class);
        startActivity(i);
    }

    
    //METODO PARA QUE CUANDO SE DE AL BOTON DE ATRAS DEL MOBIL TE SALGA UNA VENTANA
    //DE CONFIRMACION QUE COMFIRME SI DESEAS SALIR DEL JUEGO
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Salir")
                    .setMessage("Salir de Juego?")
                    .setNegativeButton(android.R.string.cancel, null)//sincolor listener
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {//un listener que al pulsar, cierre la aplicacion
                        @Override
                        public void onClick(DialogInterface dialog, int which){
                            //Salir
                            Principal.this.finish();
                        }
                    })
                    .show();
            // Si el listener devuelve true, significa que el evento esta procesado, y nadie debe hacer nada mas
            return true;
        }
        //para las demas cosas, se reenvia el evento al listener habitual
        return super.onKeyDown(keyCode, event);
    }
}

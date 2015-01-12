package com.ziroudev.simoncolor.simoncolor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.*;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class Principal extends ActionBarActivity {
    Button buttonStart;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        buttonStart = (Button) findViewById(R.id.buttonStart);

        // Crear el intersticial.
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId("ca-app-pub-1593828267033743/2017668118");

        // Crear la solicitud de anuncio.
        AdRequest adRequest = new AdRequest.Builder()
                .build();

        // Comenzar la carga del intersticial.
        interstitial.loadAd(adRequest);

        // Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });

    }

    //metodo que llama al nivel de juego
    public void empiezaJuego(View v){
        Intent i = new Intent(this, Nivel1.class);
        startActivity(i);
    }

    // Invoca displayInterstitial() cuando esté preparado para mostrar un intersticial de anuncio.
    public void displayInterstitial() {
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
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

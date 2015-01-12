package com.ziroudev.simoncolor.simoncolor;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Rekky on 07/01/2015.
 */
public class DialogFallo extends DialogFragment {

    private Context mContext;

    public DialogFallo(Context context) {
        this.mContext = context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Color incorrecto")
                .setTitle("Fallaste")
                .setPositiveButton("Volver a intentar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Intent menu = new Intent(mContext, Nivel1.class);
                        mContext.startActivity(menu);
                        ((Activity) mContext).finish();

                    }
                })
                .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        Intent menu = new Intent(mContext, Nivel1.class);
                        ((Activity) mContext).finish();

                    }
                });
        return builder.create();
    }
}

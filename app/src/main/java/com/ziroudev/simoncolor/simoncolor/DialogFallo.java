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

    Context mContext;

    public static DialogFallo newInstance(int id)
    {
        DialogFallo myFragment = new DialogFallo ();
        Bundle args = new Bundle();
        args.putInt("id", id);
        myFragment.setArguments(args);

        return myFragment;
    }

    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        super.onAttach(activity);
        mContext=activity;
    }

    /*
   public DialogFallo() {
        this.mContext = container.getContext();
    }*/

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

package layout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import odontologia.proyectoodontologia.R;

/**
 * Created by Justin Cast on 3/3/2017
 * Esta clase es la encargada de manejar la recuperacion de la contraseña
 */

public class RecoveryDialog extends android.support.v4.app.DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        final View view = inflater.inflate(R.layout.dialog_recovery_layout,null);
        final TextInputEditText emailEditTxt = (TextInputEditText) view.findViewById( R.id.username);
        builder.setView(inflater.inflate(R.layout.dialog_recovery_layout, null))
                // Aca se agregan los botones deseados
                .setPositiveButton(R.string.accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                        emailIntent.setData(Uri.parse("mailto:" + "justincastillovalladares@gmail.com"));
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My email's subject");
                        emailIntent.putExtra(Intent.EXTRA_TEXT, "My email's body");

                        try {
                            startActivity(Intent.createChooser(emailIntent, "Send email using..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(getContext(), "No email clients installed.", Toast.LENGTH_SHORT).show();
                        }

                        /*System.out.println((((TextInputEditText) getDialog().getLayoutInflater().inflate(R.layout.dialog_recovery_layout,null)).
                                getText().toString()));*/
                        if(emailEditTxt.getText().toString().isEmpty())
                            Toast.makeText(getContext(), getText(R.string.error_field_required), Toast.LENGTH_SHORT).show();
                        else if(!emailEditTxt.getText().toString().contains("@"))
                            Toast.makeText(getContext(), getText(R.string.error_invalid_email), Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getContext(), "Correo enviado a: " + emailEditTxt.getText().toString() , Toast.LENGTH_SHORT).show();

                        System.out.println(emailEditTxt.getText().toString());
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        return builder.create();
    }
}

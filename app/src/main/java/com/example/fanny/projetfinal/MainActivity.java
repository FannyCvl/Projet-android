package com.example.fanny.projetfinal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.id;
import static android.R.attr.name;

public class MainActivity extends Activity {

    private boolean haveInternetConnection(){
        // Fonction haveInternetConnection : return true si connecté, return false dans le cas contraire
        NetworkInfo network = ((ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();

        if (network==null || !network.isConnected())
        {
            // Le périphérique n'est pas connecté à Internet


            return false;
        }
        // Le périphérique est connecté à Internet
        return true;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (haveInternetConnection()==false){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this));
        builder.setTitle("Pas de connexion");
        builder.setPositiveButton("Réessayer", new  DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int idx) {
                Intent intent = getIntent());
                finish();
                startActivity(intent);
            }});
        builder.setNegativeButton("Fermer", new  DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int idx) {
                Intent intent = getIntent();
                finish();
            }});
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        }
        Intent intent = new Intent(MainActivity.this,Accueil.class);
        startActivity(intent);
    }



}

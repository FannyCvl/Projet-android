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

import org.json.JSONObject;

import java.util.ArrayList;

import static android.R.attr.id;
import static android.R.attr.name;

public class MainActivity extends Activity {

    private final Recup_articles recupart= new Recup_articles();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Thread(new Runnable() {
            public void run(){
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                assert connectivityManager!=null;
                NetworkInfo network = connectivityManager.getActiveNetworkInfo();
        if (network==null || !network.isConnected()){
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Pas de connexion");

            builder.setPositiveButton("Réessayer", new  DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int idx) {
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
            }});
            builder.setNegativeButton("Ok", new  DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int idx) {
                Intent intent = new Intent(MainActivity.this, Accueil.class);
                startActivity(intent);
            }});
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            MainActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    final AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });
        }
        else {
            try {
                synchronized (this) {
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                Log.d("TAG", "Waiting didnt work!!");
                e.printStackTrace();
            }
            ArrayList articles=recupart.Articles();
            Intent intent = new Intent(MainActivity.this, Accueil.class);
            startActivity(intent);
        }
            }
        }).start();


    }



}

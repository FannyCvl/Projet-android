package com.example.fanny.projetfinal.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fanny.projetfinal.R;
import com.example.fanny.projetfinal.Tools;
import com.example.fanny.projetfinal.api.Api;
import com.example.fanny.projetfinal.model.Article;
import com.example.fanny.projetfinal.model.ListArticles;
import com.example.fanny.projetfinal.model.ListSource;
import com.example.fanny.projetfinal.model.Source;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Accueil extends AppCompatActivity {

    public List<Source> listSource;
    public List<Article> listArticles;
    public ListView lvArticles;
    public ArticleListviewAdapter articleListviewAdapter;
    public Api api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        lvArticles = (ListView) findViewById(R.id.listViewArticles);
        String lastSource = Tools.getSource(getApplicationContext());
        api = new Api();
        getSources();
        getArticles(lastSource);
    }

    public void getArticles(String sourceId){
        Call<ListArticles> call = api.getArticlesList("d31f5fa5f03443dd8a1b9e3fde92ec34", "fr", sourceId);
        call.enqueue(new Callback<ListArticles>() {
            @Override
            public void onResponse(Call<ListArticles> call, Response<ListArticles> response) {
                ListArticles la = response.body();
                if(la != null){
                    System.out.println(la.getArticles());
                    listArticles = la.getArticles();
                    populateListView();

                }
            }

            @Override
            public void onFailure(Call<ListArticles> call, Throwable t) {

            }
        });
    }
    public void populateListView(){
        articleListviewAdapter = new ArticleListviewAdapter(getApplicationContext(), R.layout.listview_item, listArticles);
        lvArticles.setAdapter(articleListviewAdapter);
    }
    public void getSources(){

        Call<ListSource> call = api.getListSources("d31f5fa5f03443dd8a1b9e3fde92ec34", "fr");
        call.enqueue(new Callback<ListSource>() {
            @Override
            public void onResponse(Call<ListSource> call, Response<ListSource> response) {
                ListSource ls = response.body();
                System.out.println(ls);
                if (ls != null) {
                    listSource = ls.getSourceList();
                }
            }

            @Override
            public void onFailure(Call<ListSource> call, Throwable t) {

            }
        });
    }
    public void openPopup(View view) {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(Accueil.this);
        builderSingle.setIcon(R.mipmap.ic_launcher);

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Accueil.this, android.R.layout.select_dialog_singlechoice);
        for (Source s : listSource) {
            arrayAdapter.add(s.toString());
        }


        builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String strName = arrayAdapter.getItem(which);
                getArticles(listSource.get(which).getId());
                Tools.setSource(getApplicationContext(), listSource.get(which).getId());
            }
        });
        builderSingle.show();
    }
}

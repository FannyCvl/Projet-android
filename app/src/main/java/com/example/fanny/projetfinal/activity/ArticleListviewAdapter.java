package com.example.fanny.projetfinal.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fanny.projetfinal.R;
import com.example.fanny.projetfinal.model.Article;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ArticleListviewAdapter extends ArrayAdapter<Article> {


    public ArticleListviewAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public ArticleListviewAdapter(Context context, int resource, List<Article> items) {
        super(context, resource, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.listview_item, null);
        }
        Article a = getItem(position);

        if (a != null) {
            TextView titleTxt = (TextView) v.findViewById(R.id.titleTxt);
            TextView authorTxt = (TextView) v.findViewById(R.id.authorTxt);
            TextView dateTxt = (TextView) v.findViewById(R.id.dateTxt);
            ImageView img = (ImageView) v.findViewById(R.id.imgArticle);

            if (titleTxt != null) {
                if(a.getTitle() == null){
                    authorTxt.setText("Titre introuvable");
                } else {
                    titleTxt.setText(a.getTitle());
                }
            }

            if (authorTxt != null) {
                if (a.getAuthor() == null) {
                    authorTxt.setText("Auteur Inconnu");
                } else {
                    authorTxt.setText(a.getAuthor());
                }
            }

            if (dateTxt != null) {
                if (a.getPublishedAt() == null) {
                    dateTxt.setText("Date Inconnue");
                } else {
                    dateTxt.setText(a.getPublishedAt());
                }
            }
            if(img != null){
                if(a.getUrlToImage() != null){
                    URL url = null;
                    try {
                        url = new URL(a.getUrlToImage());
                        Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                        img.setImageBitmap(bmp);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    img.setImageResource(R.drawable.ic_block_black_24dp);
                    img.setColorFilter(R.color.red);
                }
            }
        }

        return v;
    }
}

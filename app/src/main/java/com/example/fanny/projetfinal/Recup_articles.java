package com.example.fanny.projetfinal;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Recup_articles {
    public static ArrayList<Article> Articles() {

        ArrayList<Article> articles = new ArrayList<Article>();

        try {
            String myurl= "https://newsapi.org/v2/everything?apiKey=d31f5fa5f03443dd8a1b9e3fde92ec34&language=fr&sources=google-news-fr";

            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            /*
             * InputStreamOperations est une classe complémentaire:
             * Elle contient une méthode InputStreamToString.
             */
            String result = InputStreamOperations.InputStreamToString(inputStream);

            JSONObject jsonObject = new JSONObject(result);
            JSONArray array = new JSONArray(jsonObject.getString("articles"));
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = new JSONObject(array.getString(i));
                Article article = new Article();
                article.setId(obj.getString("id"));
                article.setName(obj.getString("name"));
                article.setAuthor(obj.getString("author"));
                article.setTitle(obj.getString("title"));
                article.setDescription(obj.getString("description"));
                article.setUrl(obj.getString("url"));
                article.setUrlToImage(obj.getString("urlToImage"));
                article.setPublishedAt(obj.getString("publishedAt"));
                articles.add(article);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return articles;
    }
}

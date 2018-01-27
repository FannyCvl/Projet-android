//package com.example.fanny.projetfinal;
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//
//
//public class Recup_data {
//
//    public static ArrayList<Source> getSources() {
//
//        ArrayList<Source> sources = new ArrayList<Source>();
//
//        try {
//            String myurl= "https://newsapi.org/v2/sources?apiKey=d31f5fa5f03443dd8a1b9e3fde92ec34&language=fr";
//
//            URL url = new URL(myurl);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.connect();
//            InputStream inputStream = connection.getInputStream();
//            /*
//             * InputStreamOperations est une classe complémentaire:
//             * Elle contient une méthode InputStreamToString.
//             */
//            String result = InputStreamOperations.InputStreamToString(inputStream);
//
//            JSONObject jsonObject = new JSONObject(result);
//            JSONArray array = new JSONArray(jsonObject.getString("sources"));
//            for (int i = 0; i < array.length(); i++) {
//                JSONObject obj = new JSONObject(array.getString(i));
//                Source source = new Source();
//                source.setId(obj.getString("id"));
//                source.setName(obj.getString("name"));
//                source.setDescription(obj.getString("description"));
//                source.setUrl(obj.getString("url"));
//                source.setCategory(obj.getString("category"));
//                source.setLanguage(obj.getString("language"));
//                source.setCountry(obj.getString("country"));
//                sources.add(source);
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return sources;
//    }
//}


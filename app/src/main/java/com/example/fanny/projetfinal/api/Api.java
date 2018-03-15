package com.example.fanny.projetfinal.api;

import com.example.fanny.projetfinal.model.ListArticles;
import com.example.fanny.projetfinal.model.ListSource;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class Api {
    private ApiService apiService;

    public Api() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.apiService = retrofit.create(ApiService.class);
    }
    public Call<ListSource> getListSources(String apiKey, String language){
        return apiService.getListSource(apiKey, language);
    }
    public Call<ListArticles> getArticlesList(String apiKey, String language, String sourceId){
        return apiService.getArticlesList(apiKey, language, sourceId);
    }

    public interface ApiService {
        @GET("sources")
        Call<ListSource> getListSource(
                @Query("apiKey") String apiKey,
                @Query("language") String language
        );
        @GET("everything")
        Call<ListArticles> getArticlesList(
                @Query("apiKey") String apiKey,
                @Query("language") String language,
                @Query("sources") String sourceId
        );

    }
}

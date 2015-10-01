package com.feresr.dagger2;

import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.Converter.Factory;
/**
 * Created by fernando.raviola on 01/10/2015.
 */
public final class GitHubApi {

    private static GitHubEndpoints service;

    public GitHubApi() {
        super();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        service = retrofit.create(GitHubEndpoints.class);
    }

    public static GitHubEndpoints getService() {
        return service;
    }
}

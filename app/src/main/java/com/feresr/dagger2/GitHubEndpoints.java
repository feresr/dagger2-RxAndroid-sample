package com.feresr.dagger2;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by fernando.raviola on 01/10/2015.
 */
public interface GitHubEndpoints {
    @GET("users")
    Observable<List<User>> getUsers();
}

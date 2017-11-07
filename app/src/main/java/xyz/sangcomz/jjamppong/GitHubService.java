package xyz.sangcomz.jjamppong;

import java.util.List;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sangcomz on 05/11/2017.
 */

interface GitHubService {
    Retrofit retrofit = new Retrofit.Builder()
            .client(new OkHttpClient())
            .baseUrl("https://api.github.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    @GET("repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);


    @GET("repos/{owner}/{repo}/contributors")
    Single<List<Contributor>> repoContributorsUseRx(
            @Path("owner") String owner,
            @Path("repo") String repo);

}


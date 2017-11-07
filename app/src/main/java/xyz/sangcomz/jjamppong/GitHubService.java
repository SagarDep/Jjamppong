package xyz.sangcomz.jjamppong;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sangcomz on 05/11/2017.
 */

interface GitHubService {
    @GET("repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);


    @GET("repos/{owner}/{repo}/contributors")
    Single<List<Contributor>> repoContributorsUseRx(
            @Path("owner") String owner,
            @Path("repo") String repo);
}


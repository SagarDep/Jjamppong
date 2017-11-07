package xyz.sangcomz.jjamppong;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import xyz.sangcomz.jjamppong.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initRecyclerView();


        GitHubService gitHubService = new ApiManager().buildGithubService();

        Call<List<Contributor>> call = gitHubService
                .repoContributors("square", "retrofit");

        call.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Call<List<Contributor>> call,
                                   Response<List<Contributor>> response) {
                RecyclerView.Adapter adapter = binding.list.getAdapter();
                if (adapter instanceof ContributorListAdapter) {
                    ((ContributorListAdapter) adapter).setContributors(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Contributor>> call, Throwable t) {
                //TODO
            }
        });

//        gitHubService.repoContributorsUseRx("sangcomz", "fishbun")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<List<Contributor>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        System.out.println("onSubscribe onSubscribe onSubscribe");
//                    }
//
//                    @Override
//                    public void onSuccess(List<Contributor> contributors) {
//                        System.out.println("onSuccess onSuccess onSuccess");
//                        for (Contributor contributor : contributors) {
//                            System.out.println("contributor rx :::: " + contributor.login);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        System.out.println("onError onError onError");
//                    }
//                });

    }

    private void initRecyclerView() {
        binding.list.setLayoutManager(new LinearLayoutManager(this));
        binding.list.setAdapter(new ContributorListAdapter());
        binding.list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}

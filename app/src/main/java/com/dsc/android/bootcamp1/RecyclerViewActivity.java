package com.dsc.android.bootcamp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<RecyclerViewData> userlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.recycler_view);
        // createMockList();
        apicall();
        setUpRecyclerView();
    }

    private void apicall() {
        ApiServices apiServices = AppClient.getInstance().createService(ApiServices.class);
        Call<UserWrapper> call = apiServices.getuserList();
        call.enqueue(new Callback<UserWrapper>() {
            @Override
            public void onResponse(Call<UserWrapper> call, Response<UserWrapper> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        userlist.addAll(response.body().getRecyclerViewData());
                    }
                }
            }

            @Override
            public void onFailure(Call<UserWrapper> call, Throwable t) {

            }
        });
    }
    //  private void createMockList(){
    //     RecyclerViewData data;
    //     data = new RecyclerViewData("https://bit.ly/2NT7svr","Jyotini Yadav","9584973117");
    //     mockDataList.add(data);
    //     data = new RecyclerViewData("https://bit.ly/2NT7svr","Amarjeet Gupta","7415758560");
    //     mockDataList.add(data);
    //    data = new RecyclerViewData("https://bit.ly/2NT7svr","Disha Hirwani","9907229465");
    //    mockDataList.add(data);
    //    data = new RecyclerViewData("https://bit.ly/2NT7svr","Gurpreet Kaur","7000643943");
    //    mockDataList.add(data);
    //    data = new RecyclerViewData("https://bit.ly/2NT7svr","Tikam Talreja","9907587445");
    //   mockDataList.add(data);


//}

    public void setUpRecyclerView() {
        recyclerViewAdapter = new RecyclerViewAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setRecyclerViewDataList(userlist);
        recyclerViewAdapter.notifyDataSetChanged();

    }
}

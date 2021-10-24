package com.example.news;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import retrofit2.*;
import java.util.ArrayList;

public class TechnologyFragment extends Fragment {
    String api = "12baccdd6cac464abff9aa7301029fc5";
    ArrayList<Modal> modalArrayList;
    Adapter adapter;
    String country = "in";
    private RecyclerView recyclerView_technology;
    private String category = "technology";
    SwipeRefreshLayout technology_refreshlayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.technologyfragment,null);
        technology_refreshlayout = view.findViewById(R.id.technology_refreshlayout);
        recyclerView_technology = view.findViewById(R.id.recyclerView_technology);
        modalArrayList = new ArrayList<>();
        recyclerView_technology.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(), modalArrayList);
        recyclerView_technology.setAdapter(adapter);
        findNews();
        technology_refreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        technology_refreshlayout.setRefreshing(false);
                    }
                }, 1200);
            }
        });

        return view;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country, category, 100, api).enqueue(new Callback<ApiArray>() {
            @Override
            public void onResponse(Call<ApiArray> call, Response<ApiArray> response) {
                if (response.isSuccessful()) {
                    modalArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ApiArray> call, Throwable t) {

            }
        });

    }
}

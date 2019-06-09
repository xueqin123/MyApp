package com.qinxue.myapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.qinxue.myapp.model.GankResult;
import com.qinxue.myapp.model.XDCategoryItemInfo;
import com.qinxue.myapp.net.clients.gank.HttpClient;
import com.qinxue.myapp.net.clients.gank.factorys.ApiResponse;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button apiBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiBtn = findViewById(R.id.button);
        apiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LiveData<ApiResponse<GankResult<List<XDCategoryItemInfo>>>> observable = HttpClient.getInstance().getGankService().getXDCategorys();
                observable.observe(MainActivity.this, new Observer<ApiResponse<GankResult<List<XDCategoryItemInfo>>>>() {
                    @Override
                    public void onChanged(@Nullable ApiResponse<GankResult<List<XDCategoryItemInfo>>> resultApiResponse) {
                        Log.i("qinxue", "size = " + resultApiResponse.body.getResults().get(0).getName());
                    }
                });
            }
        });
    }
}

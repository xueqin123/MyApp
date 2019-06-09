package com.qinxue.myapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.qinxue.myapp.model.GankResult;
import com.qinxue.myapp.model.XDCategoryItemInfo;
import com.qinxue.myapp.net.clients.gank.HttpClient;
import com.qinxue.myapp.utils.QLog;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button apiBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiBtn = findViewById(R.id.button);
        apiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LiveData<List<XDCategoryItemInfo>> observable = HttpClient.getInstance().getGankService().getXDCategorys();
                observable.observe(MainActivity.this, new Observer<List<XDCategoryItemInfo>>() {
                    @Override
                    public void onChanged(@Nullable List<XDCategoryItemInfo> xdCategoryItemInfos) {
                        QLog.i(TAG, "size = " + xdCategoryItemInfos.get(0).getName());
                    }
                });
            }
        });
    }
}

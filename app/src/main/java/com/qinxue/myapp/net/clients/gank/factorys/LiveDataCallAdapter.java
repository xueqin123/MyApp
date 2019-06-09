package com.qinxue.myapp.net.clients.gank.factorys;

import android.arch.lifecycle.LiveData;

import com.qinxue.myapp.model.GankResult;
import com.qinxue.myapp.utils.QLog;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveDataCallAdapter<R> implements CallAdapter<R, LiveData<R>> {
    private static final String TAG = "LiveDataCallAdapter";
    private final Type responseType;

    public LiveDataCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public LiveData<R> adapt(final Call<R> call) {
        return new LiveData<R>() {
            AtomicBoolean started = new AtomicBoolean(false);

            @Override
            protected void onActive() {
                super.onActive();
                if (started.compareAndSet(false, true)) {
                    call.enqueue(new Callback<R>() {
                        @Override
                        public void onResponse(Call<R> call, Response<R> response) {
                            if (response.isSuccessful()) {
                                GankResult result = (GankResult) response.body();
                                postValue((R) result.getResults());
                            } else {
                                QLog.i(TAG, "response failed: " + response.code());
                            }
                        }

                        @Override
                        public void onFailure(Call<R> call, Throwable throwable) {
                            QLog.i(TAG, "onFailure failed message: " + throwable.getMessage());
                        }
                    });
                }
            }
        };
    }
}
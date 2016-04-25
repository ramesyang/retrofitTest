package com.retrofit.test;

import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.retrofit.test.api.ApiService;
import com.retrofit.test.api.BaseRetrofit;
import com.retrofit.test.api.model.IpInfo;
import com.retrofit.test.api.response.BaseResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("等待2S");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("网络请求开始...");

                        getData();
                    }
                }, 2000);
            }
        });
    }

    private void getData() {
        ApiService apiService = BaseRetrofit.getInstance().create(ApiService.class);
        Call<BaseResponse<IpInfo>> call = apiService.getIpInfo("63.223.108.42");
        call.enqueue(new Callback<BaseResponse<IpInfo>>() {
            @Override
            public void onResponse(Call<BaseResponse<IpInfo>> call, Response<BaseResponse<IpInfo>> response) {
                textView.setText(response.body().getData().getCountry()+"===");
            }

            @Override
            public void onFailure(Call<BaseResponse<IpInfo>> call, Throwable t) {
                t.printStackTrace();
                textView.setText("onFailure");
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}

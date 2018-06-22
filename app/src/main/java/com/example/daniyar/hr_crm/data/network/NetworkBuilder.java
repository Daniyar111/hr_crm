package com.example.daniyar.hr_crm.data.network;

import android.support.annotation.NonNull;

import com.example.daniyar.hr_crm.config.AppConstants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class NetworkBuilder {

    public static RetrofitService sService = null;

    public static RetrofitService initService(){

//        if(sService == null){
//            sService = new Retrofit.Builder()
//                    .baseUrl(AppConstants.BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .client(getClient())
//                    .build()
//                    .create(RetrofitService.class);
//        }
        return sService;
    }

    private static OkHttpClient getClient(){

        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {

                        Request.Builder ongoing = chain.request()
                                .newBuilder()
                                .addHeader("Accept", "application/json;versions=1");

                        return chain.proceed(ongoing.build());
                    }
                })
                .writeTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }
}

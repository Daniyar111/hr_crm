package com.example.daniyar.hr_crm;

import android.app.Application;
import android.content.Context;

import com.example.daniyar.hr_crm.data.network.NetworkBuilder;
import com.example.daniyar.hr_crm.data.network.RetrofitService;

public class AppApplication extends Application {

    private RetrofitService mService;

    @Override
    public void onCreate() {
        super.onCreate();

//        mService = NetworkBuilder.initService();
    }

    public static AppApplication get(Context context){

        return (AppApplication) context.getApplicationContext();
    }

    public RetrofitService getService() {
        return mService;
    }
}

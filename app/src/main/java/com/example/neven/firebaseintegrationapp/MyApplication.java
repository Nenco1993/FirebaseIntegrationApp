package com.example.neven.firebaseintegrationapp;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import com.example.neven.firebaseintegrationapp.dagger.components.AppComponent;
import com.example.neven.firebaseintegrationapp.dagger.components.DaggerAppComponent;

/**
 * Created by Neven on 24.5.2017..
 */
public class MyApplication extends Application {

    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();

    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}

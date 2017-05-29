package com.example.neven.firebaseintegrationapp.dagger.modules;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.example.neven.firebaseintegrationapp.dagger.scopes.ActivityScope;
import com.example.neven.firebaseintegrationapp.models.User;
import com.example.neven.firebaseintegrationapp.presenters.FirebasePresenter;
import com.example.neven.firebaseintegrationapp.presenters.FirebasePresenterImpl;
import com.example.neven.firebaseintegrationapp.utils.MainUtils;
import com.example.neven.firebaseintegrationapp.utils.NotificationUtils;
import com.example.neven.firebaseintegrationapp.utils.SharedPrefsUtils;
import com.example.neven.firebaseintegrationapp.views.FirebaseView;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by Neven on 25.5.2017..
 */
@Module
public class FirebaseModule {

    private Context context;
    private FirebaseView view;
    private Activity activity;


    public FirebaseModule(Context context, FirebaseView view, Activity activity) {
        this.context = context;
        this.view = view;
        this.activity = activity;
    }

    public FirebaseModule(Context context, FirebaseView view) {
        this.context = context;
        this.view = view;
    }

    public FirebaseModule(Context context) {
        this.context = context;

    }

    @Provides
    @ActivityScope
    FirebasePresenter provideFirebasePresenter(FirebasePresenterImpl presenter) {

        return presenter;
    }

    @Provides
    @ActivityScope
    FirebaseView provideView() {

        return view;
    }

    @Provides
    @ActivityScope
    User provideUser() {

        return new User();
    }

    @Provides
    @ActivityScope
    SharedPrefsUtils provideSharedPrefsUtils() {

        return new SharedPrefsUtils(context);
    }

    @Provides
    @ActivityScope
    LocalBroadcastManager provideLocalBroadcastManager() {

        return LocalBroadcastManager.getInstance(context);
    }


}

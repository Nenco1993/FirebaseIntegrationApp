package com.example.neven.firebaseintegrationapp.dagger.modules;

import android.support.v4.content.LocalBroadcastManager;
import com.example.neven.firebaseintegrationapp.dagger.scopes.ActivityScope;
import com.example.neven.firebaseintegrationapp.models.User;
import com.example.neven.firebaseintegrationapp.utils.MainUtils;
import com.example.neven.firebaseintegrationapp.utils.NotificationUtils;
import com.example.neven.firebaseintegrationapp.utils.SharedPrefsUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by Neven on 25.5.2017..
 */
@Module
public class AppModule {

    private FirebaseAuth auth;


    @Provides
    @Singleton
    FirebaseAuth provideFirebaseAuth() {


        return auth = FirebaseAuth.getInstance();
    }

    @Provides
    @Singleton
    FirebaseInstanceId provideFirebaseInstanceId() {


        return FirebaseInstanceId.getInstance();
    }

    @Provides
    @Singleton
    NotificationUtils provideNotificationUtils(){

        return new NotificationUtils();
    }

    @Provides
    @Singleton
    MainUtils provideMainUtils(){

        return new MainUtils();
    }








}

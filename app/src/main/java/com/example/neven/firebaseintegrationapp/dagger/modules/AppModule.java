package com.example.neven.firebaseintegrationapp.dagger.modules;

import com.example.neven.firebaseintegrationapp.dagger.scopes.ActivityScope;
import com.example.neven.firebaseintegrationapp.models.User;
import com.google.firebase.auth.FirebaseAuth;
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




}

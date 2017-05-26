package com.example.neven.firebaseintegrationapp.dagger.components;

import com.example.neven.firebaseintegrationapp.activities.MainActivity;
import com.example.neven.firebaseintegrationapp.dagger.modules.FirebaseModule;
import com.example.neven.firebaseintegrationapp.dagger.scopes.ActivityScope;
import dagger.Subcomponent;

/**
 * Created by Neven on 25.5.2017..
 */
@ActivityScope
@Subcomponent(modules = {FirebaseModule.class})
public interface FirebaseComponent {


    void inject(MainActivity activity);



}

package com.example.neven.firebaseintegrationapp.dagger.components;

import com.example.neven.firebaseintegrationapp.activities.BaseActivity;
import com.example.neven.firebaseintegrationapp.activities.MainActivity;
import com.example.neven.firebaseintegrationapp.dagger.modules.AppModule;
import com.example.neven.firebaseintegrationapp.dagger.modules.FirebaseModule;
import com.example.neven.firebaseintegrationapp.dagger.modules.ResetPasswordModule;
import com.example.neven.firebaseintegrationapp.service.MyFirebaseMessagingService;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by Neven on 25.5.2017..
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(BaseActivity activity);

    //void inject(MyFirebaseMessagingService service);

    FirebaseComponent newFirebaseSubComponent(FirebaseModule module);

    ResetPasswordComponent newResetPasswordSubComponent(ResetPasswordModule module);

}

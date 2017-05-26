package com.example.neven.firebaseintegrationapp.dagger.modules;

import android.app.Activity;
import com.example.neven.firebaseintegrationapp.dagger.scopes.ActivityScope;
import com.example.neven.firebaseintegrationapp.models.User;
import com.example.neven.firebaseintegrationapp.presenters.FirebasePresenter;
import com.example.neven.firebaseintegrationapp.presenters.FirebasePresenterImpl;
import com.example.neven.firebaseintegrationapp.views.FirebaseView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Neven on 25.5.2017..
 */
@Module
public class FirebaseModule {

    private Activity activity;
    private FirebaseView view;

    public FirebaseModule(Activity activity, FirebaseView view) {
        this.activity = activity;
        this.view = view;
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
    User provideUser(){

        return new User();
    }


}

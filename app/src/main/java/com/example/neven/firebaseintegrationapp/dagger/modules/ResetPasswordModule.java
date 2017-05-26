package com.example.neven.firebaseintegrationapp.dagger.modules;

import android.app.Activity;
import com.example.neven.firebaseintegrationapp.dagger.scopes.ActivityScope;
import com.example.neven.firebaseintegrationapp.models.User;
import com.example.neven.firebaseintegrationapp.presenters.ResetPasswordPresenter;
import com.example.neven.firebaseintegrationapp.presenters.ResetPasswordPresenterImpl;
import com.example.neven.firebaseintegrationapp.views.ResetPasswordView;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Neven on 26.5.2017..
 */
@Module
public class ResetPasswordModule {

    private Activity activity;
    private ResetPasswordView view;

    public ResetPasswordModule(Activity activity, ResetPasswordView view) {
        this.activity = activity;
        this.view = view;
    }

    @Provides
    @ActivityScope
    ResetPasswordPresenter providePresenter(ResetPasswordPresenterImpl presenter){

        return presenter;
    }

    @Provides
    @ActivityScope
    ResetPasswordView provideView(){

        return view;


    }

    @Provides
    @ActivityScope
    User provideUser(){

        return new User();
    }


}

package com.example.neven.firebaseintegrationapp.dagger.components;

import com.example.neven.firebaseintegrationapp.activities.ResetPasswordActivity;
import com.example.neven.firebaseintegrationapp.dagger.modules.ResetPasswordModule;
import com.example.neven.firebaseintegrationapp.dagger.scopes.ActivityScope;
import dagger.Subcomponent;

/**
 * Created by Neven on 26.5.2017..
 */
@ActivityScope
@Subcomponent(modules = {ResetPasswordModule.class})
public interface ResetPasswordComponent {


    void inject(ResetPasswordActivity activity);

}

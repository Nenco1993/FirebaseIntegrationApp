package com.example.neven.firebaseintegrationapp.presenters;

import com.example.neven.firebaseintegrationapp.models.User;
import com.example.neven.firebaseintegrationapp.views.FirebaseView;
import com.example.neven.firebaseintegrationapp.views.ResetPasswordView;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

/**
 * Created by Neven on 26.5.2017..
 */
public class ResetPasswordPresenterImpl implements ResetPasswordPresenter {

    private FirebaseAuth auth;
    private ResetPasswordView view;

    @Inject
    public ResetPasswordPresenterImpl(FirebaseAuth auth, ResetPasswordView view) {
        this.auth = auth;
        this.view = view;

    }

    @Override
    public void resetPassword(User user) {
        auth.sendPasswordResetEmail(user.getEmail()).addOnCompleteListener(task -> {


            if (task.isSuccessful()) {
                view.showResponse("email with instructions on how to reset your password has been sent to you");

            } else {
                //noinspection ConstantConditions
                view.showResponse(task.getException().getMessage());
                System.out.println("firebase exception: " + task.getException());
            }


        });
    }
}

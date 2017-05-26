package com.example.neven.firebaseintegrationapp.presenters;

import android.support.annotation.NonNull;
import com.example.neven.firebaseintegrationapp.models.User;
import com.example.neven.firebaseintegrationapp.views.FirebaseView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import javax.inject.Inject;

/**
 * Created by Neven on 25.5.2017..
 */
public class FirebasePresenterImpl implements FirebasePresenter {

    private FirebaseAuth auth;
    private FirebaseView view;


    @Inject
    public FirebasePresenterImpl(FirebaseAuth auth, FirebaseView view) {
        this.auth = auth;
        this.view = view;

    }

    @Override
    public void createUser(User user) {


        auth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnCompleteListener(task -> {

            if (task.isSuccessful()) {
                view.showResponse("user created");
            } else {
                view.showResponse("failed to create user");
                System.out.println("firebase exception: " + task.getException());
            }


        });


    }

    @Override
    public void loginUser(User user) {

        auth.signInWithEmailAndPassword(user.getEmail(), user.getPassword()).addOnCompleteListener(task -> {

            if (task.isSuccessful()) {
                view.showResponse("you are now logged in!");

            } else {
                //noinspection ConstantConditions
                view.showResponse(task.getException().getMessage());
                System.out.println("firebase exception: " + task.getException());
            }


        });


    }



    @Override
    public void changeEmail(User user) {

    }
}

package com.example.neven.firebaseintegrationapp.presenters;

import android.content.*;
import android.support.annotation.NonNull;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.example.neven.firebaseintegrationapp.models.User;
import com.example.neven.firebaseintegrationapp.utils.NotificationUtils;
import com.example.neven.firebaseintegrationapp.views.FirebaseView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

/**
 * Created by Neven on 25.5.2017..
 */
public class FirebasePresenterImpl implements FirebasePresenter {

    private FirebaseAuth auth;
    private FirebaseView view;
    private LocalBroadcastManager localBroadcastManager;
    private BroadcastReceiver broadcastReceiver;
    private NotificationUtils notificationUtils;

    @Inject
    public FirebasePresenterImpl(FirebaseAuth auth, FirebaseView view, LocalBroadcastManager localBroadcastManager, NotificationUtils notificationUtils) {
        this.auth = auth;
        this.view = view;
        this.localBroadcastManager = localBroadcastManager;
        this.notificationUtils = notificationUtils;
    }

    @Override
    public void createUser(User user) {


        auth.createUserWithEmailAndPassword(user.email, user.password).addOnCompleteListener(task -> {

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

        auth.signInWithEmailAndPassword(user.email, user.password).addOnCompleteListener(task -> {

            if (task.isSuccessful()) {
                view.showResponse("you are now logged in!");
                FirebaseUser firebaseUser = auth.getCurrentUser();
                System.out.println("eeeeeeeeeeeee: " + firebaseUser.getUid());

            } else {
                //noinspection ConstantConditions
                view.showResponse(task.getException().getMessage());
                System.out.println("firebase exception: " + task.getException());
            }


        });


    }


    @Override
    public void changeEmail(User user) {

        // coming in the next versions of the app.

    }

    @Override
    public void setupNotifications() {

        // register GCM registration complete receiver
        localBroadcastManager.registerReceiver(broadcastReceiver, new IntentFilter("complete"));

        // register new push message receiver
        // by doing this, the activity will be notified each time a new message arrives
        localBroadcastManager.registerReceiver(broadcastReceiver, new IntentFilter("push"));


    }

    @Override
    public void onReceiveNotification() {

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                switch (intent.getAction()) {

                    case "complete":

                        displayFirebaseRegId(context);

                        break;

                    case "push":

                        System.out.println("primio sam push notifikaciju!");
                        String message = intent.getStringExtra("message");
                        notificationUtils.showNotificationMessage(message);


                        break;

                    default:
                        System.out.println("fail!");
                }


            }
        };

    }

    @Override
    public void unregisterNotificationReceiver() {

        localBroadcastManager.unregisterReceiver(broadcastReceiver);

    }

    private void displayFirebaseRegId(Context context) {
        SharedPreferences pref = context.getSharedPreferences("sharedpreferences", 0);
        String regId = pref.getString("regId", null);

        Log.d("firebaseID", "Firebase reg id: " + regId);


    }
}

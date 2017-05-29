package com.example.neven.firebaseintegrationapp.service;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.example.neven.firebaseintegrationapp.MyApplication;
import com.example.neven.firebaseintegrationapp.dagger.modules.FirebaseModule;
import com.example.neven.firebaseintegrationapp.utils.MainUtils;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import javax.inject.Inject;

/**
 * Created by Neven on 27.5.2017..
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Inject
    MainUtils mainUtils;

    @Inject
    LocalBroadcastManager localBroadcastManager;

    @Override
    public void onCreate() {
        super.onCreate();
        ((MyApplication) getApplication()).getAppComponent().newFirebaseSubComponent(new FirebaseModule(getBaseContext())).inject(this);

    }


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (!mainUtils.isAppInBackground()) {
            Intent pushNotification = new Intent("push");
            pushNotification.putExtra("message", remoteMessage.getNotification().getBody());
            localBroadcastManager.sendBroadcast(pushNotification);
        } else {
            System.out.println("I got this!");
        }


    }
}

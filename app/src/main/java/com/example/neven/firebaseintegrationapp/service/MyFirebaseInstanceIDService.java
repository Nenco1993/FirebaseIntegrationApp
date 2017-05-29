package com.example.neven.firebaseintegrationapp.service;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.example.neven.firebaseintegrationapp.utils.SharedPrefsUtils;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import javax.inject.Inject;

/**
 * Created by Neven on 27.5.2017..
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private FirebaseInstanceId firebaseInstanceId;
    private SharedPrefsUtils sharedPrefsUtils;

    @Inject
    public MyFirebaseInstanceIDService(FirebaseInstanceId firebaseInstanceId, SharedPrefsUtils sharedPrefsUtils) {
        this.firebaseInstanceId = firebaseInstanceId;
        this.sharedPrefsUtils = sharedPrefsUtils;
    }

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String token = firebaseInstanceId.getToken();
        sharedPrefsUtils.storeRegIdInPref(token);
        Intent registrationComplete = new Intent("complete");
        registrationComplete.putExtra("token", token);
        LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete);


    }
}

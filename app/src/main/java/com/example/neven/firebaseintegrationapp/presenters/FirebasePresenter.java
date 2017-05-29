package com.example.neven.firebaseintegrationapp.presenters;

import com.example.neven.firebaseintegrationapp.models.User;

/**
 * Created by Neven on 25.5.2017..
 */
public interface FirebasePresenter {

    void createUser(User user);

    void loginUser(User user);

    void changeEmail(User user);

    void setupNotifications();

    void onReceiveNotification();

    void unregisterNotificationReceiver();

}

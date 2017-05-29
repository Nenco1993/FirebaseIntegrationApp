package com.example.neven.firebaseintegrationapp.utils;

import javax.inject.Inject;

/**
 * Created by Neven on 28.5.2017..
 */
public class MainUtils {

    private boolean state;



    public void appIsInBackground() {

        state = true;


    }

    public void appIsNotInBackground() {

        state = false;


    }

    public boolean isAppInBackground() {

        return state;


    }


}

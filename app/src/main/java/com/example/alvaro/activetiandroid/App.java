package com.example.alvaro.activetiandroid;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.app.Application;

/**
 * Created by alvaro on 25/07/15.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }

    @Override
    public void onTerminate() {
        ActiveAndroid.dispose();
    }
}

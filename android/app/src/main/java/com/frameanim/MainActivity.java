package com.frameanim;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.util.Log;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.leolang.frame_animation_react_native.FrameAnimReactPackage;
import com.leolang.frame_animation_react_native.ReactFrameAnimViewManager;

import java.util.Arrays;
import java.util.List;

/**
 * Created by langneng on 6/21/16.
 */
public class MainActivity extends ReactActivity{
    private static final String MAIN_REACT_CLASS = "frameanim";

    @Override
    protected String getMainComponentName() {
        return MAIN_REACT_CLASS;
    }

    @Override
    protected boolean getUseDeveloperSupport() {
        return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
                new MainReactPackage(),
                new FrameAnimReactPackage()
                );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //set the server ip & port
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //preferences.edit().putString("debug_http_host", "192.168.100.69:8081").apply();
        preferences.edit().putString("debug_http_host", "192.168.101.251:8081").apply();
        ReactFrameAnimViewManager.frameAnimInit(this,"hotel_tts_frame");
        super.onCreate(savedInstanceState);
    }
}

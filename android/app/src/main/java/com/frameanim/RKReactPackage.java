package com.frameanim;

import android.util.Log;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by langneng on 4/14/16.
 */
public class RKReactPackage implements ReactPackage {
    private static final String TAG = "RKReactPackage";

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        Log.d(TAG, "createNativeModules");
        List<NativeModule> modules = new ArrayList<NativeModule>();
        return modules;
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        Log.d(TAG, "langneng createViewManagers");

        return Arrays.<ViewManager>asList(
                new RKReactFrameAnimViewManager());
    }
}

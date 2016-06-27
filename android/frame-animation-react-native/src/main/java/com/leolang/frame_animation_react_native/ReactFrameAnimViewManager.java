package com.leolang.frame_animation_react_native;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.leolang.frame_animation_react_native.util.ResourceUtil;

import java.util.HashMap;

/**
 * Created by langneng on 6/8/16.
 */
public class ReactFrameAnimViewManager extends SimpleViewManager<FrameAnimView> {
    private static final String REACT_CLASS = "FrameAnimView";
    private static final String ACTION_FRAME_ANIM_START = "start";
    private static final String ACTION_FRAME_ANIM_STOP = "stop";
    private static final String TAG = "RKFrameAnimView";
    private LayoutInflater mInflater;
    private ThemedReactContext mReactContext;
    private FrameAnimView frameAnimView;
    private String mAction;
    private String mFrameAnimFile;
    private static HashMap<String, AnimationDrawable> frameAnimRegistry = new HashMap<String, AnimationDrawable>();
    private boolean mOneshot;

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected FrameAnimView createViewInstance(ThemedReactContext reactContext) {
        Log.d(TAG, "langneng createViewInstance FrameAnimView");
        mReactContext = reactContext;
        mInflater = LayoutInflater.from(reactContext);
        LinearLayout frameAnimLayout = (LinearLayout) mInflater.inflate(R.layout.frame_anim_layout, null);
        frameAnimView = (FrameAnimView) frameAnimLayout.findViewById(R.id.frame_anim_view);

        frameAnimLayout.removeView(frameAnimView);

        return frameAnimView;
    }

    @ReactProp(name = "action")
    public void setAction(FrameAnimView frameAnimView, String action) {
        Log.d(TAG, "langneng action:" + action + " frameAnimFile:" + mFrameAnimFile + " oneshot:" + mOneshot);
        mAction = action;
        handleEvent();
    }

    @ReactProp(name = "frameAnimFile")
    public void setFrameAnimFile(FrameAnimView frameAnimView, String frameAnimFile) {
        Log.d(TAG, "langneng setFrameAnimFile: " + frameAnimFile);
        mFrameAnimFile = frameAnimFile;
        handleEvent();
    }

    @ReactProp(name = "oneshot")
    public void setOneshot(FrameAnimView frameAnimView, boolean oneshot) {
        Log.d(TAG, "langneng setOneshot: " + oneshot);
        mOneshot = oneshot;
    }

    @Override
    public void receiveCommand(FrameAnimView root, int commandId, ReadableArray args) {
        super.receiveCommand(root, commandId, args);
    }

    public void handleEvent() {
        Log.d(TAG, "langneng handleEvent action:" + mAction + " frameAnimFile:" + mFrameAnimFile + " oneshot:" + mOneshot);
        Log.d(TAG,"langneng frameAnimRegistry:"+ frameAnimRegistry);
        AnimationDrawable animationDrawable = null;
        if (ACTION_FRAME_ANIM_START.equals(mAction)) {
            animationDrawable = frameAnimRegistry.get(mFrameAnimFile);
            if(animationDrawable!=null) {
                Log.d(TAG, "langneng frame animation has inited");
                frameAnimView.setImageDrawable(animationDrawable);
                animationDrawable.setOneShot(mOneshot);
                animationDrawable.start();
            }else{
                Log.d(TAG, "langneng frame animation has not inited");
                frameAnimView.setImageResource(ResourceUtil.getDrawableId(mReactContext, mFrameAnimFile));
                animationDrawable = (AnimationDrawable) frameAnimView.getDrawable();
                if(animationDrawable!=null){
                    animationDrawable.setOneShot(mOneshot);
                    animationDrawable.start();
                }
            }
        } else if (ACTION_FRAME_ANIM_STOP.equals(mAction)) {
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
        }
    }

    public static void frameAnimInit(Context context, String... frameAnimFile) {
        for (int i = 0; i < frameAnimFile.length; i++) {
            AnimationDrawable animationDrawable = (AnimationDrawable) context.getResources().getDrawable(ResourceUtil.getDrawableId(context, frameAnimFile[i]));
            frameAnimRegistry.put(frameAnimFile[i], animationDrawable);
        }
    }
}

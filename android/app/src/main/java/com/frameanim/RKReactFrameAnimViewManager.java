package com.frameanim;

import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

/**
 * Created by langneng on 6/8/16.
 */
public class RKReactFrameAnimViewManager extends SimpleViewManager<FrameAnimView>{
    private static final String REACT_CLASS = "RKFrameAnimView";
    private static final String ACTION_FRAME_ANIM_START = "start";
    private static final String ACTION_FRAME_ANIM_STOP = "stop";
    private static final String TAG = "RKFrameAnimView";
    private LayoutInflater mInflater;
    private AnimationDrawable animationDrawable;
    private ThemedReactContext mReactContext;
    private String mFrameAnimFile;
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
        LinearLayout frameAnimLayout = (LinearLayout)mInflater.inflate(R.layout.frame_anim_layout, null);
        FrameAnimView frameAnimView = (FrameAnimView)frameAnimLayout.findViewById(R.id.frame_anim_view);
        frameAnimLayout.removeView(frameAnimView);
        return frameAnimView;
    }

    @ReactProp(name = "action")
    public void frameAnimControl(FrameAnimView frameAnimView,String action){
        Log.d(TAG, "langneng action:"+action +" frameAnimFile:"+mFrameAnimFile+" oneshot:"+mOneshot);
        if(ACTION_FRAME_ANIM_START.equals(action)){
            Log.d(TAG,"langneng image resource:"+ResourceUtil.getDrawableId(mReactContext,mFrameAnimFile));
            frameAnimView.setImageResource(ResourceUtil.getDrawableId(mReactContext,mFrameAnimFile));
            animationDrawable = (AnimationDrawable)frameAnimView.getDrawable();
            animationDrawable.setOneShot(mOneshot);
            animationDrawable.start();
        }else if(ACTION_FRAME_ANIM_STOP.equals(action)){
            animationDrawable.stop();
        }

    }

    @ReactProp(name = "frameAnimFile")
    public void setFrameAnimFile(FrameAnimView frameAnimView,String frameAnimFile){
        mFrameAnimFile = frameAnimFile;
    }

    @ReactProp(name = "oneshot")
    public void setOneshot(FrameAnimView frameAnimView,boolean oneshot){
        mOneshot = oneshot;
    }

}

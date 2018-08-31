package com.sanjogstha.utils.viewutil;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by sanjogstha on 5/3/18.
 * sanjogshrestha.nepal@gmail.com
 */
public class ViewUtils {
    public static int convertDpToPixel(Context context, float dp){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return Math.round(px);
    }

    public static float convertPixelsToDp(Context context, float px){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return px / ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }

    public static int dpToPx(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }

    public static int getDisplayContentHeight(Context mContext) {
        final WindowManager windowManager = ((Activity)mContext).getWindowManager();
        final Point size = new Point();
        int screenHeight = 0, actionBarHeight = 0;
        ActionBar actionBar = ((Activity) mContext).getActionBar();
        if (actionBar != null) {
            actionBarHeight = actionBar.getHeight();
        }
        int contentTop = ((Activity)mContext).findViewById(android.R.id.content).getTop();
        windowManager.getDefaultDisplay().getSize(size);
        screenHeight = size.y;
        return screenHeight - contentTop - actionBarHeight;
    }
}

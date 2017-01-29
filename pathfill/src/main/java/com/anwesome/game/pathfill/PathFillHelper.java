package com.anwesome.game.pathfill;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by anweshmishra on 29/01/17.
 */
public class PathFillHelper {
    public static void addPathFillView(Activity activity, PathFillDirection pathFillDirection, PathFillShape pathFillShape, int color,View.OnClickListener onClickListener,int... coords) {
        DisplayManager displayManager = (DisplayManager) activity.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        int w = 300,h = 300;
        if(display != null) {
            Point size = new Point();
            display.getRealSize(size);
            int dimen = size.x;
            if(size.x>size.y) {
                dimen = size.y;
            }
            w = dimen/5;
            h = dimen/5;
        }
        PathFillView pathFillView = new PathFillView(activity,pathFillDirection,pathFillShape,color);
        pathFillView.setOnClickListener(onClickListener);
        if(coords.length == 2) {
            int x = coords[0],y = coords[1];
            pathFillView.setX(x);
            pathFillView.setY(y);
        }
        activity.addContentView(pathFillView,new ViewGroup.LayoutParams(w,h));
    }
}

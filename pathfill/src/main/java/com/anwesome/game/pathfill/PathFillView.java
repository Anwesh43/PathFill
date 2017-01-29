package com.anwesome.game.pathfill;

import android.content.Context;
import android.graphics.*;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 25/01/17.
 */
public class PathFillView  extends View{
    private PathFillDirection direction;
    private PathFillShape shape;
    private OnClickListener onClickListener;
    private Path path = new Path();
    private int color;
    private boolean shouldAnimate = false;
    private boolean filled = false;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int time = 0,x_start = 0,y_start=0,y_end=0,x_end=0,y_start_dir=0,y_end_dir=0,x_start_dir=0,x_end_dir = 0,x_min=0,x_max=0,y_min=0,y_max=0;
    public PathFillView(Context context, PathFillDirection direction, PathFillShape shape, int color) {
        super(context);
        this.direction = direction;
        this.shape = shape;
        this.color = color;
    }
    public void onDraw(Canvas canvas) {
        if(time == 0) {
            setParams(canvas.getWidth(),canvas.getHeight());
            setPath(canvas.getWidth(),canvas.getHeight());
            x_max = canvas.getWidth();
            y_max = canvas.getHeight();
        }
        canvas.clipPath(path);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        canvas.drawPath(path,paint);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
        canvas.drawRect(new RectF(x_start,y_start,x_end,y_end),paint);
        time++;
        if(shouldAnimate) {
            x_start+=x_start_dir*10;
            y_start+=y_start_dir*10;
            x_end+=x_end_dir*10;
            y_end+=y_end_dir*10;
            if(x_start<=x_min && x_end>=x_max){
                x_end_dir = 0;
                x_start_dir = 0;
                x_start = x_min;
                x_end = x_max;
            }
            if(y_start<=y_min && y_end>=y_max){
                y_end_dir = 0;
                y_start_dir = 0;
                y_start = x_min;
                y_end = y_max;
            }
            if(x_end_dir == 0 && x_start_dir==0 && y_start_dir==0 && y_end_dir == 0 && !filled) {
                shouldAnimate = false;
                filled = true;
                if(onClickListener!=null) {
                    onClickListener.onClick(this);
                }
            }
            try {
                Thread.sleep(20);
                invalidate();
            }
            catch (Exception ex) {

            }
        }
    }
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    private void setParams(int w,int h) {
        switch (direction) {
            case UP:
                x_end = w;
                y_start_dir = -1;
                y_end = h;
                y_start = h;
                break;
            case DOWN:
                x_end = w;
                y_end_dir = 1;
                break;
            case LEFT:
                x_end = w;
                x_start_dir = -1;
                y_end = h;
                x_start = w;
                break;
            case RIGHT:
                y_end = h;
                x_end_dir = 1;
                break;

        }
    }
    private void setPath(int w,int h) {
        switch(shape) {
            case CIRCLE:
                int r = w/2;
                if(h<w) {
                    r = h/2;
                }
                path.addCircle(w/2,h/2,r, Path.Direction.CCW);
                break;
            case TRIANGLE:
                path.moveTo(0,h);
                path.lineTo(w/2,0);
                path.lineTo(w,h);
                path.lineTo(0,h);
                break;
            default:
                break;
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN && !shouldAnimate) {
            if(filled) {
                if(onClickListener!=null) {
                    onClickListener.onClick(this);
                }
            }
            else {
                shouldAnimate = true;
                postInvalidate();
            }
        }
        return true;
    }
}

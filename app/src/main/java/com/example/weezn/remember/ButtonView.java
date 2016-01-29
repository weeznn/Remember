package com.example.weezn.remember;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * ButtunView
 *
 * @author: weezn
 * @time: 2016/1/29 15:10
 */
public class ButtonView extends Button {
    private Paint paint;
    private int viewWidth;
    private int viewHeight;

    private int raidus;     //圆形按钮的半径
    private int circlecenterX;//圆形按钮的X坐标
    private int circlecenterY;//圆形按钮的Y坐标


    public ButtonView(Context context) {
        super(context);
        init();
    }

    public ButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public void init() {
        paint = new Paint();
        paint.setAntiAlias(true);

        raidus = 90;

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawButton(canvas);
    }

    public void drawButton(Canvas canvas) {


        // 画圆形按钮的圆

        paint.setColor(this.getResources().getColor(R.color.Red));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setStrokeWidth(3);
        canvas.drawCircle(getWidth() / 2,getHeight()-100,raidus, paint);

        //画圆形按钮的  +  号

        paint.setColor(this.getResources().getColor(R.color.Whilt));
        paint.setStrokeWidth(6);
        canvas.drawLine(getWidth() / 2 - raidus / 2, getHeight() - 100, getWidth() / 2 + raidus / 2, getHeight() - 100, paint
        );
        canvas.drawLine(getWidth() / 2, getHeight() - 100 - raidus / 2, getWidth() / 2, getHeight() - 100 + raidus / 2, paint);
    }


    public int onTouchEvent(){
        int touchX=(int) getX();
        int touchY=(int) getY();
        float dx=getWidth() / 2-touchX;
        float dy=getHeight()-100-touchY;

        if(dx*dx+dy*dy<raidus*raidus){
            return 1;
        }
        else return 0;
    }
}


package com.example.weezn.remember;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * PageView
 *
 * @author: weezn
 * @time: 2016/1/29 15:12
 */
public class PageView extends View {
    private Paint paint;


    private String timeText;//时间
    private String addressText;//地点
    private String thingText;//事件
    private Color TextColor;//颜色

    private PageView pageViewLast;//将最后一个展示页设置为  设置

    public PageView(Context context) {
        super(context);
        init();
    }

    public PageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        paint=new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        paint.setColor(Color.GREEN);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        drawText(canvas);


    }

    public void setAddressText(String addressText) {
        this.addressText = addressText;
    }

    public String getAddressText() {
        return addressText;
    }




    public void setTimeText(String timeText) {
        this.timeText = timeText;
    }

    public String getTimeText() {
        return timeText;
    }





    public void setThingText(String thingText) {
        this.thingText = thingText;
    }

    public String getThingText() {
        return thingText;
    }





    public void setTextColor(Color textColor) {
        TextColor = textColor;
    }

    public Color getTextColor() {
        return TextColor;
    }






    public void drawText(Canvas canvas){
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        paint.setTextSize(20);
        canvas.drawText("时间:",20,30,paint);
    }

}


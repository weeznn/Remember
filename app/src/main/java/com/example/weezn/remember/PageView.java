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
    private String eventText;//事件
    private int timeTextColor;//颜色
    private int addressTextColor;
    private int eventTextCoor;

    private boolean isempty;

    private int space;//信息之间的间隔

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
        isempty=false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawpage(canvas);
        drawText(canvas);
    }

    public void drawpage(Canvas canvas){
        paint.setColor(getResources().getColor(R.color.BlueGrey));
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
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





    public void setEventText(String eventText) {
        this.eventText = eventText;
    }

    public String getEventText() {
        return eventText;
    }


    public void drawText(Canvas canvas){
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(2);
        paint.setTextSize(20);
        space=50;
        canvas.drawText("时间:"+getTimeText(),10,50,paint);
        canvas.drawText("地点：" + getAddressText(), 10, 50 + space, paint);
        canvas.drawText("事情："+getEventText(),10,50+2*space,paint);
    }

    public boolean isempty() {
        return isempty;
    }

    public void setIsempty(boolean isempty) {
        this.isempty = isempty;
    }
}


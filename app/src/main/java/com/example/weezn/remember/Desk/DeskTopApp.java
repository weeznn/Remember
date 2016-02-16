package com.example.weezn.remember.Desk;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

import com.example.weezn.remember.R;

/**
 * DeskTopApp
 *
 * @author: weezn
 * @time: 2016/2/15 14:51
 */
public class DeskTopApp extends AppWidgetProvider {

    private static final String TAG="DeskTopApp";


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        //创建RemoteViews对象，指定加载的界面布局文件
        RemoteViews remoteViews=new RemoteViews(context.getPackageName(), R.layout.activity_main);

        //将appwidgetprovider子类即Desktopapp对象包装成Compontname对象
        ComponentName componentName=new ComponentName(context,DeskTopApp.class);
        //
        appWidgetManager.updateAppWidget(componentName,remoteViews);
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
    }
}

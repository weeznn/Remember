package com.example.weezn.remember.Desk;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.weezn.remember.R;

/**
 * DeskActivity
 *设置桌面插件的内容
 * @author: weezn
 * @time: 2016/2/16 17:24
 */
public class DeskActivity extends Activity {


    private String deskString0;
    private String deskString1;
    private String deskString2;

    private TextView deskTXT0= (TextView) findViewById(R.id.desk0);
    private TextView deskTXT1= (TextView) findViewById(R.id.desk1);
    private TextView deskTXT2= (TextView) findViewById(R.id.desk2);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        deskTXT0.setText(deskString0);
        deskTXT1.setText(deskString1);
        deskTXT2.setText(deskString2);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void setDeskString0(String deskString0) {
        this.deskString0 = deskString0;
    }

    public void setDeskString1(String deskString1) {
        this.deskString1 = deskString1;
    }

    public void setDeskString2(String deskString2) {
        this.deskString2 = deskString2;
    }
}

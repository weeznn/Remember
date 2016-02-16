package com.example.weezn.remember.NewEvent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.example.weezn.remember.R;

/**
 * AddressActivity
 *
 * @author: weezn
 * @time: 2016/1/30 16:10
 */
public class AddressActivity extends Activity {
    public final static String TAG="AddressActivity";
    private EditText editText;
    private String address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i(TAG,"oncreat");
        super.onCreate(savedInstanceState);

        editText=(EditText)findViewById(R.id.address_edittext);
        address=editText.getText().toString();

        //返回地点
        Intent intent=getIntent();
        intent.putExtra("address", address);
        AddressActivity.this.setResult(1, intent);
        Log.i(TAG, address);
//        AddressActivity.this.finish();

    }

    public String getAddress() {
        return address;
    }




}

package com.example.weezn.remember.NewEvent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weezn.remember.R;

/**
 * AddressActivity
 *
 * @author: weezn
 * @time: 2016/1/30 16:10
 */
public class AddressActivity extends Activity {
    public final static String TAG = "AddressActivity";
    private EditText editText;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.new_event);

        Log.i(TAG, "oncreat");
        super.onCreate(savedInstanceState);

        editText = (EditText) findViewById(R.id.address_edittext);

        if(" "==editText.getText().toString()){
            Toast.makeText(this,"地址栏不能为空",Toast.LENGTH_LONG);
        }else {
            finish();
        }


    }

    public String getAddress() {
        return address;
    }

    /**
     * 结束本activity 并将数据传输到上级
     */
    public void finish(){
        address = editText.getText().toString();


        //返回地点
        Intent intent = getIntent();
        intent.putExtra("address", address);
        AddressActivity.this.setResult(1, intent);
        Log.i(TAG, "地址是："+address);

    }


}

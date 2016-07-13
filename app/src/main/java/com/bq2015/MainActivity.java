package com.bq2015;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtcontent;
    private Button mBtnScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(suirenshi.cn.scancodedemo.R.layout.activity_main);
        mEtcontent = (EditText) findViewById(suirenshi.cn.scancodedemo.R.id.et_content);
        mBtnScan = (Button) findViewById(suirenshi.cn.scancodedemo.R.id.btn_scan);
        mBtnScan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MipcaActivityCapture.class);
        intent.setFlags(67108864);
        startActivityForResult(intent, 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            String icode = bundle.getString("result");
            mEtcontent.setText(icode);
        }
    }
}

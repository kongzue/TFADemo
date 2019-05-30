package com.kongzue.authtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    
    private Button btnCreateKey;
    private TextView txtKey;
    private TextView txtCode;
    private TextView txtTime;
    
    private Timer timer;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnCreateKey = findViewById(R.id.btn_createKey);
        txtKey = findViewById(R.id.txt_key);
        txtCode = findViewById(R.id.txt_code);
        txtTime = findViewById(R.id.txt_time);
        
        btnCreateKey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtKey.setText(GoogleAuthenticator.getRandomSecretKey());
                Log.e(">>>", GoogleAuthenticator.getGoogleAuthenticatorBarCode(txtKey.getText().toString(), "test", "kongzue"));
                
                if (timer != null) timer.cancel();
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                long time = 30 - (System.currentTimeMillis() / 1000) % 30;
                                txtCode.setText(GoogleAuthenticator.getTOTPCode(txtKey.getText().toString()));
                                txtTime.setText("过期倒计时：" + time);
                            }
                        });
                    }
                }, 500, 500);
            }
        });
    }
}

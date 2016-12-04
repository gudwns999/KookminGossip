package com.gudwns999.kookmingossip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;

import com.gudwns999.kookmingossip.Main.Main;

public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        android.os.Handler handler = new android.os.Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Intent intent = new Intent(Splash.this, Main.class);
                startActivity(intent);
                finish();
            }
        };
        handler.sendEmptyMessageDelayed(0, 2000);
    }
}

package com.gudwns999.kookmingossip.Main;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TabHost;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.gudwns999.kookmingossip.Baedal.Baedal;
import com.gudwns999.kookmingossip.R;
import com.gudwns999.kookmingossip.Setting.Setting;

public class Main extends TabActivity {

    public static boolean DEBUG = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //thread 정책 바꿈.
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Splash에서 넘어온 값 받기
        TabHost tabhost = getTabHost();

        TabHost.TabSpec spec;
        Intent intent;
        Resources res = getResources();

        intent = new Intent().setClass(this, Baedal.class);
        spec = tabhost.newTabSpec("Gossip");
        spec.setIndicator("HOME", res.getDrawable(R.drawable.gossip));
        spec.setContent(intent);
        tabhost.addTab(spec);

        intent = new Intent().setClass(this, Baedal.class);
        spec = tabhost.newTabSpec("Controls");
        spec.setIndicator("Controls", res.getDrawable(R.drawable.gossip));
        spec.setContent(intent);
        tabhost.addTab(spec);

        intent = new Intent().setClass(this, Setting.class);
        spec = tabhost.newTabSpec("Controls");
        spec.setIndicator("Controls", res.getDrawable(R.drawable.gossip));
        spec.setContent(intent);
        tabhost.addTab(spec);

        //추가한 라인
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        FirebaseInstanceId.getInstance().getToken();

    }
}


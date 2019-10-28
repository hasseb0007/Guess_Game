package com.haseeb.guess_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Random;

public class GameA1 extends AppCompatActivity {


    Button start,home;
    Intent intent1,intent2;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_a1);

        init();
        initListener();
        setmAdView();
    }
    private void init()
    {
        start= findViewById(R.id.btn_start);
        home= findViewById(R.id.btn_home);
        intent1 = new Intent(this,GameA2.class);
        intent2 = new Intent(this,MainActivity.class);
    }

    private void initListener()
    {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
                intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }
        });
    }
    private void setmAdView()
    {

        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("947EFA975CA05E182E672A2281252315").build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(intent2);
        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }


}

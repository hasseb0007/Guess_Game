package com.haseeb.guess_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class GameA2 extends AppCompatActivity {


    private AdView mAdView;
    Intent intent_put;
    int value_get,value_put;
    Button positive,negative;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_a2);

        setmAdView();
        init();
        initListener();
    }
    private void init()
    {
        positive = (Button) findViewById(R.id.btn_yes);
        negative = (Button) findViewById(R.id.btn_no);
        intent_put = new Intent(this,GameA3.class);
    }
    private void setmAdView()
    {

        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("947EFA975CA05E182E672A2281252315").build();
        mAdView.loadAd(adRequest);
    }
    private void initListener(){

        positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value_put = 1;
                intent_put.putExtra("value_put",value_put);
                startActivity(intent_put);
                intent_put.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();

            }
        });

        negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value_put= 0;
                intent_put.putExtra("value_put",value_put);
                startActivity(intent_put);
                intent_put.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();

            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();

    }
}

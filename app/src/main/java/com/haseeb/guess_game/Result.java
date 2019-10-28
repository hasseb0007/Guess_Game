package com.haseeb.guess_game;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class Result extends AppCompatActivity {


    private AdView mAdView;
    Intent intent_get,intent;
    static int value_get;
    static String result;
    TextView showResult;
    Button again, result_positive, result_negative;
    private InterstitialAd mInterstitialAd;
    RelativeLayout result_relative;
    LinearLayout result_linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        init();
        runGifFor3sec();
        setmAdView();
        functionality_display();
        initListeners();
    }

    public void init(){
        result_relative = findViewById(R.id.result_relative);
        result_linear = findViewById(R.id.result_linear);
        again=(Button)findViewById(R.id.play_again);
        result_positive=(Button)findViewById(R.id.result_positive);
        result_negative=(Button)findViewById(R.id.result_negative);
        showResult=(TextView) findViewById(R.id.text_Result);
    }
    public void functionality_display(){

        result="Error Occured in intent at result ";

        intent_get = getIntent();
        value_get= intent_get.getIntExtra("value_put", -1);
        intent = new Intent(this, MainActivity.class);

        if (value_get>= 0 && value_get<=63)
        {
//            Toast.makeText(this,"At result value = "+value_get+" ",Toast.LENGTH_SHORT).show();
            check_Result();
            try {
                showResult.setText(result);
            } catch (NullPointerException e1) {
                Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Error in setting text", Toast.LENGTH_SHORT).show();
                finish();
            }

        }
        else {
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        }

    }
    public  void runGifFor3sec(){

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                result_relative.setVisibility(View.GONE);
                result_linear.setVisibility(View.VISIBLE);

            }
        }, 2500);
    }
    private void setmAdView() {

        mAdView = findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("947EFA975CA05E182E672A2281252315").build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
//        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("947EFA975CA05E182E672A2281252315").build());

    }
    protected void initListeners() {
        result_positive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }

            }
        });
        result_negative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
//                startActivity(intent);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                finish();
            }
        });
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
//                startActivity(intent);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                finish();
            }
        });
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                startActivity(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }

        });





    }
    protected void check_Result() {
        switch (value_get)
        {
            case 0:
                result=getString(R.string.s0);
                break;
            case 1:
                result=getString(R.string.s1);
                break;
            case 2:
                result=getString(R.string.s2);break;
            case 3:
                result=getString(R.string.s3);break;
            case 4:
                result=getString(R.string.s4);break;
            case 5:
                result=getString(R.string.s5);break;
            case 6:
                result=getString(R.string.s6);break;
            case 7:
                result=getString(R.string.s7);break;
            case 8:
                result=getString(R.string.s8);break;
            case 9:
                result=getString(R.string.s9);break;
            case 10:
                result=getString(R.string.s10);break;
            case 11:
                result=getString(R.string.s11);break;
            case 12:
                result=getString(R.string.s12);break;
            case 13:
                result=getString(R.string.s13);break;
            case 14:
                result=getString(R.string.s14);break;
            case 15:
                result=getString(R.string.s15);break;
            case 16:
                result=getString(R.string.s16);break;
            case 17:
                result=getString(R.string.s17);break;
            case 18:
                result=getString(R.string.s18);break;
            case 19:
                result=getString(R.string.s19);break;
            case 20:
                result=getString(R.string.s20);break;
            case 21:
                result=getString(R.string.s21);break;
            case 22:
                result=getString(R.string.s22);break;
            case 23:
                result=getString(R.string.s23);break;
            case 24:
                result=getString(R.string.s24);break;
            case 25:
                result=getString(R.string.s25);break;
            case 26:
                result=getString(R.string.s26);break;
            case 27:
                result=getString(R.string.s27);break;
            case 28:
                result=getString(R.string.s28);break;
            case 29:
                result=getString(R.string.s29);break;
            case 30:
                result=getString(R.string.s30);break;
            case 31:
                result=getString(R.string.s31);break;
            case 32:
                result=getString(R.string.s32);break;
            case 33:
                result=getString(R.string.s33);break;
            case 34:
                result=getString(R.string.s34);break;
            case 35:
                result=getString(R.string.s35);break;
            case 36:
                result=getString(R.string.s36);break;
            case 37:
                result=getString(R.string.s37);break;
            case 38:
                result=getString(R.string.s38);break;
            case 39:
                result=getString(R.string.s39);break;
            case 40:
                result=getString(R.string.s40);break;
            case 41:
                result=getString(R.string.s41);break;
            case 42:
                result=getString(R.string.s42);break;
            case 43:
                result=getString(R.string.s43);break;
            case 44:
                result=getString(R.string.s44);break;
            case 45:
                result=getString(R.string.s45);break;
            case 46:
                result=getString(R.string.s46);break;
            case 47:
                result=getString(R.string.s47);break;
            case 48:
                result=getString(R.string.s48);break;
            case 49:
                result=getString(R.string.s49);break;
            case 50:
                result=getString(R.string.s50);break;
            case 51:
                result=getString(R.string.s51);break;
            case 52:
                result=getString(R.string.s52);break;
            case 53:
                result=getString(R.string.s53);break;
            case 54:
                result=getString(R.string.s54);break;
            case 55:
                result=getString(R.string.s55);break;
            case 56:
                result=getString(R.string.s56);break;
            case 57:
                result=getString(R.string.s57);break;
            case 58:
                result=getString(R.string.s58);break;
            case 59:
                result=getString(R.string.s59);break;
            case 60:
                result=getString(R.string.s60);break;
            case 61:
                result=getString(R.string.s61);break;
            case 62:
                result=getString(R.string.s62);break;
            case 63:
                result=getString(R.string.s63);break;
            default:
                result="Error";
                Toast.makeText(this,"Error occured",Toast.LENGTH_SHORT).show();
                break;
        }
    }
    @Override public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();

    }

}

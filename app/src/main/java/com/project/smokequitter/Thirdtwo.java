package com.project.smokequitter;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Thirdtwo extends AppCompatActivity {
    private Button sbutton;
    private Button n2button;
    private Button p2button;
    private long backPressedTime;
    private Toast backToast;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdtwo);

        sbutton = (Button) findViewById(R.id.sbutton);
        n2button = (Button) findViewById(R.id.n2button);
        p2button = (Button) findViewById(R.id.p2button);

        sbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Thirdtwo.this, FourthActivity.class);
                startActivity(intent);
            }
        });
        n2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Thirdtwo.this, Thirdtwoone.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        p2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Thirdtwo.this, Thirdone.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        MobileAds.initialize(this,"ca-app-pub-2289016323621432~5682318664");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Thirdtwo.this,SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}

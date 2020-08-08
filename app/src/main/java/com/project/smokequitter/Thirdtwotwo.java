package com.project.smokequitter;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Thirdtwotwo extends AppCompatActivity {
    private Button sbutton;
    private Button n22button;
    private Button p22button;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdtwotwo);

        sbutton = (Button) findViewById(R.id.sbutton);
        n22button = (Button) findViewById(R.id.n22button);
        p22button = (Button) findViewById(R.id.p22button);

        sbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Thirdtwotwo.this, FourthActivity.class);
                startActivity(intent);
            }
        });
        n22button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Thirdtwotwo.this, Thirdthree.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        p22button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Thirdtwotwo.this, Thirdtwoone.class);
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
        Intent intent = new Intent(Thirdtwotwo.this,SecondActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }

}

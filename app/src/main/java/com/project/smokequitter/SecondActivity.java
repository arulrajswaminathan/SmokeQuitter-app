package com.project.smokequitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class SecondActivity extends AppCompatActivity {

    private EditText data1V;
    private EditText data2V;
    public TextView result1;
    private TextView result2;
    private Button getResults;
    private int resultNumber;
    private int resultNumber2;
    private String data1;
    private String data2;

    private Button selfbutton;
    private long backPressedTime;
    private Toast backToast;
    private AdView mAdView;
    public InterstitialAd interstitialAd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        data1V = (EditText) findViewById(R.id.data1);
        data2V = (EditText) findViewById(R.id.data2);
        result1 = (TextView) findViewById(R.id.result1);
        result2 = (TextView) findViewById(R.id.result2);
        getResults = (Button) findViewById(R.id.getResults);
        selfbutton = (Button) findViewById(R.id.selfbutton);



        getResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data1= data1V.getText().toString();
                data2= data2V.getText().toString();
                if(data1.matches("")  && data2.matches("")){
                    result1.setText("");
                    Toast.makeText(getApplicationContext(),"Please ensure to fill In the TextFields before checking the Results",Toast.LENGTH_LONG).show();
                }else  {
                    resultNumber = (Integer.parseInt(data1V.getText().toString())) * (Integer.parseInt(data2V.getText().toString()));
                    resultNumber2 = resultNumber *365;
                    Format form = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
                    String word = form.format(resultNumber2);
                    result1.setText(word.replace(".00",""));
                }
            }
        });


        MobileAds.initialize(this,"ca-app-pub-2289016323621432~5682318664");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-4184458681231023/3961883786");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        interstitialAd.setAdListener(new AdListener()
                                     {
                                         @Override
                                         public void onAdClosed() {
                                             startActivity(new Intent(SecondActivity.this,ThirdActivity.class));
                                             interstitialAd.loadAd(new AdRequest.Builder().build());
                                         }
                                     }
        );

    }

    public void startThirdActivity(View view) {
        if(interstitialAd.isLoaded()){
                interstitialAd.show();
        }
        else {
            startActivity(new Intent(this,ThirdActivity.class));
        }


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}

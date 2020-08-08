package com.project.smokequitter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CheckBox;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
public class FourthActivity extends AppCompatActivity {

    private EditText editText1;
    private TextView view1;
    private TextView view2;
    private TextView viewA;
    private Button button;
    private SeekBar seekBar;
    private SeekBar seekBarA;
    private CheckBox checkBox;
    private AdView mAdView;

    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String Text1 = "text1";
    private static final String CHECKBOX = "checkBox";
    private static final String SEEKBAR = "seekBar";
    private static final String SEEKBARA = "seekBarA";


    private String text1;
    private Integer seekBarVal;
    private Integer seekBarValA;
    private Boolean checkOnOff;
    private Long checkTime;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        editText1 = (EditText) findViewById(R.id.editText1);
        view1 = (TextView) findViewById(R.id.view1);
        view2 = (TextView) findViewById(R.id.view2);
        viewA = (TextView) findViewById(R.id.viewA);
        button = (Button) findViewById(R.id.button);
        seekBar = (SeekBar) findViewById((R.id.seekBar));
        seekBarA = (SeekBar) findViewById((R.id.seekBarA));
        checkBox = (CheckBox) findViewById((R.id.checkBox));
        seekBarA.setProgress(2);
        seekBar.setProgress(3);
        viewA.setText("Good");
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                view2.setText(""+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                switch (i)
                {
                    case 0 :{
                        viewA.setText("Bad");
                        break;
                    }
                    case 1 :{
                        viewA.setText("Okay");
                        break;
                    }
                    case 2 :{
                        viewA.setText("Good");
                        break;
                    }
                    case 3 :{
                        viewA.setText("Great!");
                        break;
                    }
                    case 4 :{
                        viewA.setText("Excellent!");
                        break;
                    }
                    default:{
                        viewA.setText("");
                        break;
                    }
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        MobileAds.initialize(this,"ca-app-pub-2289016323621432~5682318664");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveData();
                if(!editText1.getText().toString().matches("")){
                    view1.setText(editText1.getText().toString());
                }


            }
        });
        loadData();
        updateViews();
        ;
    }
    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(!editText1.getText().toString().matches("")){
            editor.putString(Text1,editText1.getText().toString());
        }
        editor.putInt(SEEKBAR,seekBar.getProgress());
        editor.putInt(SEEKBARA,seekBarA.getProgress());
        editor.putBoolean(CHECKBOX,checkBox.isChecked());


        editor.apply();
        Toast.makeText(getApplicationContext(),"Saved Successfully",Toast.LENGTH_SHORT).show();


    }
    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        text1 = sharedPreferences.getString(Text1, "");
        seekBarVal  = sharedPreferences.getInt(SEEKBAR,5);
        seekBarValA  = sharedPreferences.getInt(SEEKBARA,3);
        checkOnOff = sharedPreferences.getBoolean(CHECKBOX,false);;
    }

    public void updateViews(){
        view1.setText(text1);
        view2.setText((seekBarVal.toString()));
        seekBarA.setProgress(seekBarValA);
        checkBox.setChecked(checkOnOff);
        checkTime= System.currentTimeMillis();


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FourthActivity.this,ThirdActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}

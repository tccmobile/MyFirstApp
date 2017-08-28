package com.example.drwill.myfirstapp;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView helloText;
    ToggleButton visableButton;
    SeekBar opacityBar;
    RadioGroup colorButtons;
    RadioButton red, blue, green, black;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloText = (TextView)findViewById(R.id.helloText);
        visableButton = (ToggleButton)findViewById(R.id.visibleButton);
        opacityBar = (SeekBar)findViewById(R.id.opacityBar);
        colorButtons = (RadioGroup)findViewById(R.id.colorButtons);

        visableButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (helloText.getVisibility()== View.VISIBLE){
                    helloText.setVisibility(View.INVISIBLE);
                } else {
                    helloText.setVisibility(View.VISIBLE);
                }
            }
        });

        opacityBar.setProgress(100);
        opacityBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                System.out.println(progress);
                helloText.setAlpha(progress/100f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        colorButtons.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.blueButton: helloText.setTextColor(Color.BLUE);
                        break;
                    case R.id.blackButton: helloText.setTextColor(Color.BLACK);
                        break;
                    case R.id.greenButton: helloText.setTextColor(Color.GREEN);
                        break;
                    case R.id.redButton: helloText.setTextColor(Color.RED);
                        break;

                }
            }
        });

    }
}

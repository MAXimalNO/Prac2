package com.example.prac2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SwitchCompat sw = findViewById(R.id.act2_switch1);
        RelativeLayout rl = findViewById(R.id.act2_rl);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    rl.setBackgroundResource(R.drawable.waitbg);
                    sw.setText(R.string.sw_find);
                }
                else{
                    rl.setBackgroundResource(R.drawable.bgprofile);
                    sw.setText(R.string.switch_status);
                }
            }
        });
    }


}
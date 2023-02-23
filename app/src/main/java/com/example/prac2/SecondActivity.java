package com.example.prac2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String name = getIntent().getStringExtra("name");
        TextView tv = findViewById(R.id.act2_name);
        tv.setText(name);

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

        Button bt = findViewById(R.id.act2_btn);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cb_intent = new Intent();
                cb_intent.putExtra("name", name);
                setResult(RESULT_OK, cb_intent);
                finish();
            }
        });


    }


}
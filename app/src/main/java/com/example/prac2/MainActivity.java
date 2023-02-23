package com.example.prac2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton bt = findViewById(R.id.act1_btn);
        EditText et = findViewById(R.id.act1_et);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("MainActivity","Кнопка входа была нажата");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("name", et.getText().toString());
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        EditText et = findViewById(R.id.act1_et);
        et.setVisibility(View.INVISIBLE);
        TextView name = findViewById(R.id.act1_txt);
        name.setText("Здравствуйте, " + data.getStringExtra("name") + " !");
    }

    public void onClick(View view) {
        Log.i("MainActivity","Кнопка входа была нажата");
    }
}
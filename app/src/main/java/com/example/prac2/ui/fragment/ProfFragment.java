package com.example.prac2.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prac2.R;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class ProfFragment extends Fragment {

    private String name;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prof, container, false);

        if(getArguments()!=null){
            String name = getArguments().getString("name");
            TextView t = (TextView) view.findViewById(R.id.frg2_name);
            t.setText(name);
        }

        //Кнопка для перехода на фрагмент AuthFragment
        Button btn = (Button) view.findViewById(R.id.frg2_btn);
        //Кнопка для перехода на фрагмент с листом уведомлений
        Button btn2 = (Button) view.findViewById(R.id.frg2_btnN);
        //Кнопка для перехода на фрагмент с листом сообщений
        Button btn3 = (Button) view.findViewById(R.id.frg2_btnC);
        //Иконка для перехода в профиль соаки
        ImageView imgv = (ImageView) view.findViewById(R.id.frg2_img);

        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_profFragment_to_dogFragment);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_profFragment_to_notifFragment);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_profFragment_to_chatFragment);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bd = new Bundle();
                bd.putString("nameBack",name);
                Navigation.findNavController(view).navigate(R.id.action_profFragment_to_authFragment,bd);
            }
        });

        return view;
    }
}
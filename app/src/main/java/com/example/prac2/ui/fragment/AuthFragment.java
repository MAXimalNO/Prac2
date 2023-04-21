package com.example.prac2.ui.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.prac2.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class AuthFragment extends Fragment {
    static final private String TAG = "AuthFragment";
    View viewfr;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewfr = inflater.inflate(R.layout.fragment_auth, container, false);
        AppCompatButton bt = (AppCompatButton) viewfr.findViewById(R.id.frg1_btn);
        EditText et = (EditText) viewfr.findViewById(R.id.frg1_et);

        //При возвращении на фрагмент
        if(getArguments()!=null){
            TextView t = (TextView)viewfr.findViewById(R.id.frg1_txt);
            t.setText("Здравствуйте, " + getArguments().getString("nameBack") + "!");
            et.setText(getArguments().getString("nameBack"));
            et.setVisibility(View.INVISIBLE);
        }

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et.getText().toString();
                Bundle bd = new Bundle();
                bd.putString("name",name);
                Navigation.findNavController(view)
                        .navigate(R.id.action_authFragment_to_profFragment,bd);

                //Введённый username
                Log.i("file", "User name: " + name);
                //Абсолютный путь к каталогу приложения
                Log.i("file", "App specific directory: " + getContext().getFilesDir());

                //Создание и запись в файл юзернэйма
                try(FileOutputStream fos = getContext()
                        .openFileOutput("FileUser",Context.MODE_PRIVATE)) {
                    fos.write(name.getBytes());
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } ;


            }
        });

        return viewfr;
    }

}
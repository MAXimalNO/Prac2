package com.example.prac2;

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

import com.example.prac2.databinding.FragmentAuthBinding;

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

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_authFragment_to_profFragment);
            }
        });

        return viewfr;
    }
}
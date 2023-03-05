package com.example.prac2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

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
        Toast.makeText(getContext(), "onCreate", Toast.LENGTH_LONG ).show();
        Log.d(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_LONG ).show();
        Log.d(TAG, "onCreateView");

        View viewfr = inflater.inflate(R.layout.fragment_auth, container, false);

        Bundle backRes = getArguments();
        if(backRes!=null){
            TextView t = (TextView)viewfr.findViewById(R.id.frg1_txt);
            EditText et = (EditText)viewfr.findViewById(R.id.frg1_et);

            t.setText("Здравствуйте, " + getArguments().getString("nameBack") + "!");
            et.setText(getArguments().getString("nameBack"));
            et.setVisibility(View.INVISIBLE);
        }

        AppCompatButton btn = (AppCompatButton)viewfr.findViewById(R.id.frg1_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et = (EditText)viewfr.findViewById(R.id.frg1_et);
                Bundle bundle = new Bundle();
                bundle.putString("name", et.getText().toString());

                getParentFragmentManager().beginTransaction().
                        setReorderingAllowed(true)
                        .replace(R.id.fragmentContainerView,ProfFragment.class,bundle)
                        .commit();
            }
        });


        // Inflate the layout for this fragment
        return viewfr;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_LONG ).show();
        Log.d(TAG, "onViewCreated");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Toast.makeText(getContext(), "onViewStateRestored", Toast.LENGTH_LONG ).show();
        Log.d(TAG, "onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(), "onStart", Toast.LENGTH_LONG ).show();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "onResume", Toast.LENGTH_LONG ).show();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getContext(), "onPause", Toast.LENGTH_LONG ).show();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getContext(), "onStop", Toast.LENGTH_LONG ).show();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getContext(), "onSaveInstanceState", Toast.LENGTH_LONG ).show();
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getContext(), "onDestroyView", Toast.LENGTH_LONG ).show();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getContext(), "OnDestroy", Toast.LENGTH_LONG ).show();
        Log.d(TAG, "onDestroy");
    }

}
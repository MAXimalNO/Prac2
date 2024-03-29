package com.example.prac2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class ProfFragment extends Fragment {

    private String name;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        name = getArguments().getString("name");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_prof, container, false);
        Button btn = (Button) view.findViewById(R.id.frg2_btn);
        TextView t = (TextView) view.findViewById(R.id.frg2_name);
        t.setText(name);

        //Кнопка для перехода на фрагмент с листом уведомлений
        Button btn2 = (Button) view.findViewById(R.id.frg2_btnN);
        //Кнопка для перехода на фрагмент с листом сообщений
        Button btn3 = (Button) view.findViewById(R.id.frg2_btnC);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragmentContainerView,NotifFragment.class,null)
                        .commit();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragmentContainerView,ChatFragment.class,null)
                        .commit();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("nameBack",name);
                getParentFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.fragmentContainerView,AuthFragment.class,bundle)
                        .commit();
            }
        });

        return view;
    }
}
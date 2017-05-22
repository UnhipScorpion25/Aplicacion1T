package com.platzi.aplicacion1t;


import android.app.AlarmManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrincipalFragment extends Fragment {

    Button button;
    AlarmManager am;

    public PrincipalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_principal, container, false);
        Button button1 = (Button) view.findViewById(R.id.button_foto);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FotoFragment FotoFragment = new FotoFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, FotoFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        ImageView img2 = (ImageView) view.findViewById(R.id.Imagen2);
        Glide.with(this).load("http://www.gamingesports.com/wp-content/uploads/2016/03/Smite-PlayStation-4-GeS.jpg").into(img2);

        Button button2 = (Button) view.findViewById(R.id.button_du_juego);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(), DuranteJuegoActivity.class);
                startActivity(intent2);
            }
        });

        Button button5 = (Button) view.findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(), RegistroActivity.class);
                startActivity(intent2);
            }
        });

        return view;
    }

}

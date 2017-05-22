package com.platzi.aplicacion1t;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = prefs.edit();

        Button button_g = (Button) findViewById(R.id.button_guardar);

        button_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText nombre_par = (TextInputEditText) findViewById(R.id.nombre_par);
                TextInputEditText tiempo_par = (TextInputEditText) findViewById(R.id.tiempo_par);

                String nomPartida = nombre_par.getText().toString();
                int tiemPartida = Integer.parseInt(tiempo_par.getText().toString());

                editor.putInt(nomPartida, tiemPartida);
                editor.commit();

                Toast.makeText(RegistroActivity.this, "La partida se guardo" , Toast.LENGTH_SHORT).show();

                nombre_par.setText("");
                tiempo_par.setText("");
            }
        });

        Button button_juego = (Button) findViewById(R.id.button_buscar);

        button_juego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText nombre_bus = (TextInputEditText) findViewById(R.id.tiempo_bus);

                String nombreBusqueda = nombre_bus.getText().toString();

                int tiempo = prefs.getInt(nombreBusqueda, 0);
                Toast.makeText(RegistroActivity.this, "Esa partida duro " + tiempo + " minutos" , Toast.LENGTH_LONG).show();

                nombre_bus.setText("");
            }
        });

        /*editor.putString("email", "modificado@email.com");
        editor.putString("nombre", "Prueba");
        editor.putInt("edad", 23);
        editor.commit();

        String languaje = prefs.getString("email", "");
        int edad = prefs.getInt("edad", 0);
        System.out.println(languaje);*/

        ImageView img = (ImageView) findViewById(R.id.imagen3);
        Glide.with(this).load("http://comunidad.iebschool.com/desgranandoelvideojuego/files/2015/11/smite-1.png").into(img);

    }
}

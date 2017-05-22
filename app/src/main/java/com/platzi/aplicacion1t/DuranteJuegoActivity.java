package com.platzi.aplicacion1t;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DuranteJuegoActivity extends AppCompatActivity {

    Button button;
    AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_durante_juego);

        button = (Button) findViewById(R.id.button3);

        am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent();
                in.setAction("com.brounie.alarmas.action.ALARM_RECEIVER");

                PendingIntent pi = PendingIntent.getBroadcast(
                        getApplicationContext(),
                        0,
                        in,
                        0);
                am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 1200000, pi);
            }
        });

    }

    public void startService(View view){
        startService(new Intent(getBaseContext(), MiServivio.class));
    }
    public void destroyService(View view){
        stopService(new Intent(getBaseContext(),MiServivio.class));
    }
}

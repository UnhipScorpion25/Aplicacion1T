package com.platzi.aplicacion1t;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by 75785 on 21/05/2017.
 */

public class MiServivio extends Service {

    public MiServivio() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this,"Empieza el juego", Toast.LENGTH_SHORT).show();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this,"Termina el juego", Toast.LENGTH_SHORT).show();
    }

}



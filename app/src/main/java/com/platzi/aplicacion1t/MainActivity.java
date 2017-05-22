package com.platzi.aplicacion1t;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @InjectView(R.id.donHaveAccount)
    TextView sample_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        final TextInputEditText etEmail = (TextInputEditText) findViewById(R.id.email);
        final TextInputEditText etPassword = (TextInputEditText) findViewById(R.id.contraseña);

        Button btnLogin = (Button) findViewById(R.id.login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (email.equals("")){
                    Toast.makeText(MainActivity.this, "Proporcione un correo valido ", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.equals("")){
                    Toast.makeText(MainActivity.this, "Proporcione contraseña valida ", Toast.LENGTH_SHORT).show();
                    return;
                }

                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()){
                                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_LONG).show();
                                }
                                else {
                                    goHome();
                                }
                            }
                        });

            }
        });

        ImageView img2 = (ImageView) findViewById(R.id.logo);
        Glide.with(this).load("https://web2.hirez.com/smite//wp-content/uploads/2017/04/1024ganeshajpg.jpg").into(img2);

        ButterKnife.inject(this);
    }

    @OnClick(R.id.donHaveAccount)
    public void showToastMessage(){
        Intent intent = new Intent(this, CrearPerfilActivity.class);
        startActivity(intent);
    }

    public void goHome () {
        Intent intent2 = new Intent(this, ContainerActivity.class);
        startActivity(intent2);
    }

}

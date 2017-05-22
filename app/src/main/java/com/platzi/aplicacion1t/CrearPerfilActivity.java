package com.platzi.aplicacion1t;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CrearPerfilActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_perfil);

        firebaseAuth = FirebaseAuth.getInstance();

        final TextInputEditText etEmail = (TextInputEditText) findViewById(R.id.email);
        final TextInputEditText etPassword = (TextInputEditText) findViewById(R.id.password_createaccount);
        final TextInputEditText etConfirmPass = (TextInputEditText) findViewById(R.id.confirmPassword);

        Button btnCreateAccount = (Button) findViewById(R.id.joinUs);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                String confirmation = etConfirmPass.getText().toString().trim();

                if (email.equals("")){
                    Toast.makeText(getApplicationContext(), "Ingrese correo", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.equals(confirmation)){
                    if (password.equals("")){
                        Toast.makeText(getApplicationContext(), "Contraseña invalida", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(CrearPerfilActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (!task.isSuccessful()){
                                    Toast.makeText(CrearPerfilActivity.this, "Auth failed", Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(CrearPerfilActivity.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });

            }
        });

    }

}

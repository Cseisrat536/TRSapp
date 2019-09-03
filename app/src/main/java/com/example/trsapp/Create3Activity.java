package com.example.trsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Create3Activity extends AppCompatActivity {

    private EditText passId;
    private ImageButton logIn4Button;
    private FirebaseAuth mAuth;
    //private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create3);


        mAuth = FirebaseAuth.getInstance();
        passId=findViewById(R.id.PasswordInId);
        logIn4Button=findViewById(R.id.logButton4id);
        //progressBar=findViewById(R.id.ProgressbarId);
        logIn4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    UserRegister();


            }

        });
    }
    private void UserRegister() {
        String email = getIntent().getExtras().getString("email");
        String password = passId.getText().toString().trim();
        if (password.isEmpty()) {

            passId.setError("Enter your password");
            passId.requestFocus();
            return;
        }
        if (password.length() < 8) {

            passId.setError("Minimum length should be 8");
            passId.requestFocus();
            return;

        }
       // progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    Intent intent = new Intent(getApplicationContext(), TRShome.class);
                    startActivity(intent);

                } else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(), "User is already registered", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });
    /*.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Create3Activity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }*/

    }
}

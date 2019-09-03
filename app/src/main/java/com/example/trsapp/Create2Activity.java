package com.example.trsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Create2Activity extends AppCompatActivity {

    private EditText emailId;
    private ImageButton logInButton;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create2);


        mAuth = FirebaseAuth.getInstance();

        emailId=findViewById(R.id.EmailinId);

        logInButton=findViewById(R.id.logButton3id);
        progressBar=findViewById(R.id.ProgressbarId);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserRegister();
            }
        });
    }
    private void UserRegister() {

        String email=emailId.getText().toString().trim();

        if(email.isEmpty()){

            emailId.setError("Enter your email address");
            emailId.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            emailId.setError("Enter your email address");
            emailId.requestFocus();
            return;

        }
        Intent intent = new Intent(getApplicationContext(),Create3Activity.class);
        intent.putExtra("email",email);
        startActivity(intent);


    }
}

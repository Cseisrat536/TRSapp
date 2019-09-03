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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText1,editText2;
    private ImageButton logInButton;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mAuth = FirebaseAuth.getInstance();

        editText1=findViewById(R.id.Edittext1Id);
        editText2=findViewById(R.id.Edittext2Id);
        logInButton=findViewById(R.id.logButtonid);
        progressBar=findViewById(R.id.ProgressbarId);
        logInButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        UserLogin();

    }

    private void UserLogin() {

        String email=editText1.getText().toString().trim();
        String password=editText2.getText().toString().trim();
        if(email.isEmpty()){

            editText1.setError("Enter your email address");
            editText1.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            editText1.setError("Enter your email address");
            editText1.requestFocus();
            return;

        }
        if(password.isEmpty()){

            editText2.setError("Enter your password");
            editText2.requestFocus();
            return;
        }
        if(password.length()<=8){

            editText2.setError("Minimum length should be 8");
            editText2.requestFocus();
            return;

        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(),TRShome.class);
                    intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Login Unsuccessful",Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}

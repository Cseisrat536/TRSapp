package com.example.trsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CretaeActivity extends AppCompatActivity {
    private EditText editText3,editText4;
    private ImageButton logupButton;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cretae);

        databaseReference= FirebaseDatabase.getInstance().getReference("Users");
        editText3=findViewById(R.id.Edittext3Id);
        editText4=findViewById(R.id.Edittext4Id);
        logupButton=findViewById(R.id.logButton2id);

        logupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editText3.getText().toString().equals("") || editText4.getText().toString().equals("")){
                    Toast.makeText(CretaeActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                }else{
                    saveData();
                }
            }
        });

    }
    public void saveData()
    {
        String firstname=editText3.getText().toString().trim();
        String lastname=editText4.getText().toString().trim();
        String key=databaseReference.push().getKey();
        User user=new User(firstname,lastname);
        databaseReference.child(key).setValue(user);
        Intent intent  = new Intent(getApplicationContext(),Create2Activity.class);
        startActivity(intent);
    }

}

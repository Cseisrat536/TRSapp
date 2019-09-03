package com.example.trsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button Createbutton,Loginbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Loginbutton=findViewById(R.id.LoginButtonid);
        Createbutton=findViewById(R.id.CreatebuttonId);

        Loginbutton.setOnClickListener(this);
        Createbutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.LoginButtonid:

                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);


                break;

            case R.id.CreatebuttonId:


                Intent intant  = new Intent(getApplicationContext(),CretaeActivity.class);
                startActivity(intant);


                break;




        }

    }


}

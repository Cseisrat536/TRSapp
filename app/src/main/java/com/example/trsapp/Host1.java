package com.example.trsapp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Host1 extends AppCompatActivity implements View.OnClickListener {

    private Button locationbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host1);

        locationbutton = findViewById(R.id.btnLocation);
        locationbutton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.btnLocation)
        {
            Intent intent = new Intent(getApplicationContext(),host2.class);
            startActivity(intent);

        }
    }
}

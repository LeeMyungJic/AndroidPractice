package com.example.allergyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button QR = (Button) findViewById(R.id.QRbutton);
        final Button Make = (Button) findViewById(R.id.makeButton);

        QR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(MainActivity.this, QRScanner.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });

        Make.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QRMaker.class);
                startActivity(intent);
            }
        });
    }

}

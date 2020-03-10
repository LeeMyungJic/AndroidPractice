package com.example.login_practice;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        final Button list = (Button) findViewById(R.id.listButton);
        final Button schedule = (Button) findViewById(R.id.scheduleButton);
        final Button mypage = (Button) findViewById(R.id.mypageButton);

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                schedule.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                mypage.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new fragment_list());
                fragmentTransaction.commit();
            }
        });

        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                schedule.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                mypage.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new fragment_schedule());
                fragmentTransaction.commit();
            }
        });

        mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                schedule.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                mypage.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new fragment_mypage());
                fragmentTransaction.commit();
            }
        });
    }
}
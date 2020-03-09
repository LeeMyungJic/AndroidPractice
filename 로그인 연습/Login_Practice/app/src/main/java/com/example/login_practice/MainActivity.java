package com.example.login_practice;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button register = (Button) findViewById(R.id.registerButton);
        final Button login = (Button) findViewById(R.id.loginButton);
        final EditText id = (EditText) findViewById(R.id.idText);
        final EditText pass = (EditText) findViewById(R.id.passwordText);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idStr = id.getText().toString();
                int passStr = Integer.parseInt(pass.getText().toString());
                if(idStr.equals("test") && passStr == 1234) {
                    Intent intent = new Intent(getApplicationContext(), Main.class);
                    startActivity(intent);
                }
                else {
                    return;
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}

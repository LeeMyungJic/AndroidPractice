package com.example.movie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class WriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.rating_layout);

        final Button write = (Button) findViewById(R.id.save);
        final Button cancel = (Button) findViewById(R.id.cancel);
        final EditText text = (EditText) findViewById(R.id.editText2);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("name", "익명");
                intent.putExtra("text", text.getText().toString());
                setResult(RESULT_OK, intent);
                startActivityForResult(intent, 1004);
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}

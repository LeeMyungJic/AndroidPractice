package com.example.movie;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    int chk_u = 1;
    int chk_b = 1;
    int plag_u = 0;
    int plag_b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageButton button_up = (ImageButton) findViewById(R.id.thumb_up_button);
        final ImageButton button_Down = (ImageButton) findViewById(R.id.thumb_down_button);
        final TextView n1 = (TextView) findViewById(R.id.s_u);
        final TextView n2 = (TextView) findViewById(R.id.s_d);
        button_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chk_u == 0) {
                    button_Down.setSelected(false);
                    button_up.setSelected(true);
                    if(plag_b == 1) {
                        n2.setText(String.valueOf(Integer.parseInt(n2.getText().toString()) - 1));
                        plag_b = 0;
                    }
                    chk_u = 1;
                    chk_b = 0;
                    plag_u = 1;
                    n1.setText(String.valueOf(Integer.parseInt(n1.getText().toString()) + 1));
                } else {
                    button_up.setSelected(false);
                    chk_u = 0;
                    if(plag_u == 1) {
                        n1.setText(String.valueOf(Integer.parseInt(n1.getText().toString()) - 1));
                        plag_u = 0;
                    }
                }
            }
        });

        button_Down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chk_b == 0) {
                    button_up.setSelected(false);
                    button_Down.setSelected(true);
                    chk_b = 1;
                    if(plag_u == 1) {
                        n1.setText(String.valueOf(Integer.parseInt(n1.getText().toString()) - 1));
                        plag_u = 0;
                    }
                    chk_u = 0;
                    plag_b = 1;
                    n2.setText(String.valueOf(Integer.parseInt(n2.getText().toString()) + 1));
                } else {
                    button_Down.setSelected(false);
                    chk_b = 0;
                    if(plag_b == 1) {
                        n2.setText(String.valueOf(Integer.parseInt(n2.getText().toString()) - 1));
                        plag_b = 0;
                    }
                }
            }
        });

        String[] items = {"너무 재밌어요!", "노잼노잼", "후헤헤헤헤헤헤헤", "내공 냠냠"};
        ListAdapter adapter = new Adapter(this, items);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                String item = String.valueOf(parent.getItemAtPosition(position));
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
            }
        });

        final Button make = (Button) findViewById(R.id.make);
        final Button seeall = (Button) findViewById(R.id.seeall);

        make.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WriteActivity.class);
                startActivity(intent);
            }
        });
        seeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "모두보기", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

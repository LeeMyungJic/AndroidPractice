package com.example.movie;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int chk_u = 1;
    int chk_b = 1;
    int plag_u = 0;
    int plag_b = 0;
    public static RateAdapter adapter;

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

        ListView listView = (ListView) findViewById(R.id.listView1);
        final ScrollView scroll = (ScrollView) findViewById(R.id.scroll);
        adapter = new RateAdapter();
        adapter.addItem(new RateItem("박재성", "너무 잘빠져요!"));
        adapter.addItem(new RateItem("박찬인", "너무 빨개요!"));
        adapter.addItem(new RateItem("김민석", "내공 냠냠"));
        listView.setAdapter(adapter);

        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                scroll.requestDisallowInterceptTouchEvent(true);
                return false;
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
                Intent intent = new Intent(getApplicationContext(), SeeAllActivity.class);
                startActivity(intent);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode) {
            case 1004 :
                if (resultCode == RESULT_OK) {
                    adapter.addItem(new RateItem("익명", data.getStringExtra("text")));
                    // adapter.notifyDataSetChanged();
                    break;
                } else {   // RESULT_CANCEL
                    Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    break;
                }
//        } else if (requestCode == REQUEST_ANOTHER) {
//            ...
        }
    }

    public class RateAdapter extends BaseAdapter {
        ArrayList<RateItem> items = new ArrayList<RateItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(RateItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) { // 데이터를 관리하는 어댑터가 뷰도 만들어달라고 하는것..?
            RateItemView view1 = new RateItemView(getApplicationContext());

            RateItem item = items.get(position);
            view1.setName(item.getId());
            view1.setTitle(item.getText());

            return view1;
        }
    }
}

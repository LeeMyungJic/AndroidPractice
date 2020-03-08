package com.example.movie;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SeeAllActivity extends AppCompatActivity {
    protected TextView id;
    protected TextView str;
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.see_all);

        ListView listView = (ListView) findViewById(R.id.seeall_list);
        RateAdapter adapter = new RateAdapter();
        listView.setAdapter(adapter);


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

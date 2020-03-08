package com.example.movie;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RateItemView extends LinearLayout {
    TextView textView;
    TextView textView2;
    public RateItemView(Context context) {
        super(context);

        init(context);
    }

    public RateItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }
    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.rate_item, this, true);

        textView = (TextView) findViewById(R.id.name);
        textView2 = (TextView) findViewById(R.id.titleStr);
    }

    public void setName(String name) {
        textView.setText(name);
    }
    public void setTitle(String title) {
        textView2.setText(title);
    }
}

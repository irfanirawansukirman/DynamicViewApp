package com.irfan.dynamicviewapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public EditText edTxt;
    public Button btn;
    public LinearLayout mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater mLayoutInflater = (LayoutInflater) getBaseContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View mAddView = mLayoutInflater.inflate(R.layout.row, null);
                TextView mTitle = (TextView) mAddView.findViewById(R.id.textOut);
                mTitle.setText(edTxt.getText().toString());
                Button mBtnRemove = (Button) mAddView.findViewById(R.id.btn_remove);
                mBtnRemove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((LinearLayout) mAddView.getParent()).removeView(mAddView);
                    }
                });

                    mContainer.setPadding(0, 16, 0, 0);
                    mContainer.addView(mAddView);

            }
        });
    }

    public void initView() {
        edTxt = (EditText) findViewById(R.id.textin);
        btn = (Button) findViewById(R.id.btn_add);
        mContainer = (LinearLayout) findViewById(R.id.layoutContainer);
    }
}

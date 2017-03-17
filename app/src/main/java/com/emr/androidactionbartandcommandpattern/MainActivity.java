package com.emr.androidactionbartandcommandpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

enum tvwidget {
    tv1,
    tv2
}

public class MainActivity extends    AppCompatActivity
                          implements View.OnFocusChangeListener
{

    private TextView tv1, tv2;
    private tvwidget mTvwidget;
    private String   clipboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tv1 = (TextView) findViewById(R.id.editText);
        tv2 = (TextView) findViewById(R.id.editText2);

        tv1.setOnFocusChangeListener(this);
        tv2.setOnFocusChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions, menu);
        return(super.onCreateOptionsMenu(menu));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.Copy:
                switch (mTvwidget) {
                    case tv1:
                        clipboard = tv1.getText().toString();
                        break;
                    case tv2:
                        clipboard = tv2.getText().toString();
                        break;
                }
                break;
            case R.id.Paste:
                switch (mTvwidget) {
                    case tv1:
                        tv1.setText(clipboard);
                        break;
                    case tv2:
                        tv2.setText(clipboard);
                        break;
                }
                break;
        }

        return(super.onOptionsItemSelected(item));
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()) {
            case R.id.editText:
                mTvwidget = tvwidget.tv1;
                break;
            case R.id.editText2:
                mTvwidget = tvwidget.tv2;
                break;

        }
    }
}

package com.emr.androidactionbartandcommandpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.emr.androidactionbartandcommandpattern.Commands.CopyCommand;
import com.emr.androidactionbartandcommandpattern.Commands.PasteCommand;

public class MainActivity extends    AppCompatActivity
                          implements View.OnFocusChangeListener
{

    private TextView tv1, tv2, curTv;
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
                CopyCommand cc = new CopyCommand(this);
                cc.execute();
                break;
            case R.id.Paste:
                PasteCommand pc = new PasteCommand(this);
                pc.execute();
                break;
        }

        return(super.onOptionsItemSelected(item));
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()) {
            case R.id.editText:
                curTv = tv1;
                break;
            case R.id.editText2:
                curTv = tv2;
                break;

        }
    }

    public void paste()
    {
        curTv.setText(clipboard);
    }

    public void copy()
    {
        clipboard = curTv.getText().toString();
    }
}

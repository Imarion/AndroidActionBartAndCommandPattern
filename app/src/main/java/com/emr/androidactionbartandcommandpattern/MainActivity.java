package com.emr.androidactionbartandcommandpattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.emr.androidactionbartandcommandpattern.Commands.CopyCommand;
import com.emr.androidactionbartandcommandpattern.Commands.PasteCommand;

public class MainActivity extends AppCompatActivity
                          implements View.OnFocusChangeListener
{

    private MyEditText edtText1, edtText2, curEdtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        edtText1 = (MyEditText) findViewById(R.id.editText);
        edtText2 = (MyEditText) findViewById(R.id.editText2);

        edtText1.setOnFocusChangeListener(this);
        edtText2.setOnFocusChangeListener(this);
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
                CopyCommand cc = new CopyCommand(curEdtText);
                cc.execute();
                break;
            case R.id.Paste:
                PasteCommand pc = new PasteCommand(curEdtText);
                pc.execute();
                break;
        }

        return(super.onOptionsItemSelected(item));
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()) {
            case R.id.editText:
                curEdtText = edtText1;
                break;
            case R.id.editText2:
                curEdtText = edtText2;
                break;

        }
    }
}

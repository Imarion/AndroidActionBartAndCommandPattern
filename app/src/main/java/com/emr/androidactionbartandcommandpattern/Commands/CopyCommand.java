package com.emr.androidactionbartandcommandpattern.Commands;


import com.emr.androidactionbartandcommandpattern.MyEditText;

/**
 * Created by emr on 2017/04/07.
 */

public class CopyCommand implements Command {

    private MyEditText mEditText;

    public CopyCommand(MyEditText me) {
        mEditText = me;
    }

    @Override
    public void execute() {
        mEditText.copy();
    }
}

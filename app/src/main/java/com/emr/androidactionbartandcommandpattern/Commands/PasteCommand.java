package com.emr.androidactionbartandcommandpattern.Commands;

import com.emr.androidactionbartandcommandpattern.MainActivity;

/**
 * Created by emr on 2017/04/07.
 */
public class PasteCommand implements Command {

    private MainActivity mMa;

    public PasteCommand(MainActivity ma) {
        mMa = ma;
    }

    @Override
    public void execute() {
        mMa.paste();
    }
}

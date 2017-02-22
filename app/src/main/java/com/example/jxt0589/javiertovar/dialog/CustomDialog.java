package com.example.jxt0589.javiertovar.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.example.jxt0589.javiertovar.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by JXT0589 on 2/15/17.
 */

public class CustomDialog extends Dialog {


    @OnClick(R.id.custom_dialog_button)
    public void onClick()
    {
        listener.onClickListener();
        this.dismiss();
    }


    private ICustomDialogEventListener listener;
    public interface ICustomDialogEventListener {
        void onClickListener();
    }
    public CustomDialog(Context context, ICustomDialogEventListener newListener) {
        super(context, R.style.dialog);
        listener = newListener;
    }

    @Override
    protected void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.custom_dialog);
        ButterKnife.bind(this);

    }
}

package com.example.jxt0589.javiertovar.dialog;

import android.app.Dialog;
import android.content.Context;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.jxt0589.javiertovar.DialogActivity;
import com.example.jxt0589.javiertovar.ListViewActivity;
import com.example.jxt0589.javiertovar.MainActivity;
import com.example.jxt0589.javiertovar.R;
import com.example.jxt0589.javiertovar.ViewPagerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by JXT0589 on 3/8/17.
 */

public class CustomDialog2 extends Dialog {

    int checkedRadioId;

    @BindView(R.id.dialog_rdg)
    RadioGroup radioGroup;

    public CustomDialogEventListener mListener;

    public interface CustomDialogEventListener {
        void onCancelCustomDialog();
        void onOkCustomDialog(Class clazz);
    }

    public CustomDialog2(Context context, CustomDialogEventListener newListener) {
        super(context,R.style.dialog);
        setContentView(R.layout.custom_dialog_two);
        ButterKnife.bind(this);
        mListener = newListener;

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                  @Override
                                                  public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                      checkedRadioId = checkedId;
                                                  }
                                              }

        );

    }

    @OnClick(R.id.custom_dialog_cancel_bt)
    public void onCancel()
    {
        mListener.onCancelCustomDialog();
        this.dismiss();
    }

    @OnClick(R.id.custom_dialog_ok_bt)
    public void onOk()
    {
        switch(checkedRadioId)
        {
            case R.id.dialog_rb1:
                mListener.onOkCustomDialog(DialogActivity.class);
                break;
            case R.id.dialog_rb2:
                mListener.onOkCustomDialog(ListViewActivity.class);
                break;
            default:
                mListener.onOkCustomDialog(MainActivity.class);
        }
        this.dismiss();

    }
}

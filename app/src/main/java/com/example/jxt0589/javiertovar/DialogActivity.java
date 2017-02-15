package com.example.jxt0589.javiertovar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by javier on 2/13/17.
 */

public class DialogActivity
{

    public void ListDialog()
    {
        final String[]  items =   {"item1", "itm2", "item3", "item4"""};

        AlertDialog.Builder builder =  new AlertDialog.Builder(this);
        builder.setTitle("I am list dialog");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toastShort("You clicked: " + items[which]);
            }
        });
        builder.show();

    }

    int choice = 0;
    private void singleChoiceDialog()
    {
        final String[] items = {"items1", "items2", "items3", "item4"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Im a single choice dialog");
        builder.setIcon(R.mipmap.ic_launcher);

        builder.setSingleChoiceItems(items, choice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choice = which;

            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toastShort("You clicked " + items[choice]);
            }
        });

        builder.show();

    }


    ArrayList<Integer>  choices = new ArrayList<>();

    private void multipleChoiceListener()
    {
        final String[] items = {"item1", "item2"};
        final boolean initChoiceSets[] = {false, false};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Im a multi choice Dialog");
        builder.setMultiChoiceItems(items, initChoiceSets,
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked)
                        {
                            choices.add(which);
                        }
                        else
                        {
                            choices.remove(which);
                        }
                    }
                });

        builder.setPositiveButton("Ok",, new DialogInterface.OnClickListener(


        ) {
            /**
             * This method will be invoked when a button in the dialog is clicked.
             *
             * @param dialog The dialog that received the click.
             * @param which  The button that was clicked (e.g.
             *               {@link DialogInterface#BUTTON1}) or the position
             */
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int size = choices.size();
                String str = "";

                for(int i = 0 ; i < size; i++)
                {
                    str += items[choices.get(i)] +  " ";
                }
                toastShort("You choose " + str);
            }
        });

        builder.setNegativeButton("cancel" , new DialogInterface.OnClickListener() {
            /**
             * This method will be invoked when a button in the dialog is clicked.
             *
             * @param dialog The dialog that received the click.
             * @param which  The button that was clicked (e.g.
             *               {@link DialogInterface#BUTTON1}) or the position
             */
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toastShort("Cancel");
            }
        });
    }



    ProgressDialog waitingDialog;
    private void waitingDialog()
    {
        waitingDialog = new ProgressDialog(this);
        waitingDialog.setTitle("Im a waiting dialog");
        waitingDialog.setMessage("waiting");
        waitingDialog.setCancelable(true);
        waitingDialog.show();

        waitingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                    toastShort("dialog was canceled");
            }
        });
    }


    private void progressDialog()
    {
        final int MAX_PROGRESS = 100;
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("Downloading");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                        int  progress =0;;
                while(progress < MAX_PROGRESS)
                {
                    try {
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                    progressDialog.cancel();
                }
            }
        }).start();

    }

    private void inputDialog()
    {
        final EditText editText = new EditText(this);
        AlertDialog.Builder inputDialog =  new AlertDialog.Builder( this);
        inputDialog.setTitle("I am an  Input dialog").setView(editText);
        inputDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    toastShort(editText.getText().toString());
            }
        });
        inputDialog.setNegativeButton("cancel", null).show();
    }
    private void normalDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("alerTitle");
        builder.setMessage("This is a normal dialog");


    }
}

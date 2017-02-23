package com.example.jxt0589.javiertovar;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jxt0589.javiertovar.bean.Book;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton bt2;
    private ImageButton bt4;






    public void button2Click(View v)
    {
        Intent intent = new Intent(this , DialogActivity.class);
        startActivityForResult(intent, 2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_main);
        inititialView();
        initialListener();




    }

    private void inititialView() {
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt3 = (ImageButton) findViewById(R.id.bt3);
        bt2 = (ImageButton) findViewById(R.id.bt2);
        bt4 = (ImageButton) findViewById(R.id.bt_for_class_activity);

    }

    private void initialListener() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), ViewPagerActivity.class);
                intent.putExtra("key", "message");
                Bundle bundle = new Bundle();
                Book book = new Book();
                book.setName("android");
                book.setAuthor("Yann");
                bundle.putSerializable("book", book);
                intent.putExtras(bundle);

                startActivityForResult(intent, 1);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(v.getContext() , ListViewActivity.class);
                startActivityForResult(intent, 3);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2Click(v);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toClassExercise(v);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case 1:
                String message = data.getStringExtra("message");
                toastShort("From View Pager " + message);
                break;
            case 2:
                String message2 = data.getStringExtra("message");
                toastShort("from " + message2);
                break;
            case 3:
                String message3 = data.getStringExtra("message");
                toastShort("from " + message3);
                break;
            case 4:
                break;
        }
    }


    public void toClassExercise(View v)
    {
        toActivity(ActivityA.class);
    }

}

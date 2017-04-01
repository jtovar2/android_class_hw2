package com.example.jxt0589.javiertovar;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jxt0589.javiertovar.adapter.SideListViewAdapter;
import com.example.jxt0589.javiertovar.bean.Book;
import com.example.jxt0589.javiertovar.dialog.CustomDialog2;
import com.example.jxt0589.javiertovar.util.UtilLog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements CustomDialog2.CustomDialogEventListener, AdapterView.OnItemClickListener {


    private ImageButton bt1;
    private ImageButton bt3;
    private ImageButton bt2;
    private ImageButton bt4;
    private GestureDetector mGestureDetector;

    @BindView(R.id.btn_for_side_list)
    ImageButton btnForSideList;

    Animation slideInAnimation;
    Animation slideOutAnimaiton;

    @BindView(R.id.side_list_view)
    ListView sideListView;

    @BindView(R.id.fl_main)
    FrameLayout fl;

    @OnClick(R.id.bt_animation)
    public void toAnimation()
    {
        toActivity(AnimationActivity.class);
    }


    @OnClick(R.id.bt_animatior)
    public void toAnimatior()
    {
        toActivity(AnimatorActivity.class);
    }

    @OnClick(R.id.bt_timer)
    public void toTimer()
    {
        toActivity(TimerActivity.class);
    }


    @OnClick(R.id.btn_for_side_list)
    public void toggleSideList()
    {
        if(sideListView.getVisibility() == View.VISIBLE)
        {
            slideOutSideList();
        }
        else
        {
            slideInSideList();
        }
    }


    public void slideInSideList()
    {
        sideListView.setVisibility(View.VISIBLE);
        sideListView.startAnimation(slideInAnimation);
    }


    public void slideOutSideList()
    {
        sideListView.startAnimation(slideOutAnimaiton);
        sideListView.setVisibility(View.INVISIBLE);
    }

    public void button2Click(View v)
    {
        Intent intent = new Intent(this , DialogActivity.class);
        startActivityForResult(intent, 2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mGestureDetector = new GestureDetector(this, new simpleGestureListener());
        fl.setOnTouchListener(myTouchListener);
        inititialView();
        initialListener();
        initialAnimations();
        initialSideListView();
        sideListView.bringToFront();

    }

    private void initialAnimations()
    {
        slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in);
        slideOutAnimaiton = AnimationUtils.loadAnimation(this, R.anim.slide_out);
    }
    private void inititialView() {
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt3 = (ImageButton) findViewById(R.id.bt3);
        bt2 = (ImageButton) findViewById(R.id.bt2);
        bt4 = (ImageButton) findViewById(R.id.bt_for_class_activity);




    }

    public void initialSideListView()
    {
        String[] actArray =  {"Main Activity", "View Pager Activity", "ListView Activity", "Activity A", "Activity B",
                "Activity C", "Activity D"};
        HashMap<String, Class> activitiesToClassMap = new HashMap<>();
        ArrayList<String> activitiesList= new ArrayList<>(Arrays.asList(actArray));

        activitiesToClassMap.put("Main Activity", MainActivity.class);
        activitiesToClassMap.put("View Pager Activity", ViewPagerActivity.class);
        activitiesToClassMap.put("ListView Activity", ListViewActivity.class);
        activitiesToClassMap.put("Activity A", ActivityA.class);
        activitiesToClassMap.put("Activity B", ActivityB.class);
        activitiesToClassMap.put("Activity C", ActivityC.class);
        activitiesToClassMap.put("Activity D", ActivityD.class);


        SideListViewAdapter adapter = new SideListViewAdapter(activitiesList, activitiesToClassMap);
        sideListView.setAdapter(adapter);
        sideListView.setOnItemClickListener(this);


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


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        mGestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @OnClick(R.id.bt_custom_dialog_again)
    public void createCustomDialog()
    {
        CustomDialog2 customDialog2 = new CustomDialog2(this, this);
        customDialog2.setTitle("Quiz 4");
        customDialog2.show();
    }

    @Override
    public void onCancelCustomDialog() {
        toActivity(ViewPagerActivity.class);
    }

    @Override
    public void onOkCustomDialog(Class clazz) {
        if(clazz == ListViewActivity.class)
        {
            toActivity(clazz);
        }

        else if(clazz == DialogActivity.class)
        {
            toActivity(clazz);
        }


    }


    View.OnTouchListener myTouchListener = new View.OnTouchListener(){

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(sideListView.getVisibility() == View.VISIBLE && (!v.equals(sideListView) || !v.equals(btnForSideList)))
            {
                slideOutSideList();
            }
            toastShort(v.toString());
            return false;
        }
    };

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Class clazz = (Class) parent.getItemAtPosition(position);
        toActivity(clazz);
    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener {



        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if(velocityX < 0 && sideListView.getVisibility() == View.VISIBLE)
            {
                slideOutSideList();
            }
            else if(velocityX > 0 && sideListView.getVisibility() == View.INVISIBLE)
            {
                slideInSideList();
            }

            return false;
        }

    }
}

package com.example.yura.fragmentaccessview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText textActivity;
    Button buttonSendToFragment;
    MyFragment myFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textActivity = (EditText) findViewById(R.id.activitytext);
        buttonSendToFragment = (Button) findViewById(R.id.sendtofragment);

        // получим экземпляр FragmentTransaction из нашей Activity
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();

        // добавляем фрагмент
        myFragment = new MyFragment();
        fragmentTransaction.add(R.id.myfragment, myFragment);
        fragmentTransaction.commit();

        buttonSendToFragment.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                String text = textActivity.getText().toString();
                TextView textFragment = (TextView) findViewById(R.id.fragmenttext);
                textFragment.setText(text);
            }
        });

    }
}

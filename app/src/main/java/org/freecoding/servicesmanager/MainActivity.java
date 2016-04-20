package org.freecoding.servicesmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.freecoding.servicesmanager.view.RoundRelativeLayout;
import org.freecoding.servicesmanager.view.RoundTextView;

import butterknife.Bind;
import butterknife.ButterKnife;
/**
 * 主页面
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.orderView)
    RoundRelativeLayout orderView;
    @Bind(R.id.houseView)
    RoundRelativeLayout houseView;
    @Bind(R.id.nursingView)
    RoundRelativeLayout nursingView;
    @Bind(R.id.medicalView)
    RoundRelativeLayout medicalView;
    @Bind(R.id.gukefuwutai)
    RoundTextView gukefuwutai;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        orderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });

        houseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HousekeepingActivity.class);
                startActivity(intent);
            }
        });

        nursingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NursingActivity.class);
                startActivity(intent);
            }
        });

        medicalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MedicalActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}

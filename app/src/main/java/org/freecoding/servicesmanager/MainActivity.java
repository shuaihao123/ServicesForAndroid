package org.freecoding.servicesmanager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 主页面
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.orderView)
    FrameLayout orderView;
    @Bind(R.id.houseView)
    FrameLayout houseView;
    @Bind(R.id.nursingView)
    FrameLayout nursingView;
    @Bind(R.id.medicalView)
    FrameLayout medicalView;
    @Bind(R.id.gukefuwutai)
    TextView gukefuwutai;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.userButton:
                Intent intent = new Intent(MainActivity.this, UserdetailActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        orderView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

        houseView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HousekeepingActivity.class);
                startActivity(intent);
            }
        });

        nursingView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NursingActivity.class);
                startActivity(intent);
            }
        });

        medicalView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MedicalActivity.class);
                startActivity(intent);
            }
        });
        gukefuwutai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri= Uri.parse("tel:"+"15771722086");
                Intent call=new Intent(Intent.ACTION_CALL,uri);
              // startActivity(call);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


}

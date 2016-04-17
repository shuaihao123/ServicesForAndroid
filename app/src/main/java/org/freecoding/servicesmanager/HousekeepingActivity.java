package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import org.freecoding.servicesmanager.view.RoundLinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 家政服务
 */
public class HousekeepingActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.baomu)
    RoundLinearLayout baomu;
    @Bind(R.id.baomuphone)
    ImageView baomuphone;
    @Bind(R.id.yuesaophone)
    ImageView yuesaophone;
    @Bind(R.id.baojiephone)
    ImageView baojiephone;
    @Bind(R.id.yuesao)
    RoundLinearLayout yuesao;
    @Bind(R.id.baojie)
    RoundLinearLayout baojie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housekeeping);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }
}

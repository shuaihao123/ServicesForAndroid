package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.Bind;

/**
 * 家政服务/保姆订单
 */
public class HomeNurseOrderActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.baomuriqiorder)
    TextView baomuriqiorder;
    @Bind(R.id.baomutimeorder)
    TextView baomutimeorder;
    @Bind(R.id.baomudizhiorder)
    TextView baomudizhiorder;
    @Bind(R.id.baomubeizhuorder)
    TextView baomubeizhuorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_nurse_order);
    }
}

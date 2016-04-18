package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.Bind;

/**
 * 我的护理订单/洗发订单
 */
public class HomeSpaOrderActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.xifariqiorder)
    TextView xifariqiorder;
    @Bind(R.id.xifatimeorder)
    TextView xifatimeorder;
    @Bind(R.id.xifadizhiorder)
    TextView xifadizhiorder;
    @Bind(R.id.xifabeizhuorder)
    TextView xifabeizhuorder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_spa_order);
    }
}

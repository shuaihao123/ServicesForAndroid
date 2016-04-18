package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.Bind;

/**
 * 我的护理/洁牙订单
 */
public class HomeScalingOrderActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.jieyariqiorder)
    TextView jieyariqiorder;
    @Bind(R.id.jieyatimeorder)
    TextView jieyatimeorder;
    @Bind(R.id.jieyadizhiorder)
    TextView jieyadizhiorder;
    @Bind(R.id.jieyabeizhuorder)
    TextView jieyabeizhuorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_scaling_order);
    }
}

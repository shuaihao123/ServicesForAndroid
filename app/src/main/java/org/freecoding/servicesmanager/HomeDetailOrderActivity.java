package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.Bind;

/**
 * 家政服务/月嫂订单
 */
public class HomeDetailOrderActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.yuesaoriqiorder)
    TextView yuesaoriqiorder;
    @Bind(R.id.yuesaoageorder)
    TextView yuesaoageorder;
    @Bind(R.id.yuesaodizhiorder)
    TextView yuesaodizhiorder;
    @Bind(R.id.yuesaobeizhuorder)
    TextView yuesaobeizhuorder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_detail_order);
    }
}

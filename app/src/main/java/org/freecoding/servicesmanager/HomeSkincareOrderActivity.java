package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.Bind;

/**
 * 我的护理/皮肤护理订单
 */
public class HomeSkincareOrderActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.pfhlriqiorder)
    TextView pfhlriqiorder;
    @Bind(R.id.pfhltimeorder)
    TextView pfhltimeorder;
    @Bind(R.id.pfhldizhiorder)
    TextView pfhldizhiorder;
    @Bind(R.id.pfhlbeizhuorder)
    TextView pfhlbeizhuorder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_skincare_order);
    }
}

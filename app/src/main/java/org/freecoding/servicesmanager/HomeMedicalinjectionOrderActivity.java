package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.Bind;

/**
 * 医疗/预约打针订单
 */
public class HomeMedicalinjectionOrderActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.yuyueriqiorder)
    TextView yuyueriqiorder;
    @Bind(R.id.yuyuetimeorder)
    TextView yuyuetimeorder;
    @Bind(R.id.yuyuedizhiorder)
    TextView yuyuedizhiorder;
    @Bind(R.id.yuyuebeizhuorder)
    TextView yuyuebeizhuorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_medicalinjection_order);
    }
    /**
     * 返回
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

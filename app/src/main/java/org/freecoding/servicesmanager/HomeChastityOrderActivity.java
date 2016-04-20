package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.Bind;

/**
 * 我的护理/沐浴洁身订单
 */
public class HomeChastityOrderActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.muyuriqiorder)
    TextView muyuriqiorder;
    @Bind(R.id.muyutimeorder)
    TextView muyutimeorder;
    @Bind(R.id.muyudizhiorder)
    TextView muyudizhiorder;
    @Bind(R.id.muyubeizhuorder)
    TextView muyubeizhuorder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_chastity_order);
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

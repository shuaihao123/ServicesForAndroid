package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.Bind;

/**
 * 家政服务/保洁订单
 */
public class HomeCleaningOrderActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.baojieriqiorder)
    TextView baojieriqiorder;
    @Bind(R.id.baojietimeorder)
    TextView baojietimeorder;
    @Bind(R.id.baojiedizhiorder)
    TextView baojiedizhiorder;
    @Bind(R.id.baojiebeizhuorder)
    TextView baojiebeizhuorder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_cleaning_order);
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

package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.Bind;

/**
 * 医疗/医疗咨询订单
 */
public class HomeMedicaladviceOrderActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.ylzxriqiorder)
    TextView ylzxriqiorder;
    @Bind(R.id.ylzxtimeorder)
    TextView ylzxtimeorder;
    @Bind(R.id.ylzxdizhiorder)
    TextView ylzxdizhiorder;
    @Bind(R.id.ylzxbeizhuorder)
    TextView ylzxbeizhuorder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_medicaladvice_order);
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

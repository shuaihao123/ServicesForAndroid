package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.Bind;

/**
 * 医疗/上门诊疗订单
 */
public class HomeMedicaltreatmentOrderActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.smzlriqiorder)
    TextView smzlriqiorder;
    @Bind(R.id.smzltimeorder)
    TextView smzltimeorder;
    @Bind(R.id.smzldizhiorder)
    TextView smzldizhiorder;
    @Bind(R.id.smzlbeizhuorder)
    TextView smzlbeizhuorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_medicaltreatment_order);
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

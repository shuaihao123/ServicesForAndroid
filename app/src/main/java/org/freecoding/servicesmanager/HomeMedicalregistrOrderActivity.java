package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.Bind;

/**
 * 医疗/挂号订单
 */
public class HomeMedicalregistrOrderActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.guahaoriqiorder)
    TextView guahaoriqiorder;
    @Bind(R.id.guahaotimeorder)
    TextView guahaotimeorder;
    @Bind(R.id.guahaodizhiorder)
    TextView guahaodizhiorder;
    @Bind(R.id.guahaobeizhuorder)
    TextView guahaobeizhuorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_medicalregistr_order);
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

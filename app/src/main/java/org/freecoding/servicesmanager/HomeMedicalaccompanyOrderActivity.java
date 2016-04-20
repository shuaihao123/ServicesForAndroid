package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.Bind;

/**
 * 医疗/陪诊订单
 */
public class HomeMedicalaccompanyOrderActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.pzriqiorder)
    TextView pzriqiorder;
    @Bind(R.id.pztimeorder)
    TextView pztimeorder;
    @Bind(R.id.pzdizhiorder)
    TextView pzdizhiorder;
    @Bind(R.id.pzbeizhuorder)
    TextView pzbeizhuorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_medicalaccompany_order);
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

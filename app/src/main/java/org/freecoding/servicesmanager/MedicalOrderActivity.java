package org.freecoding.servicesmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 医疗订单
 */
public class MedicalOrderActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.yiliaoorder)
    LinearLayout yiliaoorder;
    @Bind(R.id.yuyueorder)
    LinearLayout yuyueorder;
    @Bind(R.id.guahaoorder)
    LinearLayout guahaoorder;
    @Bind(R.id.peizhenorder)
    LinearLayout peizhenorder;
    @Bind(R.id.zhenliaoorder)
    LinearLayout zhenliaoorder;
    @Bind(R.id.yiliaochaxun)
    ImageView yiliaochaxun;
    @Bind(R.id.yuyuechaxun)
    ImageView yuyuechaxun;
    @Bind(R.id.guahaochaxun)
    ImageView guahaochaxun;
    @Bind(R.id.peizhenchaxun)
    ImageView peizhenchaxun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_order);
        ButterKnife.bind(this);
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
    /**
     * 医疗订单/我的医疗咨询订单
     */
    @OnClick(R.id.yiliaoorder)
    void btnyiliaoorder() {
        Intent intent = new Intent(this, HomeMedicaladviceOrderActivity.class);
        startActivity(intent);
    }

    /**
     * 医疗订单跳转到我的预约打针订单
     */
    @OnClick(R.id.yuyueorder)
    void btnyuyueorder() {
        Intent intent = new Intent(this, HomeMedicalinjectionOrderActivity.class);
        startActivity(intent);
    }

    /**
     * 医疗订单跳转到我的挂号订单
     */
    @OnClick(R.id.guahaoorder)
    void btnguahaoorder() {
        Intent intent = new Intent(this, HomeMedicalregistrOrderActivity.class);
        startActivity(intent);
    }

    /**
     * 医疗订单跳转到我的陪诊订单
     */
    @OnClick(R.id.peizhenorder)
    void btnpeizhenorder() {
        Intent intent = new Intent(this, HomeMedicalaccompanyOrderActivity.class);
        startActivity(intent);
    }

    /**
     * 医疗订单跳转到我的上门诊疗订单
     */
    @OnClick(R.id.zhenliaoorder)
    void btnzhenliaoorder() {
        Intent intent = new Intent(this, HomeMedicaltreatmentOrderActivity.class);
        startActivity(intent);
    }
}

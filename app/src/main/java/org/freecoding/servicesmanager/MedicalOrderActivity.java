package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.Bind;

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
    }
}

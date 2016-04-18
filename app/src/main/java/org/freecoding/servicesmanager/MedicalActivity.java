package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.freecoding.servicesmanager.view.RoundLinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 医疗
 */
public class MedicalActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.yiliao)
   LinearLayout yiliao;
    @Bind(R.id.yuyue)
    LinearLayout yuyue;
    @Bind(R.id.guahao)
    LinearLayout guahao;
    @Bind(R.id.peizhen)
    LinearLayout peizhen;
    @Bind(R.id.gotozhiliao)
    LinearLayout gotozhiliao;
    @Bind(R.id.yiliaophone)
    ImageView yiliaophone;
    @Bind(R.id.yuyuephone)
    ImageView yuyuephone;
    @Bind(R.id.guahaophone)
    ImageView guahaophone;
    @Bind(R.id.peizhenphone)
    ImageView peizhenphone;
    @Bind(R.id.gotophone)
    ImageView gotophone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

    }
}

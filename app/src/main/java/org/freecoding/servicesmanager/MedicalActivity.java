package org.freecoding.servicesmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.freecoding.servicesmanager.view.RoundLinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
     * 跳转到医疗咨询
     */
    @OnClick(R.id.yiliao)
    void btnyiliao() {
        Intent intent = new Intent(this, MedicaladviceActivity.class);
        startActivity(intent);
    }

    /**
     * 跳转到预约打针
     */
    @OnClick(R.id.yuyue)
    void btnyuyuedazhen() {
        Intent intent = new Intent(this, MedicalInjectionActivity.class);
        startActivity(intent);
    }
    /**
     * 跳转到挂号
     */
    @OnClick(R.id.guahao)
    void btnguahao() {
        Intent intent = new Intent(this, MedicalRegistrActivity.class);
        startActivity(intent);
    }
    /**
     * 跳转到陪诊
     */
    @OnClick(R.id.peizhen)
    void btnpeizhen() {
        Intent intent = new Intent(this, MedicalAccomPanyActivity.class);
        startActivity(intent);
    }
    /**
     * 跳转到上门治疗
     */
    @OnClick(R.id.gotozhiliao)
    void btngotozhiliao() {
        Intent intent = new Intent(this, MedicalTreatmentActivity.class);
        startActivity(intent);
    }
    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

    }
}

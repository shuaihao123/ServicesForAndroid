package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.EditText;
import android.widget.SeekBar;

import org.freecoding.servicesmanager.view.RoundLinearLayout;
import org.freecoding.servicesmanager.view.RoundTextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 医疗/预约打针
 */
public class MedicalInjectionActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.yuyueriqi)
    RoundLinearLayout yuyueriqi;
    @Bind(R.id.yuyuetime)
    SeekBar yuyuetime;
    @Bind(R.id.yuyuebeizhu)
    EditText yuyuebeizhu;
    @Bind(R.id.yuyuename)
    EditText yuyuename;
    @Bind(R.id.yuyuephone)
    EditText yuyuephone;
    @Bind(R.id.yuyuedizhi)
    EditText yuyuedizhi;
    @Bind(R.id.yuyueadd)
    RoundTextView yuyueadd;
    @Bind(R.id.yuyuefinsh)
    RoundTextView yuyuefinsh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_injection);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}



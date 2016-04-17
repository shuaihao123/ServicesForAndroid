package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.EditText;
import android.widget.SeekBar;

import org.freecoding.servicesmanager.view.RoundLinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 医疗/陪诊
 */
public class MedicalAccomPanyActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.peizhenriqi)
    RoundLinearLayout peizhenriqi;
    @Bind(R.id.peizhentime)
    SeekBar peizhentime;
    @Bind(R.id.peizhenbeizhu)
    EditText peizhenbeizhu;
    @Bind(R.id.peizhenname)
    EditText peizhenname;
    @Bind(R.id.peizhenphone)
    EditText peizhenphone;
    @Bind(R.id.peizhendizhi)
    EditText peizhendizhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_accom_pany);
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
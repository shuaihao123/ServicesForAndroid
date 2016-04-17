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
 * 医疗/上门诊疗
 */
public class MedicalTreatmentActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.shangmenriqi)
    RoundLinearLayout shangmenriqi;
    @Bind(R.id.shangmentinme)
    SeekBar shangmentinme;
    @Bind(R.id.shangmenbeizhu)
    EditText shangmenbeizhu;
    @Bind(R.id.shangmenname)
    EditText shangmenname;
    @Bind(R.id.shangmenphone)
    EditText shangmenphone;
    @Bind(R.id.shangmendizhi)
    EditText shangmendizhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_treatment);
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




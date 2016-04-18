package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.EditText;

import org.freecoding.servicesmanager.view.RoundLinearLayout;
import org.freecoding.servicesmanager.view.RoundTextView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 医疗/医疗咨询
 */
public class MedicaladviceActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.yiliaoriqi)
    RoundLinearLayout yiliaoriqi;
    @Bind(R.id.yiliaobeizhu)
    EditText yiliaobeizhu;
    @Bind(R.id.yiliaoname)
    EditText yiliaoname;
    @Bind(R.id.yiliaophone)
    EditText yiliaophone;
    @Bind(R.id.yiliaodizhi)
    EditText yiliaodizhi;
    @Bind(R.id.yiliaoadd)
    RoundTextView yiliaoadd;
    @Bind(R.id.yiliaofinsh)
    RoundTextView yiliaofinsh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicaladvice);
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


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
 * 医疗/挂号
 */
public class MedicalRegistrActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.guahaoriqi)
    RoundLinearLayout guahaoriqi;
    @Bind(R.id.guahaotime)
    SeekBar guahaotime;
    @Bind(R.id.guahaobeizhu)
    EditText guahaobeizhu;
    @Bind(R.id.guahaoname)
    EditText guahaoname;
    @Bind(R.id.guahaophone)
    EditText guahaophone;
    @Bind(R.id.guahaodizhi)
    EditText guahaodizhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_registr);
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




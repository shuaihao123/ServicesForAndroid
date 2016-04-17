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
 * 护理/皮肤护理
 */
public class Skin_Care_Activity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
   @Bind(R.id.pifuriqi)
    RoundLinearLayout pifuriqi;
    @Bind(R.id.pifutime)
    SeekBar pifutime;
    @Bind(R.id.pifubeizhu)
    EditText pifubeizhu;
    @Bind(R.id.pifuname)
    EditText pifuname;
    @Bind(R.id.pifuphone)
    EditText pifuphone;
    @Bind(R.id.pifudizhi)
    EditText pifudizhi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin__care_);
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


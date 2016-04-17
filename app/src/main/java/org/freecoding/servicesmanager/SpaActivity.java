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
 * 护理/洗发
 */
public class SpaActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.xifariqi)
    RoundLinearLayout xifariqi;
    @Bind(R.id.xifatime)
    SeekBar xifatime;
    @Bind(R.id.xifabeizhu)
    EditText xifabeizhu;
    @Bind(R.id.xifaname)
    EditText xifaname;
    @Bind(R.id.xifaphone)
    EditText xifaphone;
    @Bind(R.id.xifadizhi)
    EditText xifadizhi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spa);
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

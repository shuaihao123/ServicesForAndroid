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
 * 护理/洁牙
 */
public class ScalingYaActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.jieyariqi)
    RoundLinearLayout jieyariqi;
    @Bind(R.id.jieyatime)
    SeekBar jieyatime;
    @Bind(R.id.jieyabeizhu)
    EditText jieyabeizhu;
    @Bind(R.id.jieyaname)
    EditText jieyaname;
    @Bind(R.id.jieyaphone)
    EditText jieyaphone;
    @Bind(R.id.jieyadizhi)
    EditText jieyadizhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scaling_ya);
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


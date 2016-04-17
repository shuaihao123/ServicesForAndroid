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
 * 家政服务/保洁
 */
public class HouseBaojActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.baojieriqi)
    RoundLinearLayout baojieriqi;
    @Bind(R.id.baojietime)
    SeekBar baojietime;
    @Bind(R.id.baojiebeizhu)
    EditText baojiebeizhu;
    @Bind(R.id.baojiename)
    EditText baojiename;
    @Bind(R.id.baojiephone)
    EditText baojiephone;
    @Bind(R.id.baojiedizhi)
    EditText baojiedizhi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_baoj);
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


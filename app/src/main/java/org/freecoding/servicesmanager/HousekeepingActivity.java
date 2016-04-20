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
 * 家政服务
 */
public class HousekeepingActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.baomu)
    LinearLayout baomu;
    @Bind(R.id.yuesao)
    LinearLayout yuesao;
    @Bind(R.id.baojie)
    LinearLayout baojie;
    @Bind(R.id.baomuphone)
    ImageView baomuphone;
    @Bind(R.id.yuesaophone)
    ImageView yuesaophone;
    @Bind(R.id.baojiephone)
    ImageView baojiephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housekeeping);
        ButterKnife.bind(this);
        init();
    }


    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
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
     * 跳转到保姆
     */
    @OnClick(R.id.baomu)
    void btnbaomu() {
        Intent it=new Intent(this,HomeNurseActivity.class);
        startActivity(it);
    }
    /**
     * 跳转到保洁
     */
    @OnClick(R.id.baojie)
    void btnbaojie() {
        Intent it=new Intent(this,HouseBaojActivity.class);
        startActivity(it);
    }
    /**
     * 跳转到月嫂
     */
    @OnClick(R.id.yuesao)
    void btnyuesao() {
        Intent it=new Intent(this,DetailActivity.class);
        startActivity(it);
    }

}

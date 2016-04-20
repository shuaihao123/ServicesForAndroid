package org.freecoding.servicesmanager;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的家政订单
 */
public class HomeOrderActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.baomuorder)
    LinearLayout baomuorder;
    @Bind(R.id.yuesaoorder)
    LinearLayout yuesaoorder;
    @Bind(R.id.baojieorder)
    LinearLayout baojieorder;

    @Bind(R.id.cxbmorder)
    ImageView cxbmorder;
    @Bind(R.id.cxbjorder)
    ImageView cxbjorder;
    @Bind(R.id.cxysorder)
    ImageView cxysorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_order);
        ButterKnife.bind(this);
    }
    /**
     * 我的家政订单跳转到我的保姆订单
     */
    @OnClick(R.id.baomuorder)
    void btnbaomuorder() {
        Intent intent = new Intent(this, HomeNurseOrderActivity.class);
        startActivity(intent);

    }
    @OnClick(R.id.cxbmorder)
    void btncxbmorder() {
        Intent intent = new Intent(this, HomeNurseOrderActivity.class);
        startActivity(intent);

    }

    /**
     * 我的家政订单跳转到我的保洁订单
     */
    @OnClick(R.id.baojieorder)
    void btnbaojieorder() {
        Intent intent = new Intent(this, HomeCleaningOrderActivity.class);
        startActivity(intent);

    }
    @OnClick(R.id.cxbjorder)
    void btncxbjorder() {
        Intent intent = new Intent(this, HomeCleaningOrderActivity.class);
        startActivity(intent);

    }

    /**
     * 我的家政订单跳转到我的月嫂订单
     */
    @OnClick(R.id.yuesaoorder)
    void btnyuesaoorder() {
        Intent intent = new Intent(this, HomeDetailOrderActivity.class);
        startActivity(intent);

    }
    @OnClick(R.id.cxysorder)
    void btncxysorder() {
        Intent intent = new Intent(this, HomeDetailOrderActivity.class);
        startActivity(intent);

    }

}

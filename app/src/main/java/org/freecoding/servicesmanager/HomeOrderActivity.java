package org.freecoding.servicesmanager;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.Bind;

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
    }
}

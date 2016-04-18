package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.Bind;

/**
 * 我的护理订单
 */
public class NursingOrderActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.xitouorder)
    LinearLayout xitouorder;
    @Bind(R.id.muyuorder)
    LinearLayout muyuorder;
    @Bind(R.id.jieyaorder)
    LinearLayout jieyaorder;
    @Bind(R.id.pifuorder)
    LinearLayout pifuorder;
    @Bind(R.id.xitouchaxun)
    ImageView xitouchaxun;
    @Bind(R.id.muyuchaxun)
    ImageView muyuchaxun;
    @Bind(R.id.jieyachaxun)
    ImageView jieyachaxun;
    @Bind(R.id.pifuchaxun)
    ImageView pifuchaxun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nursing_order);
    }
}

package org.freecoding.servicesmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
        ButterKnife.bind(this);
    }
    /**
     * 我的护理订单跳转到我的洗发订单
     */
    @OnClick(R.id.xitouorder)
    void btnxitouorder() {
        Intent intent = new Intent(this, HomeSpaOrderActivity.class);
        startActivity(intent);
    }

    /**
     * 我的护理订单跳转到我的沐浴洁身订单
     */
    @OnClick(R.id.muyuorder)
    void btnmuyuorder() {
        Intent intent = new Intent(this, HomeChastityOrderActivity.class);
        startActivity(intent);
    }

    /**
     * 我的护理订单跳转到我的洁牙订单
     */
    @OnClick(R.id.jieyaorder)
    void btnjieyaorder() {
        Intent intent = new Intent(this, HomeScalingOrderActivity.class);
        startActivity(intent);
    }

    /**
     * 我的护理订单跳转到我的皮肤护理订单
     */
    @OnClick(R.id.pifuorder)
    void btnpifuorder() {
        Intent intent = new Intent(this, HomeSkincareOrderActivity.class);
        startActivity(intent);
    }


}

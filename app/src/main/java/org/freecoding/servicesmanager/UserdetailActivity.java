package org.freecoding.servicesmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 个人信息页
 */
public class UserdetailActivity extends AppCompatActivity {
    /**
     * 点餐订单
     */
    @Bind(R.id.detaildiancan)
    LinearLayout detaildiancan;
    /**
     * 护理订单
     */
    @Bind(R.id.detailhuli)
    LinearLayout detailhuli;
    /**
     * 医疗订单
     */
    @Bind(R.id.detailyiliao)
    LinearLayout detailyiliao;
    /**
     * 家政订单
     */
    @Bind(R.id.detailjiazhen)
    LinearLayout detailjiazhen;
    @Bind(R.id.detailupdatepwd)
    LinearLayout detailupdatepwd;//忘记密码
    @Bind(R.id.detailfankui)
    LinearLayout detailfankui;
    @Bind(R.id.detailgywomen)
    LinearLayout detailgywomen;
    @Bind(R.id.finshlogin)
    TextView finshlogin;
    @Bind(R.id.imageshezhi)
    ImageView imageshezhi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetail);
        ButterKnife.bind(this);
    }
    /**
     * 跳转到修改个人资料
     */
    @OnClick(R.id.imageshezhi) void btnimageshezhi(){
        Intent intent = new Intent(this, UserSettingActivity.class);
        startActivity(intent);
    }
    /**
     * 跳转到点餐订单
     */
    @OnClick(R.id.detaildiancan) void btndetaildiancan(){
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }
    /**
     * 跳转到医疗订单
     */
    @OnClick(R.id.detailyiliao) void btndetailyiliao(){
        Intent intent = new Intent(this, MedicalOrderActivity.class);
        startActivity(intent);
    }
    /**
     * 跳转到家政订单
     */
    @OnClick(R.id.detailjiazhen) void btndetailjiazhen(){
        Intent intent = new Intent(this, HomeOrderActivity.class);
        startActivity(intent);
    }
    /**
     * 跳转到护理订单
     */
    @OnClick(R.id.detailhuli) void btndetailhuli(){
        Intent intent = new Intent(this, NursingOrderActivity.class);
        startActivity(intent);
    }
    /**
     * 忘记密码
     */
    @OnClick(R.id.detailupdatepwd) void btndetailupdatepwd(){
        Intent intent = new Intent(this, Forgot_password_Activity.class);
        startActivity(intent);
    }
}

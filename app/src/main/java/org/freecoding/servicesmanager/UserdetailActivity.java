package org.freecoding.servicesmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;

/**
 * 个人信息页
 */
public class UserdetailActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.detaildiancan)
    LinearLayout detaildiancan;
    @Bind(R.id.detailhuli)
    LinearLayout detailhuli;
    @Bind(R.id.detailyiliao)
    LinearLayout detailyiliao;
    @Bind(R.id.detailjiazhen)
    LinearLayout detailjiazhen;
    @Bind(R.id.detailupdatepwd)
    LinearLayout detailupdatepwd;
    @Bind(R.id.detailfankui)
    LinearLayout detailfankui;
    @Bind(R.id.detailgywomen)
    LinearLayout detailgywomen;
    @Bind(R.id.finshlogin)
    TextView finshlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetail);
    }
}

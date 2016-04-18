package org.freecoding.servicesmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import org.freecoding.servicesmanager.view.RoundLinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 护理
 */
public class NursingActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.xitou)
    LinearLayout xitou;
    @Bind(R.id.muyujieshen)
    LinearLayout muyujieshen;
    @Bind(R.id.jieya)
    LinearLayout jieya;
    @Bind(R.id.pifuhuli)
    LinearLayout pifuhuli;
    @Bind(R.id.xitouphone)
    ImageView xitouphone;
    @Bind(R.id.muyujiehsenphone)
    ImageView muyujiehsenphone;
    @Bind(R.id.jieyaphone)
    ImageView jieyaphone;
    @Bind(R.id.pifuhuliphone)
    ImageView pifuhuliphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nursing);
        ButterKnife.bind(this);
        init();
    }

    /**
     * 跳转到洗发
     */
    @OnClick(R.id.xitou)
    void btnxitou() {
        Intent intent = new Intent(this, SpaActivity.class);
        startActivity(intent);
    }

    /**
     * 跳转到沐浴洁身
     */
    @OnClick(R.id.muyujieshen)
    void btnmuyujieshen() {
        Intent intent = new Intent(this, ChastityActivity.class);
        startActivity(intent);
    }

    /**
     * 跳转到洁牙
     */
    @OnClick(R.id.jieya)
    void btnjieya() {
        Intent intent = new Intent(this, ScalingYaActivity.class);
        startActivity(intent);
    }

    /**
     * 跳转到皮肤护理
     */
    @OnClick(R.id.pifuhuli)
    void btnpifuhuli() {
        Intent intent = new Intent(this, Skin_Care_Activity.class);
        startActivity(intent);
    }

    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }
}

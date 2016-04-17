package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import org.freecoding.servicesmanager.view.RoundLinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 护理
 */
public class NursingActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.xitou)
    RoundLinearLayout xitou;
    @Bind(R.id.muyujieshen)
    RoundLinearLayout muyujieshen;
    @Bind(R.id.jieya)
    RoundLinearLayout jieya;
    @Bind(R.id.pifuhuli)
    RoundLinearLayout pifuhuli;
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

    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }
}

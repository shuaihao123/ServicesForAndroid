package org.freecoding.servicesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import butterknife.Bind;

/**
 * 修改个人信息
 */
public class UserSettingActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.settingtx)
    LinearLayout settingtx;
    @Bind(R.id.settingname)
    LinearLayout settingname;
    @Bind(R.id.settingsex)
    LinearLayout settingsex;
    @Bind(R.id.settingzjian)
    LinearLayout settingzjian;
    @Bind(R.id.settingzjianhao)
    LinearLayout settingzjianhao;
    @Bind(R.id.settingphone)
    LinearLayout settingphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }
}

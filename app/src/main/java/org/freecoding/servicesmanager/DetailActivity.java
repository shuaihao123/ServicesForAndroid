package org.freecoding.servicesmanager;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.StringCallback;

import org.freecoding.servicesmanager.model.HttpResult;
import org.freecoding.servicesmanager.model.ServicesItem;
import org.freecoding.servicesmanager.utils.HttpUtils;
import org.freecoding.servicesmanager.view.MultiLineEditText;
import org.freecoding.servicesmanager.view.SeekBarPressure;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 家政服务/月嫂
 */
public class DetailActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.age)
    SeekBarPressure age;
    @Bind(R.id.name)
    EditText yuesaoname;
    @Bind(R.id.phone)
    EditText yuesaophone;
    @Bind(R.id.dizhi)
    EditText yuesaodizhi;
    @Bind(R.id.yuesaobeizhu)
    MultiLineEditText yuesaobeizhu;
    @Bind(R.id.seekBarAgeTextView)
    TextView seekBarAgeTextView;
    ServicesItem info;
    Handler hd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        init();
        hd=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what==0){
                    msg("登陆成功");
                }else if(msg.what==1){
                    msg("登陆失败");
                }else{
                    msg("请检查网络");
                }
            }
        };
    }

    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        age.setOnSeekBarChangeListener(new SeekBarPressure.OnSeekBarChangeListener() {
            @Override
            public void onProgressBefore() {
            }

            @Override
            public void onProgressChanged(SeekBarPressure seekBar, double progressLow, double progressHigh) {
                seekBarAgeTextView.setText(String.format(getString(R.string.seekbar_age_title), String.valueOf((int) (18 + progressLow)), String.valueOf((int) (18 + progressHigh))));
            }

            @Override
            public void onProgressAfter() {

            }
        });
        info = (ServicesItem) getIntent().getSerializableExtra("info");
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
            case R.id.saveButton:
                save();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void save() {
        HttpUtils.saveServiceItemJiaZheng(info.id, info.createTime, info.updateTime,info.serviceItem, info.name, info.remark, new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                 msg("请检查网络");
            }

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                HttpResult result = gson.fromJson(response, HttpResult.class);
                if (result.success) {
                    //成功
                } else {
                    //保存失败
                }
            }
        });
    }

    void msg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 提交
     */
    @OnClick(R.id.yuesaoadd)
    void btntijiao() {
        String name = yuesaoname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            yuesaoname.requestFocus();
            return;
        }
        String phone = yuesaophone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            yuesaophone.requestFocus();
            return;
        }
        if (phone.length() != 11) {
            msg("手机号输入错误");
            yuesaophone.requestFocus();
            return;
        }
        String dizhi = yuesaodizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            yuesaodizhi.requestFocus();
            return;
        }
        String ysbz = yuesaobeizhu.getText().toString().trim();

    }


    /**
     * 取消
     */
    @OnClick(R.id.yuesaofinsh)
    void btnqxfinsh() {
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}

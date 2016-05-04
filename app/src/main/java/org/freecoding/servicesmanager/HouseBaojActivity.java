package org.freecoding.servicesmanager;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.StringCallback;

import org.freecoding.servicesmanager.model.HttpResult;
import org.freecoding.servicesmanager.model.ServicesItem;
import org.freecoding.servicesmanager.utils.HttpUtils;
import org.freecoding.servicesmanager.view.MultiLineEditText;
import org.freecoding.servicesmanager.view.RoundLinearLayout;
import org.freecoding.servicesmanager.view.SeekBarPressure;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 家政服务/保洁
 */
public class HouseBaojActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.baojieriqi)
    LinearLayout baojieriqi;
    @Bind(R.id.baojieshijian)
    SeekBarPressure baojietime;
    @Bind(R.id.bjshowtime)
    TextView bjshowtime;
    @Bind(R.id.baojiebeizhu)
    MultiLineEditText baojiebeizhu;
    @Bind(R.id.baojiename)
    EditText baojiename;
    @Bind(R.id.baojiephone)
    EditText baojiephone;
    @Bind(R.id.baojiedizhi)
    EditText baojiedizhi;
    ServicesItem info;
    Handler hd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_baoj);
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
        baojietime.setOnSeekBarChangeListener(new SeekBarPressure.OnSeekBarChangeListener() {
            @Override
            public void onProgressBefore() {
            }

            @Override
            public void onProgressChanged(SeekBarPressure seekBar, double progressLow, double progressHigh) {
                bjshowtime.setText(String.format(getString(R.string.seekbar_time_title), String.valueOf((int) (12 + progressLow)/2+":00"), String.valueOf((int) (12 + progressHigh)/2+":00")));
            }

            @Override
            public void onProgressAfter() {

            }
        });
        info = (ServicesItem) getIntent().getSerializableExtra("info");
    }


    void msg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 提交
     */
    @OnClick(R.id.baojieadd)
    void btntijiao() {
        String name = baojiename.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            baojiename.requestFocus();
            return;
        }
        String phone = baojiephone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            baojiephone.requestFocus();
            return;
        }
        if (phone.length() !=11) {
            msg("手机号输入错误");
            baojiephone.requestFocus();
            return;
        }
        String dizhi = baojiedizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            baojiedizhi.requestFocus();
            return;
        }
        String bz = baojiebeizhu.getText().toString().trim();
        if (bz.length() == 0) {
            msg("请选择备注");
            baojiebeizhu.requestFocus();
            return;
        }
    }

    /**
     * 取消
     */
    @OnClick(R.id.baojiefinsh)
    void btnqxfinsh() {
        this.finish();
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
            case  R.id.saveButton:
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}

